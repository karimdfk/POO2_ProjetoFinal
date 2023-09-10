package com.example.projetofinalpoo2.observer;

import com.example.projetofinalpoo2.entity.Tarefa;
import com.example.projetofinalpoo2.state.TarefaState;

public interface Observer { //Interface Observer que é implementada por usuário que é o interessado nas mudanças das tarefas
    public void Atualiza(Tarefa t);
}
