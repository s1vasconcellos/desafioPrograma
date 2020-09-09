package com.marcio.programareserva.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Programa implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String nome;
    private LocalDate dataCadastro;
    private boolean ativo;
    private LocalDate dataExclusao;
    
    public Programa() {
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

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