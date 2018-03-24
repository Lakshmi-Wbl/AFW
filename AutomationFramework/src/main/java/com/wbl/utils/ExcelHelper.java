package com.wbl.utils;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	
	static Logger log= LogManager.getLogger(ExcelHelper.class);
	
	public static Object[][] getExcelData(String fileName, String sheetName){
		
		log.info("In excel reader utility");
		Object[][] data =null;
		XSSFWorkbook wb=null;
		try{
			wb=new XSSFWorkbook(Constants.RESOURCES_PATH + "/test-data/" + fileName);
			XSSFSheet sheet=wb.getSheet(sheetName);
			int rowsIndex=sheet.getLastRowNum();
			//System.out.println("total rows:" + rowsIndex);
			log.info("total rows:" + rowsIndex);
			data=new Object[rowsIndex][];
			
			for(int i=1;i<=rowsIndex;i++){
				XSSFRow row=sheet.getRow(i);
				int cols=row.getLastCellNum();
				//System.out.println("total cols:"+ cols);
				log.info("total cols:"+ cols);
				Object[] colData =new Object[cols];
				for(int j=0;j<cols;j++)
				{
					colData[j]=row.getCell(j).toString();
				}
				data[i-1]=colData;
			}
		}catch(IOException e){
			//System.out.println("ExcelHelper Exception:"+ e);
			log.error("ExcelHelper Exception:"+ e);
		}finally{
			try{
				wb.close();
			}catch(IOException e){
				//System.out.println(e);
				log.error(e);
				}
			}
		return data;
		}
	}


