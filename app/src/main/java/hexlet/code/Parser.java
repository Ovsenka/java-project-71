package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(Path file) {
        Map<String, Object> mapFile = null;
        ObjectMapperFactory factory = new ObjectMapperFactory();
        ObjectMapper mapper = factory.getObjectMapper(file);
        try {
            mapFile = mapper.readValue(new File(file.toString()),
                    new TypeReference<>() { });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return mapFile;
    }
}
