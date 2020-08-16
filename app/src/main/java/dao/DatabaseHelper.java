package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "tasks";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
       //Tabela de usuários
       db.execSQL("CREATE TABLE usuarios(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
       +" nome TEXT NOT NULL, login TEXT NOT NULL, senha TEXT NOT NULL, created_at TEXT)");

       //Tabela de tarefas
        db.execSQL("CREATE TABLE tarefas(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +" tarefa TEXT NOT NULL, dt_criacao TEXT, dt_completado TEXT)");

        db.execSQL("INSERT INTO usuarios(nome, login, senha) VALUES('Admin', 'curso', '123')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static class Usuarios {
        public static final String TABELA = "usuarios";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String LOGIN = "login";
        public static final String SENHA = "senha";
        public static final String CREATED_AT = "created_at";

        public static final String[] COLUNAS = new String[]{
                _ID, NOME, LOGIN, SENHA, CREATED_AT
        };
    }

    public static class Tarefas {
        public static final String TABELA = "tarefas";
        public static final String _ID = "_id";
        public static final String TAREFA = "tarefa";
        public static final String DT_CRIACAO = "dt_criacao";
        public static final String DT_COMPLETADO = "dt_completado";

        public static final String[] COLUNAS = new String[]{
                _ID, TAREFA, DT_CRIACAO, DT_COMPLETADO
        };
    }

}
