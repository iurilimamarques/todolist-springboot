/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todolist.todolist.repository;

import com.todolist.todolist.models.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author iuri
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findById(long id_usuario);
    
    @Query(value = "SELECT COUNT(*) FROM USUARIO s WHERE s.email = ?1", 
			  nativeQuery = true)
			int getUsuarioByEmail(String email);
                        
    @Query(value = "SELECT id_usuario,"
                        + "nome,"
                        + "email,"
                        + "senha FROM USUARIO s WHERE s.email = ?1 AND s.senha = ?2", 
			  nativeQuery = true)
			Usuario verificaDadosUsuario(String email, String senha);
}
