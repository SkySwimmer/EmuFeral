package org.asf.emuferal.packets.xt.gameserver.sanctuaries;

import java.io.IOException;

import org.asf.emuferal.data.XtReader;
import org.asf.emuferal.data.XtWriter;
import org.asf.emuferal.networking.smartfox.SmartfoxClient;
import org.asf.emuferal.packets.xt.IXtPacket;
import org.asf.emuferal.packets.xt.gameserver.inventory.InventoryItemPacket;
import org.asf.emuferal.players.Player;

public class SanctuaryLookSavePacket implements IXtPacket<SanctuaryLookSavePacket> {

	private static final String PACKET_ID = "sls";

	public String lookSlotId = null;
	public String lookSlotName = null;

	@Override
	public String id() {
		return PACKET_ID;
	}

	@Override
	public SanctuaryLookSavePacket instantiate() {
		return new SanctuaryLookSavePacket();
	}

	@Override
	public void parse(XtReader reader) throws IOException {
		lookSlotId = reader.read();
		lookSlotName = reader.read();
	}

	@Override
	public void build(XtWriter writer) throws IOException {
		writer.writeInt(-1); // Data prefix

		writer.writeString(lookSlotId);

		writer.writeString(""); // Data suffix
	}

	@Override
	public boolean handle(SmartfoxClient client) throws IOException {
		// Switch sanctuary look
		Player plr = (Player) client.container;

		// Log
		if (System.getProperty("debugMode") != null) {
			System.out.println("[SANCTUARYEDITOR] [SAVELOOK]  Client to server (lookSlotId: " + lookSlotId
					+ ", lookSlotName: " + lookSlotName + ")");
		}

		// save active look into that slot

		plr.account.getPlayerInventory().getSanctuaryAccessor().saveSanctuaryLookToSlot(plr.activeSanctuaryLook,
				lookSlotId, lookSlotName);

		// send an il response

		var il = plr.account.getPlayerInventory().getItem("201");
		var ilPacket = new InventoryItemPacket();
		ilPacket.item = il;

		// send IL
		plr.client.sendPacket(ilPacket);

		// send this packet

		if (System.getProperty("debugMode") != null) {
			System.out.println("[SANCTUARYEDITOR] [SAVELOOK]  Server to client IL: " + ilPacket.build());
		}

		il = plr.account.getPlayerInventory().getItem("5");
		ilPacket = new InventoryItemPacket();
		ilPacket.item = il;

		// send IL
		plr.client.sendPacket(ilPacket);

		// send this packet

		if (System.getProperty("debugMode") != null) {
			System.out.println("[SANCTUARYEDITOR] [SAVELOOK]  Server to client IL: " + ilPacket.build());
		}

		il = plr.account.getPlayerInventory().getItem("6");
		ilPacket = new InventoryItemPacket();
		ilPacket.item = il;

		// send IL
		plr.client.sendPacket(ilPacket);

		// send this packet

		if (System.getProperty("debugMode") != null) {
			System.out.println("[SANCTUARYEDITOR] [SAVELOOK]  Server to client IL: " + ilPacket.build());
		}

		il = plr.account.getPlayerInventory().getItem("10");
		ilPacket = new InventoryItemPacket();
		ilPacket.item = il;

		// send IL
		plr.client.sendPacket(ilPacket);

		// send this packet

		if (System.getProperty("debugMode") != null) {
			System.out.println("[SANCTUARYEDITOR] [SAVELOOK]  Server to client IL: " + ilPacket.build());
		}

		plr.client.sendPacket(this);

		if (System.getProperty("debugMode") != null) {
			System.out.println("[SANCTUARYEDITOR] [SAVELOOK]  Server to client SSL: " + this.build());
		}

		return true;
	}

}
