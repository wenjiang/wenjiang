package org.zww.contentcopy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ContentCopyDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader src = new BufferedReader(new FileReader("in.txt"));
		//BufferedWriter dst = new BufferedWriter(new FileWriter("out.txt"));
		BufferedWriter dst = new BufferedWriter(new OutputStreamWriter(System.out));
		ContentCopyUtil.copy(src, dst);
	}
}

class ContentCopyUtil {
	public static void copy(BufferedReader src, BufferedWriter dst) throws IOException {
		String line = null;
		while((line = src.readLine()) != null) {
			dst.write(line);
			dst.newLine();
		}
		src.close();
		dst.close();
	}
}

