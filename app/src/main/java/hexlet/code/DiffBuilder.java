package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DiffBuilder {
    public static Map<Object, Map<String, Object>> build(Map<String, Object> mapFile, Map<String, Object> mapFile2) {
        SortedSet<String> keys = new TreeSet<>(mapFile.keySet());
        keys.addAll(mapFile2.keySet());
        Map<Object, Map<String, Object>> diffResult = new LinkedHashMap<>();
        for (String key : keys) {
            HashMap<String, Object> map = LinkedHashMap.newLinkedHashMap(1);
            Object value = mapFile.get(key) == null ? "null" : mapFile.get(key);
            if (mapFile2.containsKey(key)) {
                Object differFileKeyValue = mapFile2.get(key) == null ? "null" : mapFile2.get(key);
                if (differFileKeyValue.equals(value)) {
                    map.put("notchanged", value);
                } else if (!mapFile.containsKey(key)) {
                    map.put("add", differFileKeyValue);
                } else {
                    ArrayList<Object> values = new ArrayList<>();
                    values.add(value);
                    values.add(differFileKeyValue);
                    map.put("changed", values);
                }
                mapFile2.remove(key);
            } else {
                map.put("delete", value);
            }
            diffResult.put(key, map);
        }
        return diffResult;
    }
}
