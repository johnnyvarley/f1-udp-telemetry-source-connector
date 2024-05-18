package ai.tecton.telemetry.converter;

import ai.tecton.telemetry.avro.CarTelemetryData;
import ai.tecton.telemetry.packet.CarTelemetryPacket;

import java.util.Arrays;

import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecordBuilder;

public class CarTelemetryConverter implements PacketConverter<CarTelemetryPacket> {

    @Override
    public CarTelemetryPacket fromBytes(byte[] data) {
        return CarTelemetryPacket.fromBytes(data);
    }

    @Override
    public GenericData.Record toAvro(CarTelemetryPacket packet) {
        CarTelemetryData carTelemetryData = packet.getCarTelemetryData()[packet.getHeader().getPlayerCarIndex()];

        return new GenericRecordBuilder(CarTelemetryData.getClassSchema())
            .set("speed", carTelemetryData.getSpeed())
            .set("throttle", carTelemetryData.getThrottle())
            .set("steer", carTelemetryData.getSteer())
            .set("brake", carTelemetryData.getBrake())
            .set("clutch", carTelemetryData.getClutch())
            .set("gear", carTelemetryData.getGear())
            .set("engineRPM", carTelemetryData.getEngineRPM())
            .set("drs", carTelemetryData.getDrs())
            .set("revLightsPercent", carTelemetryData.getRevLightsPercent())
            .set("revLightsBitValue", carTelemetryData.getRevLightsBitValue())
            .set("brakesTemperature", Arrays.asList(carTelemetryData.getBrakesTemperature()))
            .set("tyresSurfaceTemperature", Arrays.asList(carTelemetryData.getTyresSurfaceTemperature()))
            .set("tyresInnerTemperature", Arrays.asList(carTelemetryData.getTyresInnerTemperature()))
            .set("engineTemperature", carTelemetryData.getEngineTemperature())
            .set("tyresPressure", Arrays.asList(carTelemetryData.getTyresPressure()))
            .set("surfaceType", Arrays.asList(carTelemetryData.getSurfaceType()))
            .build();
    }
}
