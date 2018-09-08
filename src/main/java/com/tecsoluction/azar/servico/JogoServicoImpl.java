//package com.tecsoluction.azar.servico;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.tecsoluction.azar.dao.IJogoDao;
//import com.tecsoluction.azar.entidade.Jogo;
//import com.tecsoluction.azar.framework.AbstractEntityService;
//
//
//
//@Service("jogoService")
//@Transactional
//public class JogoServicoImpl extends AbstractEntityService<Jogo> {
//
//    @Autowired
//    private IJogoDao dao;
//
//
//    public JogoServicoImpl() {
//
//        super(Jogo.class, "jogo");
//
//    }
//
//    @Override
//    protected JpaRepository<Jogo, Long> getDao() {
//
//        return dao;
//    }
//
//
//	@Override
//	protected void validateSave(Jogo post) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	protected void validateEdit(Jogo post) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	protected void validateDelete(long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//}
