package demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableResourceServer
public class SecurityConfig extends WebMvcConfigurerAdapter {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest()
                    .authenticated();
        }

    }
    
    @Configuration
    @EnableAuthorizationServer
    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    	
        @Autowired
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.authenticationManager(authenticationManager);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
	            .withClient("client-with-registered-redirect")
	            .authorizedGrantTypes("authorization_code")
	            .authorities("ROLE_CLIENT")
	            .scopes("read", "trust")
	            .redirectUris("http://anywhere?key=value")
	            .secret("secret123")
            .and()
	            .withClient("my-client-with-secret")
	            .authorizedGrantTypes("client_credentials", "password")
	            .authorities("ROLE_CLIENT")
	            .scopes("read")
	            .secret("secret");
       } 

    }

    @Configuration
    protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("mstine").password("secret").roles("USER", "ADMIN").and()
                    .withUser("littleidea").password("secret").roles("USER", "ADMIN").and()
                    .withUser("starbuxman").password("secret").roles("USER", "ADMIN");
        }

    }

}
