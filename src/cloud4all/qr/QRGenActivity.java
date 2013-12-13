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
import android.os.Bundle;

import cloud4all.Security.LoginReferences;

import com.google.zxing.integration.android.IntentIntegrator;

public class QRGenActivity extends Activity
{
    private IntentIntegrator ii;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ii = new IntentIntegrator(this);
        
        Bundle content = getIntent().getExtras();
        if (content!=null)
        {
            String user = content.getString(LoginReferences.USERNAME);
            ii.shareText(user);
        }
    }
}
