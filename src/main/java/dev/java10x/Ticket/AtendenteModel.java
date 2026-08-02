package dev.java10x.Ticket;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_atendente")
public class AtendenteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;
    private NivelSuporte nivelSuporte;

    public AtendenteModel() {
    }

    public AtendenteModel(String nome, String email, int idade, NivelSuporte nivelSuporte) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.nivelSuporte = nivelSuporte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NivelSuporte getNivelSuporte() {
        return nivelSuporte;
    }

    public void setNivelSuporte(NivelSuporte nivelSuporte) {
        this.nivelSuporte = nivelSuporte;
    }
}
