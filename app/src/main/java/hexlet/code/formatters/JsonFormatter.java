package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonFormatter implements IFormatter {
    @Override
    public String format(Map<Object, Map<String, Object>> differMap) {
        LinkedHashMap<Object, Object> properties = new LinkedHashMap<>();
        differMap.forEach((k, v) -> {
            var val = ((LinkedHashMap<String, Object>) v).firstEntry().getValue();
            properties.put(k, val);
        });
        ObjectMapper mapper = new JsonMapper();
        try {
            return mapper.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
