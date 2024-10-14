package org.lesson.platform.ticket.security;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


//contiene dei metodi annotati che indicano quale meccanismo
//di autenticazione e autorizzazione vogliamo implementare
//@Configuration
//public class SecurityConfiguration {
	/*
	//rappresenta i permessi che hanno i vari ruoli per accedere alle varie risorse
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests()
	.requestMatchers("/user").hasAuthority("USER") // AUTORIZZO SOLO USER
	.requestMatchers("/admin").hasAuthority("ADMIN")// AUTORIZZO SOLO ADMIN
	.requestMatchers("/").permitAll() // AUTORIZZO TUTTI
	.and().formLogin()
	.and().logout();
	
	return http.build();
	}
	
	// per prendere il servizio creato da me
	@Bean 
	DatabaseUserDetailsService userDetailsService() {
	return new DatabaseUserDetailsService();
	}
	
	//deleghiamo la codifica della  password *OBBLIGATORIO
	@Bean
	PasswordEncoder passwordEncoder() {
	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	//mette insieme UserDetailsService e PasswordEncoder per
	//eseguire le query per autenticare gli utenti
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userDetailsService());
	authProvider.setPasswordEncoder(passwordEncoder());
	return authProvider;
	}
	

}*/
