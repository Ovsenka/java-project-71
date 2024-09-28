package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.Map;
import java.util.TreeMap;

public class JsonFormatter implements IFormatter {
    @Override
    public String format(Map<String, Map<Object, Object>> differMap) {
        TreeMap<Object, Object> properties = new TreeMap<>();
        differMap.forEach((k, v) -> properties.putAll(v));
        ObjectMapper mapper = new JsonMapper();
        try {
            return mapper.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
