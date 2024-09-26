package hexlet.code.formatters;

import java.util.Map;

public class PlainFormatter implements IFormatter {
    @Override
    public String format(Map<String, String[]> differMap) {
        StringBuilder sb = new StringBuilder();
        differMap.forEach((k, v) ->
                {
                    switch (v[0]) {
                        case "+":
                            sb.append("\nProperty '%s' was added with value: %s".formatted(k, v[1]));
                            break;
                        case "-":
                            sb.append("\nProperty '%s' was removed".formatted(k));
                            break;
                        case "-+":
                            sb.append("\nProperty '%s' was updated. From %s to %s".formatted(k, v[1], v[2]));
                            break;
                    }
                }
        );
        return sb.toString();
    }
}
