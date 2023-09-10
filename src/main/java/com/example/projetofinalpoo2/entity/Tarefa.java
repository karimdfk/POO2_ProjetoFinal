package com.example.projetofinalpoo2.entity;


import com.example.projetofinalpoo2.observer.Observable;
import com.example.projetofinalpoo2.observer.Observer;
import com.example.projetofinalpoo2.observer.Usuario;
import com.example.projetofinalpoo2.state.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tarefa")
@Entity(name = "tarefa")
@Getter
@Setter
@Data
@Validated
public class Tarefa implements Observable { //classe da entidade tarefa com seus atributos que já é integrado ao banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "criacao")
    private LocalDate criacao;

    @Column(name = "fim")
    private LocalDate fim;

    @NotBlank
    @Column(name = "estado")
    private String estado; //Como não era possível criar um atributo do tipo State aqui na entidade devido as regras do JPA, foi criado esse atributo estado como String para mostrar o estado atual da tarefa usando o padrão State

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Tarefa(String nome, String descricao, LocalDate fim, Categoria categoria, Usuario usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.criacao = LocalDate.now();
        this.fim = fim;
        this.categoria = categoria;
        this.usuario = usuario;
        this.estado = "Pendente";
    }

    public Tarefa() {

    }

    public String getEstado() {
        return estado;
    }

    public void mudaState(String state){
        this.estado = state;
    } //método de mudança de estado do padrão state

    @Override
    public void notifica() {
        usuario.Atualiza(this);
    } //método notifica do padrão observer
}
