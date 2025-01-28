# Testing moodle using Cucumber
This directory contains the cucumber files for testing the $$*TODO* module name$$ module of the moodle application.

## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/Moodle](resources/Moodle) directory. See the files for a detailed description of the tests.

1. **Student checks quiz grade**: This scenario assumes that the student has already attempted the quiz and is checking their grade.
2. **Teacher deletes the quiz**: A teacher deletes an existing quiz from an existing course


## Step files
The step files in the [src/test/java/Moodle](src/test/java/Moodle) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.
