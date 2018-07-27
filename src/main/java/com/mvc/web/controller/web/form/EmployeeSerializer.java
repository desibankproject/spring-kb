package com.mvc.web.controller.web.form;

import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EmployeeSerializer implements JsonSerializer<EmployeeForm> {

	@Override
	public JsonElement serialize(EmployeeForm arg0, Type arg1, JsonSerializationContext arg2) {
		 JsonObject jObj = (JsonObject)new GsonBuilder().create().toJsonTree(arg0);
	            jObj.remove("name");
	        return jObj;
	}
}
