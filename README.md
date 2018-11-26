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





