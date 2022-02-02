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

    @Test
    public void getLinks2() throws IOException{
        String[] expected = { "https://ucsd-cse15l-w22.github.io/week/week3/", "https://www.google.com/" };
        Path fileName = Path.of("test-file2-own.md");
        String contents = Files.readString(fileName);
        assertEquals(Arrays.asList(expected), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks3() throws IOException{
        String[] expected = { "https://ucsd-cse15l-w22.github.io/week/week3/", "sdfgsdfgsdg","sdfsdfsdfsdf"};
        Path fileName = Path.of("test-file3-own.md");
        String contents = Files.readString(fileName);
        assertEquals(Arrays.asList(expected), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks4() throws IOException{
        String[] expected = { "stuff"};
        Path fileName = Path.of("test-file4-own.md");
        String contents = Files.readString(fileName);
        assertEquals(Arrays.asList(expected), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks6() throws IOException{
        String[] expected = { };
        Path fileName = Path.of("test-file6.md");
        String contents = Files.readString(fileName);
        assertEquals(Arrays.asList(expected), MarkdownParse.getLinks(contents));
    }

    @Test
    public void getLinks7() throws IOException{
        System.out.println("test 7");
        String[] expected = { };
        Path fileName = Path.of("test-file7.md");
        String contents = Files.readString(fileName);
        assertEquals(Arrays.asList(expected), MarkdownParse.getLinks(contents));
    }
}
