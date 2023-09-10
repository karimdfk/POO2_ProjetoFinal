package com.example.projetofinalpoo2.factory;

import com.example.projetofinalpoo2.service.Service;
import com.example.projetofinalpoo2.service.TarefaService;
import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewFactory implements Factory{ //classe da factory de ModelAndView

    @Override
    public ModelAndView criaModelAndView(String viewName) { //método de criação de uma ModelAndView para usar no HTML
        return new ModelAndView(viewName);
    }
}
