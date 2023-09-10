package com.example.projetofinalpoo2.service;

import com.example.projetofinalpoo2.entity.Categoria;
import com.example.projetofinalpoo2.observer.Usuario;
import com.example.projetofinalpoo2.repository.CategoriaRepository;
import com.example.projetofinalpoo2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService { // classe de serviços que possui a implementação dos métodos necessários para manipular os dados do banco de dados
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarioList(){ //método para pegar uma lista possível de mostrar no front de todos os usuários no banco de dados
        Iterable<Usuario> usuarioIterable = this.usuarioRepository.findAll();
        return Streamable.of(usuarioIterable).toList();
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }
}
