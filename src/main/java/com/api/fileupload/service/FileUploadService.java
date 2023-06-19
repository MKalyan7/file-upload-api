package com.api.fileupload.service;

import com.api.fileupload.model.FileUpload;
import com.api.fileupload.repository.FileUploadRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    public void uploadDocument(String documentName, MultipartFile document) throws IOException {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setDocumentName(documentName);
        fileUpload.setDocument(new Binary(BsonBinarySubType.BINARY,document.getBytes()));
        fileUpload.setUploadUser("Admin");
        fileUpload.setUploadDate(LocalDateTime.now());
        fileUploadRepository.insert(fileUpload);
    }

    public FileUpload getUploadedDocument(String id) {
        return fileUploadRepository.findById(id).get();
    }
}
