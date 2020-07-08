package com.example;

import com.example.domain.ListEntity;
import com.example.domain.IssueEntity;
import com.example.da.ListRepository;
import com.example.da.IssueRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ListRepository lists = context.getBean(ListRepository.class);
        IssueRepository issues = context.getBean(IssueRepository.class);
    }

}
