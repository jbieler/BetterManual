package com.github.ma1co.openmemories.framework.camsettings;

public class ExposureSettings {

    public final Aperture aperture;
    public final ShutterSpeed shutterSpeed;
    public final Iso iso;

    private ExposureSettings(Aperture aperture, ShutterSpeed shutterSpeed, Iso iso) {
        this.aperture = aperture;
        this.shutterSpeed = shutterSpeed;
        this.iso = iso;
    }

    public ExposureSettings with(Aperture aperture) {
        return new ExposureSettings(aperture, this.shutterSpeed, this.iso);
    }

    public ExposureSettings with(ShutterSpeed shutterSpeed) {
        return new ExposureSettings(this.aperture, shutterSpeed, this.iso);
    }

    public ExposureSettings with(Iso iso) {
        return new ExposureSettings(this.aperture, this.shutterSpeed, iso);
    }

    public static ExposureSettings of(Aperture aperture, ShutterSpeed shutterSpeed, Iso iso) {
        return new ExposureSettings(aperture, shutterSpeed, iso);
    }

    public String toString() {
        return String.format("Exposure[%s, %s, %s]", shutterSpeed, aperture, iso);
    }
}
