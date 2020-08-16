package com.example.appperson;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import adapter.UsuarioAdapter;
import dao.UsuarioDAO;
import model.Usuario;
import util.Mensagem;


public class ListUsuariosActivity extends AppCompatActivity implements
    AdapterView.OnItemClickListener, DialogInterface.OnClickListener {

    private ListView lista;
    private List<Usuario> usuarioList;
    private UsuarioAdapter usuarioAdapter;
    private UsuarioDAO usuarioDAO;

    private int idposicao;
    private AlertDialog alertDialog, alertConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_usuarios);

        alertDialog = Mensagem.criarAlertDialog(this);
        alertConfirmacao = Mensagem.criarDialogConfirmacao(this);

        usuarioDAO = new UsuarioDAO(this);
        usuarioList = usuarioDAO.listarUsuarios();
        usuarioAdapter = new UsuarioAdapter(this, usuarioList);

        lista = (ListView) findViewById(R.id.lvUsuarios);
        lista.setAdapter(usuarioAdapter);

        lista.setOnItemClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_list_usuarios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_cadastrar_usuario) {
            startActivity(new Intent(this, CadUsuarioActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = usuarioList.get(idposicao).get_id();

        switch (which){
            case 0:
                Intent intent = new Intent(this, CadUsuarioActivity.class);
                intent.putExtra("USUARIO_ID", id);
                startActivity(intent);
                break;
            case 1:
                alertConfirmacao.show();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                usuarioList.remove(idposicao);
                usuarioDAO.removerUsuario(id);
                lista.invalidateViews();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                alertConfirmacao.dismiss();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        idposicao = position;
        alertDialog.show();
    }
}
