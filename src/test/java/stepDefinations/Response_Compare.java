package stepDefinations;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import io.restassured.path.json.JsonPath;

public class Response_Compare {
	
	@Test
    public void compareJsonFiles() throws Exception {
        // Path to your expected and actual JSON files
        String expectedFilePath = "D:\\Automation\\Actual.json";
        String actualFilePath = "D:\\Automation\\Expected.json";

        // Read the content of JSON files
        String expectedJson = new String(Files.readAllBytes(Paths.get(expectedFilePath)));
        String actualJson = new String(Files.readAllBytes(Paths.get(actualFilePath)));

        // Parse JSON strings into JsonPath objects
        JsonPath expectedJsonPath = new JsonPath(expectedJson);
        JsonPath actualJsonPath = new JsonPath(actualJson);

        // Compare JSON objects
        assertEquals(expectedJsonPath.getMap(""), actualJsonPath.getMap(""));
    }
}
