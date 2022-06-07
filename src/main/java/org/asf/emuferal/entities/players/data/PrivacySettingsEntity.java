package org.asf.emuferal.entities.players.data;

import org.asf.emuferal.entities.JsonConvertableEntity;
import org.asf.emuferal.entities.players.AccountEntity;

import com.google.gson.JsonObject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "AccountPrivacySettings")
public class PrivacySettingsEntity extends JsonConvertableEntity {
	
	@Id
	@GeneratedValue
	public int id;
	
	@OneToOne
	@JoinColumn(name = "account_data_id")
	public AccountDataEntity accountData;
	
	//TODO: Convert to an enum maybe when better understood.
	public String voiceChatSetting;

	@Override
	public JsonObject ToJson() {
		// TODO Auto-generated method stub
		return null;
	}
}
