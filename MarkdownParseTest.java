import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
 * java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
 */

public class MarkdownParseTest {
    @Test
    public void addition() {
        Assert.assertEquals(2, 1+1);
    }

    @Test
    public void getLinks() throws IOException{
        String[] expected = { "https://something.com", "some-page.html" };
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(Arrays.asList(expected), MarkdownParse.getLinks(contents));
    }
}
