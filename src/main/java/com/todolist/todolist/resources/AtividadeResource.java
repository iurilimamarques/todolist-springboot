/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todolist.todolist.resources;

import com.todolist.todolist.DTO.AtividadeRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todolist.repository.AtividadeRepository;
import com.todolist.todolist.models.Atividade;
import com.todolist.todolist.models.Usuario;
import com.todolist.todolist.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author iuri
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Todo List")
public class AtividadeResource {
    
    @Autowired
    private AtividadeRepository atividadeRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @ApiOperation(value="Retorna uma atividade")
    @GetMapping("/atividade/{id_atividade}")
    public Atividade getAtividade(@PathVariable(value="id_atividade") Integer id_atividade) {
        return atividadeRepository.findById(id_atividade);
    }
    
    @ApiOperation(value="Retorna uma atividade")
    @GetMapping("/atividadesUsuario/{id_usuario}")
    public HashMap<String, HashMap<String, List<Atividade>> > getAtividadeByUsuario(@PathVariable(value="id_usuario") Integer id_usuario) {
        List<Atividade> atividades = atividadeRepository.getAtividadeByUsuario(id_usuario);
        
        HashMap<String, HashMap<String, List<Atividade>>> response = new HashMap<>();
        HashMap<String, List<Atividade>> listaSeparada = new HashMap<>();
        
        List<Atividade> atividadesTD = new ArrayList<Atividade>();
        List<Atividade> atividadesDG = new ArrayList<Atividade>();
        List<Atividade> atividadesDN = new ArrayList<Atividade>();
        
        for (Atividade ativ : atividades) {
            String status = ativ.getStatus();
            if(status.equals("TD")) {
                atividadesTD.add(0, ativ);
            }else if(status.equals("DG")){
                atividadesDG.add(0, ativ);
            }else if(status.equals("DN")){
                atividadesDN.add(0, ativ);
            }
        }

        listaSeparada.put("TD", atividadesTD);
        listaSeparada.put("DG", atividadesDG);
        listaSeparada.put("DN", atividadesDN);
        
        response.put("response", listaSeparada);
        return response;
    }
    
    @ApiOperation(value="Retorna uma atividade")
    @PostMapping("/atividade")
    public HashMap<String, String> adicionaAtividade(@RequestBody AtividadeRequest atividadeRequest) {
        Usuario usuario = usuarioRepository.getOne(atividadeRequest.getId_usuario());
        
        Atividade atividade = new Atividade(atividadeRequest.getStatus(), 
                                            atividadeRequest.getNome(), 
                                            atividadeRequest.getDescricao(), 
                                            atividadeRequest.getDt_prazo(), 
                                            atividadeRequest.getDt_sistema(), usuario);
        
        Atividade atividadeCriada = atividadeRepository.saveAndFlush(atividade);
        
        HashMap<String, String> response = new HashMap<>();

        if(atividadeCriada.getIdAtividade()>0) {
            Long id = atividadeCriada.getIdAtividade();
            response.put("id_atividade", id.toString());
            return response;
        }else{
            response.put("response", "erro");
            return response;
        }
        
    }
    
    @ApiOperation(value="Retorna uma atividade")
    @DeleteMapping("/deletaAtividade/{id_atividade}")
    public void deletaAtividade(@PathVariable(value="id_atividade") long id_atividade) {
        atividadeRepository.deleteById(id_atividade);
    }
    
    @ApiOperation(value="Retorna uma atividade")
    @PutMapping("/editaAtividade/{id_atividade}")
    public HashMap<String, String> updateAtividade(@PathVariable("id_atividade") long id_atividade, @RequestBody AtividadeRequest atividadeRequest) {
        Atividade atividadeEditada = atividadeRepository.getOne(id_atividade);
        
        atividadeEditada.setNome(atividadeRequest.getNome());
        atividadeEditada.setStatus(atividadeRequest.getStatus());
        atividadeEditada.setDescricao(atividadeRequest.getDescricao());
        atividadeEditada.setDtPrazo(atividadeRequest.getDt_prazo());
        atividadeEditada.setDtSistema(atividadeRequest.getDt_sistema());
        atividadeEditada.setIdAtividade(id_atividade);
        
        Atividade atividade = atividadeRepository.saveAndFlush(atividadeEditada);
        
        HashMap<String, String> response = new HashMap<>();
        
        if(atividade.getIdAtividade()>0) {
            Long id = atividade.getIdAtividade();
            response.put("id_atividade", id.toString());
            return response;
        }else{
            response.put("response", "erro");
            return response;
        }        
    }
    
    @ApiOperation(value="Retorna uma atividade")
    @PutMapping("/updtStatusAtividade/{id_atividade}")
    public void updateStatusAtividade(@PathVariable("id_atividade") long id_atividade, @RequestBody AtividadeRequest atividadeRequest) {
        Atividade atividadeEditada = atividadeRepository.getOne(id_atividade);
        atividadeEditada.setStatus(atividadeRequest.getStatus());
        atividadeRepository.saveAndFlush(atividadeEditada);    
    }
    
}
