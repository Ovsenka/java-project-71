package hexlet.code.formatters;

import java.util.Map;

public class PlainFormatter implements IFormatter {
    @Override
    public String format(Map<String, Object[]> differMap) {
        StringBuilder sb = new StringBuilder();
        differMap.forEach((k, v) -> {
            Object keyvalue = v[1].getClass().isArray() ? "[complex value]" : v[1];
            Object keyvalue2;
            switch (v[0].toString()) {
                case "+":
                    sb.append("\nProperty '%s' was added with value: %s".formatted(k, keyvalue));
                    break;
                case "-":
                    sb.append("\nProperty '%s' was removed".formatted(k));
                    break;
                case "-+":
                    keyvalue2 = v[2].getClass().isArray() ? "[complex value]" : v[2];
                    sb.append("\nProperty '%s' was updated. From %s to %s".formatted(k, keyvalue, keyvalue2));
                    break;
                default:
                    break;
            }
        });
        return sb.toString();
    }
}
