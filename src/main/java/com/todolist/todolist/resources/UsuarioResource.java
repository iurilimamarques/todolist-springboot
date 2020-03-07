/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todolist.todolist.resources;

import com.todolist.todolist.models.Usuario;

import com.todolist.todolist.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author iuri
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Todo List")
public class UsuarioResource {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @ApiOperation(value="Retorna usuario")
    @GetMapping("/usuario/{id_usuario}")
    public Usuario getUsuario(@PathVariable(value="id_usuario") Integer id_usuario) {
        return usuarioRepository.findById(id_usuario);
    }
    
    @PostMapping("/usuario")
    public HashMap<String, String> setUsuario(@RequestBody @Valid Usuario usuario) {
        int retorno = 0;
        retorno = usuarioRepository.getUsuarioByEmail(usuario.getEmail());
        
        HashMap<String,String> json = new HashMap<>();

        if(retorno>0){
            json.put("response","Já existe usuário com este e-mail");
            return json;
        }else{
            Usuario usuarioCriado = usuarioRepository.saveAndFlush(usuario);
            Long id = usuarioCriado.getId();
            json.put("id_usuario", id.toString());
            return json;
        }
    }
    
    @PostMapping("/login")
    public HashMap<String,Usuario> loginUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioLogado = usuarioRepository.verificaDadosUsuario(usuario.getEmail(), usuario.getSenha());
        
        HashMap<String,Usuario> hashMap = new HashMap<>();
        hashMap.put("response", usuarioLogado);
        return hashMap;
    }
}
