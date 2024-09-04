//package com.skilledservice.ClientService.config;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.List;
//
//@Configuration
//@AllArgsConstructor
//
//public class SecurityConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfigurationSource source = corsConfigurationSource();
//        return new CorsFilter(source);
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowCredentials(true);
////        configuration.setAllowedOrigins(List.of("https://sabiconnect.vercel.app/", "http://localhost:8080"));
//        configuration.addAllowedOrigin("*");
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedMethod("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/", configuration);
//        return source;
//    }
//
//
//}
