package model;

public class Usuario {

    private Integer _id;
    private String nome;
    private String login;
    private String senha;
    private String created_at;

    public Usuario(){}

    public Usuario(Integer id, String nome, String login, String senha, String created_at){
        this._id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.created_at = created_at;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
