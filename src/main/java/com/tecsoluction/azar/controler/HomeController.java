package com.tecsoluction.azar.controler;

import static org.mockito.Matchers.longThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.tecsoluction.azar.entidade.Usuario;
import com.tecsoluction.azar.servico.JogoBichoServicoImpl;
import com.tecsoluction.azar.servico.LotoFacilServicoImpl;
import com.tecsoluction.azar.servico.LotoManiaServicoImpl;
import com.tecsoluction.azar.servico.MegaSenaServicoImpl;
import com.tecsoluction.azar.servico.UsuarioServicoImpl;
import com.tecsoluction.azar.util.Banca;
import com.tecsoluction.azar.util.Estatistica;



@Controller("/")
public class HomeController {
	
	
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private  LotoFacilServicoImpl lotofacilService;
    
    private List<com.tecsoluction.azar.entidade.Lotofacil> lotofacils;
    
    private com.tecsoluction.azar.entidade.Lotofacil lotofacil;

    
    @Autowired
    private  LotoManiaServicoImpl lotomaniaService;
    
    private List<com.tecsoluction.azar.entidade.LotoMania> lotomanias;
    
    private com.tecsoluction.azar.entidade.LotoMania lotomania;
    
    
    @Autowired
    private  MegaSenaServicoImpl megasenaService;
    
    private List<com.tecsoluction.azar.entidade.MegaSena> megasenas;
    
    private com.tecsoluction.azar.entidade.MegaSena megasena;
    
    
    
    @Autowired
    private  UsuarioServicoImpl usuarioService;
    
//    private List<com.tecsoluction.azar.entidade.Usuario> megasenas;
    
    private com.tecsoluction.azar.entidade.Usuario usuario;
    
    private Estatistica estatistica;
    
    private Map<Integer,Integer> mapnumerosincidentesmegasena = new HashMap<>();
    
    private Map<Integer,Integer> mapdezenaincidentesmegasena = new HashMap<>();
    
    
    @Autowired
    private  JogoBichoServicoImpl jogobichoService;    
    private com.tecsoluction.azar.entidade.JogoBicho jogobicho;
    private List<com.tecsoluction.azar.entidade.JogoBicho> jogobichos;

    
    

    
    public HomeController(LotoFacilServicoImpl lt,LotoManiaServicoImpl ltm,MegaSenaServicoImpl mg,UsuarioServicoImpl us,JogoBichoServicoImpl jbx) {

    this.lotofacilService = lt;
    this.lotomaniaService = ltm;
    this.megasenaService= mg;
    this.usuarioService=us;
    this.jogobichoService = jbx;
   
    
    }

