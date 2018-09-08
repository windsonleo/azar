package com.tecsoluction.azar.servico;

import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import com.tecsoluction.azar.entidade.Usuario;


@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

	
	
	
    @Autowired
    private UsuarioServicoImpl userRepository;
    
    
	@Override
	public String execute(Connection<?> connection) {
		// TODO Auto-generated method stub
		
		Usuario user = new Usuario();
        user.setUsername(connection.getDisplayName());
        user.setSenha(org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(8));
        userRepository.save(user);
		
		
		return null;
	}
	
	

}
