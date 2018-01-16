package com.example.a026826.computacaomoveltrabalhofinal;

import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by A026826 on 16/01/2018.
 */

public class AsyncTask extends android.os.AsyncTask<String, Void, String> {
    private TextView tvAccount;
    private TextView tvChar;;

    public AsyncTask(TextView tvAccount, TextView tvChar) {
        this.tvChar = tvChar;
        this.tvAccount = tvAccount;
    }

    @Override
    protected String doInBackground(String... strings) {
        return LigacaoNet.getAccountinfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try{

        JSONObject jsonObject = new JSONObject(s);
        JSONArray itemsArray = jsonObject.getJSONArray("items");

        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject account = itemsArray.getJSONObject(i);
            String battletag = null;
            String hero = null;
            JSONObject volumeinfo = account.getJSONObject("volumes");
            try {
                battletag = volumeinfo.getString("battletag");
                hero = volumeinfo.getString("hero");
            }

            catch (Exception x) {
                x.printStackTrace();
            }

            if (battletag!=null && hero!=null) {
                tvAccount.setText(battletag);
                tvChar.setText(hero);
                return;
            }
        }

            tvAccount.setText("No Results found");
            tvChar.setText("");

        } catch (Exception e) {
            tvAccount.setText("No Results found");
            tvChar.setText("");
            e.printStackTrace();
        }

    }


}
