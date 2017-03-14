package webCrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void crawl(String url) throws IOException {
		URL oracle = new URL(url);

		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

		StringBuilder lines = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			lines.append(inputLine);
			lines.append("\n");
		}
		in.close();

		String request = lines.toString();

		Document doc = Jsoup.parse(request);

		Elements elements = doc.select("a[href^=/bg/Laptops/]");

		List<String> links = new ArrayList<>();

		for (Element e : elements) {
			links.add("http://www.technopolis.bg" + e.attr("href"));
		}

		links.forEach(System.out::println);

		links.forEach(l -> {
			try {
				crawl(l);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}

	public static void main(String[] args) throws IOException, JSONException {

		String url = "http://www.technopolis.bg/bg//%D0%9A%D0%BE%D0%BC%D0%BF%D1%8E%D1%82%D1%80%D0%B8-%D0%B8-%D0%BF%D0%B5%D1%80%D0%B8%D1%84%D0%B5%D1%80%D0%B8%D1%8F/%D0%9B%D0%B0%D0%BF%D1%82%D0%BE%D0%BF%D0%B8/c/P11010101";

		crawl(url);
	}
}
