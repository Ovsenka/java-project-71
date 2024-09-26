import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.IFormatter;
import hexlet.code.StylishFormatter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Map;

public class DifferTests {

    private static String expectedDifferents = "";
    private static StylishFormatter stylishFormatter = null;
    @BeforeAll
    public static void init() {
        expectedDifferents = String.join("\n\t",
                "{",
                        "chars1: [a, b, c]",
                        "- chars2: [d, e, f]",
                        "+ chars2: false",
                        "- checked: false",
                        "+ checked: true",
                        "- default: null",
                        "+ default: [value1, value2]",
                        "- id: 45",
                        "+ id: null",
                        "- key1: value1",
                        "+ key2: value2",
                        "numbers1: [1, 2, 3, 4]",
                        "- numbers2: [2, 3, 4, 5]",
                        "+ numbers2: [22, 33, 44, 55]",
                        "- numbers3: [3, 4, 5]",
                        "+ numbers4: [4, 5, 6]",
                        "+ obj1: {nestedKey=value, isNested=true}",
                        "- setting1: Some value",
                        "+ setting1: Another value",
                        "- setting2: 200",
                        "+ setting2: 300",
                        "- setting3: true",
                        "+ setting3: none\n}");
        stylishFormatter = new StylishFormatter();
    }

    @Test
    public void jsonDiffTestStylish() {
        Map<String, String[]> diff = generate(
                Paths.get("src/test/resources/test1.json").toAbsolutePath().normalize(),
                Paths.get("src/test/resources/test2.json").toAbsolutePath().normalize()
        );

        assertEquals(stylishFormatter.format(diff),
                expectedDifferents
        );
    }

    @Test
    public void yamlDiffTestStylish() {
        Map<String, String[]> diff = generate(
                Paths.get("src/test/resources/test1.yml").toAbsolutePath().normalize(),
                Paths.get("src/test/resources/test2.yml").toAbsolutePath().normalize()
        );

        assertEquals(stylishFormatter.format(diff),
                expectedDifferents
        );
    }
}
