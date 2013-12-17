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

import cloud4all.Utils.LauchEvent;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.io.UnsupportedEncodingException;

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
                    short tnfType = rec.getTnf();
                    
                    if (tnfType == NdefRecord.TNF_MIME_MEDIA) {
                        String text = new String(rec.getPayload());
                        Log.i("Found TNF_MIME_MEDIA content", text);
                        LauchEvent.loginReceived(this, text);
                    } else if (tnfType == NdefRecord.TNF_WELL_KNOWN) {
                        byte[] payload = rec.getPayload();
                        // Get the Text Encoding
                        String textEncoding = ((payload[0] & 0200) == 0) ? "UTF-8" : "UTF-16";
                        // Get the Language Code
                        int languageCodeLength = payload[0] & 0077;
                        try {
                            String text = new String(payload,
                                                     languageCodeLength + 1,
                                                     payload.length - languageCodeLength - 1,
                                                     textEncoding);
                            Log.i("Found TNF_WELL_KNOWN content", text);
                            LauchEvent.loginReceived(this, text.toString());
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
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
