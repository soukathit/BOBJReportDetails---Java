package com.tutorialspot.demo.hr.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.businessobjects.rebean.wi.DataProviders;
import com.businessobjects.rebean.wi.DocumentInstance;
import com.businessobjects.rebean.wi.ReportEngine;
import com.businessobjects.rebean.wi.ReportEngines;
import com.businessobjects.rebean.wi.ReportEngines.ReportEngineType;
//import com.crystaldecisions.enterprise.ocaframework.IProperty;
//import com.businessobjects.mds.universe.business.Attribute;
//import com.businessobjects.connectionserver.Measure;
import com.crystaldecisions.sdk.exception.SDKException;
import com.crystaldecisions.sdk.framework.CrystalEnterprise;
import com.crystaldecisions.sdk.framework.IEnterpriseSession;
import com.crystaldecisions.sdk.occa.infostore.IInfoObject;
import com.crystaldecisions.sdk.occa.infostore.IInfoObjects;
import com.crystaldecisions.sdk.occa.infostore.IInfoStore;
import com.crystaldecisions.sdk.plugin.desktop.folder.IFolder;
import com.crystaldecisions.sdk.properties.IProperties;
import com.crystaldecisions.sdk.properties.IProperty;
import com.sap.sl.sdk.authoring.businesslayer.Attribute;
import com.sap.sl.sdk.authoring.businesslayer.BlItem;
import com.sap.sl.sdk.authoring.businesslayer.BusinessLayer;
import com.sap.sl.sdk.authoring.businesslayer.BusinessLayerService;
import com.sap.sl.sdk.authoring.businesslayer.Dimension;
import com.sap.sl.sdk.authoring.businesslayer.Filter;
import com.sap.sl.sdk.authoring.businesslayer.Folder;
import com.sap.sl.sdk.authoring.businesslayer.Measure;
import com.sap.sl.sdk.authoring.businesslayer.NativeRelationalFilter;
import com.sap.sl.sdk.authoring.businesslayer.RelationalBinding;
import com.sap.sl.sdk.authoring.businesslayer.RelationalBusinessLayer;
import com.sap.sl.sdk.authoring.businesslayer.RootFolder;
import com.sap.sl.sdk.authoring.cms.CmsResourceService;
import com.sap.sl.sdk.authoring.commons.SlResource;
import com.sap.sl.sdk.authoring.connection.DatabaseConnection;
import com.sap.sl.sdk.authoring.connection.RelationalConnection;
import com.sap.sl.sdk.authoring.datafoundation.MonoSourceDataFoundation;
import com.sap.sl.sdk.authoring.datafoundation.Table;
import com.sap.sl.sdk.authoring.local.LocalResourceService;
import com.sap.sl.sdk.authoring.samples.util.AuthenticationMode;
import com.sap.sl.sdk.authoring.samples.util.SamplesUtilities;
import com.sap.sl.sdk.framework.SlContext;
import com.sap.sl.sdk.framework.cms.CmsSessionService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;







//import com.crystaldecisions.enterprise.ocaframework.IProperty;
//import com.businessobjects.mds.universe.business.Attribute;
//import com.businessobjects.connectionserver.Measure;
import com.crystaldecisions.sdk.exception.SDKException;
import com.crystaldecisions.sdk.framework.CrystalEnterprise;
import com.crystaldecisions.sdk.framework.IEnterpriseSession;
import com.crystaldecisions.sdk.occa.infostore.IInfoObject;
import com.crystaldecisions.sdk.occa.infostore.IInfoObjects;
import com.crystaldecisions.sdk.occa.infostore.IInfoStore;
import com.crystaldecisions.sdk.properties.IProperties;
import com.crystaldecisions.sdk.properties.IProperty;
import com.sap.sl.sdk.authoring.samples.util.AuthenticationMode;
import com.sap.sl.sdk.framework.SlContext;
import com.sap.sl.sdk.framework.cms.CmsSessionService;

public class BOBJReportDetailsNew {
	private final String USER_AGENT = "Mozilla/5.0";

	/** User name used to log in to the CMS */
	
	/** User Password */


	/** Authentication mode used to log in to the CMS. Here: Enterprise */
    private static final String CMS_AUTH_MODE = AuthenticationMode.ENTERPRISE;
    
