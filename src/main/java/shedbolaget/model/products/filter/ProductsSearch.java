package shedbolaget.model.products.filter;

import com.google.common.collect.Streams;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
        //TODO: figure it out kiddo
        return null;
    }

    static List<String> extractFromMethod(Function<Product, String> stringFunction, List<Product> productList) {
        List<String> stringList = new ArrayList<>();
        productList.forEach(p -> stringList.add(stringFunction.apply(p)));
        return stringList;
    }

}
