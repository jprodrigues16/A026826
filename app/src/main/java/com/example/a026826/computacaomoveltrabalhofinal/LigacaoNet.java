package com.example.a026826.computacaomoveltrabalhofinal;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by A026826 on 16/01/2018.
 */

public class LigacaoNet {
    private static final String LOG_TAG = LigacaoNet.class.getSimpleName();
    private static final String API_CONNECTION = "https://eu.api.battle.net/d3/profile/";
    private static final String SEARCH_ID = "";
    //private static final String MAX_RESULTS = "maxResults";

    @Nullable
    static String getAccountinfo(String pesquisaString) {
        HttpsURLConnection urlConnection = null;
        BufferedReader reader = null;
        String accountJSONString = null;

        //https://eu.api.battle.net/d3/profile/CiscoIvo%232899/?locale=en_GB&apikey=3fyhs7rjas7gbykdvrydkzcug7ms549x

        try {
            Uri builtUri = Uri.parse(API_CONNECTION).buildUpon()
                    .appendPath(pesquisaString)
                    .appendPath("")
                    .appendQueryParameter("", "locale")
                    .appendPath("en_GB&apikey")
                    .appendPath("3fyhs7rjas7gbykdvrydkzcug7ms549x")
                    .build();

            URL requestURL = new URL(builtUri.toString());

            urlConnection  = (HttpsURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null){
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) !=null) {
                buffer.append(line + "\n");
            }
            if(buffer.length() == 0) {
                return null;
            }
        accountJSONString = buffer.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        } finally {

        if(urlConnection != null){
            urlConnection.disconnect();
        }
        if(reader !=null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
        Log.d(LOG_TAG, accountJSONString);
        return accountJSONString;
    }
}

