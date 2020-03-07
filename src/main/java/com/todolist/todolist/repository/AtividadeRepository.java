/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todolist.todolist.repository;

import com.todolist.todolist.models.Atividade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author iuri
 */
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    Atividade findById(long id);
    
    @Query(value = "SELECT * FROM ATIVIDADE s WHERE s.id_usuario = ?1", 
			  nativeQuery = true)
			List<Atividade> getAtividadeByUsuario(int id_usuario);
}
