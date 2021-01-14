# Springboot learning

## Steps
1. Springboot starter https://start.spring.io/
2. Basic settings
   - Application class
   - Setup port number in the application.properties
3. Spring Security
   - Login
      - Create a security module inside the main module and add the configuration
4. MVC
   - Add a Welcome controller to get the username from the auth and direct to the welcome jsp
   - Add a jsp view that displays the username to the screen
   - Add the jsp path to the application.properties  
   `spring.mvc.view.prefix=/WEB-INF/jsp/`
    `spring.mvc.view.suffix=.jsp`
5. Add Bootstrap dependency, header, footer and navigation bar
6. Create a logout controller

## Notes

### Embedded Tomcat with JSP template
Create the jsp file under  `/WEB-INF/jsp/`  
In the controller, return the name of the file  
In application.properties add  
`spring.mvc.view.prefix=/WEB-INF/jsp/`
`spring.mvc.view.suffix=.jsp`
