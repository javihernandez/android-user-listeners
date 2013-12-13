/**
 * android-user-listeners
 * ----------------------
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
package test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cloud4all.Security.LoginReferences;
import cloud4all.UserListener.NFC.NdefLogin;
import cloud4all.UserListener.NFC.NfcWritingActivity;
import cloud4all.UserListener.NFC.R;
import cloud4all.qr.QRGenActivity;
import cloud4all.qr.QRScanActivity;

public class Main extends NfcWritingActivity
{
    private Button button;
    private String content = "dieguito"; // Change for generating QR and NFC ID tokens.

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button = (Button)findViewById(R.id.buttonnfc);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = new NdefLogin(content).createNdefMessage();
            }
        });

        button = (Button)findViewById(R.id.buttonqrgen);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QRGenActivity.class);
                intent.putExtra(LoginReferences.USERNAME, content);
                startActivity(intent);
            }
        });

        button = (Button)findViewById(R.id.buttonqrread);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QRScanActivity.class);
                startActivity(intent);
            }
        });
    }
}
