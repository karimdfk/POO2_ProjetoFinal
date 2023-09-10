package com.example.projetofinalpoo2.controller;

import com.example.projetofinalpoo2.service.CategoriaService;
import com.example.projetofinalpoo2.service.TarefaService;
import com.example.projetofinalpoo2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
public abstract class Controller { //Classe abstrata que é herdada por todas as classes controllers do programa
    @Autowired
    protected TarefaService tarefaService ;

    @Autowired
    protected UsuarioService usuarioService;

    @Autowired
    protected CategoriaService categoriaService;

}
