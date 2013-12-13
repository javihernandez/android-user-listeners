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

import android.content.Context;
import android.widget.Toast;

public class LauchEvent
{

    private static final String 
        HOST = "http://localhost:8081/",
        LOGIN = "/login",
        USER = "user/",
        LOGOUT = "/logout";

    public static void loginReceived(Context c, String userID)
    {
        Preferences pref = new Preferences(c);

        if (pref.getIsLoggedIn())
        {
            String user = pref.getLogin();
            pref.setLogout();
            Toast.makeText(c, "Logout from user " + user, Toast.LENGTH_LONG).show();
            NetworkAnode.sendRequest(HOST + USER + user + LOGOUT);
            if (user!=null && !user.equals(userID))
            {
                pref.setLogin(userID);
                Toast.makeText(c, "Login user " + userID, Toast.LENGTH_LONG).show();
                NetworkAnode.sendRequest(HOST + USER + userID + LOGIN);
            }
        }
        else
        {
            pref.setLogin(userID);
            Toast.makeText(c, "Login user " + userID, Toast.LENGTH_LONG).show();
            NetworkAnode.sendRequest(HOST + USER + userID + LOGIN);
        }
    }

}
