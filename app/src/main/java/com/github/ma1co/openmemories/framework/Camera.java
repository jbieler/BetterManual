package com.github.ma1co.openmemories.framework;

import com.github.ma1co.openmemories.framework.camsettings.ExposureSettings;


public interface Camera {
    ExposureSettings getExposureSettings();
    void release();
}
