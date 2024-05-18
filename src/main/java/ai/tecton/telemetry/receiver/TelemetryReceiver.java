package ai.tecton.telemetry.receiver;

import ai.tecton.telemetry.converter.CarTelemetryConverter;
import ai.tecton.telemetry.packet.CarTelemetryPacket;
import org.apache.avro.generic.GenericData;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TelemetryReceiver {

    private static final int PORT = 20777;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT, InetAddress.getByName("localhost"))) {
            byte[] buffer = new byte[2048];
            CarTelemetryConverter converter = new CarTelemetryConverter();

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                byte[] data = packet.getData();

                CarTelemetryPacket carTelemetryPacket = converter.fromBytes(data);
                GenericData.Record avroRecord = converter.toAvro(carTelemetryPacket);

                // Print the Avro record to the console
                System.out.println(avroRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
