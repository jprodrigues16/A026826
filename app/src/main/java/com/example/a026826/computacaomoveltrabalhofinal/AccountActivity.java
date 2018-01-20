package com.example.a026826.computacaomoveltrabalhofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by A026826 on 16/01/2018.
 */

public class AccountActivity extends AppCompatActivity {

    private static final String TAG = AccountActivity.class.getSimpleName();
    private EditText battletag;
    private TextView tvAccount, tvChar, tvGuild, tvLastChar;
    private Button btn_add;
    private DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        battletag = (EditText) findViewById(R.id.battletag_input);
        tvAccount = (TextView) findViewById(R.id.battletag);
        tvChar = (TextView) findViewById(R.id.char_text);
        tvLastChar = (TextView) findViewById(R.id.lastchar_text);
        tvGuild = (TextView) findViewById(R.id.tv_guild);

        btn_add = (Button) findViewById(R.id.btn_add);
        AddData();
    }

    private void AddData() {
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = myDb.insertData(tvChar.getText().toString(),
                            tvGuild.getText().toString(),
                            tvLastChar.getText().toString() );
                }
            };
    }

    public void searchaccount(View view) {
        String palavraAdicionada = battletag.getText().toString();
        Log.i(TAG, "searchaccount: " + palavraAdicionada);
        new AsyncTask(tvAccount, tvChar, tvGuild, tvLastChar, btn_add).execute(palavraAdicionada);

    }
}
