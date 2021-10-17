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
            int r1 = FuzzySearch.ratio(query, product.getCategoryLevel1().getName());
            int r2 = FuzzySearch.ratio(query, product.getCategoryLevel2().getName());
            int r3 = 0;
            try {
                r3 = FuzzySearch.ratio(query, product.getCategoryLevel3().getName());
            } catch (NullPointerException ignored) {
            }
            int score = Math.max(r1, Math.max(r2, r3));
            if (score >= requiredHitRatio)
                pScore.put(product, score);
        }
        return pScore;
    }

    private static Map<Product, Integer> sortMap(Map<Product, Integer> pMap) {
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
