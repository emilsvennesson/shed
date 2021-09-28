package shedbolaget.backend.parser;

public final class ParserFactory {
    private static ParserFactory instance;

    private ParserFactory() {
    }

    public ParserFactory getInstance() {
        if (instance == null) {
            instance = new ParserFactory();
        }
        return instance;
    }

    public static IProductParser makeJsonParser() {
        return new ProductJsonFileParser();
    }
}
