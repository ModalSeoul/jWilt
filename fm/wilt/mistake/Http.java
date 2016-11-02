package fm.wilt.mistake;

import java.net.*;
import java.io.*;

public class Http {
	protected HttpURLConnection connection;
	protected String APIUrl;
	
	public Http(String APIUrl) {
		this.APIUrl = APIUrl;
	}
	
	public String get(String endPoint, String format) throws Exception {
		URL url = new URL(String.format("%s%s%s", APIUrl, endPoint, format));
		URLConnection wilt = url.openConnection();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
				wilt.getInputStream()));
		String inputLine = in.readLine();
		in.close();
		return inputLine;
	}
}
