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
   - Add a Welcome controller to get the username from the auth, direct to the welcome jsp using the Model
   - To use a model, pass it in the parameter ModelMap
   - Use expression language in the jsp file `${name}`
   - Create a jsp view `/WEB-INF/jsp/` that displays the username to the screen 
   - Add the jsp path to the application.properties  
   `spring.mvc.view.prefix=/WEB-INF/jsp/`
    `spring.mvc.view.suffix=.jsp`
   - Return the name of the jsp file in the controller
5. Add Bootstrap dependency, header, footer and navigation bar
6. Create a logout controller
7. Todo object
   - Add a directory called model 
   - Create the Todo object
   - Add Lombok dependency for getters and setters
8. Todo Service which holds the business logic as insert, update, retrieve and delete todos
10. Add JSTL dependency to be able to loop through the todos in the jsp file
9. Create a view to display all the todos in a table
10. Create the TodoController to return all the todos for a user

## Notes

### Coupling in Java

Coupling refers to the usage of an object by another object. It can also be termed a collaboration.
An object which depends on another to get a task done can be classified in two types:
#### Tight Coupling
A tight coupling situation is when an object creates the object to be used. 
As the main object creates the object itself, this object cannot be changed from the outside world easily.
#### Loose Coupling
A loose coupling situation is when an object gets the object to be used from the outside. 
As the main object is merely using the object, this object can be changed from the outside world easily.

### Annotations
@Component - Instance of an object  

@Autowired - Marks a dependency  

@SpringbootApplication - Automatically scans the package it is in. Application context manages all the beans  

@Primary - Identifies the dependency/bean to be used when there's more than one 

@RequestMapping - Maps web request to Spring Controller methods  

@Controller:  
- Intercepts incoming requests
- Converts payloads of the request to the internal structure 
- Sends the data to Model for further processing
- Gets processed data from the Model and advances that data to the View for rendering  

@RequestParam - Gets the parameter from the request  

@Service - anything that has business logic  

@SessionAttribute("name") - Allows to store values across requests. Warning: it takes up memory  

### Spring Flows
#### Startup
1. Spring goes through the package and searches for the components
2. Creates the beans
3. Wires the dependencies, constructor
4. Finishes creating the beans

#### MVC Request
1. DispacherServlet receives a HTTP request
2. DispacherServlet identifies the right Controller based on the URL
3. Controller executes business logic
4. Controller returns a)Model b)View back to the DispacherServlet
5. DispacherServlet identifies the correct view (ViewResolver)
6. DispacherServlet makes the model available to the view and executes it
7. DispacherServlet returns HTTP response back 

### Types of Dependency Injection
Immutability - When the object's state cannot be modified after creation.
#### Field
`@Autowired`  
`private DogsController controller;`  
- Readable
- Doesn't support immutability

#### Setter
`private DogsController controller;`  
`@Autowired`  
`public void setController(DogsController controller) {`  
`this.controller = controller;`  
`}`
- Not readable
- Doesn't support immutability

#### Constructor
`private DogsController controller;`  
`public MyClass(DogsController controller) {`  
`this.controller = controller;`  
`}`
- Ok readability
- Supports immutability

### Spring
#### Modules
Core
- Beans
- Core
- Context
- SpEl

Data Access/Integration
- JDBC
- ORM -> Hibernate
- JMS -> Talk to other applications
- OMX -> Object to XML
- Transactions

Web
- Web
- Web Socket
- Servlet

Cross cutting concern is a concern which is applicable throughout the application
E.g. logging, security and data transfer. AOP - Aspect Oriented Programming (security and logging)

#### Projects
- Boot -> Quickly build applications
- Cloud -> Build cloud native apps
- Data -> Consistent Data Access
- Integration -> Connecting enterprise applications
- Batch -> Batch applications
- Security -> Protect your application
- HATEOAS -> Compatible services

### POM
Project Object Model - Inheritance

spring-boot-starter-web -> build web applications  
spring-boot-starter-test  
spring-boot-devtools -> helpful tools  
Enable auto restart on changes in Intellij:  
- Run/debug configurations
- On frame deactivation
- Update classes and resources

Transitive dependencies are the ones the project needs to work

### JSTL 
Java Standard Tags Library  
For loops in the jsp files  

