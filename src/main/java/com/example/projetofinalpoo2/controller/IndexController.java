package com.example.projetofinalpoo2.controller;

import com.example.projetofinalpoo2.entity.Categoria;
import com.example.projetofinalpoo2.entity.Tarefa;
import com.example.projetofinalpoo2.factory.Factory;
import com.example.projetofinalpoo2.factory.ModelAndViewFactory;
import com.example.projetofinalpoo2.observer.Usuario;
import com.example.projetofinalpoo2.service.CategoriaService;
import com.example.projetofinalpoo2.service.TarefaService;
import com.example.projetofinalpoo2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController extends com.example.projetofinalpoo2.controller.Controller {

    private Factory mvFactory = new ModelAndViewFactory(); //Instanciação de uma Factory de ModelAndView para controle do front-end

    @GetMapping("/")
    public ModelAndView getList(){
        List<Tarefa> tarefaList = tarefaService.findALL(); //Criação de uma lista com todas as tarefas inseridas no banco de dados
        List<Categoria> categoriaList = this.categoriaService.findAll(); //Criação de uma lista com todas as categorias inseridas no banco de dados
        List<Usuario> usuarioList = this.usuarioService.findAll(); //Criação de uma lista com todos os usuários inseridos no banco de dados

        int x = 0; // criação de uma flag para comparação de datas de conclusão da tarefa e data atual para que o padrão observer notifique sobre o atraso
        ModelAndView mv = mvFactory.criaModelAndView("index"); //criação da parte gráfica no index.html
        mv.addObject("tarefaList", tarefaList); //add a lista de tarefas no front-end
        mv.addObject("categoriaList", categoriaList); //add a lista de categoria para aparecer no index também
        for(Tarefa t : tarefaList){ // percorre a lista de tarefas
            if(t.getFim().isEqual(LocalDate.now()) || t.getFim().isBefore(LocalDate.now())){ //analisa se a data de conclusão da tarefa já passou
                x = 1; //se o prazo estiver expirado a flag é acionada
                usuarioList.get(0).Atualiza(t); //uso do padrão observer para atualizar o usuário sobre o prazo da tarefa
            }
        }
        if(x == 1){
            mv.addObject("usuarioList", usuarioList);
        }
        return mv;
    }
}
