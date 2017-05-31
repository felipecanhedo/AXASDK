package com.ca.axasdk;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ca.integration.CaMDOCallback;
import com.ca.integration.CaMDOIntegration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bStartTestTransaction,bStopTestTransaction;

    CaMDOCallback axacb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bStartTestTransaction = (Button)findViewById(R.id.bStartTestTransaction);
        bStopTestTransaction  = (Button)findViewById(R.id.bStopTestTransaction);
        bStartTestTransaction.setOnClickListener(this);
        bStopTestTransaction.setOnClickListener(this);

        axacb = new CaMDOCallback(new Handler()) {
            @Override
            public void onError(int errorCode, Exception exception) {
                Log.d("[CA MAA]","errorCode=" + errorCode + " trace=" + Log.getStackTraceString(exception));
            }
            @Override
            public void onSuccess(Bundle data) {
                Log.d("[CA MAA]","Successfully submitted transaction with Callback");
            }
        };

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bStartTestTransaction:
                Log.d("[CA MAA]","calling startApplicationTransaction");
                CaMDOIntegration.startApplicationTransaction("Test","Service",axacb);
                Log.d("[CA MAA]","called startApplicationTransaction");
                break;
            case R.id.bStopTestTransaction:
                Log.d("[CA MAA]","calling stopApplicationTransaction");
                CaMDOIntegration.stopApplicationTransaction("Test",axacb);
                Log.d("[CA MAA]","called stopApplicationTransaction");
                break;
        }
    }
}
