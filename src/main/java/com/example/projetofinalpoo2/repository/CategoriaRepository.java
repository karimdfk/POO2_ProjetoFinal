package com.example.projetofinalpoo2.repository;


import com.example.projetofinalpoo2.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> { //Interface de categoria que serve apenas para pegar os métodos do CrudRepository que manipulam dados no banco de dados
    @Override
    List<Categoria> findAll();
}
