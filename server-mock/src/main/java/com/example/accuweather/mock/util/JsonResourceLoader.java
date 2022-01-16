package com.example.accuweather.mock.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;

@UtilityClass
public class JsonResourceLoader {
    public String loadGivenJsonOrReturnEmptyJson(String path) throws IOException {
//        InputStream resource = ClassLoader.getSystemClassLoader().getResourceAsStream(path);
//        if (resource == null) {
//            return "[]";
//        } else {
//            return new String(resource.readAllBytes(), StandardCharsets.UTF_8);
//        } //TODO: fix finding files in jar
        if ("json/location/location_02-796.json" .equals(path)) {
            return """
                    [
                      {
                        "Version": 1,
                        "Key": "335299_PC",
                        "Type": "PostalCode",
                        "Rank": 500,
                        "LocalizedName": "Warszawa",
                        "EnglishName": "Warszawa",
                        "PrimaryPostalCode": "02-796",
                        "Region": {
                          "ID": "EUR",
                          "LocalizedName": "Europe",
                          "EnglishName": "Europe"
                        },
                        "Country": {
                          "ID": "PL",
                          "LocalizedName": "Poland",
                          "EnglishName": "Poland"
                        },
                        "AdministrativeArea": {
                          "ID": "14",
                          "LocalizedName": "Masovia",
                          "EnglishName": "Masovia",
                          "Level": 1,
                          "LocalizedType": "Voivodship",
                          "EnglishType": "Voivodship",
                          "CountryID": "PL"
                        },
                        "TimeZone": {
                          "Code": "CET",
                          "Name": "Europe/Warsaw",
                          "GmtOffset": 1,
                          "IsDaylightSaving": false,
                          "NextOffsetChange": "2022-03-27T01:00:00Z"
                        },
                        "GeoPosition": {
                          "Latitude": 52.25,
                          "Longitude": 21,
                          "Elevation": {
                            "Metric": {
                              "Value": 100,
                              "Unit": "m",
                              "UnitType": 5
                            },
                            "Imperial": {
                              "Value": 327,
                              "Unit": "ft",
                              "UnitType": 0
                            }
                          }
                        },
                        "IsAlias": false,
                        "SupplementalAdminAreas": [],
                        "DataSets": [
                          "AirQualityCurrentConditions",
                          "AirQualityForecasts",
                          "Alerts",
                          "DailyPollenForecast",
                          "ForecastConfidence",
                          "FutureRadar",
                          "MinuteCast",
                          "Radar"
                        ]
                      }
                    ]
                    """;
        } else if ("json/forecast/forecast_14.json" .equals(path)) {
            return """
                    {
                      "Headline": {
                        "EffectiveDate": "2022-01-17T01:00:00+01:00",
                        "EffectiveEpochDate": 1642377600,
                        "Severity": 4,
                        "Text": "Silne wiatry w: niedziela późna noc, w porywach do ponad 65 km/h; wiatry mogą być lokalnie niszczące",
                        "Category": "wind",
                        "EndDate": "2022-01-17T07:00:00+01:00",
                        "EndEpochDate": 1642399200,
                        "MobileLink": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?unit=c",
                        "Link": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?unit=c"
                      },
                      "DailyForecasts": [
                        {
                          "Date": "2022-01-15T07:00:00+01:00",
                          "EpochDate": 1642226400,
                          "Temperature": {
                            "Minimum": {
                              "Value": -7.3,
                              "Unit": "C",
                              "UnitType": 17
                            },
                            "Maximum": {
                              "Value": -4,
                              "Unit": "C",
                              "UnitType": 17
                            }
                          },
                          "Day": {
                            "Icon": 3,
                            "IconPhrase": "Częściowo słonecznie",
                            "HasPrecipitation": false
                          },
                          "Night": {
                            "Icon": 7,
                            "IconPhrase": "Pochmurno",
                            "HasPrecipitation": false
                          },
                          "Sources": [
                            "AccuWeather"
                          ],
                          "MobileLink": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=1&unit=c",
                          "Link": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=1&unit=c"
                        },
                        {
                          "Date": "2022-01-16T07:00:00+01:00",
                          "EpochDate": 1642312800,
                          "Temperature": {
                            "Minimum": {
                              "Value": 0.5,
                              "Unit": "C",
                              "UnitType": 17
                            },
                            "Maximum": {
                              "Value": 2.4,
                              "Unit": "C",
                              "UnitType": 17
                            }
                          },
                          "Day": {
                            "Icon": 7,
                            "IconPhrase": "Pochmurno",
                            "HasPrecipitation": false
                          },
                          "Night": {
                            "Icon": 32,
                            "IconPhrase": "Wietrznie",
                            "HasPrecipitation": false
                          },
                          "Sources": [
                            "AccuWeather"
                          ],
                          "MobileLink": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=2&unit=c",
                          "Link": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=2&unit=c"
                        },
                        {
                          "Date": "2022-01-17T07:00:00+01:00",
                          "EpochDate": 1642399200,
                          "Temperature": {
                            "Minimum": {
                              "Value": -8.7,
                              "Unit": "C",
                              "UnitType": 17
                            },
                            "Maximum": {
                              "Value": 1.4,
                              "Unit": "C",
                              "UnitType": 17
                            }
                          },
                          "Day": {
                            "Icon": 2,
                            "IconPhrase": "Przeważnie słonecznie",
                            "HasPrecipitation": false
                          },
                          "Night": {
                            "Icon": 35,
                            "IconPhrase": "Zachmurzenie umiarkowane",
                            "HasPrecipitation": false
                          },
                          "Sources": [
                            "AccuWeather"
                          ],
                          "MobileLink": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=3&unit=c",
                          "Link": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=3&unit=c"
                        },
                        {
                          "Date": "2022-01-18T07:00:00+01:00",
                          "EpochDate": 1642485600,
                          "Temperature": {
                            "Minimum": {
                              "Value": -2.9,
                              "Unit": "C",
                              "UnitType": 17
                            },
                            "Maximum": {
                              "Value": -1.7,
                              "Unit": "C",
                              "UnitType": 17
                            }
                          },
                          "Day": {
                            "Icon": 4,
                            "IconPhrase": "Przejściowe zachmurzenia",
                            "HasPrecipitation": false
                          },
                          "Night": {
                            "Icon": 7,
                            "IconPhrase": "Pochmurno",
                            "HasPrecipitation": false
                          },
                          "Sources": [
                            "AccuWeather"
                          ],
                          "MobileLink": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=4&unit=c",
                          "Link": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=4&unit=c"
                        },
                        {
                          "Date": "2022-01-19T07:00:00+01:00",
                          "EpochDate": 1642572000,
                          "Temperature": {
                            "Minimum": {
                              "Value": -2.5,
                              "Unit": "C",
                              "UnitType": 17
                            },
                            "Maximum": {
                              "Value": 6.4,
                              "Unit": "C",
                              "UnitType": 17
                            }
                          },
                          "Day": {
                            "Icon": 29,
                            "IconPhrase": "Deszcz i śnieg",
                            "HasPrecipitation": true,
                            "PrecipitationType": "Mixed",
                            "PrecipitationIntensity": "Light"
                          },
                          "Night": {
                            "Icon": 38,
                            "IconPhrase": "Zachmurzenie duże",
                            "HasPrecipitation": false
                          },
                          "Sources": [
                            "AccuWeather"
                          ],
                          "MobileLink": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=5&unit=c",
                          "Link": "http://www.accuweather.com/pl/no/hektner/14/daily-weather-forecast/14?day=5&unit=c"
                        }
                      ]
                    }
                    """;
        } else {
            return "[]";
        }
    }
}
