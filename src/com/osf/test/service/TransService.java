package com.osf.test.service;

import java.util.Map;

public interface TransService {
	public Map<String,String> transferText(String source, String target, String text);
}
