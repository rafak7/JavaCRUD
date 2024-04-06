package com.example.restcrud;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
