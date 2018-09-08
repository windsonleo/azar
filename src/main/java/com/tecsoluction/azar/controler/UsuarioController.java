package com.tecsoluction.azar.controler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tecsoluction.azar.entidade.Role;
import com.tecsoluction.azar.entidade.Usuario;
import com.tecsoluction.azar.framework.AbstractController;
import com.tecsoluction.azar.framework.AbstractEditor;
import com.tecsoluction.azar.servico.JogoBichoServicoImpl;
import com.tecsoluction.azar.servico.LotoFacilServicoImpl;
import com.tecsoluction.azar.servico.LotoManiaServicoImpl;
import com.tecsoluction.azar.servico.MegaSenaServicoImpl;
import com.tecsoluction.azar.servico.RoleServicoImpl;
import com.tecsoluction.azar.servico.UsuarioServicoImpl;




/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "usuario/")
public class UsuarioController extends AbstractController<Usuario> {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
    private  UsuarioServicoImpl userService;

	@Autowired
    private
    RoleServicoImpl roleService;
	
	
	private Usuario usuario;
	
	private List<Role> roles;
	
	@Autowired 
	private ServletContext contexto = null;
	
	private String filenamef = null;
	
	private 
	final
	JogoBichoServicoImpl jogobichoService;
	
	
    private com.tecsoluction.azar.entidade.JogoBicho jogobicho;
    private List<com.tecsoluction.azar.entidade.JogoBicho> jogobichos;
    
    
	private 
	final
	LotoFacilServicoImpl lotofacilService;
	
    private List<com.tecsoluction.azar.entidade.Lotofacil> lotofacils;
    
    private com.tecsoluction.azar.entidade.Lotofacil lotofacil;
    
    
    private 
	final
	LotoManiaServicoImpl lotomaniaService;
	
	    
    private List<com.tecsoluction.azar.entidade.LotoMania> lotomanias;
    
    private com.tecsoluction.azar.entidade.LotoMania lotomania;
    
    
    private 
	final
	MegaSenaServicoImpl megasenaService;
	
    private List<com.tecsoluction.azar.entidade.MegaSena> megasenas;
    
    private com.tecsoluction.azar.entidade.MegaSena megasena;
    
    

