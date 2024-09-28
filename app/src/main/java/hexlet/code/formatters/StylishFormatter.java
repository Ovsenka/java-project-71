package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class StylishFormatter implements IFormatter {
    @Override
    public String format(Map<Object, Map<String, Object>> differMap) {
        StringBuilder result = new StringBuilder("{");
        differMap.forEach((k, v) -> {
            Map.Entry<String, Object> pair = ((LinkedHashMap<String, Object>) v).firstEntry();
            Object differValue = pair.getValue();
            switch (pair.getKey()) {
                case "notchanged":
                    result.append("\n    ").append(k).append(": ").append(differValue);
                    break;
                case "add":
                    result.append("\n  + ").append(k).append(": ").append(differValue);
                    break;
                case "delete":
                    result.append("\n  - ").append(k).append(": ").append(differValue);
                    break;
                case "changed":
                    Object oldValue = ((ArrayList<?>) differValue).get(0);
                    Object newValue = ((ArrayList<?>) differValue).get(1);
                    result.append("\n  - ").append(k).append(": ").append(oldValue);
                    result.append("\n  + ").append(k).append(": ").append(newValue);
                    break;
                default:
                    break;
            }
        });
        result.append("\n}");
        return result.toString();
    }
}
