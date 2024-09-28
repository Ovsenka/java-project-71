package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Map;

public class PlainFormatter implements IFormatter {
    @Override
    public String format(Map<String, Map<Object, Object>> differMap) {
        StringBuilder sb = new StringBuilder();
        differMap.forEach((k, v) -> {
            switch (k) {
                case "add":
                    v.forEach((key, value) ->
                            sb.append("\nProperty '%s' was added with value: %s"
                                    .formatted(key, value)));
                    break;
                case "delete":
                    v.forEach((key, value) ->
                            sb.append("\nProperty '%s' was removed"
                            .formatted(key)));
                    break;
                case "changed":
                    v.forEach((key, value) -> {
                        Object resultValue = ((ArrayList<?>) value).get(0);
                        Object resultValue2 = ((ArrayList<?>) value).get(1);
                        sb.append("\nProperty '%s' was updated. From %s to %s"
                                .formatted(key, resultValue, resultValue2));
                    });
                    break;
                default:
                    break;
            }
        });
        return sb.toString();
    }
}
