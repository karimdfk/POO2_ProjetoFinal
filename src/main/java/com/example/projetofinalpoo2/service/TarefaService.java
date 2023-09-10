package com.example.projetofinalpoo2.service;

import com.example.projetofinalpoo2.entity.Tarefa;
import com.example.projetofinalpoo2.repository.TarefaRepository;
import com.example.projetofinalpoo2.state.TarefaConcluida;
import com.example.projetofinalpoo2.state.TarefaPendente;
import com.example.projetofinalpoo2.state.TarefaState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService implements com.example.projetofinalpoo2.service.Service { // classe de serviços que possui a implementação dos métodos necessários para manipular os dados do banco de dados
    @Autowired
    private TarefaRepository tarefaRepository;

    public void save(Tarefa tarefa){
        this.tarefaRepository.save(tarefa);
    }

    public List<Tarefa> findALL() {
        return this.tarefaRepository.findAll();
    }

    public Tarefa findById(Long id) {
        return this.tarefaRepository.findById(id).get();
    }

    public void delete(Long id) {
        this.tarefaRepository.deleteById(id);
    }

    public void mudarEstadoTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalStateException());

        TarefaState tarefaState = new TarefaState(tarefa);

        if (tarefa.getEstado().equals("Concluido")) {
            tarefaState.mudaState(new TarefaPendente(tarefaState, "Pendente"));
            tarefa.mudaState("Pendente");
            tarefaRepository.save(tarefa);
        } else  {
            tarefaState.mudaState(new TarefaConcluida(tarefaState, "Concluido"));
            tarefa.mudaState("Concluido");
            tarefaRepository.save(tarefa);
        }


    }
}
