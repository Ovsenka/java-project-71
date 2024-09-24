package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Path;

public class ObjectMapperFactory {
    public ObjectMapper getObjectMapper(Path filepath) {
        ObjectMapper mapper = null;
        if (filepath.toString().endsWith(".yml")) {
            mapper = new YAMLMapper();
        } else if (filepath.toString().endsWith(".json")) {
            mapper = new JsonMapper();
        }
        return mapper;
    }
}
