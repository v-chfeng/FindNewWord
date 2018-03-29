package com.company.common;

import java.io.*;

/**
 * TextDatReader.java 2013-9-9 16:47:09
 * 
 * @Author George Bourne
 */
public class TextDatReader {
	public static String read(String path) throws IOException {
		/*
		File file = new File(path);
		FileReader reader = new FileReader(file);
		byte buffer[] = new byte[][(int) file.length()];
		reader.read(buffer);
		return new String(buffer, );*/
		/*
		String FileContent = "";
		FileInputStream fs = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fs, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while((line = br.readLine())!=null){
			FileContent += line;
			FileContent += "\r\n";
		}

		return FileContent;
		*/

		// read content once.
		String encoding = "UTF-8";
		File file = new File(path);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try{
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		try{
			return new String(filecontent, encoding);
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}

		return "";
	}
}
