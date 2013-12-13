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

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;

public class NdefLogin extends NdefTag
{

    /**
     * The username to be recorded into an NFC tag.
     */
    private String user;

    /**
     * The password of the user to be recorded into an NFC tag.
     * Its formatted as a 40 hexadecimal characters SHA1 String hash.
     */
    private String pass;

    /**
     * Creates an instance of the LoginNdef allowing to create
     * NdefMessages containing a username
     * @param username The username of the user.
     */
    public NdefLogin(String username) { //, String password)
        user = username;
        //pass = HashUtils.SHA1(password);
    }

    /**
     * Provides a NdefMessage structure with a pair (username).
     * @return The NdefMessage.
     */
    @Override
    public NdefMessage createNdefMessage() {
        byte[]
        id = new byte[0],
        mime = MIME_TYPE.getBytes(),
        u = user.getBytes();
        NdefRecord userRec = new NdefRecord(NdefRecord.TNF_MIME_MEDIA, mime, id, u);
        // If we want to add a passworkd too:
        //p = pass.getBytes();
        //NdefRecord passRec = new NdefRecord(NdefRecord.TNF_MIME_MEDIA, mime, id, p);
        NdefRecord[] recs = { userRec }; //, passRec };
        NdefMessage msg = new NdefMessage(recs);
        return msg;
    }

}
