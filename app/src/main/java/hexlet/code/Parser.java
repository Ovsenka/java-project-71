package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(Path file) {
        Map<String, Object> mapFile = null;
        ObjectMapper mapper = null;
        if (file.toString().endsWith(".yml")) {
            mapper = new YAMLMapper();
        } else if (file.toString().endsWith(".json")) {
            mapper = new JsonMapper();
        }
        try {
            mapFile = mapper.readValue(new File(file.toString()),
                    new TypeReference<>() { });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return mapFile;
    }
}
