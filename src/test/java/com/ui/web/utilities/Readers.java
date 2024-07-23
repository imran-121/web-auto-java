package com.ui.web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.cucumber.datatable.DataTable;

//import com.api.utils.PropertiesFile;



//import com.api.utils.PropertiesFile;

public class Readers {
	
	public static class PropertiesFile {
		
		private static final Logger LOG = LogManager.getLogger(PropertiesFile.class);
		private static FileInputStream fis;
		private static Properties prop = null;

		public static String getProperty(String property) {		

			try {
				fis = new FileInputStream(new File("src\\test\\resources\\config\\config.properties"));
				prop = new Properties();
				prop.load(fis);
			} catch(FileNotFoundException fnfe) {
				LOG.error("Properties File Not Found", fnfe);
			} catch(IOException ioe) {
				LOG.error("IO Exception while loading Properties File", ioe);
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					LOG.error("IO Exception while closing file input stream", e);
				}
			}
			return prop.getProperty(property).trim();
		}
	}
	
	public static class JsonReader {
		
		private static String dataPath = new File(PropertiesFile.getProperty("test.data.path")).getAbsolutePath()+File.separator;
		private static JSONParser parser = new JSONParser();
		private static Object body;
		
		public static String readJsonData(String jsonFileName, String jsonKey) {
			
			try {
				body = ((JSONObject)parser.parse(new FileReader(dataPath+jsonFileName))).get(jsonKey);
				if (body == null) {
					throw new RuntimeException("NO DATA FOUND in JSON file '" + jsonFileName +"' for key '"+jsonKey+"'");
				}
			} catch (FileNotFoundException e) {
				throw new RuntimeException("JSON file not found at path: " + dataPath+jsonFileName);
			} catch (IOException e) {
				throw new RuntimeException("IOException while reading file: " + jsonFileName);
			} catch (ParseException e) {
				throw new RuntimeException("Parse Exception occured while Parsing: " + jsonFileName);
			}
			return body.toString();
		}

	}
	
	public static class DataTableReader {
		
		
		public static List<Map<String, String>> lstOfMap;
		

		public static void readDataTableToLstMap(DataTable dataTable) {
			lstOfMap = new ArrayList<>();
			lstOfMap = dataTable.asMaps(String.class, String.class);
		}
		
		public static String getFirstRowDataTable(String key) {
			if(lstOfMap.size()==1) {
				return lstOfMap.get(0).get(key);
			}else {
				return "";
			}
			
		}

	}
	
		

}
