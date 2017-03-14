package requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class URLReader {

	public static void main(String[] args) throws IOException, JSONException {

		URL oracle = new URL(
				"http://api.openweathermap.org/data/2.5/weather?q=Sofia,bg&appid=9ed81d9300f326bbd3f1ef06bb0f1207");

		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

		StringBuilder lines = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			lines.append(inputLine);
			System.out.println(inputLine);
		}
		in.close();

		String request = lines.toString();

		JSONObject jso = new JSONObject(request);

		System.out.println((int)((double)jso.getJSONObject("main").get("temp") - 273.15));
		System.out.println(jso.get("name"));
		
		
	}
}
