package org.asf.emuferal.interactions.modules;

import java.util.ArrayList;
import java.util.List;

import org.asf.emuferal.interactions.dataobjects.NetworkedObject;
import org.asf.emuferal.interactions.dataobjects.StateInfo;
import org.asf.emuferal.players.Player;
import org.asf.emuferal.shops.ShopManager;

public class ShopkeeperModule extends InteractionModule {

	@Override
	public void prepareWorld(int levelID, List<String> ids, Player player) {
	}

	@Override
	public boolean canHandle(Player player, String id, NetworkedObject object) {
		// Check if this NPC is a shopkeeper
		for (ArrayList<StateInfo> states : object.stateInfo.values()) {
			for (StateInfo state : states) {
				if (!state.branches.isEmpty()) {
					for (ArrayList<StateInfo> branches : state.branches.values()) {
						for (StateInfo branch : branches)
							if (branch.command.equals("84") && branch.params.length == 3 && ShopManager.isShop(branch.params[2]))
								return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean handleInteractionSuccess(Player player, String id, NetworkedObject object, int state) {
		return false;
	}

	@Override
	public boolean handleInteractionDataRequest(Player player, String id, NetworkedObject object, int state) {
		// Prevent freezing
		player.client.sendPacket("%xt%$ui%-1%0%");
		return true;
	}

}
