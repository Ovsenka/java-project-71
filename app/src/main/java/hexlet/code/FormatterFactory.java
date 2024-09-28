package hexlet.code;

import hexlet.code.formatters.IFormatter;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class FormatterFactory {

    public static IFormatter getFormatter(String format) throws Exception {
        return switch (format) {
            case "stylish" -> new StylishFormatter();
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> throw new Exception("Unexpected format '%s'. Possible formats: [stylish, plain, json]"
                    .formatted(format));
        };
    }


}
