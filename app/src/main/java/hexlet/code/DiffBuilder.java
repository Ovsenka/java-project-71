package hexlet.code;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class DiffBuilder {
    public static Map<String, Map<Object, Object>> build(Map<String, Object> mapFile, Map<String, Object> mapFile2) {
        SortedSet<String> keys = new TreeSet<>(mapFile.keySet());
        keys.addAll(mapFile2.keySet());
        Map<String, Map<Object, Object>> diffResult = new LinkedHashMap<>();
        LinkedHashMap<Object, Object> deleteMap = new LinkedHashMap<>();
        LinkedHashMap<Object, Object> notChangedMap = new LinkedHashMap<>();
        LinkedHashMap<Object, Object> changedMap = new LinkedHashMap<>();
        LinkedHashMap<Object, Object> addedMap = new LinkedHashMap<>();
        for (String key : keys) {
            Object value = mapFile.get(key) == null ? "null" : mapFile.get(key);
            if (mapFile2.containsKey(key)) {
                Object differFileKeyValue = mapFile2.get(key) == null ? "null" : mapFile2.get(key);
                if (differFileKeyValue.equals(value)) {
                    notChangedMap.put(key, value);
                } else if (!mapFile.containsKey(key)) {
                    addedMap.put(key, differFileKeyValue);
                } else {
                    ArrayList<Object> values = new ArrayList<>();
                    values.add(value);
                    values.add(differFileKeyValue);
                    changedMap.put(key, values);
                }
                mapFile2.remove(key);
            } else {
                deleteMap.put(key, value);
            }
        }
        diffResult.put("notchanged", notChangedMap);
        diffResult.put("add", addedMap);
        diffResult.put("changed", changedMap);
        diffResult.put("delete", deleteMap);
        return diffResult;
    }
}
