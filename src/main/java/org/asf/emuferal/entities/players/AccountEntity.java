package org.asf.emuferal.entities.players;

import org.asf.emuferal.entities.players.data.AccountDataEntity;
import org.asf.emuferal.entities.players.data.PrivacySettingsEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "Account")
public class AccountEntity {

	@Id
	public int numericAccountId;
	
	public String uuid;
	
	public String loginName;
	
	public boolean isNew;
	
	public String displayName;

	public String credential;
	
	@OneToOne
	@JoinColumn(name = "account_data_id")
	public AccountDataEntity inventory;
}
