package com.heigo.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyUploadUtils {

	public static List<String> upload_img_name(MultipartFile[] file) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < file.length; i++) {

			String img_name = System.currentTimeMillis() + file[i].getOriginalFilename();

			try {
				file[i].transferTo(new File(MyPropertiesUtils.getProperty("imgPath_windows") + "/" + img_name));
				list.add(img_name);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
