package com.util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public final class JsonUtil {

	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	private static final JsonParser jsonParser = new JsonParser();

	private JsonUtil() {
	}

	public static List<String> getJsonAsList(Object json) {
		String jsonString = String.valueOf(json);
		Type listType = new TypeToken<List<String>>() {
		}.getType();
		List<String> list = gson.fromJson(jsonString, listType);

		return list;
	}

	public static JsonObject getAsJsonObject(Object json) {
		String jsonString = String.valueOf(json);
		JsonElement element = jsonParser.parse(jsonString);
		JsonObject jsonObject = element.getAsJsonObject();

		return jsonObject;
	}

}
