
As we know that, to kickstart the automation journey using Selenium and JAVA, we majorly need three pre-requisites:
•	Installing and Setting up JAVA
•	Installing and Setting up an IDE, such as Eclipse
•	Downloading Selenium WebDriver

1. Download Java: There are few steps to follow:
•	Download Java
•	Install Java
•	Set Java Environment Path
•	Verify Java Installation

a.	Download Java:
1.	To install Java, you first need to download the installer program from Oracle. Visit the Download Java page: https://www.oracle.com/technetwork/java/javase/downloads/index.html. Click on Download button.
2.	Accept the License Agreement.  Choose the correct OS corresponding to the specific JDK. (Windows, Mac, Linux, etc.)
3.	The above step will start the downloading of the JDK exe automatically. This can be noticed at the left bottom side of the browser window.
b.	Steps to Install Java:   
1.  Once the download is complete, double click the file to begin the installation of JDK. This will start the installation process. The installation process starts. Click the Next button to continue the installation.
2.  It starts preparing for the installation and that will take a few minutes to complete.
3.  Next window will ask you where or on which location you would like to install Java on your system. You can choose to change where you want to keep your folder but it’s best to stick with the default options. Click Next to continue.
4.  Let the installation finish. A few brief dialogs confirm the last steps of the installation process; click Close on the last dialog. This will complete the Java installation process.
c.	 Steps to set the Java Environment Path:  
1.	Right Click on the My Computer and select the Properties.
2.	Click Advanced system settings on the left pane.
3.	Switch to Advanced tab and click Environment Variables button.
4.	Click on the New button of User variables. 
5.	 Right-click on the address bar and Copy address as text of bin folder where the JDK is installed.
6.	Type PATH in the Variable Name. And then paste the path of bin folder in Variable Value. Click on OK button
d.	Steps to Verify Java Installation:
•	Go to Command Prompt and type java -version If you see a screen like below, Java is installed.

2. Download Eclipse: Download Eclipse for Java Developers, extract and save it in any drive, run ‘eclipse.exe’ directly so you do not need to install Eclipse in your system. 
•	Download Eclipse IDE for Go to http://www.eclipse.org/downloads.
•	Save the .zip file to your disk.
•	Once you have downloaded the Eclipse archive you will need to Extract the zip file, which will create the unzipped Eclipse fold
•	Extract the archive to the root of C: drive, thus creating the folder “C:eclipse”, or just moved the extracted eclipse folder to the root of C: drive if you extracted it already. I prefer to leave it as it is.
•	Open the eclipse folder.
•	Extract the archive to the root of C: drive, thus creating the folder “C:eclipse”, or just moved the extracted eclipse folder to the root of C: drive if you extracted it already. I prefer to leave it as it is.
3. Download Selenium WebDriver:
•	Firstly, you can download the WebDriver java client from the official Selenium website. After that, click on the Download link for the Java driver.
•	Secondly, once the zip file download is complete, Extract the file so that you see the unzipped Selenium Java folde
•	Thirdly, once the extraction is complete, open the downloaded Selenium folder
4. Install Chrome Driver:
•	Download the Chrome Driver Server from the Chromium project : thttps://sites.google.com/a/chromium.org/chromedriver/ or https://chromedriver.storage.googleapis.com/index.html?path=2.20/
•	Chrome driver executable must be set into you machine system environments or it should be explicitly set in the code. 
•	Set property in Environment Variables:-
a.	Go to My Computer and Right-click to get the context menu.
b.	Click on the Change Settings on the opened window.
c.	Go to Advanced tab in the System Properties window and click on Environment Variables.
d.	Now under the System variables, select Path and click on Edit.
e.	At the end of the string use a semicolon and paste the path of the ChromeDriver. On my machine, my ChromeDriver exe resides in D:\ToolsQA\trunk\Library|drivers\
5. Install TestNG In Eclipse:
1.	Launch the Eclipse IDE and click “Install New Software” in the Help menu.
2.	You will see a new installation dialog window, click the “Add” button.
3.	Fill out the information as follows:
•	Name: TestNG (depends on the user)
•	Location: https://dl.bintray.com/testng-team/testng-eclipse-release/6.14.3/
•	Click Add.

4.	Clicking on add redirects us back to the previous window. However, this time you must see the TestNG option in the available software list. After that, check “TestNG” and click Next.
5.	Click Next to install the TestNG dependencies that eclipse calculates by itself
6.	After that, accept the terms of the license agreement then click Finish.
7.	You may or may not encounter a Security warning. Click Install Anyway if you do.
8.	Finally, after the restart, verify if TestNG installed successfully. Right-click on your project and see if TestNG displays in the opened menu.
6. If you are importing maven project for the first time, you would need to:
•	Install Maven
•	Install Maven-Eclipse Plugin
•	Import project in eclipse
Step-by-step guide
1) Install Maven:         
a.	download latest Maven  zip folder from: https://maven.apache.org/download.cgi
b.	Go to the download folder and right click on the Maven3.3 zip file and "Extract All"
c.	Set the destination folder as c:\Program Files
d.	Append "PATH" system Properties:
•	Control Panel > System and Security > System
•	Click on Advanced System Settings
•	Click On Environment Variables
•	Under System Variables highlight "Path" and click edit
•	Go to the end of the  value and (append with semicolon)  -    ;C:\Program Files\apache-maven-3.3.3-bin\apache-maven-3.3.3\bin
a.	e) Set JAVA_HOME if not already set in Environment Variable
b.	f) Start >Type cmd
c.	g) type mvn enter
d.	h) Copy settings.xml from C:\Program Files\apache-maven-3.3.3-bin\apache-maven-3.3.3\conf  to c:\users\<username>\.m2
e.	f) Open c:\users\<username>\.m2\repository and delete any content inside the folder (Empty repository folder)
2) Install Maven Plugin
•	Open Eclipse 
•	Click Help - > Install New Software
•	Note: If you downloaded the latest version of Eclipse, it already have Maven installed. 
•	In Work With text box Enter  http://www.eclipse.org/m2e/  and click Add
•	This url may not work with some versions of Eclipse . If the above gives error Type : http://download.eclipse.org/technology/m2e/releases
•	Click OK
•	Select the Maven Plugin installer and follow instructions on screen to Finish
3) Import project in eclipse
1.	Open Eclipse IDE and right click in Package Explorer
2.	Click on Maven folder and expand
3.	Select "Existing Maven Projects" and click NextIn root Directory Enter : 
4.	Select the check box next to /pom.xml 
5.	Click Next and Click Finish
6.	Eclipse - Clean Build
7.	Right Click on Project Framework ->run as > Maven >Install
8.	Open any of the Java. Class under application ?Right Click ?TestNg ?Run as TestNG Test. 
9.	User can see the web browser loading and able to create registration, login and Uploading video.
10.	Please follow the instructions to load Spin up a local development server  : https://github.com/LoganBresnahan/time-stamps

