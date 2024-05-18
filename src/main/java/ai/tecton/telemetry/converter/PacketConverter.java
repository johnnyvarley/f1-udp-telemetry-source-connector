package ai.tecton.telemetry.converter;

import org.apache.avro.generic.GenericData;

public interface PacketConverter<T> {
    T fromBytes(byte[] data);
    GenericData.Record toAvro(T packet);
}
