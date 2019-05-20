CDIT Assignment (Spring Boot and Java)

# SpringBoot MVC + MySQL + BufferedReader
This application uses,
1. MySQL
2. JPA
3. Hibernate
4. Spring MVC 
5. Maven
6. Buffered Reader to read CSV file

To use this application, 
1. git clone the repository ```https://github.com/txinyi/Spring_CSV_BufferedReader.git```
2. create MySQL database based on the credentials mentioned in ```application.properties```
4. CSV file can be found in ```src/main/resources/users.csv```
3. Run the application


## Input
Input Data:
```mary,2000.30
bill,1000.10
jill,3000.30
johnny,4000.20
ian,2000
eve,5000
ann,0 
goat,6000
```

Upload the CSV file  
![Index](https://github.com/txinyi/Spring_CSV_BufferedReader/blob/master/readme/indexJSP.PNG?raw=true)


## Output
Expose outputs on users with valid salary (0 <= salary <= 4000) in Json.  
*Take note that uploading a new csv file will not append records to the database. In order to append, go to ```application.properties``` and set ```spring.jpa.hibernate.ddl-auto=update ```*  
![JsonEndPoint](https://github.com/txinyi/Spring_CSV_BufferedReader/blob/master/readme/usersEndpoint.PNG?raw=true)


## Implmentation
**Spring MVC**  
Entity class which Hibernate will automatically translate into table  
Controller class intercept incoming requests, send data to Model for further processing, get processed data from the Model and advances the data to View for rendering  
View (WEB-INF) render views


## References  
- Get Started with Spring Boot - https://spring.io/guides/gs/spring-boot/ 
- Spring MVC - https://github.com/ekirastogi/spring-boot-gradle-mvc 
- Accessing Data MySQL - https://spring.io/guides/gs/accessing-data-mysql/ 
- Spring data JPA Query - https://www.baeldung.com/spring-data-jpa-query 
- Uploading files - https://spring.io/guides/gs/uploading-files/ 




