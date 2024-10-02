import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hexlet.code.Differ;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTests {

    private static final String YAML_PATH = "src/test/resources/fixtures/test1.yml";
    private static final String YAML_PATH2 = "src/test/resources/fixtures/test2.yml";
    private static final String JSON_PATH = "src/test/resources/fixtures/test1.json";
    private static final String JSON_PATH2 = "src/test/resources/fixtures/test2.json";

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
    public void unexpectedFormatTest() {
        Exception exception = assertThrows(Exception.class,
                () -> Differ.generate(JSON_PATH, JSON_PATH2, "unknown").trim());
        Exception exception2 = assertThrows(Exception.class,
                () -> Differ.generate(YAML_PATH, YAML_PATH2, "").trim());

        assertEquals("Unexpected format 'unknown'. Possible formats: [stylish, plain, json]",
                exception.getMessage());
        assertEquals("Unexpected format ''. Possible formats: [stylish, plain, json]",
                exception2.getMessage());
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

    @Test
    public void parserTest() {
        assertEquals(Parser.parse(getPath("test1.json")),
                Parser.parse(getPath("test1.yml"))
        );
        assertEquals(Parser.parse(getPath("test2.json")),
                Parser.parse(getPath("test2.yml"))
        );
    }

    private static String readFixture(String fileName) throws Exception {
        return Files.readString(getPath(fileName)).trim();
    }

    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
}

