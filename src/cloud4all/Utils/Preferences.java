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
