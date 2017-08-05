# CountMeUp

#####Background
This is a basic election application made for Technical Challenge 2017.  The application is fairly basic
and could be expanded in a number of ways, most notably with the addition of a web front end and
a database.

#####Installation Instructions for CENTOS 7
1.  Java 8 will need to be installed to run this code.  Java can be found from the oracle website located here:
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html.  You will need to install the 
version appropriate to your environment, which is most likely Linux x64 and the tar version of it.  You will then need
to install this onto your machine and set up you environment details correctly.  More information on this can be found here
https://tecadmin.net/install-java-8-on-centos-rhel-and-fedora/

2.  Next up will be to ensure that Apache Maven is installed on your machine.  On CENTOS 7 this will involve downloading the 
Apache Maven version for linux, which again is a tar file.  This is located here https://maven.apache.org/download.cgi.  Instructions on setting up the environment variables can be found 
here https://maven.apache.org/install.html

3.  The next step will be to clone my repository.  Once this has been done, you can run mvn package in the CountMeUp directory.
 This will install the required dependencies.  The final step is to run the application on your local machine.  This can be done on 
an IDE of your choice (I used IntelliJ).  It can also be done via the terminal.

4.  The automated tests can be run by either using the mvn test command when in the application's parent directory 
or running the test directory if you are using an IDE.   

Note:  Some thoughts I had as I wrote this application can be found in the GitHub commit history.