package com.ca.integration;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/**
 * Callback for the {@link com.ca.integration.CaMDOIntegration} APIs
 *
 * Created by sugsh04 on 6/6/16.
 */
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public abstract class CaMDOCallback {

    public static final String UPLOAD_EVENT_COUNT = "upload_event_count";

    /**
     * Create a new callback.  The {@link #onError(int, Exception)} or
     * {@link #onSuccess(android.os.Bundle)} methods will be called from the thread
     * running <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public CaMDOCallback(Handler handler) {
    }

    /**
     * Called when an error occurred.
     * The method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null
     * @param errorCode Exception error code.
     * @param exception Exception that occurred
     */
    abstract public void onError(int errorCode, Exception exception);

    /**
     * Called when an the operation succeeds
     * The method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null
     * @param data Generic Bundle that can be used to pass data back to caller.
     */
    abstract public void onSuccess(Bundle data);

}
