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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import cloud4all.Security.LoginReferences;
import cloud4all.UserListener.NFC.NdefLogin;
import cloud4all.UserListener.NFC.NfcWritingActivity;
import cloud4all.UserListener.NFC.R;
import cloud4all.qr.QRGenActivity;
import cloud4all.qr.QRScanActivity;

public class Main extends NfcWritingActivity
{
    private Button NFCWriteButton;
    private Button QRGenButton;
    private Button QRReadButton;

    private enum UserListenerMode {
        QR,
        NFC
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        NFCWriteButton = (Button)findViewById(R.id.buttonnfc);
        NFCWriteButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                storeUserToken(UserListenerMode.NFC);
            }
        });

        // Disable NFC button if the device doesn't support NFC
        //
        if (NfcAdapter.getDefaultAdapter(this) == null) {
            NFCWriteButton.setEnabled(false);
        }

        QRGenButton = (Button)findViewById(R.id.buttonqrgen);
        QRGenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                storeUserToken(UserListenerMode.QR);
            }
        });

        QRReadButton = (Button)findViewById(R.id.buttonqrread);
        QRReadButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                                           QRScanActivity.class);
                startActivity(intent);
            }
        });
    }

    private void storeUserToken(final UserListenerMode mode) {
        String message = "";

        final EditText input = new EditText(this);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        if (mode.equals(UserListenerMode.QR)) {
            message = getResources().getString(R.string.qr_message);
        } else if (mode.equals(UserListenerMode.NFC)) {
            message = getResources().getString(R.string.nfc_message);
        }

        dialog.setMessage(message);
        dialog.setView(input);

        dialog.setPositiveButton(getResources().getString(R.string.continue_label),
                                 new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String userToken = input.getText().toString();
                if (mode.equals(UserListenerMode.NFC)) {
                    msg = new NdefLogin(userToken).createNdefMessage();
                } else if (mode.equals(UserListenerMode.QR)) {
                    Intent intent = new Intent(getApplicationContext(),
                                               QRGenActivity.class);
                    intent.putExtra(LoginReferences.USERNAME, userToken);
                    startActivity(intent);
                }
                return;
            }
        });

        dialog.setNegativeButton(getResources().getString(R.string.cancel_label),
                                 new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // do nothing
                return;
            }
        });

        dialog.create().show();
    }

}
