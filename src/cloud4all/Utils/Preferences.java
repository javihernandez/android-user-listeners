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

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cloud4all.UserListener.NFC.R;


public class Preferences
{

    private SharedPreferences sp;
    private Editor spe;
    
    private static final String
        LOGIN = "IsLoggedIn",
        USER_ID = "UserLogin";

    public Preferences(Context c)
    {
        sp = c.getSharedPreferences(c.getString(R.string.app_name), Activity.MODE_PRIVATE);
    }

    public Boolean getIsLoggedIn()
    {
        return sp.getBoolean(LOGIN, false);
    }

    public String getLogin()
    {
        return sp.getString(USER_ID, null);
    }

    public void setLogin(String userID)
    {
        spe = sp.edit();
        spe.putBoolean(LOGIN, true);
        spe.putString(USER_ID, userID);
        spe.commit();
    }

    public void setLogout()
    {
        spe = sp.edit();
        spe.putBoolean(LOGIN, false);
        spe.putString(USER_ID, null);
        spe.commit();
    }

} // Preferences
