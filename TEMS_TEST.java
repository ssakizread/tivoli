package tems;

import java.net.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.w3c.dom.Document;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TEMS_TEST {
	
	private String server;
	private int port;
	private String user;
	private String password;
	

	public TEMS_TEST() {
		this("localhost");
		// TODO Auto-generated constructor stub
	}
	
	public TEMS_TEST(String serverName)
	{
		server = "HOST";
		port = 1920;
		user = "USER";
		password = "PASSSWD";


	}
	
	
	public void setPort(int newPort)
	{
		port = newPort;
	}
	
	public int getPort()
	{
		return(port);
	}
	
	public void setUser(String newUser)
	{
		user = newUser;
	}
	
	public String getUser()
	{
		return(user);
	}
	
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
	
	public String toString()
	{
		String s = "Server=" + server + ";Port=" +
		   port + ";User=" + user + ";Password=" + password;
		return(s);
	}
	
	public String getUrl()
	{
		String url = "http://" + server + ":" + port + "///cms/soap";
		return(url);
	}
	
	public NodeList CT_Get(String objectName, String target)
	{	
		String xml = "<CT_Get>" + 
		      "<userid>" + user + "</userid>" +
		      "<password>" + password + "</password>" +
		      "<object>" + objectName + "</object>" +
		      "<target>" + target + "</target>" +
		      "</CT_Get>";
		
		NodeList nodes = null;
		
		try {
			// establish http connection.
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	public NodeList CT_Get(String objectName, String attribute1, String attribute2,  String attribute3)
	{	
		String xml = "<CT_Get>" + 
		      "<userid>" + user + "</userid>" +
		      "<password>" + password + "</password>" +
		      "<object>" + objectName + "</object>" +
		      "<attribute>" + attribute1 + "</attribute>" +
		      "<attribute>" + attribute2 + "</attribute>" +
		      "<attribute>" + attribute3 + "</attribute>" +
		      "</CT_Get>";
		
		NodeList nodes = null;
		
		try {
			// establish http connection.
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	public NodeList CT_Get(String objectName, String attribute1, String attribute2)
	{	
		String xml = "<CT_Get>" + 
		      "<userid>" + user + "</userid>" +
		      "<password>" + password + "</password>" +
		      "<object>" + objectName + "</object>" +
		      "<attribute>" + attribute1 + "</attribute>" +
		      "<attribute>" + attribute2 + "</attribute>" +
		      "</CT_Get>";
		
		NodeList nodes = null;
		
		try {
			// establish http connection.
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
		}
		catch (Exception e) {
		}
		return(nodes);
	}

	public NodeList CT_Get_Filter_SEM(String tableName, String targetName, String attribute1, String attribute2,String attribute3,String attribute4, String attribute5,String attribute6,String attribute7,String[] filters)
	{	
		String xml = "<CT_Get>" + 
			      "<userid>" + user + "</userid>" +
			      "<password>" + password + "</password>" +
			      "<table>" + tableName + "</table>" +
			      "<target>" + targetName + "</target>" +
			      "<attribute>" + attribute1 + "</attribute>" +
			      "<attribute>" + attribute2 + "</attribute>" +
			      "<attribute>" + attribute3 + "</attribute>" +
			      "<attribute>" + attribute4 + "</attribute>" +
			      "<attribute>" + attribute5 + "</attribute>" +
			      "<attribute>" + attribute6 + "</attribute>" +
			      "<attribute>" + attribute7 + "</attribute>"  ;
				for (String e : filters) {
					// System.out.println(e);

					String filter= e;
					xml= xml + "<afilter>" + filter + "</afilter>" ;
				}
				
				xml = xml +  "</CT_Get>";
		
		NodeList nodes = null;
		
		try {
			// establish http connection.
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	

	
	public NodeList CT_Get_Filter_SEM1(String tableName, String targetName, String attribute1, String attribute2,String attribute3,String attribute4,String attribute5,String[] filters)
	{	
		String xml = "<CT_Get>" + 
			      "<userid>" + user + "</userid>" +
			      "<password>" + password + "</password>" +
			      "<table>" + tableName + "</table>" +
			      "<target>" + targetName + "</target>" +
			      "<attribute>" + attribute1 + "</attribute>" +
			      "<attribute>" + attribute2 + "</attribute>" +
			      "<attribute>" + attribute3 + "</attribute>" +
			      "<attribute>" + attribute4 + "</attribute>" +
			      "<attribute>" + attribute5 + "</attribute>"  ;
		for (String e : filters) {
			// System.out.println(e);

			String filter= e;
			xml= xml + "<afilter>" + filter + "</afilter>" ;
		}
		
				
				xml = xml +  "</CT_Get>";
				System.out.println(" REQUEST1 : " + xml);
				
		NodeList nodes = null;
		
		try {
			// establish http connection.
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	public NodeList CT_Get_Filter_SEM2(String tableName, String targetName, String attribute1, String attribute2,String attribute3,String attribute4,String attribute5,String attribute6,String attribute7,
			String attribute8,String attribute9,String attribute10,String attribute11)
	{	
		String xml = "<CT_Get>" + 
			      "<userid>" + user + "</userid>" +
			      "<password>" + password + "</password>" +
			      "<table>" + tableName + "</table>" +
			      "<target>" + targetName + "</target>" +
			      "<attribute>" + attribute1 + "</attribute>" +
			      "<attribute>" + attribute2 + "</attribute>" +
			      "<attribute>" + attribute3 + "</attribute>" +
			      "<attribute>" + attribute4 + "</attribute>" +
			      "<attribute>" + attribute5 + "</attribute>"  +
				  "<attribute>" + attribute6 + "</attribute>"  +
				  "<attribute>" + attribute7 + "</attribute>"  +
				  "<attribute>" + attribute8 + "</attribute>"  +
				  "<attribute>" + attribute9 + "</attribute>"  +
				  "<attribute>" + attribute10 + "</attribute>" +
				  "<attribute>" + attribute11 + "</attribute>"  ;

				
				xml = xml +  "</CT_Get>";
				System.out.println(" REQUEST1 : " + xml);
				
		NodeList nodes = null;
		
		try {
			// establish http connection.
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	
	public NodeList CT_Get_Filter_SEM3(String tableName,String targetName,  String attribute1, String attribute2,String attribute3,String attribute4,String attribute5)
	{	
		String xml = "<CT_Get>" + 
			      "<userid>" + user + "</userid>" +
			      "<password>" + password + "</password>" +
			      "<table>" + tableName + "</table>" +
			      "<target>" + targetName + "</target>" +
			      "<attribute>" + attribute1 + "</attribute>" +
			      "<attribute>" + attribute2 + "</attribute>" +
			      "<attribute>" + attribute3 + "</attribute>" +
			      "<attribute>" + attribute4 + "</attribute>" +
			      "<attribute>" + attribute5 + "</attribute>"  ;
			 // xml= xml + "<afilter>" + filter + "</afilter>" ;

					
				xml = xml +  "</CT_Get>";
				System.out.println(" REQUEST1 : " + xml);
				
		NodeList nodes = null;
		
		try {
			// establish http connection.
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	public NodeList CT_Get_Filter(String objectName, String attribute1, String attribute2, String filter)
	{	
		String xml = "<CT_Get>" + 
		      "<userid>" + user + "</userid>" +
		      "<password>" + password + "</password>" +
		      "<object>" + objectName + "</object>" +
		      "<attribute>" + attribute1 + "</attribute>" +
		      "<attribute>" + attribute2 + "</attribute>" +
		      "<afilter>" + filter + "</afilter>" +
		      "</CT_Get>";
		
		NodeList nodes = null;
		
		try {
			// establish http connection.
			System.out.println("trace x");
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			System.out.println("trace y");
			System.out.println("trace y : " + xml );
			
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			 System.out.println("trace z");
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
			
			// System.out.println("trace 1");
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	//NodeList managedSystems = tems.CT_Get_FilterX("OMCICS.CICSODV", filter, "End_Time", "Transaction_ID","Response_Time");
	
	public NodeList CT_Get_FilterX(String tableName, String targetName, String attribute1, String attribute2,String attribute3,String attribute4, String attribute5,String attribute6,String attribute7,String filter1, String filter2)
	{	
		String xml = "<CT_Get>" + 
		      "<userid>" + user + "</userid>" +
		      "<password>" + password + "</password>" +
		      "<table>" + tableName + "</table>" +
		      "<target>" + targetName + "</target>" +
		      "<attribute>" + attribute1 + "</attribute>" +
		      "<attribute>" + attribute2 + "</attribute>" +
		      "<attribute>" + attribute3 + "</attribute>" +
		      "<attribute>" + attribute4 + "</attribute>" +
		      "<attribute>" + attribute5 + "</attribute>" +
		      "<attribute>" + attribute6 + "</attribute>" +
		      "<attribute>" + attribute7 + "</attribute>" +
		      "<afilter>" + filter1 + "</afilter>" +
		      "<afilter>" + filter2 + "</afilter>" +
		      "</CT_Get>";
		
		
		System.out.println(" REQUEST1 : " + xml);
		
		// xml="<CT_Get><userid>USER</userid><password>PASSWD</password><table>OMCICS.CICSODV</table><target>LPAR.REGION</target><attribute>End_Time</attribute><attribute>Transaction_ID</attribute><attribute>Response_Time</attribute><attribute>Task_Number</attribute></CT_Get>";
		//System.out.println(" REQUEST2 : " + xml);
		NodeList nodes = null;
		
		try {
			// establish http connection.
			 System.out.println("trace x CT_Get_FilterX");
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// System.out.println("trace y");
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			System.out.println("trace CT_Get_FilterX get the response and parse it into XML node list");
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
			
			// System.out.println("trace 1");
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	
	
	
	public NodeList CT_Get_FilterXX(String tableName, String targetName, String attribute1, String attribute2,String attribute3,String attribute4, String attribute5,String attribute6,String attribute7,String filter1, String filter2,String filter3)
	{	
		String xml = "<CT_Get>" + 
		      "<userid>" + user + "</userid>" +
		      "<password>" + password + "</password>" +
		      "<table>" + tableName + "</table>" +
		      "<target>" + targetName + "</target>" +
		      "<attribute>" + attribute1 + "</attribute>" +
		      "<attribute>" + attribute2 + "</attribute>" +
		      "<attribute>" + attribute3 + "</attribute>" +
		      "<attribute>" + attribute4 + "</attribute>" +
		      "<attribute>" + attribute5 + "</attribute>" +
		      "<attribute>" + attribute6 + "</attribute>" +
		      "<attribute>" + attribute7 + "</attribute>" +
		      "<afilter>" + filter1 + "</afilter>" +
		      "<afilter>" + filter2 + "</afilter>" +
		      "<afilter>" + filter3 + "</afilter>" +
		      "</CT_Get>";
		
		
		System.out.println(" REQUEST1 : " + xml);
		

		NodeList nodes = null;
		
		try {
			// establish http connection.
			 System.out.println("trace x CT_Get_FilterX");
			URL url = new URL(getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			
			// System.out.println("trace y");
			// post the request
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(xml);
			writer.flush();
			writer.close();
			
			System.out.println("trace CT_Get_FilterX get the response and parse it into XML node list");
			// get the response and parse it into XML node list.
			nodes = parseXmlStream(connection.getInputStream());
			
			// System.out.println("trace 1");
		}
		catch (Exception e) {
		}
		return(nodes);
	}
	
	
	
	
	// reads the SOAP response from input stream and returns the XML nodes after parsing the XML. 
	public NodeList parseXmlStream(InputStream xmlStream) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		Document document = null;
		NodeList nodes = null;
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(xmlStream);
			  System.out.println("trace 2");
			// print result
		
			try {
				printDocument(document,System.out);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
			
			// Well, a XPath might be a better idea here, but I can't find a 
			// built-in parser that supports XPath in JDK 1.4.
			// gets the "/SOAP-ENV:Envelope/OBJECT/DATA/ROW node, which contains
			// the results.
			nodes = document.getElementsByTagName("ROW");
			

		
		}
		catch (SAXException sxe)
		{
			Exception x = sxe;
			if (sxe.getException() != null)
				x = sxe.getException();
			x.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch (ParserConfigurationException pce)
		{
			pce.printStackTrace();
		}
		
		return(nodes);
	}
	
	
	public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
	    
		// System.out.println("trace 3");
		TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	    transformer.transform(new DOMSource(doc), 
	         new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}

}
