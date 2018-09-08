package com.tecsoluction.azar.servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tecsoluction.azar.dao.ILotoManiaDao;
import com.tecsoluction.azar.entidade.LotoMania;
import com.tecsoluction.azar.framework.AbstractEntityService;

@Service("lotomaniaService")
@Transactional
public class LotoManiaServicoImpl extends AbstractEntityService<LotoMania> {


    @Autowired
    private
    ILotoManiaDao dao;



    public LotoManiaServicoImpl() {
        super(LotoMania.class, "lotomania");
    }



	@Override
	protected JpaRepository<LotoMania, Long> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}



	@Override
	protected void validateSave(LotoMania post) {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void validateEdit(LotoMania post) {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void validateDelete(long id) {
		// TODO Auto-generated method stub
		
	}





}