package ma.ac.ginf.emi.fajouianas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll();

                    //vous devez etre un "USER" pour pouvoir reserver (voir ficher Personne.http dans le repertoire http, dans la requete ###RESEVER)
                    auth.requestMatchers("/personne/reserver").hasRole("USER");

                    //vous devez etre un "USER" pour pouvoir confirmer (voir ficher Personne.http dans le repertoire http, dans la requete ###CONFITMER)
                    auth.requestMatchers("/personne/confirmer").hasRole("USER");

                    //vous devez etre un "ADMIN" pour pouvoir inviter (voir ficher Mariage.http dans le repertoire http, dans la requete ###QRINVITATION)
                    auth.requestMatchers("/mariage/qrinvitation").hasRole("ADMIN");

                    //dans la requette http on ajout un ligne "Authorization: Basic <user> <password>" avec le username et le password du ROLE qu'on veut s'authentifier avec !
                })
                .httpBasic(withDefaults())
                .build();
    }

}