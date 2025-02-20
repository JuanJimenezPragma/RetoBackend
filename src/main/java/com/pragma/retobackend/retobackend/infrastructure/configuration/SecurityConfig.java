package com.pragma.retobackend.retobackend.infrastructure.configuration;

import com.pragma.retobackend.retobackend.domain.enums.RolCuentaEnum;
import com.pragma.retobackend.retobackend.infrastructure.input.rest.component.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/cuenta").hasRole(RolCuentaEnum.ADMINISTRADOR.name())
                        .requestMatchers("/cuenta/create-employed").hasRole(RolCuentaEnum.PROPIETARIO.name())
                        .requestMatchers("/cuenta/create-client").permitAll()
                        .requestMatchers("/restaurante").hasRole(RolCuentaEnum.ADMINISTRADOR.name())
                        .requestMatchers("/restaurante/all").hasAnyRole(RolCuentaEnum.ADMINISTRADOR.name(),RolCuentaEnum.CLIENTE.name())
                        .requestMatchers("/plato").hasAnyRole(RolCuentaEnum.PROPIETARIO.name(),RolCuentaEnum.CLIENTE.name())
                        .requestMatchers("/plato/{idPlato}").hasRole(RolCuentaEnum.PROPIETARIO.name())
                        .requestMatchers("/plato/{id}").hasRole(RolCuentaEnum.PROPIETARIO.name())
                        .requestMatchers("/pedido").hasRole(RolCuentaEnum.CLIENTE.name())
                        .requestMatchers("/pedido/all").hasRole(RolCuentaEnum.EMPLEADO.name())
                        .requestMatchers("/pedido/asign").hasRole(RolCuentaEnum.EMPLEADO.name())
                        .requestMatchers("/pedido/ready").hasRole(RolCuentaEnum.EMPLEADO.name())
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
