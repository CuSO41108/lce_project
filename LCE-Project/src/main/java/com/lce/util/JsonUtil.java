package com.lce.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
    public static String createJsonResponse(int code, String message) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("message", message);
        return json.toJSONString();
    }
}
