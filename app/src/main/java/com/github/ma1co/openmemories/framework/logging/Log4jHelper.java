package com.github.ma1co.openmemories.framework.logging;

import android.os.Environment;
import android.widget.TextView;

import org.apache.log4j.net.SocketAppender;

import java.net.SocketAddress;

import de.mindpipe.android.logging.log4j.LogConfigurator;

public class Log4jHelper {
    private final static LogConfigurator mLogConfigrator = new LogConfigurator();

    static {
        configureLog4j();
    }

    public static void configureTextViewAppender(TextView textView) {
        org.apache.log4j.Logger.getRootLogger().addAppender(new TextViewAppender(textView));
    }

    public static void configureSocketAppender(String host, int port) {
        SocketAppender socketAppender = new SocketAppender(host, port);
        org.apache.log4j.Logger.getRootLogger().addAppender(socketAppender);
    }

    private static void configureLog4j() {
        String fileName = Environment.getExternalStorageDirectory() + "/" + "log4j.log";
        String filePattern = "%d - [%c] - %p : %m%n%t";
        int maxBackupSize = 10;
        long maxFileSize = 1024 * 1024;

        configure( fileName, filePattern, maxBackupSize, maxFileSize );
    }

    private static void configure( String fileName, String filePattern, int maxBackupSize, long maxFileSize ) {
        mLogConfigrator.setFileName( fileName );
        mLogConfigrator.setMaxFileSize( maxFileSize );
        mLogConfigrator.setFilePattern(filePattern);
        mLogConfigrator.setMaxBackupSize(maxBackupSize);
        mLogConfigrator.setUseLogCatAppender(false);
        mLogConfigrator.configure();
    }

    public static org.apache.log4j.Logger getLogger( String name ) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger( name );
        return logger;
    }
}