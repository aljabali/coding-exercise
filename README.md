# coding-exercise

###How to deploy
- Deploy Java 8 runtime environment.
- Define JAVA-HOME environment variable
- Copy the Jar artifact to your prefered folder
- Run following command "default memory settings should be sufficient":
 java -jar coding-exercise-0.0.1-SNAPSHOT.jar 
 
### Better to have
I prefer to have another API that allow listing of countries and cities in order to have better user experience

In addition i noticed that "minStarRating/maxStarRating" sometime retrieves data out of date range , i thought this due to provide more close offers but i still think its little bit confusing for the end user
https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTripStartDate=2018-04-10&maxTripStartDate=2018-04-20&destinationName=Bangkok


Travis CI link : https://travis-ci.org/aljabali/coding-exercise
Heroku - Demo link  : https://expedia-code-exercise.herokuapp.com