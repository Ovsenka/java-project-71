package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Map;

public class StylishFormatter implements IFormatter {
    @Override
    public String format(Map<String, Map<Object, Object>> differMap) {
        StringBuilder result = new StringBuilder("{");
        differMap.forEach((k, v) -> {
            switch (k) {
                case "notchanged":
                    v.forEach((key, value) -> result.append("\n ").append(key).append(": ").append(value));
                    break;
                case "add":
                    v.forEach((key, value) -> result.append("\n + ").append(key).append(": ").append(v.get(key)));
                    break;
                case "delete":
                    v.forEach((key, value) -> result.append("\n - ").append(key).append(": ").append(v.get(key)));
                    break;
                case "changed":
                    v.forEach((key, value) -> {
                        Object resultValue = ((ArrayList<?>) value).get(0);
                        Object resultValue2 = ((ArrayList<?>) value).get(1);
                        result.append("\n - ").append(key).append(": ").append(resultValue);
                        result.append("\n + ").append(key).append(": ").append(resultValue2);
                    });
                    break;
                default:
                    break;
            }
        });
        result.append("\n}");
        return result.toString();
    }
}
