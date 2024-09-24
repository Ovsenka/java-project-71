import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import hexlet.code.Differ;

public class DifferTests {

    private ClassLoader classLoader = null;

    @BeforeAll
    public void init() {
        classLoader = getClass().getClassLoader();

    }

    @Test
    public void jsonDiffTest() {
        File file = new File("test1.json");
        File file2 = new File("test2.json");
    }

    @Test
    public void yamlDiffTest() {

    }
}
