package com.osf.test.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.osf.test.db.DBCon;
import com.osf.test.service.TransService;

public class TransServiceImpl implements TransService {
	private Gson gson = new Gson();

	@Override
	public Map<String, String> transferText(String source, String target, String text) {
		Map<String, String> rMap = new HashMap<>();
		rMap.put("isError", "true");
		try {
			text = URLEncoder.encode(text, "UTF-8");
			URL url = new URL(DBCon.NAVER_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(DBCon.METHOD);
			con.setRequestProperty("X-Naver-Client-Id", DBCon.CLIENT_ID);
			con.setRequestProperty("X-Naver-Client-Secret", DBCon.CLIENT_SECRET);
			String postParams = "source=" + source + "&target=" + target + "&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				Map<String, Map<String, Map<String, String>>> cMap = gson.fromJson(response.toString(), Map.class);
				rMap.put("msg", cMap.get("message").get("result").get("translatedText"));
				rMap.put("isError", "false");
			} else {
				Map<String, String> errorMap = gson.fromJson(response.toString(), Map.class);
				rMap.put("msg", errorMap.get("errorMessage"));
			}
		} catch (Exception e) {
			rMap.put("msg", e.getMessage());
		}
		return rMap;
	}
}
