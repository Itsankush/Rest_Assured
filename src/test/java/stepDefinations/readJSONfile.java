package stepDefinations;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readJSONfile {
	public static void main(String[] args) {
		JSONObject requestJson;
		try {
			// Read the JSON file content
			String jsonContent = new String(Files.readAllBytes(Paths.get("D:\\Automation\\SamplePayload.json")));

			// Create a JSONObject from the JSON content
			requestJson = new JSONObject(jsonContent);

			// Now you can use requestJson as your payload in Rest Assured requests
			System.out.println(requestJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
