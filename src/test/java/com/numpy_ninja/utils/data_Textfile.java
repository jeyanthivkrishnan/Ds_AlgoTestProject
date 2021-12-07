package com.numpy_ninja.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class data_Textfile {

		
		public static String readFile(String filename) throws IOException
		{

			String content = null;
			File file = new File(filename);
			FileReader reader = null;
			try {
				reader = new FileReader(file);
				char[] chars = new char[(int) file.length()];
				reader.read(chars);
				content = new String(chars);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
			return content;
		}



}
