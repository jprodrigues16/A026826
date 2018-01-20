package com.example.a026826.computacaomoveltrabalhofinal;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

/**
 * Created by A026826 on 16/01/2018.
 */

public class AsyncTask extends android.os.AsyncTask<String, Void, String> {
    private TextView tvAccount;
    private TextView tvChar;
    private TextView tvGuild;
    private TextView tvLastChar;
    private Button btn_add;
    private TextView info1;
    private TextView info2;
    private TextView info3;

    public AsyncTask(TextView tvAccount, TextView tvChar, TextView tvGuild, TextView tvLastChar, Button btn_add,
                     TextView info1, TextView info2, TextView info3) {
        this.tvChar = tvChar;
        this.tvAccount = tvAccount;
        this.tvGuild = tvGuild;
        this.tvLastChar = tvLastChar;
        this.info1 = info1;
        this.info2 = info2;
        this.info3 = info3;
        this.btn_add = btn_add;
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
            String jsonObject2 = null;
            String jsonObject3 = null;
            int jsonObject4 = 0;
            int jsonObject5 = 0;
            int jsonObject6 = 0;
            int jsonObject7 = 0;
            int jsonObject8 = 0;



            if (jsonObject.has("battleTag" + "guildName" + "paragonLevel" + "paragonLevelHardcore" + "paragonLevelSeason" +
                    "lastHeroPLayed" + "lastUpdated"))
                jsonObject2 = (String)jsonObject.get("battleTag");
                jsonObject3 = (String)jsonObject.get("guildName");
                jsonObject4 = (int)jsonObject.get("paragonLevel");
                jsonObject5 = (int)jsonObject.get("paragonLevelHardcore");
                jsonObject6 = (int)jsonObject.get("paragonLevelSeason");
                jsonObject7 = (int)jsonObject.get("lastHeroPlayed");
                jsonObject8 = (int)jsonObject.get("lastUpdated");
            try {
                jsonObject2 = jsonObject.getString("battleTag");
                jsonObject3 = jsonObject.getString("guildName");
                jsonObject4 = jsonObject.getInt("paragonLevel");
                jsonObject5 = jsonObject.getInt("paragonLevelHardcore");
                jsonObject6 = jsonObject.getInt("paragonLevelSeason");
                jsonObject7 = jsonObject.getInt("lastHeroPlayed");
                //jsonObject8 = jsonObject.getInt("lastUpdate");
                tvChar.setText("Last Update: " + jsonObject8 + "\nParagon Level: " + jsonObject4 + "\nParagon Level Hardcore: " +
                jsonObject5 + "\nParagon Level Season: " + jsonObject6);
                tvAccount.setText("" + jsonObject2);
                tvLastChar.setText("" + jsonObject7);
                tvGuild.setText("" + jsonObject3);
                btn_add.setVisibility(View.VISIBLE);
                info1.setVisibility(View.VISIBLE);
                info2.setVisibility(View.VISIBLE);
                info3.setVisibility(View.VISIBLE);
            } catch (Exception ez) {
                ez.printStackTrace();
            }


        /*for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject account = itemsArray.getJSONObject(i);
            String battletag = null;
            String hero = null;
            JSONObject volumeinfo = account.getJSONObject("heroes");
            try {
                battletag = volumeinfo.getString("name" + "class");
                hero = volumeinfo.getString("heroes");
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
*/
        } catch (Exception e) {
            tvAccount.setText("No Results found");
            tvChar.setText("This Battletag does not exist");
            e.printStackTrace();
        }

    }


}
