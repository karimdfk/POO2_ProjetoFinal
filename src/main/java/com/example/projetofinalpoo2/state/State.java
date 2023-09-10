package com.example.projetofinalpoo2.state;

import com.example.projetofinalpoo2.entity.Tarefa;

public abstract class State { //classe abstrata de State que sera extendida por todos os estados concretos

    protected TarefaState tarefaState; //instanciação do tarefaState que teve que ser criado para a plicar o padrão pois na entidade tarefa não era possível passar um atributo de tipo State

    protected  String nome; // foi colocado um nome para poder associar esse nome na entidade tarefa de fato

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public State(TarefaState tarefa){
        this.tarefaState = tarefa;
    }



    public abstract void concluirTarefa(); //muda o estado da tarefa de pendente para concluída
    public abstract void reabrirTarefa(); //muda o estado da tarefa de concluida para pendente

}
