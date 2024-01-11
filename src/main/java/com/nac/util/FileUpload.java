package com.nac.util;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.nac.model.IIQA.AffiliatingUniversity;
import com.nac.model.IIQA.CollegeProgramBySRA;
import com.nac.repository.AffiliatingUniversityRepo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

@Service
public class FileUpload {
	
	@Autowired
	private AffiliatingUniversityRepo affiliRepo;
	
	@Autowired
	EntityManager entityManager;
	
    @Value("${user.image.upload.path}")
    private String fileUploadPath;
    
    @Value("${application.bucket.name}")
    private String bucketName;
	@Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;
    
    @Autowired
    private AmazonS3 s3Client;
	
//	public String uploadFile(MultipartFile pdfFile) {    
//	    if (!pdfFile.isEmpty()) {           	            
//	            String originalFileName = pdfFile.getOriginalFilename();
//	            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
//	            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;	            
//	    	String key = "Naac/"+ uniqueFileName;
//	    	boolean s3 = uploadToS3(pdfFile,key);
//	    	if(s3==true) {
//	    		 return uniqueFileName;
//	    	}else {
//	    		return "File upload failed!";
//	    	}
//	    } else {
//	        return "File is empty!";
//	    }
//	}
    public String uploadFile(MultipartFile pdfFile) {
        long maxFileSize = 10 * 1024 * 1024; // 5MB in bytes

        if (!pdfFile.isEmpty()) {
            if (pdfFile.getSize() > maxFileSize) {
                return "File size exceeds the maximum allowed (5MB)!";
            }

            String originalFileName = pdfFile.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

            String key = "Naac/" + uniqueFileName;
            boolean s3 = uploadToS3(pdfFile, key);

            if (s3) {
                return uniqueFileName;
            } else {
                return "File upload failed!";
            }
        } else {
            return "File is empty!";
        }
    }

	
	
	public String waitUntilDocumentNameIsSet(Long AffiliatingUniversityId) {
	    int maxAttempts = 10; 
	    int attempts = 0;
	    String documentName = "";
	    while (attempts < maxAttempts) {
	        AffiliatingUniversity univ = affiliRepo.getOne(AffiliatingUniversityId);
	        documentName = univ.getDocumentName();
	        if (documentName != null && !documentName.isEmpty()) {
	            return documentName; 
	        }
	        try {
	            Thread.sleep(1000); 
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	        attempts++;
	    }
	    return documentName;
	}
	

	
	public String waitUntilDocumentNameIsSet(Class<?> entityClass, Long entityId, String documentPropertyName) {
	    int maxAttempts = 5; 
	    int attempts = 0;
	    String documentName = "";
	    while (attempts < maxAttempts) {
	        Object entity = entityManager.find(entityClass, entityId);

	        if (entity != null && Hibernate.isInitialized(entity)) {
	            if (entity instanceof HibernateProxy) {
	               
	                entity = ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
	            }
	            try {	               
	                Field documentField = entity.getClass().getDeclaredField(documentPropertyName);
	                documentField.setAccessible(true);
	                documentName = (String) documentField.get(entity);

	                if (documentName != null && !documentName.isEmpty()) {
	                    return documentName; 
	                }
	            } catch (NoSuchFieldException | IllegalAccessException e) {	                
	                e.printStackTrace(); 
	            }
	        }	       
	        try {
	            Thread.sleep(1000); 
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt(); 	             
	            e.printStackTrace(); 
	        }
	        attempts++;
	    }
	    return documentName;
	}

	
	
	public boolean deleteFile(String imageName) {
		String key = "Naac/"+ imageName;
		if(s3Client.doesObjectExist(bucketName,key)) {
			s3Client.deleteObject(new DeleteObjectRequest(bucketName,key));
		return true;
		}else {
			return false;
		}
    }
	
	public boolean uploadToS3(MultipartFile file,String key) {
		PutObjectRequest putObjectRequest;
		try {
			putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream(),null);
			s3Client.putObject(putObjectRequest);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

    public boolean deleteFileByName(String fileName) {
        try {
            
            System.out.println("Attempting to delete file: " + fileName);

            
            s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));

            
            System.out.println("File deleted successfully: " + fileName);

            
            return true;
        } catch (AmazonServiceException e) {
            
            System.err.println("AmazonServiceException during file deletion:");
            e.printStackTrace();
        } catch (SdkClientException e) {
            
            System.err.println("SdkClientException during file deletion:");
            e.printStackTrace();
        }

        // Return false if deletion failed
        return false;
    }

}
