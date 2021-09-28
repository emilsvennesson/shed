package shedbolaget.backend.parser;

public final class ParserFactory {
    private static volatile ParserFactory instance = new ParserFactory();
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
