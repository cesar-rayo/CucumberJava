## Running Test Scenarios from Gradle
It's possible to run cucumber from `gradle` all thanks to the configuration we set in the `build.gradle` file:

```groovy
plugins {
    id "se.thinkcode.cucumber-runner" version "0.0.8"
}

configurations {
    cucumberRuntime {
        extendsFrom testImplementation
    }
}

cucumber {
    main = 'io.cucumber.core.cli.Main'
    featurePath = 'src/test/java/linkedinlearning/cucumber/features'
    glue = 'classpath:linkedinlearning/cucumber/stepdefinitions'
    plugin = ['pretty']
}
```

Run all test Scenarios:
```shell
$ ./gradlew cucumber
```

Run test Scenarios using tags:
```shell
$ ./gradlew cucumber --tags "@MenuManagementTest"
$ ./gradlew cucumber --tags "@RegularTest"
$ ./gradlew cucumber --tags "@SmokeTest"
```

Run test Scenarios using tags and logical operators (`and`, `or`, `not`):
```shell
$ ./gradlew cucumber --tags "@NightlyBuildTest and @RegularTest"
$ ./gradlew cucumber --tags "@SmokeTest or @RegularTest"
$ ./gradlew cucumber --tags "not (@NightlyBuildTest and @RegularTest)"
```

## Running Test Scenarios from test runner

By specifying a file like `MenuManagementTest.java` we can simply execute as it was a Junit file, it will execute the test scenarios that match with the specified conditions:

```java
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/linkedinlearning/cucumber/features/MenuManagement.feature"},
        glue = {"linkedinlearning/cucumber/stepdefinitions"},
        tags = "not (@NightlyBuildTest and @RegularTest)",
        plugin = {"pretty"}
)
public class MenuManagementTest {
}
```

Notice this runner does not have an actual implementation, and that is expected.


## Gradle

Initialize the project
```shell
$ gradle wrapper
```

Show all tasks
```shell
$ ./gradlew tasks --all
```