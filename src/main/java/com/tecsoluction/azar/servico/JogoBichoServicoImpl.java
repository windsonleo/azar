package com.tecsoluction.azar.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsoluction.azar.dao.IJogoBichoDao;
import com.tecsoluction.azar.entidade.JogoBicho;
import com.tecsoluction.azar.framework.AbstractEntityService;



@Service("jogobichoService")
@Transactional
public class JogoBichoServicoImpl extends AbstractEntityService<JogoBicho> {

    @Autowired
    private IJogoBichoDao dao;


    public JogoBichoServicoImpl() {

        super(JogoBicho.class, "jogobicho");

    }


	@Override
	protected JpaRepository<JogoBicho, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}


	@Override
	protected void validateSave(JogoBicho post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateEdit(JogoBicho post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateDelete(long id) {
		// TODO Auto-generated method stub
		
	}




}
