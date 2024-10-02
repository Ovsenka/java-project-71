package hexlet.code;

import hexlet.code.formatters.IFormatter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String pathToFile, String pathToFile2, String format) throws Exception {
        Path filepath = Paths.get(pathToFile).toAbsolutePath().normalize();
        Path filepath2 = Paths.get(pathToFile2).toAbsolutePath().normalize();

        Map<String, Object> mapFile = Parser.parse(filepath);
        Map<String, Object> mapFile2 = Parser.parse(filepath2);

        IFormatter formatter;
        formatter = FormatterFactory.getFormatter(format);
        return formatter.format(DiffBuilder.build(mapFile, mapFile2));
    }
}
