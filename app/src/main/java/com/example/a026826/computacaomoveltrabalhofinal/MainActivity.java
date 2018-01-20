package com.example.a026826.computacaomoveltrabalhofinal;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProximaPagina();
        ProximaPagina2();
    }

    public void dokkan(View v) {
        Intent dokkanDownload = new Intent(Intent.ACTION_VIEW, Uri.parse("https://us.battle.net/d3/en/"));
        startActivity(dokkanDownload);
    }

    public void ProximaPagina(){
        Button proximo = (Button) findViewById(R.id.list_btn);
        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

    }
    public void ProximaPagina2(){
        Button account_view = (Button)  findViewById(R.id.teambuild_btn);
        account_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AccountActivity.class));
            }
        });
    }
}