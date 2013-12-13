/**
 * android-user-listeners
 *  ----------------------
 *
 * Copyright 2013 UPM
 * Copyright 2013 Emergya
 *
 * Licensed under the New BSD license. You may not use this file except in
 * compliance with this License.
 *
 * You may obtain a copy of the License at
 * https://github.com/gpii/universal/LICENSE.txt
 *
 * The research leading to these results has received funding from the European
 * Union's Seventh Framework Programme (FP7/2007-2013) under grant agreement 
 * #289016.
 **/
package cloud4all.qr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import cloud4all.Utils.LauchEvent;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRScanActivity extends Activity
{

    private IntentIntegrator ii;

    private void backNoBarcode()
    {
        // Do something
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent i) 
    {
        if (requestCode!=RESULT_OK) {
            IntentResult res = IntentIntegrator.parseActivityResult(requestCode, resultCode, i);
            if (res!=null && res.getContents()!=null) {
                String contents = res.getContents();
                if (contents!=null)
                {
                    Log.i("Found content in QR code!", contents);
                    LauchEvent.loginReceived(this, contents);
                }
            }
            else backNoBarcode();
        }
        else backNoBarcode();
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ii = new IntentIntegrator(this);
        ii.initiateScan();
    }
}
