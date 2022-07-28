package org.asf.emuferal.packets.xt.gameserver.minigames;

import java.io.IOException;

import org.asf.emuferal.data.XtReader;
import org.asf.emuferal.data.XtWriter;
import org.asf.emuferal.networking.gameserver.GameServer;
import org.asf.emuferal.networking.smartfox.SmartfoxClient;
import org.asf.emuferal.packets.xt.IXtPacket;
import org.asf.emuferal.players.Player;
import org.asf.emuferal.minigames.TwiggleBuilders;

public class MinigameMessage implements IXtPacket<MinigameMessage> {

	private static final String PACKET_ID = "mm";

    public String command;
    public String data;

	@Override
	public MinigameMessage instantiate() {
		return new MinigameMessage();
	}

	@Override
	public String id() {
		return PACKET_ID;
	}

	@Override
	public void parse(XtReader reader) throws IOException {
        command = reader.read();
		data = reader.readRemaining();
	}

	@Override
	public void build(XtWriter writer) throws IOException {
	}

	@Override
	public boolean handle(SmartfoxClient client) throws IOException {

		Player plr = (Player) client.container;

		// Log
		if (System.getProperty("debugMode") != null) {
			System.out.println(
					"[MINIGAME] [MESSAGE] Client to server (command: " + command + ")");
		}

		switch (plr.levelID) {
			case 4111: {
				TwiggleBuilders.HandleMessage(plr, command, data);
				break;
			}
		}

		return true;
	}

}
