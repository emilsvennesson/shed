package shedbolaget.model.products.parser;

import shedbolaget.model.products.IProductsCollection;

import java.io.InputStream;

/**
 * The products parser factory.
 *
 * @author Emil Svensson
 */
public enum ProductsParserFactory {
    ;

    /**
     * Creates an IProductsCollection from a file name in the resources directory.
     *
     * @param fileName the file name to parse
     * @return the IProductsParser object
     */
    public static IProductsCollection createJSONParser(String fileName) {
        return new ProductsJSONFileParser(ClassLoader.getSystemClassLoader().getResourceAsStream(fileName));
    }

    /**
     * Creates an IProductsCollection from an InputStream object.
     *
     * @param inputStream the stream to parse
     * @return the IProductsCollection object
     */
    public static IProductsCollection createJSONParser(InputStream inputStream) {
        return new ProductsJSONFileParser(inputStream);
    }
}