    /** Full path of the connection in the CMS repository */
    //private static final String CNX_PATH = CmsResourceService.CONNECTIONS_ROOT + "/BO to Greenplum (JDBC)";
    
    /** Full path of the connection in the CMS repository */
    //private static final String UNX_PATH = CmsResourceService.UNIVERSES_ROOT + "/Backup/ByWeek";
    
    /** Universe name */
    private static final String UNX_NAME = "Campaign Influence.unx";
    
    static String dbName = "BINRTUT2";
    
    //static String userName = "S_INF";
    
   // static String password = "edw2Infa4";
    
    static Connection connection = null;
    
    List<Object> listFolder = new ArrayList<Object>();
    List<Object> listDimension = new ArrayList<Object>();
    List<Object> listAttribute = new ArrayList<Object>();
    List<Object> listMeasure = new ArrayList<Object>();
    List<Object> listFilter = new ArrayList<Object>();
	
	/** Local folder used to save all resources locally */
    //private static final String LOCAL_FOLDER = System.getProperty("java.io.tmpdir");
    private static final String LOCAL_FOLDER = "D://Soukath Folder//BO Shared Folder//SL SDK Project Test";
    
    String Universe_Name = UNX_NAME;
	/** New user name to set in the connection */
    //private static final String NEW_USER = "gp_rpt";

	/** New password to set in the connection */
    //private static final String NEW_PASS = "gp_rpt";

    private static SlContext context;
    
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static Date date = new Date();
    static String current_Date_parameter = sdf.format(date);
    static Properties prop=null;
    //private IEnterpriseSession enterpriseSession;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Sample Hello World");
		// TODO Auto-generated method stub
				 //System.out.println("LOCAL_FOLDER : " + LOCAL_FOLDER);
					// Connects to the CMS and creates a session
			    	//System.out.println("@ Before Execution");
					prop = new Properties();
					prop.load(new FileInputStream(args[0]));
			        context = SlContext.create();
			        //System.out.println("@ Before Execution - Context Creation");
			        
			        String to = "XXXXXXX";

			        // Sender's email ID needs to be mentioned
			        String from = "XXXXXXX";

			        // Assuming you are sending email from localhost
			        String host = "XXXXXXXX";

			        // Get system properties
			        Properties properties = System.getProperties();

			        // Setup mail server
			        properties.setProperty("mail.smtp.host", host);

			        // Get the default Session object.
			        Session session = Session.getDefaultInstance(properties);
			    	
			    	/*try {
			          	 
						//Class.forName("oracle.jdbc.driver.OracleDriver");
			    		 connection = DriverManager.getConnection(
			    		            "jdbc:sap://sbi-dev-d1:30015/?autocommit=false",userName,password);
			    		         System.out.println("SAP HANA DB Connected Successfully");

					} catch (SQLException e) {
						e.printStackTrace();
					}*/
			     Connection connection = null;
			     Statement stmt = null;
			     String SQL_INSERT_BOBJ_USERS = "INSERT INTO VCORE.BOBJ_USERS" + " VALUES(?, ?, ?,?,?,?)";
			     String SQL_INSERT_BOBJ_ROLES = "INSERT INTO VCORE.BOBJ_ROLES" + " VALUES(?, ?, ?,?,?)";
			     String SQL_INSERT_BOBJ_USER_ROLES = "INSERT INTO VCORE.BOBJ_USER_ROLES" + " VALUES(?, ?,?,?)";
			     String SQL_DELETE_BOBJ_USERS = "DELETE FROM VCORE.BOBJ_USERS";
			     String SQL_DELETE_BOBJ_ROLES = "DELETE FROM VCORE.BOBJ_ROLES";
			     String SQL_DELETE_BOBJ_USER_ROLES = "DELETE FROM VCORE.BOBJ_USER_ROLES";
			     
			     String SQL_INSERT_WEBI_REPORTS = "INSERT INTO VCORE.BOBJ_RPT_DETAILS" + " VALUES(?, ?, ?,?,?,?,?,?,?)";
			     
			     String SQL_DELETE_WEBI_REPORTS = "DELETE FROM VCORE.BOBJ_RPT_DETAILS";
			     
			     //String CMServerURL = prop.getProperty("CMServerURL");
			     String userName =prop.getProperty("userName");
			     
