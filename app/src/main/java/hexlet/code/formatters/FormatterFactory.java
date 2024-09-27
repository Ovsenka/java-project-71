package hexlet.code.formatters;

public class FormatterFactory {

    public static IFormatter getFormatter(String formatter) {
        return switch (formatter) {
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> new StylishFormatter();
        };
    }


}
