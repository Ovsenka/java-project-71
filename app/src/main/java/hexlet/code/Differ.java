package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;


public class Differ {
    public static String generate(Path filepath, Path filepath2) throws IOException {
        StringBuilder differStr = new StringBuilder("{");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFile = mapper.readValue(new File(filepath.toString()),
                new TypeReference<Map<String, Object>>() {});
        Map<String, Object> mapFile2 = mapper.readValue(new File(filepath2.toString()),
                new TypeReference<Map<String, Object>>() {});
        SortedSet<String> keys = new TreeSet<>(mapFile.keySet());
        for (String key : keys) {
            Object value = mapFile.get(key);
            if (mapFile2.containsKey(key)) {
                Object differFileKeyValue = mapFile2.get(key);
                if (differFileKeyValue.equals(value)) {
                    differStr.append("\n\t" + key + ": " + value);
                }
                else {
                    differStr.append("\n\t- " + key + ": " + value.toString());
                    differStr.append("\n\t+ " + key + ": " + differFileKeyValue);
                }
                mapFile2.remove(key);
            } else {
                differStr.append("\n\t- " + key + ": " + value.toString());
            }
        }
        mapFile2.forEach((k, v) -> {
            if (!mapFile.containsKey(k)) {
                differStr.append("\n\t+ " + k + ": " + v);
            }
        });
        differStr.append("\n}");
        return differStr.toString();
    }
}
