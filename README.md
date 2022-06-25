# Weather app

This is a simple app which acts as a proxy between client and AccuWeather API (https://developer.accuweather.com/). It
has transient memory counter of performed AccuWeather API calls.

It provides two get mappings:

1) localhost:8090/5day/forecast/{postalCode}
2) localhost:8090/api/statistics

First one returns if succeed json array of daily forecasts for the next 5 days. Forecast is prepared for an area of
given postalCode. Returning this array requires making two requests to Accuweather API. One for getting identifier of
area by given postalCode, and second for getting forecasts by mentioned area identifier. App uses simple memory map
cache to store area identifier by postalCode to reduce API calls.

Second one return json with counter of accuweatherApiCalls.

## Usage

To run this project you need to have maven 3, java 17 and docker.

App has two profiles: dev and prod. First one is default. Dev is for development purposes and communicates with local
mock-server. Prod is for production and communicates with real accuweather API.\
To run app in dev mode execute bootstrap-dev.sh\
To run app in prod mode execute bootstrap-prod.sh

## Tech stack:

Spring boot 2.6.2\
Spring boot actuator\
Spring RestTemplate with Apache client\
Lombok\
JUnit 5\
Docker \
Redis

## License

[MIT](https://choosealicense.com/licenses/mit/)