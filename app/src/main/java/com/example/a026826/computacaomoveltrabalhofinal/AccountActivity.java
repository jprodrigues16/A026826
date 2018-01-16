package com.example.a026826.computacaomoveltrabalhofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by A026826 on 16/01/2018.
 */

public class AccountActivity extends AppCompatActivity {

    private static final String TAG = AccountActivity.class.getSimpleName();
    private EditText battletag;
    private TextView tvAccount, tvChar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        battletag = (EditText) findViewById(R.id.battletag_input);
        tvAccount = (TextView) findViewById(R.id.battletag);
        tvChar = (TextView) findViewById(R.id.char_text);

    }

    public void searchaccount(View view) {
        String palavraAdicionada = battletag.getText().toString();
        Log.i(TAG, "searchaccount: " + palavraAdicionada);

    }
}
