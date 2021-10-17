package shedbolaget.model.products.parser;

import java.io.InputStream;

/**
 * The products parser factory.
 *
 * @author Emil Svensson
 */
public enum ProductsParserFactory {
    ;

    /**
     * Create an IProductsParser from a JSON InputStream.
     *
     * @param streamToParse the stream to parse
     * @return the IProductsParser object
     */
    public static IProductsParser createJSONParser(InputStream streamToParse) {
        return new ProductsJSONFileParser(streamToParse);
    }
}

