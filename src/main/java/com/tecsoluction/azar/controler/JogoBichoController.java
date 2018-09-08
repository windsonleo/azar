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

import com.tecsoluction.azar.entidade.JogoBicho;
import com.tecsoluction.azar.entidade.Usuario;
import com.tecsoluction.azar.framework.AbstractController;
import com.tecsoluction.azar.servico.JogoBichoServicoImpl;
import com.tecsoluction.azar.servico.UsuarioServicoImpl;
import com.tecsoluction.azar.util.Banca;
import com.tecsoluction.azar.util.Estatistica;

@Controller
@RequestMapping(value = "jogobicho/")
public class JogoBichoController extends AbstractController<JogoBicho> {
	
    @Autowired
    private  UsuarioServicoImpl usuarioService;    
    private com.tecsoluction.azar.entidade.Usuario usuario;
	
	private 
	final
	JogoBichoServicoImpl jogobichoService;
	
	
    private com.tecsoluction.azar.entidade.JogoBicho jogobicho;
    private List<com.tecsoluction.azar.entidade.JogoBicho> jogobichos;
	
	
	public JogoBichoController(JogoBichoServicoImpl jg) {
		super("jogobicho");
		this.jogobichoService = jg;

	}

	private static final Logger logger = LoggerFactory.getLogger(LotofacilController.class);
	
	
	   @ModelAttribute
	    public void addAttributes(Model model) {


	    		
	    	jogobichos =jogobichoService.findAll();
	    		    	
	    	
	    	Banca[] bancaList = Banca.values();
	    	
	    	
	    	
	    	
	    	if(jogobicho == null){
	    		
	    		jogobicho = new com.tecsoluction.azar.entidade.JogoBicho();
	    	}
	    	
	    	
	    	   	
	    	
	        Usuario usuariotemp = new Usuario();
	        usuariotemp.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	 		usuario = usuarioService.findByUsername(usuariotemp.getUsername()); 
	    	
	    	if(usuario == null){
	    		
	    		usuario = new com.tecsoluction.azar.entidade.Usuario();
	        	usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	        	usuario.setFoto("img/sof.jpg");
	    	}
	    	
	    	
	    	model.addAttribute("usuario",usuario);
	    		    	
	    	model.addAttribute("bancaList",bancaList);

	    	model.addAttribute("jogobicho",jogobicho);

	    	model.addAttribute("jogobichoList",jogobichos);


	    }


	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView  Home(HttpServletRequest request, HttpSession session){
  	

		ModelAndView home = new ModelAndView("/private/jogobicho/cadastrojogobicho");

		
  	return home;
  	
	}
	
	@Override
	protected JogoBichoServicoImpl getservice() {
		// TODO Auto-generated method stub
		return jogobichoService;
	}
	
	
	
	
}