    @ModelAttribute
    public void addAttributes(Model model) {
    	
    	lotofacils = lotofacilService.findAll();
    	
    	lotomanias = lotomaniaService.findAll();
    	
    	megasenas = megasenaService.findAll();
    	
    	jogobichos =jogobichoService.findAll();
    	
    	    	
    	estatistica = new Estatistica(megasenas);
    	
    	estatistica.NumeroIncidencia(megasenas);
    	
    	mapnumerosincidentesmegasena = estatistica.getMapincidencianumero();
    	
    	Map<Integer, Integer> mapsdez = estatistica.getMapincidencianumerodezmais();

    	
    	
    	
    	Banca[] bancaList = Banca.values();
    	
    	
    	if(lotofacil == null){
    		
    		lotofacil = new com.tecsoluction.azar.entidade.Lotofacil();
    	}
    	
    	if(lotomania == null){
    		
    		lotomania = new com.tecsoluction.azar.entidade.LotoMania();
    	}
    	
    	if(megasena == null){
    		
    		megasena = new com.tecsoluction.azar.entidade.MegaSena();
    	}
    	
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
    	

    	
    	model.addAttribute("lotofacilList",lotofacils);
    	model.addAttribute("lotomaniaList",lotomanias);
    	model.addAttribute("megasenaList",megasenas);

    	model.addAttribute("lotofacil",lotofacil);
    	model.addAttribute("lotomania",lotomania);
    	model.addAttribute("megasena",megasena);
    	
    	model.addAttribute("usuario",usuario);
    	
    	model.addAttribute("incidencianumeromegasena",mapnumerosincidentesmegasena);
    	
    	model.addAttribute("bancaList",bancaList);

    	model.addAttribute("jogobicho",jogobicho);

    	model.addAttribute("jogobichoList",jogobichos);
//    	Collection<Integer> key;
//    	Collection<Integer> value;

//    	model.addAttribute("key", key = mapnumerosincidentesmegasena.keySet());
//    	model.addAttribute("value",value = mapnumerosincidentesmegasena.values());

    	model.addAttribute("mapsdez",mapsdez);

    	
    	
    	
    	


    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Home(Locale locale, Model model) {
       
    	logger.info("Welcome home! The client locale is {}.", locale);

        ModelAndView login = new ModelAndView("/public/login");


        return login;
    }


//    @RequestMapping(value = "/public", method = RequestMethod.GET)
//    public ModelAndView Public(Locale locale, Model model) {
//      
//    	logger.info("Welcome home! The client locale is {}.", locale);
//
//
//        ModelAndView home = new ModelAndView("/public/home");
//
//
//        return home;
//    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView Login(Locale locale, Model model) {
      
    	logger.info("Welcome home! The client locale is {}.", locale);


        ModelAndView login = new ModelAndView("/public/login");


        return login;
    }
    
    
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView Error(Locale locale, Model model) {
      
    	logger.info("Welcome home! The client locale is {}.", locale);


        ModelAndView erro = new ModelAndView("/error/erro");


        return erro;
    }
    
    
    @RequestMapping(value ={"/accessdenied"}, method = RequestMethod.GET)
	public ModelAndView  AcessDenied(HttpServletRequest request){
  	
    	ModelAndView accessdenied = new ModelAndView("/public/accessdenied");

  	return accessdenied;	
  	
	}   
    
    
    
//    @RequestMapping(value ={"/lotofacil"}, method = RequestMethod.GET)
//	public ModelAndView  Lotofacil(HttpServletRequest request){
//  	
//    	ModelAndView lotofacil = new ModelAndView("/public/lotofacil");
//
//  	return lotofacil;	
//  	
//	}  
//    
//    
//    @RequestMapping(value ={"/megasena"}, method = RequestMethod.GET)
//	public ModelAndView MegaSena(HttpServletRequest request){
//  	
//    	ModelAndView megasena = new ModelAndView("/public/megasena");
//
//  	return megasena;	
//  	
//	}  
    
    
//    @RequestMapping(value ={"/lotomania"}, method = RequestMethod.GET)
//	public ModelAndView  Lotomania(HttpServletRequest request){
//  	
//    	ModelAndView lotomania = new ModelAndView("/public/lotomania");
//
//  	return lotomania;	
//  	
//	} 
    
    
    @RequestMapping(value ={"/home"}, method = RequestMethod.GET)
	public ModelAndView  Home(HttpServletRequest request){
  	
    	ModelAndView home = new ModelAndView("/public/home");

  	return home;	
  	
	} 
    
    
//    @RequestMapping(value ={"/profile"}, method = RequestMethod.GET)
//	public ModelAndView  Profile(HttpServletRequest request){
//  	
//    	ModelAndView accessdenied = new ModelAndView("/public/profile");
//
//  	return accessdenied;	
//  	
//	} 
    
    
    
//    @RequestMapping(value ={"/simular"}, method = RequestMethod.GET)
//	public ModelAndView  Simular(HttpServletRequest request){
//  	
//    	ModelAndView accessdenied = new ModelAndView("/public/simular");
//
//  	return accessdenied;	
//  	
//	} 
    
    
//    @RequestMapping(value ={"/jogobicho"}, method = RequestMethod.GET)
//	public ModelAndView  JogoBicho(HttpServletRequest request){
//  	
//    	ModelAndView jogobicho = new ModelAndView("/public/cadastrojogobicho");
//
//  	return jogobicho;	
//  	
//	} 
    
    
//    @RequestMapping(value ={"/cadastrousuario"}, method = RequestMethod.GET)
//	public ModelAndView  CadastroUsuario(HttpServletRequest request){
//  	
//    	ModelAndView cadastro = new ModelAndView("/public/cadastrousuario");
//
//  	return cadastro;	
//  	
//	} 
    
    @RequestMapping(value ={"/fibonaci"}, method = RequestMethod.GET)
	public long  fibonaci(HttpServletRequest request){
  	
    	long num = Long.parseLong(request.getParameter("id"));
    	
    	
    	
  	return fibonacci(num);	
  	
	} 
    
    
    public long fibonacci(long num) {
   
    	if (num <= 1) return 1;

    	  return fibonacci(num - 1) + fibonacci(num - 2);
    	}

}
