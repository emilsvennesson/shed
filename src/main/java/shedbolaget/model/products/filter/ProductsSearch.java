package shedbolaget.model.products.filter;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import shedbolaget.model.products.Product;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Emil Svensson
 */
enum ProductsSearch {
    ;

    static List<Product> search(List<Product> products, String query, int requiredHitRatio) {
        Map<Product, Integer> productsNameHit = getNameHitRatio(products, query, requiredHitRatio);
        Map<Product, Integer> productsCategoryHit = getCategoryHitRatio(products, query, requiredHitRatio);
        // merge the two search results, and remove possible duplicates based on the fuzzysearch score
        HashMap<Product, Integer> mergedMap =
                productsCategoryHit.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1 > v2 ? v1 : v2, () -> new HashMap<>(productsNameHit)));
        return new ArrayList<>(sortMap(mergedMap).keySet());
    }

    static List<Product> searchByName(List<Product> products, String query, int requiredHitRatio) {
        Map<Product, Integer> pScore = getNameHitRatio(products, query, requiredHitRatio);
        return new ArrayList<>(sortMap(pScore).keySet());
    }

    static List<Product> searchByCategory(List<Product> products, String query, int requiredHitRatio) {
        Map<Product, Integer> pScore = getCategoryHitRatio(products, query, requiredHitRatio);
        return new ArrayList<>(sortMap(pScore).keySet());
    }

    private static Map<Product, Integer> getNameHitRatio(List<Product> products, String query, int requiredHitRatio) {
        // return a map with product as key and its fuzzy search ratio as value
        Map<Product, Integer> pScore = new LinkedHashMap<>();
        for (Product product : products) {
            int score = FuzzySearch.weightedRatio(query, product.getFullProductName());
            if (score >= requiredHitRatio)
                pScore.put(product, score);

        }
        return pScore;
    }

    private static Map<Product, Integer> getCategoryHitRatio(List<Product> products, String query, int requiredHitRatio) {
        Map<Product, Integer> pScore = new LinkedHashMap<>();
        for (Product product : products) {
            int r1 = FuzzySearch.weightedRatio(query, product.getCategoryLevel1().getName());
            int r2 = FuzzySearch.weightedRatio(query, product.getCategoryLevel2().getName());
            int r3 = 0;
            try {
                r3 = FuzzySearch.weightedRatio(query, product.getCategoryLevel3().getName());
            } catch (NullPointerException ignored) {
            }
            int score = Math.max(r1, Math.max(r2, r3));  // account for all 3 category levels, and save the highest score
            if (score >= requiredHitRatio)
                pScore.put(product, score);
        }
        return pScore;
    }

    private static Map<Product, Integer> sortMap(Map<Product, Integer> pMap) {
        // found on stack overflow: this will sort a Map based on its value in descending order
        return pMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
    }

}
