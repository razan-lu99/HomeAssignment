This is a solution for Web App Testing and Mobile App Testing.

<h2>Web App Testing</h2>

<h4>Proposed steps to follow for the set-up:</h4>
1. An IDE, I'm using IntelliJ.<br>
2. Programming language, I'm using Java, JDK downloaded, preferibly version 11<br>
3. Browser, I'm using Chrome<br>
4. A Chrome Driver downloaded on the PC (one that is compatible with the Chrome version), I'm using version 120.0.6099.71<br>
5. Inside Environment Variables in PC correct System Variables fixed up for the PC, "java_home"

<h4>How to execute tests:</h4>
1. When creating a project, create it as Maven.<br>
2. After creating a Maven project go to https://mvnrepository.com/ and search for needed libraries, ex. Selenium Java, TestNG. Paste in pom.xml file<br>
3. Run BookTest.java class

<h4>For the Web App Testing, these are the included files:</h4>
1. BaseTest.java<br>
2. WebElementHelpers.java<br>
3. BookPage.java<br>
4. BookTest.java

<h4>P.S.</h4>A way to execute on different test cases/scenarios easily is Cucumber. Which I'm currently taking a course on.


<h2>Mobile App Testing</h2>

<h4>Proposed steps to follow for the set-up:</h4>
1. An IDE, I'm using IntelliJ.<br>
2. Programming language, I'm using Java, JDK downloaded, preferibly version 11<br>
3. Inside Environment Variables in PC correct System Variables fixed up for the PC, "java_home" and "ANDROID_HOME"<br>
4. Appium Server, downloaded from Appium Server repository<br>
5. Appium Inspector, downloaded from Appium Inspector repository<br>
6. Connected device, I'm using physical device, Huawei P30 lite<br>
7. APK of the desired app to be tested

<h4>How to execute tests:</h4>
1. When creating a project, create it as Maven.<br>
2. After creating a Maven project go to https://mvnrepository.com/ and search for needed libraries, ex. Selenium Java, TestNG, Java Client. Paste in pom.xml file<br>
3. Start the Appium Server and Appium Inspector with the correct capabilities<br>
4. Run WeatherTest.java class

<h4>For the Mobile App Testing, these are the included files:</h4>
1. MobileBaseTest.java<br>
2. MobileElementHelpers<br>
3. res.properties<br>
4. Weather Forecast_3.5_Apkpure.apk<br>
5. WeatherPage.java<br>
6. WeatherTest.java
