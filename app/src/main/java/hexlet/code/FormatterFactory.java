package hexlet.code;

public class FormatterFactory {

    public static IFormatter getFormatter (String formatter) {
        if (formatter.equals("stylish")) {
            return new StylishFormatter();
        }
        return new StylishFormatter();
    }
}
