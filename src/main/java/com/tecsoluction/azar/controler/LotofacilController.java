package com.tecsoluction.azar.controler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.tecsoluction.azar.entidade.Lotofacil;
import com.tecsoluction.azar.entidade.Usuario;
import com.tecsoluction.azar.framework.AbstractController;
import com.tecsoluction.azar.servico.LotoFacilServicoImpl;
import com.tecsoluction.azar.servico.UsuarioServicoImpl;
import com.tecsoluction.azar.util.Banca;
import com.tecsoluction.azar.util.Estatistica;


@Controller
@RequestMapping(value = "lotofacil/")
public class LotofacilController  extends AbstractController<Lotofacil> {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LotofacilController.class);
	
	private 
	final
	LotoFacilServicoImpl lotofacilService;
	
    private List<com.tecsoluction.azar.entidade.Lotofacil> lotofacils;
    
    private com.tecsoluction.azar.entidade.Lotofacil lotofacil;
    
    
    @Autowired
    private  UsuarioServicoImpl usuarioService;
        
    private com.tecsoluction.azar.entidade.Usuario usuario;
	
	
	public LotofacilController(LotoFacilServicoImpl lf,UsuarioServicoImpl us) {
		
		super("lotofacil");

		this.lotofacilService = lf;
		this.usuarioService=us;
	
	}


	
	
	  @ModelAttribute
	    public void addAttributes(Model model) {

	        
		  lotofacils = lotofacilService.findAll();
	    	
	       	
	    	
	    	if(lotofacil == null){
	    		
	    		lotofacil = new com.tecsoluction.azar.entidade.Lotofacil();
	    	}
	    	
	      	   	
	    	
	        Usuario usuariotemp = new Usuario();
	        usuariotemp.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	 		usuario = usuarioService.findByUsername(usuariotemp.getUsername()); 
	    	
	    	if(usuario == null){
	    		
	    		usuario = new com.tecsoluction.azar.entidade.Usuario();
	        	usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	        	usuario.setFoto("img/sof.jpg");
	    	}
	    	

	    	
	    	model.addAttribute("lotofacilList",lotofacils);
	    	
	    	model.addAttribute("lotofacil",lotofacil);
	    	
	    	model.addAttribute("usuario",usuario);
	    	

	    }	
	    
	    
	    
//		@RequestMapping(value = "/lista", method = RequestMethod.GET)
//		public ModelAndView  Home(HttpServletRequest request, HttpSession session){
//	  	
//
//			ModelAndView home = new ModelAndView("/private/lotofacil/lotofacil");
//
//			
//	  	return home;	
	  	
//		}

	
	
	@Override
	protected LotoFacilServicoImpl getservice() {
		// TODO Auto-generated method stub
		return lotofacilService;
	}

}
