package hexlet.code.formatters;

public class FormatterFactory {

    public static IFormatter getFormatter(String formatter) {
        if (formatter.equals("stylish")) {
            return new StylishFormatter();
        } else if (formatter.equals("plain")) {
            return new PlainFormatter();
        }
        return new StylishFormatter();
    }
}
