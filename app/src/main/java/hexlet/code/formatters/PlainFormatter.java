package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlainFormatter implements IFormatter {
    @Override
    public String format(Map<Object, Map<String, Object>> differMap) {
        StringBuilder sb = new StringBuilder();
        differMap.forEach((k, v) -> {
            Map.Entry<String, Object> pair = ((LinkedHashMap<String, Object>) v).firstEntry();
            Object differValue = pair.getValue();
            String differKey = pair.getKey();
            Object listValue = null;
            Object listValue2 = null;
            if (!differKey.equals("changed")) {
                differValue = getIfComplexValue(differValue);
            } else {
                listValue = ((ArrayList<?>) differValue).get(0);
                listValue = getIfComplexValue(listValue);
                listValue2 = ((ArrayList<?>) differValue).get(1);
                listValue2 = getIfComplexValue(listValue2);
            }
            switch (differKey) {
                case "add":
                    sb.append("\nProperty '%s' was added with value: %s".formatted(k, differValue));
                    break;
                case "delete":
                    sb.append("\nProperty '%s' was removed".formatted(k));
                    break;
                case "changed":
                    sb.append("\nProperty '%s' was updated. From %s to %s"
                            .formatted(k, listValue, listValue2));
                    break;
                default:
                    break;
            }
        });
        return sb.toString().replaceFirst("\n", "");
    }

    private static Object getIfComplexValue(Object object) {
        if (isComplexValue(object)) {
            return "[complex value]";
        }
        if (object.getClass().equals(String.class) && !object.equals("null")) {
            return String.format("'%s'", object);
        }
        return object;
    }

    private static boolean isComplexValue(Object object) {
        return object instanceof ArrayList<?> || object instanceof LinkedHashMap<?, ?>;
    }
}
