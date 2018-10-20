package com.json.microcontroller.Helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public final class Functions {
    public static HashMap<String,String> JsonArrayToHashMap(String jsonString) throws JSONException {
        JSONArray jsonArray =new JSONArray(jsonString);
        HashMap<String, String> pairs = new HashMap<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject j = jsonArray.optJSONObject(i);
            Iterator it = j.keys();
            while (it.hasNext()) {
                String n = (String) it.next();
                pairs.put(n, j.getString(n));
            }
        }

        return pairs;
    }
}
