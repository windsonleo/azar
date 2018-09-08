//package com.tecsoluction.azar;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.social.connect.ConnectionFactoryLocator;
//import org.springframework.social.connect.UsersConnectionRepository;
//import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
//import org.springframework.social.connect.web.ProviderSignInController;
//
//import com.tecsoluction.azar.servico.FacebookConnectionSignup;
//import com.tecsoluction.azar.servico.FacebookSignInAdapter;
//
//
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.tecsoluction.azar")
//public class MyWebSecurityConfigurerAdapterFacebook extends WebSecurityConfigurerAdapter {
//	
//    @Autowired
//    private ConnectionFactoryLocator connectionFactoryLocator;
// 
//    @Autowired
//    private UsersConnectionRepository usersConnectionRepository;
// 
//    @Autowired
//    private FacebookConnectionSignup facebookConnectionSignup;
//	
//	
////    @Autowired
////    private UserDetailsService userDetailsService;
//    
//	@Value("${spring.queries.users-query}")
//	private String usersQuery;
//	
//	@Value("${spring.queries.roles-query}")
//	private String rolesQuery;
//    
//	@Autowired
//	private DataSourceConf dataSource;
//	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//			throws Exception {
////		auth.userDetailsService(userDetailsService);
//		
//		auth.
//		jdbcAuthentication()
//			.usersByUsernameQuery(usersQuery)
//			.authoritiesByUsernameQuery(rolesQuery)
//			.dataSource(dataSource.dataSource());
//				
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//				
//		http.
//			authorizeRequests()				
//				.antMatchers("/public/**").permitAll()
//				.antMatchers("/resources/**").permitAll()
//				.antMatchers("/static/**").permitAll()
//				.antMatchers("/templates/**").permitAll()
//				.antMatchers("/web/**").permitAll()
//				.antMatchers("/build/**").permitAll()
//				.antMatchers("/vendors/**").permitAll()
//				.antMatchers("/img/**").permitAll()
//				.antMatchers("/css/**").permitAll()
//				.antMatchers("/js/**").permitAll()
//				.antMatchers("/login*","/signin/**","/signup/**").permitAll()
//				.antMatchers("/bootstrap/**").permitAll()
////				.antMatchers("/home").permitAll()
//				.antMatchers("/webjars/**").permitAll()
//				.antMatchers("*/sass/**").permitAll()
//				.antMatchers("/private/**").hasAnyRole("MEMBRO","ADM").anyRequest().authenticated()
//				.and()
//				.csrf().disable().formLogin()
//				.loginPage("/login").failureUrl("/erro")
//				.defaultSuccessUrl("/usuario/home")
//				.usernameParameter("username")
//				.passwordParameter("senha")
//				.and().logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/login").and().exceptionHandling()
//				.accessDeniedPage("/accessdenied");
//				
////		http.sessionManagement().maximumSessions(sessaoMax).and().invalidSessionUrl("/sessaoinvalida").and()
////		.sessionManagement().sessionFixation().migrateSession();
//		
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web
//	       .ignoring()
//	       .antMatchers("/resources/**");
//       web
//	       .ignoring()
//	       .antMatchers("/static/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/css/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/js/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/img/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/web/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/build/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/vendors/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/public/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/templates/**");
//       
//       web
//       .ignoring()
//       .antMatchers("/webjars/**");
//       
//       web
//       .ignoring()
//       .antMatchers("*/sass/**");
//       
//       
//
//	}
//	
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("MEMBRO")
//                .and()
//                .withUser("admin").password("password").roles("ADM");
//    }
//    
//    
//    @Bean
//    public ProviderSignInController providerSignInController() {
//        ((InMemoryUsersConnectionRepository) usersConnectionRepository)
//          .setConnectionSignUp(facebookConnectionSignup);
//         
//        return new ProviderSignInController(
//          connectionFactoryLocator, 
//          usersConnectionRepository, 
//          new FacebookSignInAdapter());
//    }
//	
//	
//	
//
//}
