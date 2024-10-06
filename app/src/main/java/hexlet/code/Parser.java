package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(Path file) {
        Map<String, Object> mapFile = null;
        ObjectMapper mapper = null;
        String fileExtension = file.toString().split("\\.")[1];
        mapper = switch (fileExtension) {
            case "yml" -> new YAMLMapper();
            case "json" -> new JsonMapper();
            default -> mapper;
        };
        try {
            if (mapper == null) {
                throw new Exception("Unexpected file extension '%s'".formatted(fileExtension));
            }
            mapFile = mapper.readValue(new File(file.toString()),
                    new TypeReference<>() { });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mapFile;
    }
}
