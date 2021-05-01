package ml.darubyminer360.twistcraft;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.Hand;

public class WrapperPlayClientBlockPlace extends AbstractPacket {
	public static final PacketType TYPE = PacketType.Play.Client.BLOCK_PLACE;

	public WrapperPlayClientBlockPlace() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayClientBlockPlace(PacketContainer packet) {
		super(packet, TYPE);
	}

	public Hand getHand() {
		return handle.getHands().read(0);
	}

	public void setHand(Hand value) {
		handle.getHands().write(0, value);
	}

	public long getTimestamp() {
		return handle.getLongs().read(0);
	}

	public void setTimestamp(long value) {
		handle.getLongs().write(0, value);
	}

}
