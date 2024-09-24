import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class DifferTests {

    private static String expectedDifferents = "";
    @BeforeAll
    public static void init() {
        expectedDifferents = String.join("\n\t",
                "{",
                "- follow: false",
                "host: hexlet.io",
                "- proxy: 123.234.53.22",
                "- timeout: 50",
                "+ timeout: 20",
                "+ verbose: true\n}");
    }

    @Test
    public void jsonDiffTest() {
        assertEquals(
                generate(
                        Paths.get("src/test/resources/test1.json").toAbsolutePath().normalize(),
                        Paths.get("src/test/resources/test2.json").toAbsolutePath().normalize()
                ),
                expectedDifferents
        );
    }

    @Test
    public void yamlDiffTest() {
        assertEquals(
                generate(
                        Paths.get("src/test/resources/test1.yml").toAbsolutePath().normalize(),
                        Paths.get("src/test/resources/test2.yml").toAbsolutePath().normalize()
                ),
                expectedDifferents
        );
    }
}
