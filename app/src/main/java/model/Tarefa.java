package model;

public class Tarefa {

    private Integer _id;
    private String tarefa;
    private String dt_criacao;
    private String dt_completado;

    public Tarefa(){}

    public Tarefa(Integer id, String tarefa, String dt_criacao, String dt_completado){
        this._id = id;
        this.tarefa = tarefa;
        this.dt_criacao = dt_criacao;
        this.dt_completado = dt_completado;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public String getDt_completado() {
        return dt_completado;
    }

    public void setDt_completado(String dt_completado) {
        this.dt_completado = dt_completado;
    }
}
