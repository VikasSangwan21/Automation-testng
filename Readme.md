celsius-qa-canary-automation-framework
celsius-qa-canary-automation-framework for test automation covers:
    UI tests,
    API tests,and 
    Jenkins schduled executions.

Features:
    Multi-module maven project
    TestNG
    REST Assured
    Dependency injection 
    Page Object Model
    Test Data Management using excel
    Framework configuration using properties file.
    Multiple environment support using Owner library
    Multiple Test Suites (Regression, Smoke etc.) using TestNG xml file.
    Common QA-utilites sub-module for UI and API tests
    Common Utilities for web page interaction 
    Common Utilities for api interaction methods
    Email reporting post execution
    Extent Reporting

Tools Maven Selenium Webdriver

Requirements In order to utilise this project you need to have the
following installed locally: Maven 3 Chrome and Chromedriver (UI tests
use Chrome by default, can be changed in config) 
java version 17
BitBucket Jenkins

Installation:
    1. Create a project root folder.
    2. Copy the URL for project repositry from BitBucket. 
    3. Go to folder path and open GIT Bash. 
    4. On GIT bash prompt Enter command 'git clone <bitbucket URL>'. 
    5. The project will be cloned to the project root folder.

Usage:
    The project is a multi-module maven project with separate modules for API & UI testing.
    Each of these modules can be built and executed independently of the other using maven profiles.

Framework Configuration:
    Properties files are used for storing framework level configuration like timeouts, execution environment etc. The file is stored at the following location for each sub-module
    - \src\test\resources\configuration\configsettings.properties

Test Data:
    The test data will be read from an excel file for easy test data management and manipulation. The test data excel is stored at the following location for each sub-module
    - src\test\resources\test-data\TestData.xlsx
    

Execution: 
- using Command Prompt
    To run all modules, navigate to test-automation-quickstart directory and run the following command using command prompt:
    'mvn clean test'

    To run UI acceptance tests only, navigate to test-automation-quickstart directory and run the following command using command prompt:
    'mvn clean test'

    To run API acceptance tests only, navigate to test-automation-quickstartdirectory and run the following command using command prompt:
    'mvn clean test'

Reporting:
    Post exectution the test results will be generated and stored int the respective sub-module at the following location:
    - celsius-qa-canary\\ui-tests\\reports


Future Prospects:
    Parallel execution
    Optional Report overwriting
    Screenshots for failed test cases
    Cross Browser Support
    Multiple environment configuration

