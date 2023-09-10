package com.example.projetofinalpoo2.service;

import com.example.projetofinalpoo2.entity.Categoria;
import com.example.projetofinalpoo2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements com.example.projetofinalpoo2.service.Service { // classe de serviços que possui a implementação dos métodos necessários para manipular os dados do banco de dados

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getCategoriaList(){ //método para retornar a lista de categorias dentro do banco de dados para mostrar no front end
        Iterable<Categoria> categoriaIterable = this.categoriaRepository.findAll();
        return Streamable.of(categoriaIterable).toList();
    }

    public List<Categoria> findAll() { //método que pega todas as categorias do banco de dados
        return this.categoriaRepository.findAll();
    }
}
