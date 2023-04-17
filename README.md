# Spring Revision Project
This project made when I'm relearn Java Spring Boot . It contain all features that I'm research and learning and storing for my future working. Anytime I need something that I have learned before, this is the place. Hope you find some interesting thing in here
## 🚀 About Me
My name is Phuong. I'm developer. Currently I'm still looking for new job (Up to date 04/14/2023). For any information, please contact me via
```
  Phone/zalo : +84938159116
```
```
  Email : phuongnguyenit93@gmail.com
```

## Appendix
This project use Java with some information
- Java Core 8
- Spring Boot 2.7.10
- MySQL Database
## Demo
- In progress...

## Main Feature

- ####	Buiding CRUD RestAPI or MVC (In progress)

  -	Model (Entity) : Have relationship 1-1, 1-n, n-n to mapping database
  -	View use JSP and thymeleaf
  -	Database use MySQL with connector by 3 way : JDBC , Hibernate or JPA (Config by bean or application.properties) come with each query method.

- ####	Seperated feature
```http
-	Email configuration and send email by smtp (gmail) . Send mail by text or can use thymelead template to send.
-	AWS S3 Storage : Create, delete bucket , manage file (Download, upload , delete)
-	Send SMS or call using Twilio service (Test account)
-	Encrypt password (Bcrypt)
-	Rate limit using Bucket4j (For Pricing Plan in the future)
```
- ####	Security
```http
-	Spring boot security basic with authorization, authentication (User-role and API filter) and basic session management.
-	Basic Anti Ddos : Using Bucket4j and Jcache to set Rate Limitted per IP Address and logging their IP Address to server
```
- ####	Project Analytic
```http
-	Custom Error Handler
-	Log4j2 : Custom logger console for Spring Boot
-	Spring Boot Actuator : Spring Boot View for analytic, management, measuring all project to get info for analyze and optimize it
-	Spring Boot Admin Server/Client : Library use for manage multiple spring boot actuator project in 1 project.
-	Run with project https://github.com/phuongnguyenit93/spring-boot-admin-server
```
- ####	Code management
```http
-	AOP (Aspect oriented programming) : Building method to execute before or after any method without adding any code in that method.
-	i18n : Get Message based on your location
-	Automation task (Building with cron format or setting delay time to do it interval)
```
- ####	Feature for developer
```http
-	Spring boot live upload : Now you can fixed code and apply it without restart the app over and over.
```
-	Still updating .... 

## Future update
-	Upgrade fully Rest API for 1-1, 1-n , n-n relationship
-	Upgrade spring Security (JWT, Oauth2)
-	Spring Cloud 
-	Microservice
-	Clean code
-	Combine feature to make fully project.
-	Upcoming….



## Documentation


## Author
For more information, please contact me via email `phuongnguyenit93@gmail.com`