# Test-app

## Pre-requisites
- Java version 11+
- Maven
- Terminal session

## Programmatically test
```shell
> mvn test
```

## User exploration test

### Exercise 1:
Run the program passing two arguments, "ex1" and maxNumber

- The first argument of the program must be "ex1"
- The second argument is a positive integer that represents the maxNumber

```shell
> mvn clean compile assembly:single
> java -jar target/test-app-1.0-SNAPSHOT-jar-with-dependencies.jar ex1 100
```

### Exercise 2:
Run the program passing two arguments, "ex2" and the JSON with the content.

- The first argument of the program must be "ex2"
- The second argument is a valid JSON that represents the data structure

```shell
> mvn clean compile assembly:single
> java -cp target/test-app-1.0-SNAPSHOT.jar test.bysix.App ex2 '[ { obj } { obj } ]'

# Example:
# java -jar target/test-app-1.0-SNAPSHOT-jar-with-dependencies.jar ex2 "[{\"country\":\"US\",\"languages\":[\"en\"]},{\"country\":\"BE\",\"languages\":[\"nl\",\"fr\",\"de\"]},{\"country\":\"NL\",\"languages\":[\"nl\",\"fy\"]},{\"country\":\"DE\",\"languages\":[\"de\"]},{\"country\":\"ES\",\"languages\":[\"es\"]}]"
```

