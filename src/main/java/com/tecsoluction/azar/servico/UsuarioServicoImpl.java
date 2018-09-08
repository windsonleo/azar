package com.tecsoluction.azar.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tecsoluction.azar.dao.IUsuarioDao;
import com.tecsoluction.azar.entidade.Usuario;
import com.tecsoluction.azar.framework.AbstractEntityService;


@Service("userService")
@Transactional
public class UsuarioServicoImpl extends AbstractEntityService<Usuario> {


    @Autowired
    private IUsuarioDao dao;


    public UsuarioServicoImpl() {

        super(Usuario.class, "usuario");


    }


	@Override
	protected JpaRepository<Usuario, Long> getDao() {

		return dao;
	}


	@Override
	protected void validateSave(Usuario post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateEdit(Usuario post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateDelete(long id) {
		// TODO Auto-generated method stub
		
	}
	
    public Usuario findByUsername(@Param("username")String username){
    	
    	return dao.findByUsername(username);
    }



}
