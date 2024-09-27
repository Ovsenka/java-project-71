package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class JsonFormatter implements IFormatter {
    @Override
    public String format(Map<String, Object[]> differMap) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<>();
        differMap.forEach((k, v) -> {
            switch (v[0].toString()) {
                case "+", "-":
                    map.put(k, v[1]);
                    break;
                case "-+":
                    map.put(k, v[2]);
                    break;
                default:
                    break;
            }
        });
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
