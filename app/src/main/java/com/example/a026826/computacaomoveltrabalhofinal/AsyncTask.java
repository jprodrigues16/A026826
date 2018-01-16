package com.example.a026826.computacaomoveltrabalhofinal;

import android.widget.TextView;

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
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
    @Override
    protected String doInBackground(String... params) {
        return null;
    }


}
