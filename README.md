## theScore Appium Framework

### **Project Overview**

It is a robust and efficient test automation framework developed from scratch, integrating Data-Driven Testing (DDT) and Page Object Model (POM) methodologies. This framework is designed to automate testing for theScore mobile application, offering high scalability and maintainability for comprehensive test coverage.

### **Environment Setup**

#### Prerequisites:

* **Java: Version 11**
* **Appium Server: Version 1.9.1**
* **Maven**
* **Android Studio**

#### Dependencies

The project relies on several Maven dependencies, including:

* **Cucumber** (for BDD approach)
* **Appium Java-Client**
* **Selenium Java**
* **Apache POI** (for Excel data handling)
* **SLF4J** (Simple Logging Facade for Java)
* **Jackson Databind** (for JSON parsing)
* **AssertJ** (for fluent assertions)
* **Apache Commons Lang** (for Java utility classes)

### **Running the Tests**

#### Configuration

Before running the tests, set up the following device emulator:

* **Device Name:** Pixel XL API 26
* **Phone:** Pixel XL
* **Screen Size:** 5.5 inches
* **Resolution:** 1440x2560
* **Density:** 560 dpi
* **OS Version:** Android 8.0 (Oreo, x86)

### **Test Execution**
The project includes two feature files for testing:

* **Welcome.feature**: Validates the app's first-time launch sequence.
* **Leagues.feature**: Regular testing for the app's primary functionalities.

### **Test Structure and Design**

#### Framework Structure

The framework is structured for optimal organization and ease of use:

* **apk folder**: Contains the theScore.apk file.
* **test folder**: Includes java and resources subfolders.
* **java folder**: packages for POM pages, runners, steps and utils.
* **resources folder**: Contains the config.properties file and feature files.

#### Data-Driven Elements

The Cucumber Scenario Outline is used to achieve data-driven testing, enabling the execution of tests with various data sets for thorough coverage.

#### Test Cases
1. **Welcome Sequence Navigation** - 
   validates the app's welcome sequence, including league and team selection.


2. **Enhanced League Page Navigation** - 
   tests the navigation and verification of league pages and sub-tabs, ensuring correct display and interaction capabilities.
