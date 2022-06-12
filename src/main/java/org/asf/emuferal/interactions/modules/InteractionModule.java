package org.asf.emuferal.interactions.modules;

import org.asf.emuferal.interactions.dataobjects.NetworkedObject;
import org.asf.emuferal.players.Player;

public abstract class InteractionModule {

	/**
	 * Called to prepare world objects
	 * 
	 * @param player Player to prepare this module for
	 */
	public abstract void prepareWorld(Player player);

	/**
	 * Checks if this module can handle the given interaction
	 * 
	 * @param player Player making the interaction
	 * @param id     Interaction ID
	 * @param object Object that was interacted with
	 * @return True if the given interaction can be processed by this module, false
	 *         otherwise
	 */
	public abstract boolean canHandle(Player player, String id, NetworkedObject object);

	/**
	 * Handles interaction success packets
	 * 
	 * @param player Player making the interaction
	 * @param id     Interaction ID
	 * @param object Object that was interacted with
	 * @param state  Interaction state
	 * @return True if the given interaction was handled, false otherwise
	 */
	public abstract boolean handleInteractionSuccess(Player player, String id, NetworkedObject object, int state);

	/**
	 * Handles interaction data requests
	 * 
	 * @param player Player making the interaction
	 * @param id     Interaction ID
	 * @param object Object that was interacted with
	 * @param state  Interaction state
	 * @return True if the given interaction request was handled, false otherwise
	 */
	public abstract boolean handleInteractionDataRequest(Player player, String id, NetworkedObject object, int state);

}
