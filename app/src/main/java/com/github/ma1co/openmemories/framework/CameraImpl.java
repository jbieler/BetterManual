package com.github.ma1co.openmemories.framework;

import android.util.Pair;

import com.github.ma1co.openmemories.framework.camsettings.Aperture;
import com.github.ma1co.openmemories.framework.camsettings.ExposureSettings;
import com.github.ma1co.openmemories.framework.camsettings.Iso;
import com.github.ma1co.openmemories.framework.camsettings.ShutterSpeed;
import com.sony.scalar.hardware.CameraEx;


public class CameraImpl implements Camera {

    private CameraEx cameraEx;
    private android.hardware.Camera normalCamera;

    public CameraImpl() {
        cameraEx = CameraEx.open(0, null);
        normalCamera = cameraEx.getNormalCamera();
    }

    @Override
    public ExposureSettings getExposureSettings() {
        return ExposureSettings.of(getAperture(), getShutterSpeed(), getIso());
    }

    @Override
    public void release() {
        cameraEx.release();
    }

    private Aperture getAperture() {
        final CameraEx.ParametersModifier paramsModifier = cameraEx.createParametersModifier(normalCamera.getParameters());
        int sonyApertureValue = paramsModifier.getAperture();
        double apertureValue = (double) sonyApertureValue / 100.0f;
        return Aperture.of(apertureValue);
    }

    private ShutterSpeed getShutterSpeed() {
        final CameraEx.ParametersModifier paramsModifier = cameraEx.createParametersModifier(normalCamera.getParameters());
        Pair<Integer, Integer> sonyShutterSpeed = paramsModifier.getShutterSpeed();
        return ShutterSpeed.fromFraction(sonyShutterSpeed.first, sonyShutterSpeed.second);
    }

    private Iso getIso() {
        final CameraEx.ParametersModifier paramsModifier = cameraEx.createParametersModifier(normalCamera.getParameters());
        int sonyIsoIndex = paramsModifier.getISOSensitivity();
        return Iso.of(sonyIsoIndex);
    }
}
