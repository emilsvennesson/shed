package shedbolaget.model.parser;

/**
 * @author Emil Svensson
 */
public final class ParserFactory {
    private static final ParserFactory instance = new ParserFactory();
    private static final ProductJsonFileParser jsonParser = new ProductJsonFileParser();

    private ParserFactory() {
    }

    public ParserFactory getInstance() {
        return instance;
    }
  
    public static IProductParser getJsonParser() {
        return jsonParser;
    }
}
