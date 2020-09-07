package com.marcioprograma.reserva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Programa {
    private String id;
    private String nome;
    private LocalDate dataCadastro;
    private boolean ativo;
    private LocalDate dataExclusao;
    
    public Programa() {
    }
    
    @Id
    @Column(name = "id",length = 10)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    @Column(length = 100)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Column(name = "data_cadastro")
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    @Column(name = "ativo")
    public boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    @Column(name = "data_exclusao")
    public LocalDate getDataExclusao() {
        return dataExclusao;
    }
    public void setDataExclusao(LocalDate dataExclusao) {
        this.dataExclusao = dataExclusao;
    }
    
    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataExclusao=" + dataExclusao +
                ", ativo=" + ativo +
                '}';
    }
}