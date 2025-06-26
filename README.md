# openweather-mcp
Using Spring AI to create an MCP server for OpenWeather

*NB at time of writing MCP itself not yet implemented.*


## Requirements

* java 17
* gradle 8+

## Running

Ensure these 2 environment variables are set.

> export SPRING_AI_OPENAI_API_KEY=<your openai key>

> export WEATHER_OPENWEATHER_API_KEY=<your open weather api key>


Start the app:

> gradle bootRun

Make a query:


> curl --get --data-urlencode "query=What's the weather like in Rome today?" http://localhost:8080/weather

You should get a response of this form:

> {"main":{"temp":23.67,"feels_like":24.16,"temp_min":22.49,"temp_max":24.31,"pressure":1019,"humidity":79,"sea_level":1019,"grnd_level":992},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],"name":"Rome"}

