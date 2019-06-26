package belegGPU;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class LoadShader {
	private LoadShader() {
	}
	
	public static String load(String src) {
		File f = new File(src);
		FileInputStream fis;
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		int len; //number of read bytes
		byte[] buf = new byte[1024];
		try {
			fis = new FileInputStream(f);
			while ((len = fis.read(buf)) > -1) {
				bas.write(buf, 0, len);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		String code = new String(bas.toByteArray());
		System.out.println(code);
		return code;
	}
}
