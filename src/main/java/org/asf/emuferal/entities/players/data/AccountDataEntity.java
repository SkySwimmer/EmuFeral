package org.asf.emuferal.entities.players.data;

import java.util.List;

import org.asf.emuferal.entities.players.AccountEntity;

import com.google.gson.JsonArray;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "AccountData")
public class AccountDataEntity {
	
	@Id
	@GeneratedValue
	public int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public AccountEntity account;
		
	//slot 1
	@OneToMany(mappedBy = "accountData", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<SpeciesUnlockEntity> speciesUnlocks;

	//slot 2
	@OneToMany(mappedBy = "accountData", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<BodyModsEntity> bodyMods;
	
	public JsonArray getAllSpeciesUnlocks()
	{
		//TODO: constructs a list of all the species unlocks in json format (call the GetJson)
		throw new UnsupportedOperationException("Not yet implemented.");
	}
	
	public JsonArray getAllBodyMods()
	{
		//TODO: constructs a list of all the species unlocks in json format (call the GetJson)
		throw new UnsupportedOperationException("Not yet implemented.");
	}
}
