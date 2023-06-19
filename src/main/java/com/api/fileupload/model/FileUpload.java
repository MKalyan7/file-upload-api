package com.api.fileupload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "file-upload")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUpload {
    @Id
    private String documentID;
    private String documentName;
    private Binary document;
    private String uploadUser;
    private LocalDateTime uploadDate;
}