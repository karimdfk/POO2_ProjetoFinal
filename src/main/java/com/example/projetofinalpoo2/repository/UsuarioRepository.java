package com.example.projetofinalpoo2.repository;

import com.example.projetofinalpoo2.observer.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> { //Interface de usuário que serve apenas para pegar os métodos do CrudRepository que manipulam dados no banco de dados
    @Override
    List<Usuario> findAll();
}
