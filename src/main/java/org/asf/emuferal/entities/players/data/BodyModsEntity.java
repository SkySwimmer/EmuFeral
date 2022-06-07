package org.asf.emuferal.entities.players.data;

import org.asf.emuferal.entities.JsonConvertableEntity;

import com.google.gson.JsonObject;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BodyModsEntity extends JsonConvertableEntity {

	//The slot id of the inventory.
	private static int slot = 2;
	
	@Id
	@GeneratedValue
	public int id;
	
	@ManyToOne
	@JoinColumn(name = "inventory_id", foreignKey = @ForeignKey(name = "INVENTORY_ID_FK"))
	public AccountDataEntity parentAccountData;
	
	public int defId;
	
	public String timeStamp;
	
	public int uuid;
	
	public int type;
			
	@Override
	public JsonObject ToJson() {
		//TODO: reconstructs the json format WW-Style from the fields.
		throw new UnsupportedOperationException("Not yet implemented.");
	}

}
