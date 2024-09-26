package hexlet.code;

import java.nio.file.Path;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.LinkedHashMap;


public class Differ {
    public static Map<String, String[]> generate(Path filepath, Path filepath2) {
        Map<String, Object> mapFile = Parser.parse(filepath);
        Map<String, Object> mapFile2 = Parser.parse(filepath2);
        return compareFiles(mapFile, mapFile2);
    }

    private static Map<String, String[]> compareFiles(Map<String, Object> mapFile, Map<String, Object> mapFile2) {
        //Set<> mergedKeySet = new TreeSet<>(mapFile.keySet()).addAll(mapFile2.keySet());
        //Set<String> set = Collections.addAll();
        SortedSet<String> keys = new TreeSet<>(mapFile.keySet());
        keys.addAll(mapFile2.keySet());
        Map<String, String[]> diffResult = new LinkedHashMap<>();
        for (String key : keys) {
            Object value = String.valueOf(mapFile.get(key));
            if (mapFile2.containsKey(key)) {
                Object differFileKeyValue = String.valueOf(mapFile2.get(key));
                if (differFileKeyValue.equals(value)) {
                    diffResult.put(key, new String[] {"none", value.toString()});
                } else if (!mapFile.containsKey(key)) {
                    diffResult.put(key, new String[] {"+", differFileKeyValue.toString() });
                } else {
                    diffResult.put(key, new String[] {"-+", value.toString(), differFileKeyValue.toString() });
                }
                mapFile2.remove(key);
            } else {
                diffResult.put(key, new String[] {"-", value.toString()});
            }
        }
        mapFile2.forEach((k, v) -> {
            if (!mapFile.containsKey(k)) {
                diffResult.put(k, new String[] {"+", v.toString()});
            }
        });
        return diffResult;
    }

}
