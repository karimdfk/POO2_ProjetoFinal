package com.example.projetofinalpoo2.repository;

import com.example.projetofinalpoo2.entity.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarefaRepository extends CrudRepository<Tarefa,Long> {//Interface de tarefa que serve apenas para pegar os métodos do CrudRepository que manipulam dados no banco de dados
    @Override
    List<Tarefa> findAll();

}
