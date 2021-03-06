package org.asf.emuferal.modules.events.interactions;

import org.asf.emuferal.interactions.dataobjects.NetworkedObject;
import org.asf.emuferal.modules.eventbus.EventObject;
import org.asf.emuferal.modules.eventbus.EventPath;
import org.asf.emuferal.players.Player;

/**
 * 
 * Interaction Data Request Event - called when a client requests interaction
 * data
 * 
 * @author Sky Swimmer - AerialWorks Software Foundation
 *
 */
@EventPath("interaction.datareq")
public class InteractionDataRequestEvent extends EventObject {

	private String objectId;
	private NetworkedObject object;
	private Player player;
	private int state;

	public InteractionDataRequestEvent(Player player, String objectId, NetworkedObject object, int state) {
		this.player = player;
		this.object = object;
		this.objectId = objectId;
		this.state = state;
	}

	@Override
	public String eventPath() {
		return "interaction.datareq";
	}

	/**
	 * Retrieves the player that made the interaction
	 * 
	 * @return Player instance
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Retrieves the object that is being interacted with
	 * 
	 * @return NetworkedObject instance
	 */
	public NetworkedObject getObject() {
		return object;
	}

	/**
	 * Retrieves the UUID of the object that is being interacted with
	 * 
	 * @return Object ID
	 */
	public String getObjectId() {
		return objectId;
	}

	/**
	 * Retrieves the interaction state
	 * 
	 * @return Interaction state
	 */
	public int getState() {
		return state;
	}

}
