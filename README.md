sainscraper
===========

*sainscraper* is a console application that scrapes the Sainsbury’s grocery site - Ripe Fruits page and prints out 
a JSON array of all the products on the page.

GitHub project repository: https://github.com/dejlek/sainscraper

source tree
-----------

Project's source tree looks like:

    .
    |-- nbproject
    `-- src
        |-- main
        |   `-- java
        |       `-- com
        |           `-- sainsburys
        |               `-- sainscraper
        `-- test
            `-- java
                `-- com
                    `-- sainsburys
                        `-- sainscraper

As you can see, the code resides in the com.sainsburys.sainscraper package (both testing, and regular).

running the application
-----------------------

The simplest way to run the application is to compile and run it:

    mvn compile
    mvn exec:java

I have also configured maven to package all dependencies in a single, executable JAR. To generate this JAR file
execute

    mvn package

After that you can run the application with simple:

    java -jar target/sainscraper-1.0-SNAPSHOT.jar

The sainscraper-1.0-SNAPSHOT.jar can then be copied anywhere and executed independently. 

testing
-------

To execute tests run:

`mvn test`

Here is an example output:

    .
    .
    .
    ------------------------------------------------------
     T E S T S
    -------------------------------------------------------
    Picked up _JAVA_OPTIONS: -Dsun.java2d.noddraw=true -Dsun.java2d.xrender=true
    Running com.sainsburys.sainscraper.SainscraperTest
    ProductInfo{title=Sainsbury's Avocado Ripe & Ready XL Loose 300g, size=35.0, unitPrice=1.5, description=Avocados}
    Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.648 sec

    Results :

    Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
