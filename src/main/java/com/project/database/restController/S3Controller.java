package com.project.database.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;
import com.project.database.service.S3Service;

@RestController
@RequestMapping("s3")
public class S3Controller {

    @Autowired
    S3Service s3Service;

    @GetMapping("/bucket")
    public ResponseEntity<List<Bucket>> getBucketList() {
        List<Bucket> result = s3Service.getBucketList();
        if (result.size() != 0) {
            return new ResponseEntity<List<Bucket>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("bucket/{bucketName}")
    public ResponseEntity<String> createBucket(@PathVariable(required = true) String bucketName) {
        try {
            if (s3Service.checkBucketExist(bucketName)) {
                return new ResponseEntity<>("Already have bucket", HttpStatus.BAD_REQUEST);
            } else {
                s3Service.createBucket(bucketName);
                return new ResponseEntity<>("Success", HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("bucket/{bucketName}")
    public ResponseEntity<String> deleteBucket(@PathVariable(required = true) String bucketName) {
        try {
            if (s3Service.checkBucketExist(bucketName)) {
                s3Service.deleteBucket(bucketName);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("No bucket found to Delete", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
