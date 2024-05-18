package ai.tecton.telemetry.packet;

import ai.tecton.telemetry.model.CarTelemetryData;
import ai.tecton.telemetry.model.PacketHeader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CarTelemetryPacket {
    private PacketHeader header;
    private CarTelemetryData[] carTelemetryData = new CarTelemetryData[22];
    private int mfdPanelIndex;
    private int mfdPanelIndexSecondaryPlayer;
    private int suggestedGear;

    public static CarTelemetryPacket fromBytes(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        CarTelemetryPacket packet = new CarTelemetryPacket();
        packet.header = PacketHeader.fromBytes(data);

        for (int i = 0; i < 22; i++) {
            packet.carTelemetryData[i] = CarTelemetryData.fromBytes(buffer);
        }

        packet.mfdPanelIndex = buffer.get();
        packet.mfdPanelIndexSecondaryPlayer = buffer.get();
        packet.suggestedGear = buffer.get();

        return packet;
    }

	public PacketHeader getHeader() {
		return header;
	}

	public void setHeader(PacketHeader header) {
		this.header = header;
	}

	public CarTelemetryData[] getCarTelemetryData() {
		return carTelemetryData;
	}

	public void setCarTelemetryData(CarTelemetryData[] carTelemetryData) {
		this.carTelemetryData = carTelemetryData;
	}

	public int getMfdPanelIndex() {
		return mfdPanelIndex;
	}

	public void setMfdPanelIndex(int mfdPanelIndex) {
		this.mfdPanelIndex = mfdPanelIndex;
	}

	public int getMfdPanelIndexSecondaryPlayer() {
		return mfdPanelIndexSecondaryPlayer;
	}

	public void setMfdPanelIndexSecondaryPlayer(int mfdPanelIndexSecondaryPlayer) {
		this.mfdPanelIndexSecondaryPlayer = mfdPanelIndexSecondaryPlayer;
	}

	public int getSuggestedGear() {
		return suggestedGear;
	}

	public void setSuggestedGear(int suggestedGear) {
		this.suggestedGear = suggestedGear;
	}
}

