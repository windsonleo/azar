package com.tecsoluction.azar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tecsoluction.azar.entidade.Usuario;

@Repository("userRepository")
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT p FROM Usuario p where p.username=:username")
    Usuario findByUsername(@Param("username")String username);
    
    

}
