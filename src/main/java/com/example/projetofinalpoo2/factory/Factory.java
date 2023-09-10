package com.example.projetofinalpoo2.factory;

import org.springframework.web.servlet.ModelAndView;

public interface Factory { //interface da fábrica de ModelAndView
    public ModelAndView criaModelAndView(String viewName);
}
