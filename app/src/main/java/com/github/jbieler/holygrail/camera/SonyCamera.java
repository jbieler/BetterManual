package com.github.jbieler.holygrail.camera;


import com.github.jbieler.holygrail.camsettings.Aperture;
import com.github.jbieler.holygrail.camsettings.CameraSettings;
import com.github.jbieler.holygrail.camsettings.Iso;
import com.github.jbieler.holygrail.camsettings.ShutterSpeed;
import com.github.ma1co.openmemories.framework.CameraImpl;
import com.github.ma1co.openmemories.framework.camsettings.ExposureSettings;
/*
public class SonyCamera implements Camera {

    com.github.ma1co.openmemories.framework.Camera cameraHardware;

    public SonyCamera() {
        cameraHardware = new CameraImpl();
    }

    @Override
    public BufferedImage lastTakenImage() {
        return null;
    }

    @Override
    public CameraSettings cameraSettings() {
        ExposureSettings settings = cameraHardware.getExposureSettings();

        Aperture aperture = Aperture.of(settings.aperture.asDouble());
        ShutterSpeed shutterSpeed = ShutterSpeed.fromSeconds(settings.shutterSpeed.nominator() / settings.shutterSpeed.denominator());
        Iso iso = Iso.of(settings.iso.asInt());

        return CameraSettings.of(aperture, shutterSpeed, iso);
    }

    @Override
    public void adjustCameraSettings(CameraSettings cameraSettings) {

    }
}
*/