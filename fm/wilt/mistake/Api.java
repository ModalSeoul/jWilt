package fm.wilt.mistake;

import fm.wilt.mistake.Http;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Api {
	protected String format;
	protected Http http;
	JSONParser parser = new JSONParser();
	
	public Api(String format) {
		this.format = String.format("?format=%s", format);
		this.http = new Http("https://wilt.fm/api/");
	}
	
	public JSONObject getMember(String nick) {
		String reqUrl = String.format("members/%s/", nick);
		JSONObject memberObj = new JSONObject();
		try {
			String ret = this.http.get(reqUrl, this.format);
			memberObj = (JSONObject) parser.parse(ret);
			return memberObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setFormat(String newFormat) {
		this.format = newFormat;
	}
	
	public String getFormat() {
		return this.format;
	}

}
