package com.example.projetofinalpoo2.state;

import com.example.projetofinalpoo2.entity.Tarefa;

public class TarefaConcluida extends State { //Classe do estado concreto "Concluido"


    public TarefaConcluida(TarefaState tarefa, String nome) { //construtor
        super(tarefa);
        this.nome = "Concluida";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void concluirTarefa() {
        System.out.println("Esta tarefa já está concluída");
    } //método de mudança de estado

    @Override
    public void reabrirTarefa() {
        tarefaState.mudaState(new TarefaPendente(tarefaState, "Pendente"));
    }//método de mudança de estado
}
