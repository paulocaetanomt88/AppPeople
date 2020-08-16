package com.example.appperson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import dao.UsuarioDAO;
import util.Mensagem;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario, edtSenha;
    private UsuarioDAO helper;
    private CheckBox ckbConectado;

    private static final String MANTER_CONECTADO = "manter_conectado";
    private static final String PREFERENCE_NAME = "LoginActivityPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = (EditText) findViewById(R.id.login_edtUsuario);
        edtSenha = (EditText) findViewById(R.id.login_edtSenha);
        ckbConectado = (CheckBox) findViewById(R.id.login_CkbConectado);

        helper = new UsuarioDAO(this);

        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        boolean conectado = preferences.getBoolean(MANTER_CONECTADO, false);

        if(conectado){
            ChamarMainActivity();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void logar(View view){
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        boolean validacao = true;

        if(usuario == null || usuario.equals("")) {
            validacao = false;
            edtUsuario.setError(getString(R.string.login_valUsuario));
        }

        if(usuario == null || senha.equals("")) {
            validacao = false;
            edtSenha.setError(getString(R.string.login_valSenha));
        }

        if(validacao){
            //logar
            if (helper.logar(usuario, senha)){
                if(ckbConectado.isChecked()){
                    SharedPreferences SharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = SharedPreferences.edit();

                    editor.putBoolean(MANTER_CONECTADO, true);
                    editor.commit();
                }
                ChamarMainActivity();
            } else {
                //Mensagem de Erro
                Mensagem.Msg(this, getString(R.string.msg_login_incorreto));
            }
        }
    }

    private void ChamarMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
