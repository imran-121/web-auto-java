# API-Automation

## **OVverview:**
This Web Automation framework is developed using JAVA, Maven(build automation tool), Selenium, Cucumber, Log4j and other supporting dependencies .  


### ** Key Features:**

Required:
1. BDD approach is followed
2. Page Object Model() is used
3. Configurations can be done from files (config.properties, cucumber.properties, extent.properties, log4j.properties, pom.xml, etc)
4. You can run the test cases by tag configuration in TestRunner.java file
5. Maven is used a dependency management tool

Capability:
5. It generates Extent report with all the step details. Report will be generated both HTML & PDF file format.
6. Generates execution logs and reports
7. Test execution can be triggered form command line. 
8. Easy integration to CI/CD pipeline.

## ** Architecture :**


Generic Flow:
1. Runner -> StepDefinition -> Hooks -> TestContext -> PageObject 

Packages:

1. com.ui.web.main -> Contains Runners and Hooks
2. com.ui.we.datamodels -> contains data structures for getting and setting data from pages
3. com.ui.pageobjects -> Contains page objects
4. com.ui.web.stepdefinitions -> contains bindings for feature files
5. com.ui.web.utilities -> contains the helper functions


## **Running Test:**

Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean test


Once the execution completes report & log will be generated in below folder.

**Report:** 		*target/report*<br>
**Log:** 		*target/logs*

