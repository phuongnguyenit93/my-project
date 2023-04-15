package com.project.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

@Service
public class S3Service {
    @Autowired
    AmazonS3Client amazonS3Client;

    public List<Bucket> getBucketList() {
        return amazonS3Client.listBuckets();
    }

    public void createBucket(String bucketName) {
        amazonS3Client.createBucket(bucketName);
    }

    public boolean checkBucketExist(String bucketName) {
        return amazonS3Client.doesBucketExist(bucketName);
    }

    public void deleteBucket(String bucketName) {
        amazonS3Client.deleteBucket(bucketName);
    }
}
