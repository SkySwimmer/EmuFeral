package org.asf.emuferal.packets.xt.gameserver.inventory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

import org.asf.emuferal.data.XtReader;
import org.asf.emuferal.data.XtWriter;
import org.asf.emuferal.entities.inventory.InspirationCombineResult;
import org.asf.emuferal.networking.smartfox.SmartfoxClient;
import org.asf.emuferal.packets.xt.IXtPacket;
import org.asf.emuferal.players.Player;

public class InventoryItemInspirationCombinePacket implements IXtPacket<InventoryItemInspirationCombinePacket> {

	public int[] inspirationIds;
	public InspirationCombineResult result;
	
	@Override
	public InventoryItemInspirationCombinePacket instantiate() {
		return new InventoryItemInspirationCombinePacket();
	}

	@Override
	public String id() {	
		return "iic";
	}

	@Override
	public void parse(XtReader reader) {
		int inspirationCount = reader.readInt();
		
		inspirationIds = new int[inspirationCount];
		
		for(int i = 0; i < inspirationCount; i++)
		{
			inspirationIds[i] = reader.readInt();
		}
	}

	@Override
	public void build(XtWriter writer) throws IOException {
		writer.writeInt(-1); // Data prefix
		writer.writeString(result.combineStatus.name);
		writer.writeInt(result.enigmaDefId);			

		writer.writeString(""); // Empty suffix
	}

	@Override
	public boolean handle(SmartfoxClient client) throws IOException {
		Player plr = (Player) client.container;
		
		// Log
		if (System.getProperty("debugMode") != null) {
			String ids = "";
			
			for(var id : inspirationIds)
			{
				ids += id + ", ";
			}
			
			ids = ids.substring(0, ids.length() - 2);
			System.out.println("[INVENTORY] [UPDATE]  Client to server: Combine Inspirations using ids" + ids);
		}
		
		result = plr.account.getPlayerInventory().getInspirationAccessor().combineInspirations(inspirationIds, plr);
		
		//build packet
		
		plr.client.sendPacket(this);	
		
		if (System.getProperty("debugMode") != null) {
			System.out.println("[INVENTORY] [UPDATE]  Server to client: " + this.build());
		}
		
		return true;
	}
}
