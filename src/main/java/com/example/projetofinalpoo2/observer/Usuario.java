package com.example.projetofinalpoo2.observer;

import com.example.projetofinalpoo2.entity.Tarefa;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
@Data
public class Usuario implements Observer{ //classe da entidade usuário com seus atributos que já é integrado ao banco de dados

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "texto")
    private String texto;

    @Override
    public void Atualiza(Tarefa t) {
        this.texto = "Atenção! Existem tarefas com prazo expirado";
    } //método atualiza que possui a mensagem a ser disparada no pop up avisando que o prazo da tarefa já passou
}
