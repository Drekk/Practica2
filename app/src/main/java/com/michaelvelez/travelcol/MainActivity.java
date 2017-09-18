package com.michaelvelez.travelcol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private String correoR,passwordR,a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Bundle extras = getIntent().getExtras();
//        correoR = extras.getString("correo");
//        passwordR = extras.getString("password");

        Bundle extras = this.getIntent().getExtras();
        if(extras !=null){
             correoR = extras.getString("correo");
             passwordR = extras.getString("password");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.mPerfil:
                intent = new Intent(MainActivity.this,PerfilActivity.class);
                intent.putExtra("correo",correoR);
                intent.putExtra("password",passwordR);

                startActivity(intent);
                finish();
                break;
            case R.id.mCerrar:
                intent = new Intent(MainActivity.this,LoginActivity.class);

                startActivity(intent);
                finish();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
