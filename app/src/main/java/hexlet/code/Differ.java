package hexlet.code;

import java.nio.file.Path;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.LinkedHashMap;


public class Differ {
    public static Map<String, Object[]> generate(Path filepath, Path filepath2) {
        Map<String, Object> mapFile = Parser.parse(filepath);
        Map<String, Object> mapFile2 = Parser.parse(filepath2);
        return compareFiles(mapFile, mapFile2);
    }

    private static Map<String, Object[]> compareFiles(Map<String, Object> mapFile, Map<String, Object> mapFile2) {
        SortedSet<String> keys = new TreeSet<>(mapFile.keySet());
        keys.addAll(mapFile2.keySet());
        Map<String, Object[]> diffResult = new LinkedHashMap<>();
        for (String key : keys) {
            Object value = mapFile.get(key) == null ? "null" : mapFile.get(key);
            if (mapFile2.containsKey(key)) {
                Object differFileKeyValue = mapFile2.get(key) == null ? "null" : mapFile2.get(key);
                if (differFileKeyValue.equals(value)) {
                    diffResult.put(key, new Object[] {"none", value});
                } else if (!mapFile.containsKey(key)) {
                    diffResult.put(key, new Object[] {"+", differFileKeyValue });
                } else {
                    diffResult.put(key, new Object[] {"-+", value, differFileKeyValue });
                }
                mapFile2.remove(key);
            } else {
                diffResult.put(key, new Object[] {"-", value});
            }
        }
        mapFile2.forEach((k, v) -> {
            if (!mapFile.containsKey(k)) {
                diffResult.put(k, new Object[] {"+", v});
            }
        });
        return diffResult;
    }

}
