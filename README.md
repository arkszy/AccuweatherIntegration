# Weather app

This is a simple app which acts as a proxy between client and AccuWeather API (https://developer.accuweather.com/). 
It have transient memory counter of performed AccuWeather API calls.

It provides two get mappings:
1) localhost:8080/5day/forecast/{postalCode}
2) localhost:8080/api/statistics

First one return if succeed json array of daily forecasts for the next 5 days. Forecast is prepared for an area of given postalCode.
Returning this array requires making two requests to Accuweather API. One for getting identifier of area by given postalCode, and second for getting forecasts by mentioned area identifier.
App uses simple memory map cache to store area identifier by postalCode to reduce API calls.

Second one return json with counter of accuweatherApiCalls.



## Usage

To run this project you need to have maven 3 and java 11.

Example commands to run this app:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```
or
```bash
mvn clean install -P prod
java -jar target\accuweather-0.0.1-SNAPSHOT.jar
```

## License
[MIT](https://choosealicense.com/licenses/mit/)