# springBoot-security


## Spring Boot Demo Application implementing Spring-Security 6.1.5

Each branch of this repository implements different spring-security modules.

Branch Names
1. [BasicAuth/SecureAllUrls](https://github.com/gramesh87/springBoot-security/tree/BasicAuth/SecureAllUrls)
2. [FormLogin/In-MemoryAuthentication](https://github.com/gramesh87/springBoot-security/tree/FormLogin/In-MemoryAuthentication)
   - Spring Security’s `InMemoryUserDetailsManager` implements `UserDetailsService` to provide support for username/password based authentication that is stored in memory. `InMemoryUserDetailsManager` provides management of `UserDetails` by implementing the `UserDetailsManager` interface. `UserDetails`-based authentication is used by Spring Security when it is configured to accept a username and password for authentication.