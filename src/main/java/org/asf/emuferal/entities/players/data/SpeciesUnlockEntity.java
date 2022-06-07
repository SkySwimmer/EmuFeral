package org.asf.emuferal.entities.players.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.asf.emuferal.entities.JsonConvertableEntity;

import com.google.gson.JsonObject;

import jakarta.persistence.ForeignKey;

public class SpeciesUnlockEntity extends JsonConvertableEntity
{
	//The slot id of the inventory.
	private static int slot = 1;
	
	@Id
	@GeneratedValue
	public int id;
	
	@ManyToOne
	@JoinColumn(name = "account_data_id", foreignKey = @ForeignKey(name = "ACCOUNT_ID_FK"))
	public AccountDataEntity accountData;
	
	public int defId;
	
	public String timeStamp;
	
	public int uuid;
	
	public int type;
	
	public JsonObject ToJson() {
		//TODO: reconstructs the json format WW-Style from the fields.
		throw new UnsupportedOperationException("Not yet implemented.");
	}
}
