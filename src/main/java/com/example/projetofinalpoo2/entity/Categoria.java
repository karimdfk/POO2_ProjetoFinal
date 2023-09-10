package com.example.projetofinalpoo2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "categoria")
@Entity(name = "categoria")
@Getter
@Setter
@Data
public class Categoria { //classe da entidade categoria com seus atributos que já é integrado ao banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; //Criação do ID que é um número sequencial feito pelo próprio banco de dados

    @Column(name = "nome")
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {

    }

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    List<Tarefa> tarefas = new ArrayList<>(); //relacionamento que a categoria tem com tarefa de um para muitos
}
