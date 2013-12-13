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
package cloud4all.Utils;

public class ByteUtils
{

    /**
     * Converts a byte array into a String of its hexadecimal representation.
     * This method should be called statically.
     * @param data The array of bytes to be converted.
     * @return The hexadecimal String representation of the byte array.
     */
    public static String toHexString(byte[] data)
    {
        int c;
        String res = "", s;
        for (byte aux : data)
        {
            c = aux & 0xff;
            s = Integer.toHexString(c);
            if (s.length()==1) res += "0";
            res+=s;
        }
        return res;
    }
}
