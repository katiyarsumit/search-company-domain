package com.example.demo.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.service.CompanyDomain;

@Service
public class CompanyDomainImpl implements CompanyDomain {
	String encoding = "UTF-8";
	//public static String filePath = "E://spring boot learning/demo/src/main/resources/static/";
	static String userPath=System.getProperty("user.dir");
	static String replaceString=userPath.replace('\\','/');
	static String replaceString1=replaceString.replaceFirst("/","//");
	public static String filePath=replaceString1+"/src/main/resources/static/";
	 public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	
	public String convertFile(MultipartFile file) {
		String downloadUrl="";
		try {
			Path fileName = convertMultiPartToFileAndSave1(file);
			downloadUrl=fileName.toString();
			String domainName;
			FileInputStream fis = new FileInputStream(new File(fileName.toString()));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook (fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> ite = sheet.rowIterator();
			while(ite.hasNext()){
				Row row = (Row) ite.next();
				Cell c = row.getCell(0);
				String searchText =c.toString();
				Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText, encoding)).get();
				Elements webSitesLinks = google.getElementsByTag("cite");					
				if (webSitesLinks.isEmpty()) {
					domainName="######## no result found for ##### ";
					
				}else {
					domainName = webSitesLinks.get(0).text();
				}
				
				Cell c1=row.createCell(1);
				c1.setCellValue(domainName);
				fis.close();
				FileOutputStream fos =new FileOutputStream(new File(fileName.toString()));
				workbook.write(fos);
		        fos.close();
			}
			System.out.println("successfully executed");
			System.out.println("uploadDirectory file path : "+uploadDirectory);
			System.out.println("dynamic file path : "+fileName);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return downloadUrl;
	}
	
	static Path convertMultiPartToFileAndSave1(MultipartFile file) throws IOException {
		StringBuilder fileNames = new StringBuilder();
		 File directory = new File("uploads");
		 if(!directory.exists()) {
			 directory.mkdir();
			 System.out.println(directory);
		 }
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileNameAndPath;
	}
	
	static String convertMultiPartToFileAndSave(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		FileOutputStream fos = new FileOutputStream(filePath + fileName);
		fos.write(file.getBytes());
		fos.close();
		return fileName;
	}
}
