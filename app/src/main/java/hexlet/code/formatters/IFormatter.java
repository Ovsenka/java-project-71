package hexlet.code.formatters;

import java.util.Map;

public interface IFormatter {
    String format(Map<String, Map<Object, Object>> differMap);
}
