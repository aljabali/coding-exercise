#Coding exercise

##Used technologies
- Springboot 2.0
- Thymeleafe
- Material Design Lite 
- JDK 8 - prefered latest build

##Why these technologies  
#### Springboot 2.0 , 
Overall springboot is very powerful with less effort and many features out of the box "i.e. security handling, simple rest , simple integrations ". 

#### Thymeleafe
Eventhough iam familiar with Angular for front end but i thought it was a good chance for me to explore Thymeleaf.

#### Material Design Lite
Material is a very simple and nice once that trend of website move toward it.


##What aimed to accomplesh 
* I was trying to have website enables user to find good deals for hotel reservation based on provided API,
the main point that i was not able to call other api(s) to get list of cities ,countries or regions due to need for api key, thats why i changed it to be free text.

* The provided backend follows TDD, and the CI/CD was done in the early stage to make sure that its deployable all the time.  

* I followed MVC design pattern using Spring MVC.

* Rest standard operations followed "Actually we only need get in such scenario"

* All validations done on backend "should be done on both client and backend" but thought i should focus on backend:
- Destination should be provided "City or Country"
- Min/Max pairs of filter options not allowed to overlap, i.e. minStarRating should not be after maxStarRating


The process of CI/CD iam familiar with CI process but is my first time for CD , so overall i consider it good exercise as i explored :
- Thymeleaf 
- CD using Heroku and Travis



