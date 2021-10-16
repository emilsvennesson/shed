package shedbolaget.model.products.filter;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import shedbolaget.model.products.Product;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

enum ProductsSearch {
    ;

    static List<Product> searchByName(List<Product> products, String query) {
        List<ExtractedResult> result = FuzzySearch.extractSorted(query, extractFromMethod(Product::getFullProductName, products));
        List<Product> matches = new ArrayList<>();
        for (ExtractedResult r : result)
            matches.add(products.get(r.getIndex()));
        return matches;
    }

    static List<Product> searchByCategory(List<Product> products, String query) {
        Map<Product, Integer> pScore = getCategoryHitRatio(products, query);
        return new ArrayList<>(sortMap(pScore).keySet());
    }

    static Map<Product, Integer> getCategoryHitRatio(List<Product> products, String query) {
        Map<Product, Integer> pScore = new LinkedHashMap<>();
        for (Product product : products) {
            int r1 = FuzzySearch.ratio(query, product.getCategoryLevel1().getName());
            int r2 = FuzzySearch.ratio(query, product.getCategoryLevel2().getName());
            int r3 = FuzzySearch.ratio(query, product.getCategoryLevel3().getName());
            int score = Math.max(r1, Math.max(r2, r3));
            pScore.put(product, score);
        }
        return pScore;
    }

    static Map<Product, Integer> sortMap(Map<Product, Integer> pMap) {
        Map<Product, Integer> sortedMap = pMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        return sortedMap;
    }

    static List<String> extractFromMethod(Function<Product, String> stringFunction, List<Product> productList) {
        List<String> stringList = new ArrayList<>();
        productList.forEach(p -> stringList.add(stringFunction.apply(p)));
        return stringList;
    }

}
