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
import com.tecsoluction.azar.entidade.LotoMania;
import com.tecsoluction.azar.entidade.Usuario;
import com.tecsoluction.azar.framework.AbstractController;
import com.tecsoluction.azar.servico.LotoManiaServicoImpl;
import com.tecsoluction.azar.servico.UsuarioServicoImpl;
import com.tecsoluction.azar.util.Banca;
import com.tecsoluction.azar.util.Estatistica;


@Controller
@RequestMapping(value = "lotomania/")
public class LotoManiaController extends AbstractController<LotoMania> {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LotoManiaController.class);
	
	private 
	final
	LotoManiaServicoImpl lotomaniaService;
	
	    
    private List<com.tecsoluction.azar.entidade.LotoMania> lotomanias;
    
    private com.tecsoluction.azar.entidade.LotoMania lotomania;
    
    @Autowired
    private  UsuarioServicoImpl usuarioService;
    
//    private List<com.tecsoluction.azar.entidade.Usuario> megasenas;
    
    private com.tecsoluction.azar.entidade.Usuario usuario;

    
    public LotoManiaController(LotoManiaServicoImpl lf,UsuarioServicoImpl us) {
		
		super("lotomania");

		this.lotomaniaService = lf;
		this.usuarioService = us;
	
	}


	
	
	  @ModelAttribute
	    public void addAttributes(Model model) {

	        
	    	
	    	lotomanias = lotomaniaService.findAll();
	    	
	    	
	    	if(lotomania == null){
	    		
	    		lotomania = new com.tecsoluction.azar.entidade.LotoMania();
	    	}
	    
	    	   	
	    	
	        Usuario usuariotemp = new Usuario();
	        usuariotemp.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	 		usuario = usuarioService.findByUsername(usuariotemp.getUsername()); 
	    	
	    	if(usuario == null){
	    		
	    		usuario = new com.tecsoluction.azar.entidade.Usuario();
	        	usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	        	usuario.setFoto("img/sof.jpg");
	    	}
	    	

	    	
	    	model.addAttribute("lotomaniaList",lotomanias);

	    	model.addAttribute("lotomania",lotomania);
	    	
	    	model.addAttribute("usuario",usuario);  	
	  

	    }	
	    
	    
	    
//		@RequestMapping(value = "/lista", method = RequestMethod.GET)
//		public ModelAndView  Lotomania(HttpServletRequest request, HttpSession session){
//	  	
//
//			ModelAndView home = new ModelAndView("/private/lotomania/lotomania");
//
//			
//	  	return home;	
//	  	
//		}




		@Override
		protected LotoManiaServicoImpl getservice() {

			
			return lotomaniaService;
		}
}
