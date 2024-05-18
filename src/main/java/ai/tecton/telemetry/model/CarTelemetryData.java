package ai.tecton.telemetry.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class CarTelemetryData {
    private int speed;
    private float throttle;
    private float steer;
    private float brake;
    private int clutch;
    private int gear;
    private int engineRPM;
    private int drs;
    private int revLightsPercent;
    private int revLightsBitValue;
    private int[] brakesTemperature = new int[4];
    private int[] tyresSurfaceTemperature = new int[4];
    private int[] tyresInnerTemperature = new int[4];
    private int engineTemperature;
    private float[] tyresPressure = new float[4];
    private int[] surfaceType = new int[4];

    public static CarTelemetryData fromBytes(ByteBuffer buffer) {
        CarTelemetryData telemetry = new CarTelemetryData();

        telemetry.speed = buffer.getShort() & 0xFFFF;
        telemetry.throttle = buffer.getFloat();
        telemetry.steer = buffer.getFloat();
        telemetry.brake = buffer.getFloat();
        telemetry.clutch = buffer.get() & 0xFF;
        telemetry.gear = buffer.get();
        telemetry.engineRPM = buffer.getShort() & 0xFFFF;
        telemetry.drs = buffer.get() & 0xFF;
        telemetry.revLightsPercent = buffer.get() & 0xFF;
        telemetry.revLightsBitValue = buffer.getShort() & 0xFFFF;

        for (int i = 0; i < 4; i++) {
            telemetry.brakesTemperature[i] = buffer.getShort() & 0xFFFF;
        }
        for (int i = 0; i < 4; i++) {
            telemetry.tyresSurfaceTemperature[i] = buffer.get() & 0xFF;
        }
        for (int i = 0; i < 4; i++) {
            telemetry.tyresInnerTemperature[i] = buffer.get() & 0xFF;
        }
        telemetry.engineTemperature = buffer.getShort() & 0xFFFF;
        for (int i = 0; i < 4; i++) {
            telemetry.tyresPressure[i] = buffer.getFloat();
        }
        for (int i = 0; i < 4; i++) {
            telemetry.surfaceType[i] = buffer.get() & 0xFF;
        }

        return telemetry;
    }

    // Getters and setters...

    @Override
    public String toString() {
        return "CarTelemetryData{" +
                "speed=" + speed +
                ", throttle=" + throttle +
                ", steer=" + steer +
                ", brake=" + brake +
                ", clutch=" + clutch +
                ", gear=" + gear +
                ", engineRPM=" + engineRPM +
                ", drs=" + drs +
                ", revLightsPercent=" + revLightsPercent +
                ", revLightsBitValue=" + revLightsBitValue +
                ", brakesTemperature=" + Arrays.toString(brakesTemperature) +
                ", tyresSurfaceTemperature=" + Arrays.toString(tyresSurfaceTemperature) +
                ", tyresInnerTemperature=" + Arrays.toString(tyresInnerTemperature) +
                ", engineTemperature=" + engineTemperature +
                ", tyresPressure=" + Arrays.toString(tyresPressure) +
                ", surfaceType=" + Arrays.toString(surfaceType) +
                '}';
    }
}
