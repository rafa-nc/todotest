package br.com.todo.todotest.model;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tarefa;
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ToDoPrioridadeStatus status = ToDoPrioridadeStatus.MEDIA;

    public ToDo() {
    }

    public void setStatus(ToDoPrioridadeStatus status) {
        this.status = status;
    }

//    public ToDo(String tarefa, String descricao) {
//        this.tarefa = tarefa;
//        this.descricao = descricao;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public Long getId() {
        return id;
    }

    public ToDoPrioridadeStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
