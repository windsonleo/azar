package com.tecsoluction.azar.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tecsoluction.azar.dao.ILotoFacilDao;
import com.tecsoluction.azar.entidade.Lotofacil;
import com.tecsoluction.azar.framework.AbstractEntityService;



@Service("lotofacilService")
@Transactional
public class LotoFacilServicoImpl extends AbstractEntityService<Lotofacil> {


    @Autowired
    private ILotoFacilDao dao;


    public LotoFacilServicoImpl() {

        super(Lotofacil.class, "lotofacil");


    }


	@Override
	protected JpaRepository<Lotofacil, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}


	@Override
	protected void validateSave(Lotofacil post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateEdit(Lotofacil post) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void validateDelete(long id) {
		// TODO Auto-generated method stub
		
	}


 


}
