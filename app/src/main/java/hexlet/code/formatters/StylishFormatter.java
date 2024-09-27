package hexlet.code.formatters;

import java.util.Map;

public class StylishFormatter implements IFormatter {
    @Override
    public String format(Map<String, Object[]> differMap) {
        StringBuilder result = new StringBuilder("{");
        differMap.forEach((k, v) -> {
            switch (v[0].toString()) {
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
                default:
                    break;
            }
        });
        result.append("\n}");
        return result.toString();
    }
}
