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
