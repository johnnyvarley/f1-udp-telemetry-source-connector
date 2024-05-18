package ai.tecton.telemetry.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Represents the header for all telemetry packets.
 */
public class PacketHeader {
    private int packetFormat;
    private int gameMajorVersion;
    private int gameMinorVersion;
    private int packetVersion;
    private int packetId;
    private long sessionUID;
    private float sessionTime;
    private int frameIdentifier;
    private int playerCarIndex;
    private int secondaryPlayerCarIndex;

    public static PacketHeader fromBytes(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        PacketHeader header = new PacketHeader();
        header.packetFormat = buffer.getShort() & 0xFFFF;
        header.gameMajorVersion = buffer.get() & 0xFF;
        header.gameMinorVersion = buffer.get() & 0xFF;
        header.packetVersion = buffer.get() & 0xFF;
        header.packetId = buffer.get() & 0xFF;
        header.sessionUID = buffer.getLong();
        header.sessionTime = buffer.getFloat();
        header.frameIdentifier = buffer.getInt();
        header.playerCarIndex = buffer.get() & 0xFF;
        header.secondaryPlayerCarIndex = buffer.get() & 0xFF;

        return header;
   }

	public int getPacketFormat() {
		return packetFormat;
	}

	public void setPacketFormat(int packetFormat) {
		this.packetFormat = packetFormat;
	}

	public int getGameMajorVersion() {
		return gameMajorVersion;
	}

	public void setGameMajorVersion(short gameMajorVersion) {
		this.gameMajorVersion = gameMajorVersion;
	}

	public int getGameMinorVersion() {
		return gameMinorVersion;
	}

	public void setGameMinorVersion(short gameMinorVersion) {
		this.gameMinorVersion = gameMinorVersion;
	}

	public int getPacketVersion() {
		return packetVersion;
	}

	public void setPacketVersion(short packetVersion) {
		this.packetVersion = packetVersion;
	}

	public int getPacketId() {
		return packetId;
	}

	public void setPacketId(short packetId) {
		this.packetId = packetId;
	}

	public long getSessionUID() {
		return sessionUID;
	}

	public void setSessionUID(long sessionUID) {
		this.sessionUID = sessionUID;
	}

	public float getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(float sessionTime) {
		this.sessionTime = sessionTime;
	}

	public int getFrameIdentifier() {
		return frameIdentifier;
	}

	public void setFrameIdentifier(int frameIdentifier) {
		this.frameIdentifier = frameIdentifier;
	}

	public int getPlayerCarIndex() {
		return playerCarIndex;
	}

	public void setPlayerCarIndex(short playerCarIndex) {
		this.playerCarIndex = playerCarIndex;
	}

	public int getSecondaryPlayerCarIndex() {
		return secondaryPlayerCarIndex;
	}

	public void setSecondaryPlayerCarIndex(short secondaryPlayerCarIndex) {
		this.secondaryPlayerCarIndex = secondaryPlayerCarIndex;
	}    
}
