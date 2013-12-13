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
package cloud4all.UserListener.NFC;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import cloud4all.Utils.LauchEvent;

public class NfcReadingActivity extends NfcActivity
{

    protected void resolveIntent(Intent intent)
    {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action))
        {
            Parcelable[] rawMsg = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMsg!=null)
            {
                NdefMessage msg = (NdefMessage)rawMsg[0];
                NdefRecord[] recs = msg.getRecords();
                for (NdefRecord rec : recs)
                {
                    String text = new String(rec.getPayload());
                    Log.i("Found content in NFC tag!", text);
                    LauchEvent.loginReceived(this, text);
                }
            }
        }
        finish();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        resolveIntent(getIntent());
    }

}
