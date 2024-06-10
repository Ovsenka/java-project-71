package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Differ {
    public static String generate(Path filepath, Path filepath2) throws IOException {
        StringBuilder differStr = new StringBuilder("{");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFile = mapper.readValue(new File(filepath.toString()),
                new TypeReference<Map<String, Object>>() {});
        Map<String, Object> mapFile2 = mapper.readValue(new File(filepath2.toString()),
                new TypeReference<Map<String, Object>>() {});
        for (Entry entry : mapFile.entrySet()) {
            String key = entry.getKey().toString();
            Object value = entry.getValue();
            if (mapFile2.containsKey(key)) {
                Object differFileKeyValue = mapFile2.get(key);
                if (differFileKeyValue.equals(value)) {
                    differStr.append("\n\t" + key + ": " + value);
                }
                else {
                    differStr.append("\n\t- " + key + ": " + entry.getValue().toString());
                    differStr.append("\n\t+ " + key + ": " + mapFile2.get(key));
                }
            } else {
                // ...
            }
        }
        differStr.append("\n}");
        return differStr.toString();
    }
}
