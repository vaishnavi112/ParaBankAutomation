
## Getting Started

## Test Cases Description:

1. New Customer Registration Test (NewCustomerRegistrationTest)
Ensure the seamless registration process for new customers on the Parabank website. This automated test case verifies that users can successfully create a new account, receive confirmation, and log in with their registered credentials.

2. User Login and Logout Test (UserLoginLogoutTest)
Validate the login and logout functionality for existing users. This automated test case confirms that users can securely log in with their credentials, access their account dashboard, and log out successfully, maintaining the security of their accounts.

3. View Account Information Test (ViewAccountInfoTest)
Verify the accuracy of account information retrieval. This automated test case ensures that users can view their account balances and transaction history after logging in, providing a reliable overview of their financial activities on the Parabank website.

## Result
![TestResult](https://github.com/vaishnavi112/ParaBankAutomation-Part2/assets/51792745/1d1b6929-1415-4d3e-ba40-83adb5270434)

## To Setup Project :

1. Create a Maven Project 

2. Add following lines into your `pom.xml` build section:
```
<dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>4.4.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin -->
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.webdriver/webdriver-selenium -->
        <dependency>
            <groupId>org.seleniumhq.webdriver</groupId>
            <artifactId>webdriver-selenium</artifactId>
            <version>0.9.7376</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.2</version>
        </dependency>
        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-maven</artifactId>
            <version>2.10.0</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <!-- ... other plugins ... -->
            <plugin>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-maven</artifactId>
                <version>2.10.0</version>
                <configuration>
                    <reportVersion>2.14.0</reportVersion>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

* `mvn clean test` - run your tests

You can generate a report using one of the following command:

* `mvn allure:serve`

Report will be generated into temp folder. Web server with results will start.

* `mvn allure:report`

Report will be generated tо directory: target\surefire-reports\index.html

## Note: Discovered a bug while exploring the website.

Bug Description: After registering a new user, there is an issue where users are unable to log in with the newly created username and password. It's important to note that this is an intermittent issue.
