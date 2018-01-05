package com.dsib.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteFileToFile {
	public void write(String msg) {
		write(msg,"");
	}

	public void write(String msg, String fileName) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		String name = fileName +"-"+ format.format(date);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		String fold = format1.format(date);
		File file = new File("D:\\messageOfPolicy\\" + fold);
		File file1 = new File("D:\\messageOfPolicy\\" + fold + "\\" + name + ".txt");
		if (!file.exists()) {
			file.mkdirs();
			file.setWritable(true);
		}
		if (!file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(file1);
			pw.print(msg);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	public void write(String msg, String fileName,String foldName) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		String name = fileName +"-"+ format.format(date);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		String fold = format1.format(date);
		File file = new File("D:\\"+foldName+"\\" + fold);
		File file1 = new File("D:\\"+foldName+"\\" + fold + "\\" + name + ".txt");
		if (!file.exists()) {
			file.mkdirs();
			file.setWritable(true);
		}
		if (!file1.exists()) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		PrintWriter pw;
		try {
			pw = new PrintWriter(file1);
			pw.print(msg);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
