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
     * Creates an IProductsParser from a Data file. File directory in resources.
     *
     * @param fileName the file name to parse
     * @return the IProductsParser object
     */
    public static IProductsCollection createJSONParser(String fileName) {
        return new ProductsJSONFileParser(ClassLoader.getSystemClassLoader().getResourceAsStream(fileName));
    }

    /**
     * Creates an IProductsParser from a JSON InputStream.
     *
     * @param inputStream the stream to parse
     * @return the IProductsParser object
     */
    public static IProductsCollection createJSONParser(InputStream inputStream) {
        return new ProductsJSONFileParser(inputStream);
    }
}

