# openweather-mcp
Using Spring AI to create an MCP server for OpenWeather

*NB at time of writing MCP itself not yet implemented.*


## Requirements

* java 17
* gradle 8+

## Running

Ensure these 2 environment variables are set.

> export SPRING_AI_OPENAI_API_KEY=<your openai key>

> export OPENWEATHER_API_KEY=<your open weather api key>

You may wish to create a local properties file with your values - don't commit this! - use application.properties as a basis.


Start the app:

> gradle bootRun

Or if you are using local properties:

> gradle bootRun --args='--spring.config.location=file:./local.properties'


Make a query:


> curl --get --data-urlencode "message=What's the weather like in Paris today?" http://localhost:8080/chat/weather

You should get a response of this form:

> The weather in Paris today is clear, with a temperature of 38.9°C (feels like 39.2°C). The humidity is at 25%.
