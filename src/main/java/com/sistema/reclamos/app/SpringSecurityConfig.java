package com.sistema.reclamos.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.sistema.reclamos.app.auth.handler.LoginSuccesHandler;
import com.sistema.reclamos.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true) // importante para poner anotaciones secured en los controladores
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginSuccesHandler successHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/images/**","/listar**","/api/clientes/**").permitAll()
		.antMatchers("/clientes/**").hasAnyRole("ADMIN")
		.antMatchers("/clientes/**").hasAnyRole("ATENCION")
		.antMatchers("/solicitud/**").hasAnyRole("ADMIN") 
		.antMatchers("/solicitud/**").hasAnyRole("ATENCION") 
		.antMatchers("/solicitud/**").hasAnyRole("AREA") 
		.antMatchers("/solicitud/**").permitAll()
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.successHandler(successHandler)
			.loginPage("/login")
			.permitAll()
		.and()
			.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}

	
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
		}
	
	
}
