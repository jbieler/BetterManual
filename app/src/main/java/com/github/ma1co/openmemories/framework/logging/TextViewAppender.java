package com.github.ma1co.openmemories.framework.logging;

import android.widget.TextView;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class TextViewAppender extends AppenderSkeleton {

    private final TextView textView;

    private static final String defaultLogPattern = "[%p] %c{3} - %m%n%throwable";

    public TextViewAppender(TextView textView) {
        this(textView, new EnhancedPatternLayout(defaultLogPattern));
    }

    public TextViewAppender(TextView textView, Layout layout) {
        this.textView = textView;
        setLayout(layout);
    }

    @Override
    protected void append(LoggingEvent event) {
        textView.append(getLayout().format(event));
    }

    @Override
    public void close() {
        // Nothing to do
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