    @Autowired
    public UsuarioController(UsuarioServicoImpl usu,RoleServicoImpl rd,LotoFacilServicoImpl lt,LotoManiaServicoImpl ltm,MegaSenaServicoImpl mg,JogoBichoServicoImpl jbx) {
        super("usuario");
        this.userService = usu;
        this.roleService=rd;
        this.lotofacilService = lt;
        this.lotomaniaService = ltm;
        this.megasenaService= mg;
        this.jogobichoService = jbx;
        
    }
		
		
//	    @Autowired
//	    public UsuarioController(UsuarioServicoImpl usu,RoleServicoImpl rd) {
//	        super("usuario");
//	        this.userService = usu;
//	        this.roleService=rd;
//
//	        
//	    }
    
    
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Role.class, new AbstractEditor<Role>(this.roleService) {
        });
     


    }
	
	
    @ModelAttribute
    public void addAttributes(Model model) {
    	
    	jogobichos =jogobichoService.findAll();
    	lotofacils = lotofacilService.findAll();
    	lotomanias = lotomaniaService.findAll();
    	megasenas = megasenaService.findAll();	    	


         Usuario usuariotemp = new Usuario();
         usuariotemp.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
  		 this.usuario = userService.findByUsername(usuariotemp.getUsername()); 
  		
  		  		
  		roles = roleService.findAll();
  		
  		
  		if(usuario == null){
    		
    		usuario = new com.tecsoluction.azar.entidade.Usuario();
        	usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        	usuario.setFoto("img/sof.jpg");
    	}
  		
  		
  	 	if(jogobicho == null){
    		
    		jogobicho = new com.tecsoluction.azar.entidade.JogoBicho();
    	}
    	
  	 	
    	if(lotofacil == null){
    		
    		lotofacil = new com.tecsoluction.azar.entidade.Lotofacil();
    	}
    	
    	
    	if(lotomania == null){
    		
    		lotomania = new com.tecsoluction.azar.entidade.LotoMania();
    	}
    	
    	
    	if(megasena == null){
    		
    		megasena = new com.tecsoluction.azar.entidade.MegaSena();
    	}
    	

     		
  		model.addAttribute("usuario", usuario);
  		model.addAttribute("roles", roles);
    	model.addAttribute("jogobicho",jogobicho);
    	model.addAttribute("lotofacilList",lotofacils);
    	model.addAttribute("jogobichoList",jogobichos);
    	model.addAttribute("lotofacil",lotofacil);
    	model.addAttribute("lotomaniaList",lotomanias);
    	model.addAttribute("lotomania",lotomania);
    	model.addAttribute("megasenaList",megasenas);
    	model.addAttribute("megasena",megasena);

    }	
    
    
    
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView  Home(HttpServletRequest request, HttpSession session){
  	

  	
		ModelAndView home = new ModelAndView("/private/usuario/home");
  	
//  	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  		Usuario usuario =  new Usuario();
		usuario.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
//		usuario = getservice().findByUsername(usuario.getUsername());
		
		if(usuario.getUsername() == null){
			
			usuario.setUsername("Maria");
			System.out.println(" Windson if usuariocontroller Usuario :"+ usuario.getUsername());
		}else{
			
			session.setAttribute("usuario", usuario);
		}
		
		System.out.println(" Windson fora if usuariocontroller Usuario :"+ usuario.getUsername());

	


		home.addObject("usuario", usuario);
//		home.addObject("filename2","../audio/"+filenamef);
//		home.addObject("filenamef", filenamef);
		
		
  	return home;	
  	
	}

    
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
  	public ModelAndView  profileUsuario(HttpServletRequest request,HttpSession session){
    	
    	
//    	long idf = Long.parseLong(request.getParameter("id"));
    	
    	ModelAndView profileusuario = new ModelAndView("/private/usuario/profile");
    	
    	
    	  this.usuario = userService.findOne(this.usuario.getId());
    	 

    	 profileusuario.addObject("usuario",usuario);

  		
//  		return "redirect:/usuario/profile?id="+usuario.getId();
    	 
    	 return profileusuario;
  	}
    
       
    @RequestMapping(value = "/form_upload",method = RequestMethod.POST)
    public ModelAndView UploadAudio(@RequestParam("file") MultipartFile   file,HttpSession session,HttpServletRequest request,Model model) {
    	
    	
    	
    	long id = Long.parseLong(request.getParameter("usuarioid"));
    	
    	Usuario usuario = userService.findOne(id);
    	
    	
    	ModelAndView home = new ModelAndView("home");
    	
    	home.addObject("usuario", usuario);


    	String mensagem = "Sucesso ao salvar foto";
    	String erros = "Falha ao salvar foto";

//    	funfa
//    	String path=session.getServletContext().getRealPath("/resources");

    	String path=session.getServletContext().getRealPath("/WEB-INF/classes/static/audio/");
    	
    	

    	
    	
        System.out.println("path:"+path);  


    	
    	String camfoto = null;
    	
//    	String pathh = "\\static\\audio\\";
    	//string pathh = file.get
         this.filenamef=file.getOriginalFilename();  
          

    	
    	
    	camfoto = "audio\\"+filenamef;
    	String camfoto2 = path+"\\"+filenamef;
    	
    	 System.out.println("camfoto2"+ camfoto2);
    	 System.out.println("camfoto1"+ camfoto);

    	 
    	 String diretorio = null;
    	 
    	 File dir = new File(path);
    	 
    	 
    	

    	 if (!dir.exists()){
             dir.mkdirs();
    	 }
    	 
    	 
        try{ 
        	
        byte barr[]=file.getBytes();  
        
      File serverFile = new File(dir.getAbsolutePath() + File.separator + filenamef);

          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(serverFile));  
        
//        BufferedOutputStream bout=new BufferedOutputStream(  
//                new FileOutputStream(pathh+"/"+filename));
        
//        BufferedOutputStream bout=new BufferedOutputStream(  
//                new FileOutputStream(contexto.getResourceAsStream("/resources/static/audio/")+filename));
        
      
//        String rootPath = System.getProperty("C:\\Users\\teste\\Downloads");

        
        
        bout.write(barr);  
        bout.flush();  
        bout.close();  
        

    	home.addObject("filename", serverFile.getAbsolutePath());
    	home.addObject("filename2", "audio/"+filenamef);


          
        }catch(Exception e){
        	
        	System.out.println(e);
        	
        	home.addObject("filename2", "audio/"+filenamef);

        } 
        
//        return Home(request, session);
        
        return new ModelAndView("redirect:/usuario/home");	    
        
    }


	@Override
	protected UsuarioServicoImpl getservice() {

		return userService;
	}

	
}
