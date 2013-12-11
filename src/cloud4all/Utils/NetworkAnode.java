package cloud4all.Utils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class NetworkAnode
{

    public static void sendRequest(String anode)
    {
        AsyncTask<String, Void, Void> at = new AsyncTask<String, Void, Void>()
        {
            @Override
            protected Void doInBackground(String... url)
            {
                try
    	        {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet command = new HttpGet(url[0]);
                    client.execute(command);
                }
    	        catch(Exception e) { e.printStackTrace(); }
                return null;
            }
        };
        at.execute(anode);
    }

}
