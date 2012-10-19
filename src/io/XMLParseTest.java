package io;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLParseTest {

	
	public static void main(String[] args) {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			
			//parse a xml file 
			File file=new File("E:/temporary/web.xml");
			Document document=builder.parse(file);
			
			//get the root element
			Element root=document.getDocumentElement();
			//get children
			NodeList children=root.getChildNodes();
			
			//get every child
			for(int i=0;i<children.getLength();i++){
				Node child=children.item(i);
				//only print dom element,except for text
				if(child instanceof Element){
					System.out.println(child.getNodeName()+":"
							+child.getFirstChild().getNodeValue());
				}
			}
			
			
			NamedNodeMap attributes=root.getAttributes();
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
