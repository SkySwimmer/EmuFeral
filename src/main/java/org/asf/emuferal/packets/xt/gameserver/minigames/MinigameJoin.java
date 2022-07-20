package org.asf.emuferal.packets.xt.gameserver.minigames;

import java.io.IOException;

import org.asf.emuferal.data.XtReader;
import org.asf.emuferal.data.XtWriter;
import org.asf.emuferal.networking.smartfox.SmartfoxClient;
import org.asf.emuferal.packets.xt.IXtPacket;
import org.asf.emuferal.players.Player;
import org.asf.emuferal.packets.xt.gameserver.world.JoinRoom;

public class MinigameJoin implements IXtPacket<MinigameJoin> {

	private static final String PACKET_ID = "mj";
    public int MinigameID;
	
	@Override
	public MinigameJoin instantiate() {
		return new MinigameJoin();
	}

	@Override
	public String id() {
		return PACKET_ID;
	}

	@Override
	public void parse(XtReader reader) throws IOException {
        MinigameID = reader.readInt();
	}

	@Override
	public void build(XtWriter writer) throws IOException {
	}

	@Override
	public boolean handle(SmartfoxClient client) throws IOException {
		// Make the client load the tutorial
		Player plr = (Player) client.container;

		//Set previous
        plr.previousLevelID = plr.levelID;
        plr.previousLevelType = plr.levelType;
        
        // Assign room
		plr.roomReady = false;
		plr.pendingLevelID = MinigameID;
		plr.pendingRoom = "room_" + MinigameID;
		plr.levelType = 1;

		// Send response
		JoinRoom join = new JoinRoom();
		join.levelType = plr.levelType;
		join.levelID = plr.pendingLevelID;
		client.sendPacket(join);

		// Log
		if (System.getProperty("debugMode") != null) {
			System.out.println("[JOINROOM]  Client to server (room: " + plr.pendingRoom + ", level: " + plr.pendingLevelID + ")");
		}

		return true;
	}

}
