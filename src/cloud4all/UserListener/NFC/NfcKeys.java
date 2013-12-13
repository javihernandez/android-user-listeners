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

public class NfcKeys
{

    public static final String
        bcast = "cloud4all",
        mode = "mode",
        id = "ID",
        err = "err";

    public static final int
        errOK = 0,
        errIO = -1,
        errProtected = -2,
        errStorageSpace = -3,
        errNotSupported = -4;
}
