package com.example.projetofinalpoo2.controller;

import com.example.projetofinalpoo2.entity.Categoria;
import com.example.projetofinalpoo2.entity.Tarefa;
import com.example.projetofinalpoo2.factory.Factory;
import com.example.projetofinalpoo2.factory.ModelAndViewFactory;
import com.example.projetofinalpoo2.service.CategoriaService;
import com.example.projetofinalpoo2.service.TarefaService;
import com.example.projetofinalpoo2.state.TarefaConcluida;
import com.example.projetofinalpoo2.state.TarefaPendente;
import com.example.projetofinalpoo2.state.TarefaState;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class TarefaController extends com.example.projetofinalpoo2.controller.Controller { //Controller da página de criação de tarefa

    private final Factory mvFactory = new ModelAndViewFactory(); //instanciação de uma factory de ModelAndView



    @GetMapping("/tarefa/form/add")
    public ModelAndView getFormAdd(){ //método para pegar a lista de categorias para ser selecionado na criação da tarefa
        ModelAndView mv = mvFactory.criaModelAndView("tarefaForm"); //criação do front end da página de criação de tarefas
        List<Categoria> categoriaList = this.categoriaService.getCategoriaList(); // criação da lista de categorias
        mv.addObject("categoriaList", categoriaList); //Codigo para o formulario ter acesso as categorias cadastradas no banco

        return mv;
    }


    @PostMapping("/tarefa/form/save")
    public String saveTarefa(@Valid Tarefa tarefa, BindingResult result, RedirectAttributes redirect){ //método para salvar a tarefa a ser inserida
        if (result.hasErrors()){ //tratamento de erros
            redirect.addFlashAttribute("mensagem","Favor verificar campos obrigatorios");
            return "redirect:/tarefa/form/add";
        }
        this.tarefaService.save(tarefa); // aão de salvar a terfa quando o botão de save é clicado
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable Long id){ // método para quando for necessário editar uma tarefa

        ModelAndView mv = mvFactory.criaModelAndView("tarefaForm"); //criação do model and view para front end
        List<Categoria> categoriaList = this.categoriaService.getCategoriaList(); //Lista de categorias
        mv.addObject("categoriaList", categoriaList); //Codigo para o formulario ter acesso as categorias cadastradas no banco

        Tarefa tarefa = this.tarefaService.findById(id); //acha a tarefa a ser editada no banco de dados
        mv.addObject("tarefa",tarefa); //adição da tarefa editada no banco de dados
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){ //Método para deleção de tarefa

        this.tarefaService.delete(id); //usa o método do CrudRepository JPA
        return "redirect:/"; //volta para a página inicail após deleção
    }

    @GetMapping("/estado/{id}")
    public String mudaEstado(@PathVariable Long id){ //método para uso do padrão state, que faz a mudança de estado da tarefa
        Tarefa tarefa = tarefaService.findById(id); //acha a tarefa no banco de dados
        tarefaService.mudarEstadoTarefa(id); //usa o método feito no TarefaService para mudança de estado
        return "redirect:/"; //retorna para a página inicial (recarrega)
    }
}
