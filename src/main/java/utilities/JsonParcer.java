package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonParcer {
	String jsonString = null;

	public JsonParcer() {
	}

	public JsonParcer(String file) {
		try {
			jsonString = new String(Files.readAllBytes(Paths.get(file).toAbsolutePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets value for multiple or single key lookup. Provide multiple keys separated
	 * by dot (ex: user.name)
	 * 
	 * @param json
	 * @param key
	 * @return
	 * @throws JSONException
	 */
	public String getValue(String json, String key) {
		String value = null;
		try {
			if (key.contains(".")) {
				// loop until you reach the desired key
				value = multipleKeyLookup(json, key);
			} else {
				// single key look up
				value = singleKeyLookup(json, key);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	private String singleKeyLookup(String json, String key) {
		String jsonRes = null;
		try {
			int index = -1; // no index provided by default
			Object jsonString = new JSONTokener(json).nextValue(); // {...}

			// items or event or id
			boolean isJSONObject = jsonString instanceof JSONObject;
			boolean isJSONArray = jsonString instanceof JSONArray;

			// System.out.println("String json test: " + json.indexOf("items")); // will
			// return position 2

			// test based on items key, an json object
			// items[0]
			if (isJSONObject) {
				if (key.contains("[") && key.endsWith("]")) { // [0]
					String c = key.substring(key.indexOf("[") + 1, key.indexOf("]"));
					if (c.matches("\\d+$")) {
						index = Integer.parseInt(c); // converts "0" to 0
					}

					System.out.println("index: " + index);
					key = key.substring(0, key.indexOf("[")); // items
					System.out.println("key: " + key);
				}
				JSONObject jsonObject = new JSONObject(json); // convert json string to json object, stores items' value
				jsonRes = jsonObject.get(key).toString(); // key = items; convert json object to json string
				if (index != -1 && !jsonRes.equals("[]") && !jsonRes.equals("null")) { // added [] on Monday 4/20/2020
					JSONArray jsonArray = new JSONArray(jsonRes); // convert json string to json array
					jsonRes = (jsonArray.length() > index) ? jsonArray.get(index).toString() : null;
				}

				return jsonRes; // key = items; convert json object to json string
			}

			// test based on items' value, an json array
			// items[0].id
			if (isJSONArray) {
				JSONArray jsonArray = new JSONArray(json); // convert json string to json array
				JSONArray retJSONArr = new JSONArray(); // create new array to hold elements' value; ex: items.events;
														// events.id
				for (int i = 0; i < jsonArray.length(); i++) {
					String element = jsonArray.get(i).toString();
					retJSONArr.put(this.singleKeyLookup(element, key));
				}

				jsonRes = retJSONArr.toString();
			}
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
		return jsonRes;
	}

	private String multipleKeyLookup(String json, String key) {
		String[] keys = key.split("\\."); // [items[*],event,id]
		String tempJson = json;
		for (String k : keys) {
			tempJson = singleKeyLookup(tempJson, k);
		}
		return tempJson;
	}

	private void assertResults(String value, String[] expected, String assertionType) throws JSONException {
		/*
		 * Begin: Asserting results
		 */
		boolean testPassed = false;
		if (assertionType.equals("contains")) {
			for (String exp : expected) {
				testPassed = (value.contains(exp));
			}
		} else if (assertionType.equals("equals")) {
			JSONArray array = new JSONArray(value);
			for (int i = 0; i < array.length(); i++) {
				for (String exp : expected) {
					// if(assertionType.equals("equals"))
					testPassed = (array.get(i).toString().equals(exp));
					// if(assertionType.equals("contains"))
					testPassed = (array.get(i).toString().contains(exp));

					if (testPassed == false) {
						i = array.length();
					}
				}
			}
		}
		System.out.println("Test passed: " + testPassed);
		/*
		 * End: Asserting results
		 */
	}

}
