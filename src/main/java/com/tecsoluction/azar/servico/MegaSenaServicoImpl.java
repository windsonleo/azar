package com.tecsoluction.azar.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecsoluction.azar.dao.IMegaSenaDao;
import com.tecsoluction.azar.entidade.MegaSena;
import com.tecsoluction.azar.framework.AbstractEntityService;


@Service("megasenaService")
@Transactional
public class MegaSenaServicoImpl extends AbstractEntityService<MegaSena> {

    @Autowired
    private IMegaSenaDao dao;


    public MegaSenaServicoImpl() {

        super(MegaSena.class, "megasena");

    }


	@Override
	protected JpaRepository<MegaSena, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}


	@Override
	protected void validateSave(MegaSena post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateEdit(MegaSena post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateDelete(long id) {
		// TODO Auto-generated method stub
		
	}





}