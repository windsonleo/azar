package com.tecsoluction.azar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsoluction.azar.entidade.Role;


@Repository("roleRepository")
public interface IRoleDao extends JpaRepository<Role, Long> {

//	Role findByRole(String role);

}