			     String password =prop.getProperty("password");
			     String HANA_DB = prop.getProperty("HANA_DB");	     
			     try {
			    	 
			    	 connection = DriverManager.getConnection(
			    			 HANA_DB,userName,password);
		 		         //System.out.println("SAP HANA DB Connected Successfully");
						//System.out.println("Connected :" + connection.getSchema() );

					} catch (SQLException e) {

						e.printStackTrace();
					}
			  
			  if (connection != null) {
						//System.out.println("nSuccessfullly connected to HANA DB");
						stmt = connection.createStatement();
						
					} else {
						//System.out.println("nFailed to connect to HANA DB");
					}
			  	//PreparedStatement statement_bobj_users = connection.prepareStatement(SQL_INSERT_BOBJ_USERS);
			  	//PreparedStatement statement_bobj_roles = connection.prepareStatement(SQL_INSERT_BOBJ_ROLES);
			  	//PreparedStatement statement_bobj_user_roles = connection.prepareStatement(SQL_INSERT_BOBJ_USER_ROLES);
			  	
				PreparedStatement statement_webi_reports = connection.prepareStatement(SQL_INSERT_WEBI_REPORTS);
			  	
			  	//stmt.executeUpdate(SQL_DELETE_BOBJ_USERS);
			  	//stmt.executeUpdate(SQL_DELETE_BOBJ_ROLES);
			  	stmt.executeUpdate(SQL_DELETE_WEBI_REPORTS);
			  	
			  	//System.out.println("Code Execution Started");
			  	
			  	String bipURL = prop.getProperty("bipURL");  
			  	//System.out.println(bipURL);
			   
				String CMServerURL = prop.getProperty("CMServerURL"); 
			    String documentId = "190149";
			    String CMSUser = prop.getProperty("CMSUser"); 
			    String CMSPassword = prop.getProperty("CMSPassword"); 
			    String CMS_LOG_HOST = prop.getProperty("CMS_LOG_HOST");
			    String CMSAuthType =CMS_AUTH_MODE;// "secEnterprise";
			    //System.exit(0);
			   // IEnterpriseSession enterpriseSession = CrystalEnterprise.getSessionMgr().logon(CMS_LOG_USER, CMS_LOG_PASS, CMServerURL, CMS_AUTH_MODE);
			    String Report_Type_Public = "Public";
			    String Report_Type_My_Favourites = "My Favourites";
			    String Report_Type_Inbox = "Inbox";
			   // System.out.println(CMServerURL);
			    //System.out.println(CMSUser);
			    //System.out.println(CMSPassword);
			    //System.out.println(CMSAuthType);
			    
			    //Commented this Code
				//Authentication authentication = new Authentication();
				//WorkWithPropertiesFlows workWithPropertiesFlows = new WorkWithPropertiesFlows();
				//authentication.setCMSServerURL(CMServerURL);
				//authentication.setCMSUser(CMSUser);
				//authentication.setCMSPassword(CMSPassword);
				//authentication.setCMSAuthType(CMSAuthType);
				//String trace;
				//String resourcesFolderField = "D:\\Soukath Folder\\SDK Jars";
				String resourcesFolderField = prop.getProperty("resourcesFolderField");;
				//System.out.println(resourcesFolderField);
				//trace = authentication.logonCreateXMLs(resourcesFolderField);
				//workWithPropertiesFlows.setAuthentication(authentication);
				//--------------
				
			    IEnterpriseSession enterpriseSession = CrystalEnterprise.getSessionMgr().logon(CMSUser, CMSPassword, CMS_LOG_HOST, CMSAuthType);
			    context.getService(CmsSessionService.class).setSession(enterpriseSession);
			    IInfoStore infoStore = (IInfoStore) enterpriseSession.getService("InfoStore");
			    
			

		// Code to get all the Reports  and Folders in the Enterprise System 
		   //String query_webi_reports = "select Top 1000000  si_id,si_name,si_parentid from ci_infoobjects where si_kind in ('Webi') and  SI_RUNNABLE_OBJECT = 0 AND SI_INSTANCE_OBJECT = 0 AND SI_ANCESTOR = 23 ";
		   String query_webi_reports = "select Top 1000000  si_id,si_name,si_parentid,SI_CUID from ci_infoobjects where si_kind in ('Webi') and  SI_RUNNABLE_OBJECT = 0 AND SI_INSTANCE_OBJECT = 0  AND SI_ANCESTOR = 23 ";
		IInfoObjects iObjects_webi_reprots = (IInfoObjects) infoStore.query(query_webi_reports);
		IInfoObject iObject_webi_report = null;

