package com.github.ma1co.openmemories.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;

import com.github.ma1co.openmemories.framework.logging.Log4jHelper;
import com.github.ma1co.pmcademo.app.LogActivity;

import java.util.logging.Logger;

public class WifiSupport {
    private WifiManager wifiManager;
    private BroadcastReceiver wifiStateReceiver;
    private BroadcastReceiver supplicantStateReceiver;
    private BroadcastReceiver networkStateReceiver;

    org.apache.log4j.Logger LOG = Log4jHelper.getLogger( getClass().getName() );

    public WifiSupport(WifiManager wifiManager, Context context) {
        this.wifiManager = wifiManager;
        registerReceivers(context);
    }

    private void registerReceivers(Context context) {
        wifiStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                wifiStateChanged(intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN));
            }
        };

        supplicantStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                networkStateChanged(WifiInfo.getDetailedStateOf((SupplicantState) intent.getParcelableExtra(WifiManager.EXTRA_NEW_STATE)));
            }
        };

        networkStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                networkStateChanged(((NetworkInfo) intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO)).getDetailedState());
            }
        };

        context.registerReceiver(wifiStateReceiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
        context.registerReceiver(supplicantStateReceiver, new IntentFilter(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION));
        context.registerReceiver(networkStateReceiver, new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION));
    }

    public void enableWifi() {
        setWifiEnabled(true);
    }

    public void disableWifi() {
        setWifiEnabled(false);
    }

    public void setWifiEnabled(boolean isEnabled) {
        //String newState = isEnabled ? "Enabling" : "Disabling";
        //LOG.info(newState + " Wifi");
        wifiManager.setWifiEnabled(isEnabled);
    }

    protected void wifiStateChanged(int state) {
        switch (state) {
            case WifiManager.WIFI_STATE_ENABLING:
                LOG.info("Enabling wifi");
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                LOG.info("Wifi enabled");
                break;
        }
    }

    protected void networkStateChanged(NetworkInfo.DetailedState state) {
        String ssid = wifiManager.getConnectionInfo().getSSID();

        switch (state) {
            case CONNECTING:
                if (ssid != null) {
                    LOG.info(ssid + ": Connecting");
                }
                break;
            case AUTHENTICATING:
                LOG.info(ssid + ": Authenticating");
                break;
            case OBTAINING_IPADDR:
                LOG.info(ssid + ": Obtaining IP");
                break;
            case CONNECTED:
                if (ssid != null) {
                    String ip = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
                    LOG.info(ssid + ": Connected. IP: " + ip);
                }
                break;
            case DISCONNECTED:
                LOG.info("Disconnected");
                break;
            case FAILED:
                LOG.info("Connection failed");
                break;
        }
    }
}
