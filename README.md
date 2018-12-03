This project is to get the BOBJ Report details from SAP BOBJ CMC Server. The Java Project uses SAP BOBJ SDK's and connects to CMC Server and pulls the report details. We need to do some initial setup to run this Java project.

Follow the configurations as mentioned in the URL in Eclipse.

To Deploy the BI Semantic Layer Java SDK in a Non-OSGI Eclipse Configuration

https://help.sap.com/viewer/4359a0ef221e4a1098bae432bdd982c1/4.2.3/en-US/45f1ee226e041014910aba7db0e91070.html

Create the project folder by following the steps in the above mentioned URL

The main file to run is BOBJReportDetailsNew.java under src\com\tutorialspot\demo\hr\model folder.

Please follow the below steps to export the project into executable JAR files. This is tested successfully in linux environment.
1. Right Click on the project folder in Eclipse -> Export
2. Java-> Runnable JAR File
3. Select the main class file BOBJUsersAndGroupsMain under Launch Configuration
4. Export Destination - Provide the path of the file and name to save this JAR file prefrebbly in the output_files_jars folder
5. Under Library Handling - Copy the required files into a sub-folder next to the generated JAR
6. Click Next and Finish.

All the complied JAVA files will be avaiable in the bin folder that gets generated.

The report details are loaded into a SAP HANA database. Any database can be used to stored the data. We need to use the respective jdbc JAR files for the program to work.

The java program can be executed by running the shell script from the config files folder (BOBJReportDetails.sh). Please modify the shell sript to add the path of the JAR files and BOBJReportDetails.properties properties file.

The SAP BOBJ CMC URL , username and  password needs to be provided in the BOBJReportDetails.properties folder. The authentication it uses is Enterprise.

create the tables in the database.
1.bobj_rpt_details - To store the Report details in the BOBJ system


CREATE TABLE BOBJ_RPT_DETAILS
(
REPORT_ID varchar(4000),
REPORT_NAME varchar(4000),
REPORT_PATH varchar(4000),
FULL_REPORT_PATH varchar(4000),
SERVER_NAME varchar(4000),
LOAD_DATE varchar(4000),
REPORT_TYPE varchar(4000),
RPT_CUID varchar(4000),
PARENT_FOLDER_ID varchar(4000)
)

Useful Links
================
http://help.sap.com/saphelpiis_sbo42sp1sl-sdk/frameset.htm?45f1ee226e041014910aba7db0e91070.html
https://archive.sap.com/discussions/thread/3582257
https://github.com/starschema/business-objects-universe-extractor


To Deploy the BI Semantic Layer Java SDK in a Non-OSGI Eclipse Configuration – BO Version 4.2
=============================================================================================
BI Semantic Layer Java SDK Event Workflow
The following steps represent the event workflow that is common to all BI Semantic Layer Java SDK samples that edit an object of the Semantic Layer. This is also the basic, essential workflow that you should apply in any development project that uses the SDK.
1.	An SDK context is created.
2.	A session is created in the CMS repository and attached to the context.
3.	The context instantiates a service.
4.	The necessary resources are loaded in memory using the service.
5.	Operations are performed on the objects as on a Java bean to edit it.
6.	The resources are saved using the service. Most security and integrity controls are performed during this step.
7.	The resources are released using the service.
8.	The context is released using the service.
9.	The session is logged off.
Steps to create a JAVA Project:
Creating Sessions
Loading Services
Using Factories
Instantiating Resources
SDK Object Models
A series of models defines the objects that are used by the SDK. The following sections give some details about these objects. For more information, see the SAP BusinessObjects BI Semantic Layer Java SDK Object Model Diagrams at http://help.sap.com:   Analytics   Business Intelligence   SAP BusinessObjects Business Intelligence platform 4.2   Development Information  .

In this section:
Resources
Data Foundations
Business Layers
Business Layer Items
Display Formats
Lists of Values
Parameters and Answers
Security Profiles
Connections




Saving Objects
Checking Objects
Releasing Objects
Raising Errors

Go to Run -> Run Configuration
 

 
Load Required Drivers
ngdbc.jar file for SAP HANA Connectivity
ojdbc6.jar for Oracle Database Connectivity
 




