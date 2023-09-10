package com.example.projetofinalpoo2.state;

import com.example.projetofinalpoo2.entity.Tarefa;

public class TarefaState { //classe criada para aplicação do padrão State

    private State state;
    private Tarefa tarefa; //tem como um dos atributos uma entidade tarefa para associar o estado à tarefa que está de fato no banco de dados

    public TarefaState(Tarefa tarefa) {
        this.tarefa = tarefa;
        this.state = new TarefaPendente(this, "Pendente");
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public String mudaState(State state) { //método para mudança de estado que muda o estado da TarefaState e o estado da entidade Tarefa que está no banco de dados
        this.tarefa.mudaState(state.getNome());
        this.state = state;
        return state.getNome();
    }
}
