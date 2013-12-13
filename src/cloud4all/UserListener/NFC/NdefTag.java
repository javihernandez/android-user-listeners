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

public abstract class NdefTag
{

    /**
     * Generic Mime Type for the record.
     */
    public static final String MIME_TYPE = 
        "cloud4all/cloud4all.userlistener.nfc";

    /**
     * Abstraction of the NdefMessage creation for generic fields.
     */
    public abstract NdefMessage createNdefMessage();

}
