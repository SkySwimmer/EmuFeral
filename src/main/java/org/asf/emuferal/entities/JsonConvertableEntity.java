package org.asf.emuferal.entities;

import com.google.gson.JsonObject;

public abstract class JsonConvertableEntity {

	/**
	 * Constructs the json format that WW uses from this entity.
	 * @return A JsonObject in the format that WW uses.
	 */
	public abstract JsonObject ToJson();
	
}
