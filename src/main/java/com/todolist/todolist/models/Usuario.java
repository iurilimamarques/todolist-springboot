package com.todolist.todolist.models;

import com.todolist.todolist.models.Atividade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_usuario;
        
	private String nome;

	private String senha;
        
	private String email;
        
        public Usuario(String nome, String senha, String email,
			 List<Atividade> atividades) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.atividades = atividades;
	}
	
        public Usuario() {
		
        }

	public long getId() {
            return id_usuario;
	}

	public void setId(long id) {
            this.id_usuario = id;
	}

	public String getNome() {
            return nome;
	}

	public void setNome(String nome) {
            this.nome = nome;
	}

	public String getSenha() {
            return senha;
	}

	public void setSenha(String senha) {
            this.senha = senha;
	}

	public String getEmail() {
            return email;
	}

	public void setEmail(String email) {
            this.email = email;
	}
	 
	@OneToMany(fetch = FetchType.LAZY)
        private List<Atividade> atividades;	
        
}
