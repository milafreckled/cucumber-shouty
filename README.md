# Cucumber Shouty App

This code covers rules and scenarios for Shouty application - which is basically marketing app for "shouting", where business owner can "shout" their messages and people within range can hear it. 
This Java Test Suite consists of few feature files, corresponding step definitions, test runner class and helper classes.
## Run with Maven

Open a command window and run:

    cd maven
    ./mvnw test

This runs Cucumber features using Cucumber's JUnit Platform Engine. The `Suite`
annotation on the `RunCucumberTest` class tells JUnit to kick off Cucumber.

## RUn with Gradle

Open a command window and run:

    cd gradle
    ./gradlew test --rerun-tasks --info

This runs Cucumber features using Cucumber's JUnit Platform Engine. The `Suite`
annotation on the `RunCucumberTest` class tells JUnit to kick off Cucumber.

## Overriding options

The Cucumber runtime uses configuration parameters to know what features to run,
where the glue code lives, what plugins to use etc. When using JUnit, these
configuration parameters are provided through the `@ConfigurationParameter`
annotation on your test.

For available parameters see: `io.cucumber.junit.platform.engine.Constants`

### Run a subset of Features or Scenarios

Specify a particular scenario by *line*

    @SelectClasspathResource(value = "io/cucumber/skeleton/shouty.feature", line = 23)

In case you have multiple feature files or scenarios to run against repeat the
annotation.

You can also specify what to run by *tag*:

    @IncludeTags("todo")
