package hexlet.code.formatters;

import java.util.Map;

public interface IFormatter {
    String format(Map<Object, Map<String, Object>> differMap);
}
