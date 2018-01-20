package com.example.a026826.computacaomoveltrabalhofinal;

import android.content.Intent;
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
    private TextView tvAccount, tvChar, tvGuild, tvLastChar, info1, info2, info3;
    private Button btn_add, home_btn, card_btn;
    private DatabaseHelper myDb;

    String[] battleTag = { "CiscoIvo#2988","pberna#2814","Psasp91#2972" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        battletag = (EditText) findViewById(R.id.battletag_input);
        tvAccount = (TextView) findViewById(R.id.battletag);
        info1 = (TextView) findViewById(R.id.info1);
        info2 = (TextView) findViewById(R.id.info2);
        info3 = (TextView) findViewById(R.id.info3);
        tvChar = (TextView) findViewById(R.id.char_text);
        tvLastChar = (TextView) findViewById(R.id.lastchar_text);
        tvGuild = (TextView) findViewById(R.id.tv_guild);
        home_btn = (Button) findViewById(R.id.home_btn2);
        card_btn = (Button) findViewById(R.id.card_btn2);

        btn_add = (Button) findViewById(R.id.btn_add);
        myDb = new DatabaseHelper(this);
        AddData();
        menuBtns();
    }

    public void searchaccount(View view) {
        String palavraAdicionada = battletag.getText().toString();
        Log.i(TAG, "searchaccount: " + palavraAdicionada);
        new AsyncTask(tvAccount, tvChar, tvGuild, tvLastChar, btn_add, info1, info2, info3).execute(palavraAdicionada);

    }

    public void menuBtns(){
        Button home = (Button) findViewById(R.id.home_btn2);
        Button lista = (Button) findViewById(R.id.home_btn2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, MainActivity.class));
            }
        });
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, ListActivity.class));
            }
        });
    }

    private void AddData() {
        btn_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(tvAccount.getText().toString(),
                                tvGuild.getText().toString(),
                                tvLastChar.getText().toString() );
                    }
                });
    }
}
