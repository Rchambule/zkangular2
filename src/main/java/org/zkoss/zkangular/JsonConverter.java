package org.zkoss.zkangular;

import com.google.gson.Gson;

public class JsonConverter {

	static Gson gson = new Gson();
	
	static public String toJson(Object obj){
		return gson.toJson(obj);
	}
}
