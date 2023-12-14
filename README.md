## theScore Appium Framework

### **Project Overview**

It is a robust and efficient test automation framework developed from scratch, integrating Data-Driven Testing (DDT) and Page Object Model (POM) methodologies. This framework is designed to automate testing for theScore mobile application, offering high scalability and maintainability for comprehensive test coverage.

### **Environment Setup**

#### Prerequisites:

* **Java 11**
* **Appium 1.9.1**
* **Maven 3.9.3**
* **Android Studio Giraffe | 2022.3.1 Patch 1**

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


### **Framework Setup Guide**

**Prerequisites**
- Windows Operating System
- Administrative access on the machine

**Environment Setup**

1. Install Node.js and NPM
- Download and install Node.js from [Node.js website](https://nodejs.org/)
- Verify the installation in Command Prompt: `node -v` `npm -v`

2. Install Java JDK

- Download the Java JDK from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html).
- Install the JDK and note down the installation path.
- Set the `JAVA_HOME` environment variable

3. Install Maven

- Download and install Maven 3.9.3 from [Apache Maven Project](https://maven.apache.org/download.cgi).
- Extract and set the Maven path in the Environment Variables, similar to `JAVA_HOME`

4. Install and Configure Appium

- Install Appium via NPM: `npm install -g appium@1.9.1`
- Optionally, install Appium Doctor: `npm install -g appium-doctor`
- Run Appium Doctor to verify the installation: `appium-doctor`

5. Install Android Studio and Set Up the Emulator

- Download and install Android Studio from [Android Developer website](https://developer.android.com/studio/).
- Follow the installation instructions and make sure to install the Android Virtual Device component.
- Open Android Studio and install the necessary SDKs and tools through the SDK Manager: 


- SDK Platforms: 


- Android SDK Platform 34 (Android API 34)
- Google APIs Intel x86 Atom System Image (Android 8.0 ("Oreo"))


- SDK Tools:


- Android SDK Build-Tools 34
- Android Emulator hypervisor driver (installer)
- Intel x86 Emulator Accelerator (HAXM Installer)


- Set the `ANDROID_HOME` under user variable `C:\Users\...\AppData\Local\Android\Sdk`

6. Edit path variable under system variable as shown below:

- C:\Program Files\Java\jdk11.0.20\bin
- C:\Program Files\apache-maven-3.9.3\bin
- C:\Users\\...\AppData\Local\Android\Sdk\emulator
- C:\Users\\...\AppData\Local\Android\Sdk\tools
- C:\Users\\...\AppData\Local\Android\Sdk\platform-tools

7. Cloning the Repository
- Command: `git clone https://github.com/OleksiiRash/theScore.git`

### **Running the Tests**

#### Configuration

Before running the tests, set up the following device emulator:

* **Device Name:** Pixel XL API 26
* **Phone:** Pixel XL
* **Screen Size:** 5.5 inches
* **Resolution:** 1440x2560
* **Density:** 560 dpi
* **OS Version:** Android 8.0 (Oreo, x86)

- Ensure the theScore.apk set-upped on the device.
- Ensure the Appium server is running.
- Start the Android emulator or connect an Android device.
- Navigate to the root directory of the project.

### **Test Execution**
The project includes two feature files for testing:

* **Welcome.feature**: Validates the app's first-time launch sequence.
* **Leagues.feature**: Regular testing for the app's primary functionalities.

#### **Initial App Launch (Welcome.feature)**

**Important:** If you decide to run instead the `Leagues.feature` using the `@leagues` tag for the first time, please ensure to manually launch the app on the connected Android device to complete any initial setup or registration process required by the application.

**To run the welcome sequence test:**

To run the welcome sequence tests, you will need to modify the `tags` option in the `RunnerClass`:

1. Navigate to the `RunnerClass` file located at `src/test/java/runners/RunnerClass.java`.
2. Change the `tags` attribute in `@CucumberOptions` to `@welcome`.
3. Save the changes.
4. Open the command prompt or terminal.
5. Navigate to the root directory of the project.
6. Execute the tests using Maven with the command:

`mvn test -Dcucumber.filter.tags="@welcome"`

This command will trigger the test runner to execute only the tests marked with the `@welcome` tag.

#### **League Tests (Leagues.feature)**

**To run the league-related tests:**

1. Make sure the app has been launched manually on your device if this is the first run (if you did not launch the Welcome.feature before). When you launch it go via the all set-upping steps and then when the main dashboard appear just close it and relaunch this test.
2. Navigate to the `RunnerClass` file located at `src/test/java/runners/RunnerClass.java`.
3. Change the `tags` attribute in `@CucumberOptions` to `@leagues`.
4. Save the changes.
5. Open the command prompt or terminal.
6. Navigate to the root directory of the project.
7. Execute the tests using Maven with the command:

`mvn test -Dcucumber.filter.tags="@leagues"`

**Note**: The `dryRun` option is currently set to `false`, which means that the tests will be executed. If you want to ensure that the Cucumber steps are well-defined without actually running the tests, you can set `dryRun` to `true` temporarily.

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