		for(int i=0;i<iObjects_webi_reprots.size();i++)
		{	
		  iObject_webi_report = (IInfoObject)iObjects_webi_reprots.get(i);
		 int webi_report_id_int =  iObject_webi_report.getID();
		 String webi_report_id = String.valueOf(webi_report_id_int);
		 String webi_report_name =  iObject_webi_report.getTitle();
		 String webi_rpt_cuid = iObject_webi_report.getCUID();
		//System.out.println( "Webi Report Name : " + iObject_webi_report.getTitle() + " - Webi Report Id : " +  iObject_webi_report.getID());
		IProperties prop = iObject_webi_report.properties();
		IProperty getProp = prop.getProperty("SI_PARENTID");
		String FolderID = getProp.toString();
		IInfoObjects folder = infoStore .query("select si_id,si_name,si_parentid,si_path,si_cuid from ci_infoobjects where si_id=" + FolderID);
		IInfoObject ifolder=(IInfoObject)folder.get(0); 
		if(ifolder.getKind().equals("Folder"));
		{
			   IFolder iifolder=(IFolder)ifolder;
			   String finalFolderPath="";
			   if(iifolder.getPath()!= null)
			   {
				    String path[]=iifolder.getPath();
				    for(int fi=0;fi<path.length;fi++)
				    {
				        finalFolderPath = path[fi] + "/" + finalFolderPath;
				       }
				    finalFolderPath = finalFolderPath + iifolder.getTitle();
			   }
			   else
			   {
			    finalFolderPath=finalFolderPath+iifolder.getTitle();
			   }
			   //System.out.println( finalFolderPath );
			   String full_report_path = finalFolderPath  + '/' +  webi_report_name;
			   statement_webi_reports.setString(1, webi_report_id);
			   statement_webi_reports.setString(2, webi_report_name);
			   statement_webi_reports.setString(3, finalFolderPath);
			   statement_webi_reports.setString(4, full_report_path);
			   statement_webi_reports.setString(5, current_Date_parameter);
			   statement_webi_reports.setString(6, CMServerURL);
			   statement_webi_reports.setString(7, Report_Type_Public);
			   statement_webi_reports.setString(8, webi_rpt_cuid);
			   statement_webi_reports.setString(9, FolderID);
			   statement_webi_reports.executeUpdate();
			   //Uncomment this Section to get the entire dataprovider details
			 //  String trace_properties_dp = workWithPropertiesFlows.getDocumentDataProviders(webi_report_id, resourcesFolderField,statement_webi_rpt_dp,statement_webi_rpt_dp_details,connection,statement_webi_rpt_dp_query,current_Date_parameter,CMServerURL);
			   //String trace_properties_rpt_sh_elmt = workWithPropertiesFlows.getDocumentSharedElements(webi_report_id, resourcesFolderField,statement_webi_rpt_sh_elmt,connection,current_Date_parameter,CMServerURL);
		}

		}


			    connection.commit();
			    connection.close();
			    	//System.out.println("@ After Execution");
					// Closes the CMS session
			    enterpriseSession.logoff();
			        context.close();
			        //System.out.println("@ After Execution -  Context Close and Program Ended Successfully");
			        //enterpriseSession.logoff();
			        
			        
			        
			        try {
			            // Create a default MimeMessage object.
			            MimeMessage message = new MimeMessage(session);

			            // Set From: header field of the header.
			            message.setFrom(new InternetAddress(from));

			            // Set To: header field of the header.
			            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			            // Set Subject: header field
			            message.setSubject("BOBJ Report Details Schedule Task Update");

			            // Send the actual HTML message, as big as you like
			            message.setContent("<h3>The BOBJ Report Details Schedule Completed Successfully</h3>", "text/html");

			            // Send message
			            Transport.send(message);
			         //   System.out.println("Sent message successfully....");
			         }catch (Exception mex) {
			            mex.printStackTrace();
			         }
	}

}
