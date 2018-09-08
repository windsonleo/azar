package com.tecsoluction.azar.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsoluction.azar.dao.IRoleDao;
import com.tecsoluction.azar.entidade.Role;
import com.tecsoluction.azar.framework.AbstractEntityService;


@Service("roleService")
@Transactional
public class RoleServicoImpl extends AbstractEntityService<Role> {


    @Autowired
    private
    IRoleDao roledao;

//	private Entity entityClass;


    public RoleServicoImpl() {
        super(Role.class, "role");
    }


	@Override
	protected void validateSave(Role post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void validateEdit(Role post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateDelete(long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected JpaRepository<Role, Long> getDao() {
		// TODO Auto-generated method stub
		return roledao;
	}


}
