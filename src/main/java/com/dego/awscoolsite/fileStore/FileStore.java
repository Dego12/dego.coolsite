package com.dego.awscoolsite.fileStore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

public class FileStore {

    private final AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3)
    {
        this.s3 = s3;
    }

    public void save(String path, String fileName, Optional<Map<String, String>> metadata, InputStream inputStream){
        ObjectMetadata meta = new ObjectMetadata();

        metadata.ifPresent(map ->{
            if (!map.isEmpty()) {
                map.forEach(meta::addUserMetadata);
            }
        });

        try {
            s3.putObject(path, fileName, inputStream, meta);
        } catch (AmazonServiceException e){
            throw new IllegalArgumentException("Failed to store file", e);
        }
    }
}
