package com.ada.testes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Component
public class Produto {

    @Id
    private Long id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto() {

    }


    @Override
    public String toString() {
        return "Produto [descricao=" + descricao + ", nome=" + nome + ", preco=" + preco + "]";
    }
}
