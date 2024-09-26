package hexlet.code;

import hexlet.code.formatters.FormatterFactory;
import hexlet.code.formatters.IFormatter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "gendiff 0.2"
        )
public class App implements Callable<Integer> {

    @Option(names = { "-f", "--format" }, defaultValue = "stylish", paramLabel = "format", description = "output format [default: stylish]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filepath;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filepath2;

    @Override
    public Integer call() throws Exception {
        Map<String, String[]> diffResult = Differ.generate(
                Paths.get(filepath).toAbsolutePath().normalize(),
                Paths.get(filepath2).toAbsolutePath().normalize()
        );
        IFormatter formatter = FormatterFactory.getFormatter(format);
        System.out.println(formatter.format(diffResult));
        return 0;
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
