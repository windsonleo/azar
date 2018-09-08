package com.tecsoluction.azar.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.tecsoluction.azar.entidade.MegaSena;
import com.tecsoluction.azar.entidade.Usuario;
import com.tecsoluction.azar.framework.AbstractController;

import com.tecsoluction.azar.servico.MegaSenaServicoImpl;
import com.tecsoluction.azar.servico.UsuarioServicoImpl;
import com.tecsoluction.azar.util.AnaliseCombinatoria;
import com.tecsoluction.azar.util.Banca;
import com.tecsoluction.azar.util.Estatistica;


@Controller
@RequestMapping(value = "megasena/")
public class MegaSenaController extends AbstractController<MegaSena> {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MegaSenaController.class);
	
	private 
	final
	MegaSenaServicoImpl megasenaService;
	
    private List<com.tecsoluction.azar.entidade.MegaSena> megasenas;
    
    private com.tecsoluction.azar.entidade.MegaSena megasena;
    
    @Autowired
    private  UsuarioServicoImpl usuarioService;
        
    private com.tecsoluction.azar.entidade.Usuario usuario;
    
    private Estatistica estatistica;
    
    private Map<Integer,Integer> mapnumerosincidentesmegasena = new HashMap<>();
    
    private Map<Integer,Integer> mapdezincidentesmegasena = new HashMap<>();

    
    private Map<Integer,Integer> mapdezenaincidentesmegasena = new HashMap<>();
    
    private List<Integer> objetos = new ArrayList<Integer>();
    
    private List<Integer> posicoes = new ArrayList<Integer>() ;
    
    private AnaliseCombinatoria analisecomb ;

	
	
	public MegaSenaController(MegaSenaServicoImpl lf,UsuarioServicoImpl us) {
		
		super("megasena");
		this.megasenaService =lf;
		this.usuarioService = us;
	
	}


	
	
	  @ModelAttribute
	    public void addAttributes(Model model) {

	          	
	    	megasenas = megasenaService.findAll();	    	
	    	    	
	    	estatistica = new Estatistica(megasenas);
	    	
	    	estatistica.NumeroIncidencia(megasenas);
	    	
	    
	    	
	    	mapnumerosincidentesmegasena = estatistica.getMapincidencianumero();
	    	
	    	mapdezincidentesmegasena = estatistica.MaisIncidentesDez(mapnumerosincidentesmegasena);
//	    	
//	    	mapdezenaincidentesmegasena = estatistica.getMapincidencianumerodezmais();
	    	
	    	    	
	    	if(megasena == null){
	    		
	    		megasena = new com.tecsoluction.azar.entidade.MegaSena();
	    	}
	    		    	   	
	    	
	        Usuario usuariotemp = new Usuario();
	        usuariotemp.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	 		usuario = usuarioService.findByUsername(usuariotemp.getUsername()); 
	    	
	    	if(usuario == null){
	    		
	    		usuario = new com.tecsoluction.azar.entidade.Usuario();
	        	usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	        	usuario.setFoto("img/sof.jpg");
	    	}
	    	

	    	
	    	model.addAttribute("megasenaList",megasenas);

	    	model.addAttribute("megasena",megasena);
	    	
	    	model.addAttribute("usuario",usuario);
	    	
	    	model.addAttribute("incidencianumeromegasena",mapnumerosincidentesmegasena);
	    	
	    	
	    	model.addAttribute("mapdezincidentesmegasena",mapdezincidentesmegasena);


	    }	
	    
	    
	    
		@RequestMapping(value = "/lista", method = RequestMethod.GET)
		public ModelAndView  Lotomania(HttpServletRequest request, HttpSession session){
	  	

			ModelAndView home = new ModelAndView("/private/usuario/home");

			
	  	return home;	
	  	
		}
		
		
		@RequestMapping(value = "/dezmaismega", method = RequestMethod.GET)
		public ModelAndView  DezMaisMega(HttpServletRequest request, HttpSession session){
	  	

			ModelAndView dez = new ModelAndView("/private/megasena/dezmaismega");

			
	  	return dez;	
	  	
		}




		@Override
		protected MegaSenaServicoImpl getservice() {

			return megasenaService;
		}

}
