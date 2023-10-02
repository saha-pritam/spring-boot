package org.pritam.springbootdemo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MyControllerThree {
	@PostMapping("/uploadImage")
	public ResponseEntity<Object> uploadImage(@RequestParam("imageFile") MultipartFile file){
		try {
			byte[] bytes = file.getBytes();
			String absolutePath = new ClassPathResource("").getFile().getAbsolutePath() + "\\uploadedImages";
			File f = new File(absolutePath);
			if(!f.exists())
				f.mkdir();
			FileOutputStream fos = new FileOutputStream(absolutePath+"\\"+file.getOriginalFilename());
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Image Upload Successful",HttpStatus.OK);
	}
}
