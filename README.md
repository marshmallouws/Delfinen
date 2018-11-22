# Delfinen

The system handles the members of the club where it is possible to see their swimming results and information. 

## Installation

When opening the program, make sure to add the MySQL connector to the project library and change the username and
password for your SQLserver in the file: **delfinen.data/DBConnector.java**. 
Afterwards, you can download and run the database-file: **DelfinSQL** and the file with test data: **TestDataSQL**. 

### Dependencies

To use the system, make sure to have following programs installed:

* Java 8
* MySQL JDBC-driver (MySQL connector)
* MySQL Server
* MySQL Workbench

## Configuration

Some MySQL functionalities require that you uncheck “Safe Updates” in preferences → SQL Editor.

## Run

To initialize the GUI, open the file: **delfinen.presentation/GUIMenu.java** and run the file.

## Pitfalls

The following test-files requires you to rerun the SQL-scripts as there are no methods to remove the test data.
In test packages:

* delfinen.data/DataAccessorTest.java
* delfinen.logic/ControllerAdmin.java

## Authors

* Sofie Amalie Landt
* Amanda Juhl Hansen
* Frederikke Simone Nielsen
* Annika Bhagya Ehlers
