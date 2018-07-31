Environment preparation:
1. Download and install last jdk package from java.com
2. Download and install IntelliJ IDEA
3. Download and install last Firefox version.
4. Download geckodriver.zip from GitHUB(for Firefox 47+ version). Copy this file to C:\Windows\system32\
5. Open pom.xml (main file of our project) and add:
   <dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.13.0</version>
    </dependency>
   </dependencies>
(connect Selenium)

6.