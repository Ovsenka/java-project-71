package hexlet.code;

import java.nio.file.Path;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public class Differ {
    public static String generate(Path filepath, Path filepath2) {
        Map<String, Object> mapFile = Parser.parse(filepath);
        Map<String, Object> mapFile2 = Parser.parse(filepath2);
        return compareFilesProperties(mapFile, mapFile2);
    }

    private static String compareFilesProperties(Map<String, Object> mapFile, Map<String, Object> mapFile2) {
        StringBuilder differStr = new StringBuilder("{");
        SortedSet<String> keys = new TreeSet<>(mapFile.keySet());
        for (String key : keys) {
            Object value = mapFile.get(key);
            if (mapFile2.containsKey(key)) {
                Object differFileKeyValue = mapFile2.get(key);
                if (differFileKeyValue.equals(value)) {
                    differStr.append("\n\t").append(key).append(": ").append(value);
                } else {
                    differStr.append("\n\t- ").append(key).append(": ").append(value.toString());
                    differStr.append("\n\t+ ").append(key).append(": ").append(differFileKeyValue);
                }
                mapFile2.remove(key);
            } else {
                differStr.append("\n\t- ").append(key).append(": ").append(value.toString());
            }
        }
        mapFile2.forEach((k, v) -> {
            if (!mapFile.containsKey(k)) {
                differStr.append("\n\t+ ").append(k).append(": ").append(v);
            }
        });
        differStr.append("\n}");
        return differStr.toString();
    }

}
