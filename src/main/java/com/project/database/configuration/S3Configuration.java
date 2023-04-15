package com.project.database.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
@PropertySource(value = {"classpath:s3.properties"})
public class S3Configuration {
    @Autowired
    Environment env;

    @Bean
    public AmazonS3Client amazonS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(env.getProperty("amazon.aws.accesskey"), env.getProperty("amazon.aws.secretkey"));
        AmazonS3Client amazonS3Client = new AmazonS3Client(credentials);
        amazonS3Client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        return amazonS3Client;
    }
}
