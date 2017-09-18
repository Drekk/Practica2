package com.michaelvelez.travelcol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    private String correoR,passwordR;
    private TextView tNombre,tPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tNombre = (TextView)findViewById(R.id.tNombre);
        tPassword = (TextView)findViewById(R.id.tPassword);


        Bundle extras = getIntent().getExtras();
        correoR = extras.getString("correo");
        passwordR = extras.getString("password");

        tNombre.setText(correoR);
        tPassword.setText(passwordR);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mperfil,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.mPrincipal:
                intent = new Intent(PerfilActivity.this,MainActivity.class);
                intent.putExtra("correo",correoR);
                intent.putExtra("password",passwordR);


                startActivity(intent);
                finish();
                break;
            case R.id.mCerrar:
                intent = new Intent(PerfilActivity.this,LoginActivity.class);

                startActivity(intent);
                finish();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
