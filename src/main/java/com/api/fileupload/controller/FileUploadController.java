package com.api.fileupload.controller;

import com.api.fileupload.model.FileUpload;
import com.api.fileupload.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file-upload/apis")
@RequiredArgsConstructor
public class FileUploadController {

   @Autowired
   FileUploadService fileUploadService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadDocument(@RequestParam("documentName") String documentName, @RequestParam("document")MultipartFile document ) throws IOException {
        fileUploadService.uploadDocument(documentName,document);
    }

    @GetMapping("/fetch-document/{id}")
    public FileUpload getPhoto(@PathVariable String id) {
        FileUpload fileUpload = fileUploadService.getUploadedDocument(id);
        return fileUpload;
    }

}
