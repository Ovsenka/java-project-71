package hexlet.code;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class StylishFormatter implements IFormatter {
    @Override
    public String format(Map<String, String[]> differMap) {
        StringBuilder result = new StringBuilder("{");
        differMap.forEach((k, v) ->
                {
                    switch (v[0]) {
                        case "none":
                            result.append("\n\t").append(k).append(": ").append(v[1]);
                            break;
                        case "+":
                            result.append("\n\t+ ").append(k).append(": ").append(v[1]);
                            break;
                        case "-":
                            result.append("\n\t- ").append(k).append(": ").append(v[1]);
                            break;
                        case "-+":
                            result.append("\n\t- ").append(k).append(": ").append(v[1]);
                            result.append("\n\t+ ").append(k).append(": ").append(v[2]);
                            break;
                    }
                }
        );
        result.append("\n}");
        return result.toString();
    }
}
