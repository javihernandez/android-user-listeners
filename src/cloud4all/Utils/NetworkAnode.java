package cloud4all.Utils;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetworkAnode 
{
    public static void sendRequest(String anode) {
        AsyncTask<String, Void, Void> at = new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... url) {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet command = new HttpGet(url[0]);
                    HttpResponse response = client.execute(command);

                    InputStreamReader isr = new InputStreamReader(response.getEntity().getContent());
                    BufferedReader in = new BufferedReader(isr);
                    String res = in.readLine();
                    Log.d("GPIIUserListeners", "GPII has returned: " + res);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        at.execute(anode);
    }
}
