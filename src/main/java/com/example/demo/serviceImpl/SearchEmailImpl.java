package com.example.demo.serviceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.SearchEmail;

@Service
public class SearchEmailImpl implements SearchEmail{
	public static String filePath = "E://spring boot learning/demo/src/main/resources/static/";

	@Override
	public String searchEmail(MultipartFile file) {

		String line = null;
		String downloadUrl="";
		String encoding = "UTF-8";
		try {
			String fileName = CompanyDomainImpl.convertMultiPartToFileAndSave(file);
			FileReader fr = new FileReader(filePath + fileName);
			
			FileWriter fw = new FileWriter(filePath + "complete"+fileName);
			downloadUrl="complete"+fileName;
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				String searchText = line;
				Document google = Jsoup
						.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText, encoding)).get();
				
				Element name = google.getElementById("cphContent_WizardDirectory_FullNameLabel");
				Element address1 = google.getElementById("cphContent_WizardDirectory_AddressLabel");
				Element address2 = google.getElementById("cphContent_WizardDirectory_AddressCSZLabel");
				Element email = google.getElementById("cphContent_WizardDirectory_hlEmailAddress");
				Element phone = google.getElementById("cphContent_WizardDirectory_PhoneLabel");
				if (name==null) {
					fw.write("#############");
					fw.flush();
					fw.write(" ");
				}else {
					String userName = name.text();
					fw.write(userName);
					fw.flush();
					fw.write(" ");
				}
				
				if (email==null) {
					fw.write("#############");
					fw.flush();
					fw.write(" ");
				}else {
					String useremail = email.text();
					fw.write(useremail);
					fw.flush();
					fw.write(" ");
				}
				
				if (phone==null) {
					fw.write("#############");
					fw.flush();
					fw.write(" ");
				}else {
					String userphone = phone.text();
					fw.write(userphone);
					fw.flush();
					fw.write(" ");
				}
				
				if (address1==null) {
					fw.write("#############");
					fw.flush();
					fw.write(" ");
				}else {
					String useraddress1 = address1.text();
					fw.write(useraddress1);
					fw.flush();
					fw.write(" ");
				}
				if (address2==null) {
					fw.write("#############");
					fw.flush();
					fw.write("\r\n");
				}else {
					String useraddress2 = address2.text();
					fw.write(useraddress2);
					fw.flush();
					fw.write("\r\n");
				}
			}
			
			br.close();
			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return downloadUrl;
	
	}

}
