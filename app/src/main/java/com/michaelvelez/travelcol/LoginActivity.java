package com.michaelvelez.travelcol;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private String correoR,passwordR,correoC,passwordC,cp,cc;
    private EditText eCorreo,ePassword;
    private Button bIniciar;
    private TextView tRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eCorreo = (EditText)findViewById(R.id.eCorreo);
        ePassword = (EditText)findViewById(R.id.ePassword);
        bIniciar = (Button) findViewById(R.id.bIniciar);
        tRegistrar = (TextView)findViewById(R.id.tRegistrar);


        cargar();



    }

    public void cargar(){
        SharedPreferences cargar= getSharedPreferences("preferencias",Context.MODE_PRIVATE);

        eCorreo.setText(cargar.getString("email",""));
        ePassword.setText(cargar.getString("pass",""));
        correoR = eCorreo.getText().toString();
        passwordR=ePassword.getText().toString();
        eCorreo.setText("");
        ePassword.setText("");

    }



    public void guardar(){
        SharedPreferences cargar= getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = cargar.edit();
        cp = ePassword.getText().toString();
        cc = eCorreo.getText().toString();
        editor.putString("email",cc);
        editor.putString("pass",cp);
        correoR = cc;passwordR=cp;
        editor.commit();


    }

    public void iniciar (View view){

        passwordC = ePassword.getText().toString();
        correoC = eCorreo.getText().toString();


        if (correoC.equals(correoR) && passwordC.equals(passwordR)){
            guardar();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("correo",correoR);
        intent.putExtra("password",passwordR);
        startActivity(intent);
        finish();}

        else{ eCorreo.setText("");
        ePassword.setText("");
        eCorreo.setError("Usuario o contraseña incorrecta!");
        eCorreo.requestFocus();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1234 && resultCode == RESULT_OK){

            correoR = data.getExtras().getString("correo");
            passwordR = data.getExtras().getString("password");
            eCorreo.setText("");
            ePassword.setText("");
            eCorreo.setError("Digite los datos!");

           // Toast.makeText(this,correoR,Toast.LENGTH_SHORT).show();
            Log.d("correo",correoR);
            Log.d("password",passwordR);


        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void registrar(View view) {

        Intent intent = new Intent(LoginActivity.this,RegistroActivity.class);
        startActivityForResult(intent,1234);

    }
}
