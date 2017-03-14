package crawler.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

	static String webpageUrl = "http://www.technopolis.bg/bg";

	public static void main(String[] args) throws IOException {

		URL weburl = new URL(webpageUrl);
		String content = getURL(weburl);

		Pattern p = Pattern.compile("class=\"product-code\"");
		Matcher m = p.matcher(content);
		if (m.find()) {
			System.out.println("Stop searchig");
			return;
		}

		p = Pattern.compile("href=\"(.*?)\"");
		m = p.matcher(content);

		LinkedList<String> l = new LinkedList<>();
		while (m.find()) {
			l.add(m.group(1));
		}

		List<String> links = l.stream()
				.filter(x -> !x.endsWith(".jpg") && !x.endsWith(".png") && !x.endsWith(".ico") && !x.endsWith("css"))
				.map(x -> {
					if (x.startsWith("/")) {
						return webpageUrl + x;
					} else {
						return x;
					}
				}).collect(Collectors.toList());

		System.out.println(links);

	}

	public static String getURL(URL u) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));

		StringBuilder lines = new StringBuilder();

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			lines.append(inputLine);
			lines.append("\n");
		}
		in.close();

		String result = lines.toString();
		return result;
	}

}
