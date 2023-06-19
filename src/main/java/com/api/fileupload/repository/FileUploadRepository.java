package com.api.fileupload.repository;

import com.api.fileupload.model.FileUpload;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileUploadRepository extends MongoRepository<FileUpload,String> {
}
