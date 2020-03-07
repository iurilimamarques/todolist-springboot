/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todolist.todolist.DTO;

import java.io.Serializable;

/**
 *
 * @author iuri
 */
public class AtividadeRequest implements Serializable{
    
    private long id_atividade;
    
    private String status;
    
    private String nome;
    
    private String descricao;
    
    private String dt_prazo;
    
    private String dt_sistema;
    
    private long id_usuario;
    
    public long getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(long id_atividade) {
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
    
    public String getDt_prazo() {
        return dt_prazo;
    }
    
    public void setDt_prazo(String dt_prazo) {
        this.dt_prazo = dt_prazo;
    }
    
    public String getDt_sistema() {
        return dt_sistema;
    }
    
    public void setDt_sistema(String dt_sistema) {
        this.dt_sistema = dt_sistema;
    }
    
    public long getId_usuario() {
        return this.id_usuario;
    }
    
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
