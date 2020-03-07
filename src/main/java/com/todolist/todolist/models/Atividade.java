/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todolist.todolist.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author iuri
 */

@Entity
@Table(name = "ATIVIDADE")
public class Atividade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_atividade;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    private String status;
    
    private String nome;
    
    private String descricao;
    
    private String dt_prazo;
    
    private String dt_sistema;
    
    public Atividade(String status, String nome, String descricao, String dt_prazo, String dt_sistema, Usuario usuario) {
        super();
        this.status = status;
        this.nome = nome;
	this.descricao = descricao;
	this.dt_prazo = dt_prazo;	
        this.dt_sistema = dt_sistema;
        this.usuario = usuario;
    }
    
    public Atividade() {
    
    }
    
    public long getIdAtividade() {
        return id_atividade;
    }

    public void setIdAtividade(long id_atividade) {
        this.id_atividade = id_atividade;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDtPrazo() {
        return dt_prazo;
    }
    
    public void setDtPrazo(String dt_prazo) {
        this.dt_prazo = dt_prazo;
    }
    
    public String getDtSistema() {
        return dt_sistema;
    }
    
    public void setDtSistema(String dt_sistema) {
        this.dt_sistema = dt_sistema;
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
