import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTests {

    private static final String YAML_PATH = "src/test/resources/test1.yml";
    private static final String YAML_PATH2 = "src/test/resources/test2.yml";
    private static final String JSON_PATH = "src/test/resources/test1.json";
    private static final String JSON_PATH2 = "src/test/resources/test2.json";

    @Test
    public void jsonDiffTestStylish() {

    }

    @Test
    public void jsonDiffTest() throws Exception {
        assertEquals(
                readFixture("stylishFixture"),
                Differ.generate(JSON_PATH, JSON_PATH2, "stylish").trim()
        );
        assertEquals(
                readFixture("jsonFixture"),
                Differ.generate(JSON_PATH, JSON_PATH2, "json").trim()
        );
        assertEquals(
                readFixture("plainFixture"),
                Differ.generate(JSON_PATH, JSON_PATH2, "plain").trim()
        );
    }

    @Test
    public void yamlDiffTest() throws Exception {
        assertEquals(
                readFixture("stylishFixture"),
                Differ.generate(YAML_PATH, YAML_PATH2, "stylish").trim()
        );
        assertEquals(
                readFixture("jsonFixture"),
                Differ.generate(YAML_PATH, YAML_PATH2, "json").trim()
        );
        assertEquals(
                readFixture("plainFixture"),
                Differ.generate(YAML_PATH, YAML_PATH2, "plain").trim()
        );
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
        return Files.readString(filePath).trim();
    }
}

