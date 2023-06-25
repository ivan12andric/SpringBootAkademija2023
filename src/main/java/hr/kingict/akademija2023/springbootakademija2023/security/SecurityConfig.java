package hr.kingict.akademija2023.springbootakademija2023.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(
                        request -> request
                                //API-u mogu pristupiti samo korisnici u roli...
                                .requestMatchers("api/test/**").hasRole("TEST")   //TEST
                                .requestMatchers("api/flight-search/airports/**").hasRole("USER")  // USER
                                .requestMatchers("api/flight-search/flights/**").hasRole("ADMIN")  // ADMIN
                                .requestMatchers(PathRequest.toH2Console()).permitAll() // dozvoljeno za sve korisnike
                                )
                .csrf(csrf -> csrf.disable())
                .headers(header -> header.frameOptions(frameOption -> frameOption.disable()))
                .httpBasic(httpBasic -> httpBasic.init(httpSecurity))
                .build();

    }

    // In memory useri / role - zakomentirano zbog implementacije dohvata usera iz baze
    /*@Bean
    public UserDetailsService getUserDetails() {

        UserDetails testUser = User.withDefaultPasswordEncoder()
                .username("test")
                .password("test")
                .roles("TEST").build();

        UserDetails userUser = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER").build();

        UserDetails adminUser = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(testUser, userUser, adminUser);
    }*/

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }


}
