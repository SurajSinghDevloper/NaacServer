package com.nac.contollerRestful;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nac.dtos.TemplateDto;
import com.nac.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@CrossOrigin
@RequestMapping("/files")
public class FileController {
	
	@Value("${user.image.upload.path}")
	private String imageUploadPath;
	
	@Autowired
	private FileUpload fileUpload;

	@GetMapping("view/{imageName:.+}")
	public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
		try {
			// Construct the full path to the image file
			Path imagePath = Paths.get(imageUploadPath).resolve(imageName);
			Resource resource = new UrlResource(imagePath.toUri());

			// Check if the image file exists
			if (resource.exists() && resource.isReadable()) {
				// Set appropriate headers for the image response
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_PDF); // Adjust MediaType as needed

				// Return the image as a ResponseEntity
				return ResponseEntity.ok().headers(headers).body(resource);
			} else {
				// Return a 404 Not Found response if the image does not exist
				return ResponseEntity.notFound().build();
			}
		} catch (IOException e) {
			// Handle exceptions appropriately (e.g., log the error)
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/dataTemplate/upload")
	public ResponseEntity<String>saveDataTemplate(@ModelAttribute TemplateDto dto) {
		String key = "Naac/Template/"+dto.getFileName();
		boolean s3 = fileUpload.uploadToS3(dto.getFile(),key);
		if(s3==true) {
			return new ResponseEntity<>("File Uploaded",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("File Not Uploaded",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
