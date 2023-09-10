package com.example.projetofinalpoo2.state;

import com.example.projetofinalpoo2.entity.Tarefa;

public class TarefaPendente extends State{


    public TarefaPendente(TarefaState tarefa, String nome) { //construtor
        super(tarefa);
        this.nome = "Pendente";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void concluirTarefa() {
        tarefaState.mudaState(new TarefaConcluida(tarefaState, "Concluida"));//método de mudança de estado

    }

    @Override
    public void reabrirTarefa() {
        System.out.println("Esta tarefa ainda está em aberto");
    }//método de mudança de estado
}
