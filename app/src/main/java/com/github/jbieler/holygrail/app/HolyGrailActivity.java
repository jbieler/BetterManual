package com.github.jbieler.holygrail.app;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import com.github.ma1co.openmemories.framework.Camera;
import com.github.ma1co.openmemories.framework.CameraImpl;
import com.github.ma1co.openmemories.framework.WifiSupport;
import com.github.ma1co.openmemories.framework.camsettings.ExposureSettings;
import com.github.ma1co.openmemories.framework.logging.Log4jHelper;
import com.github.ma1co.pmcademo.app.LogActivity;

public class HolyGrailActivity extends LogActivity {

    org.apache.log4j.Logger LOG = Log4jHelper.getLogger( getClass().getName() );

    private WifiSupport wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi = new WifiSupport(wifiManager, this);
        wifi.enableWifi();

        LOG.info("Create holygrail");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LOG.info("resume holygrail");
        setAutoPowerOffMode(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setAutoPowerOffMode(true);
    }

    protected boolean onEnterKeyDown() {
        return true;
    }

    protected boolean onEnterKeyUp() {
        try {
            Camera camera = new CameraImpl();
            ExposureSettings settings = camera.getExposureSettings();
            LOG.info(settings);
            throw new RuntimeException("Boom");
        } catch (Exception e) {
            LOG.error("Ex", e);
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
