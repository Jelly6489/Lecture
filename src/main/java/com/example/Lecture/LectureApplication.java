package com.example.Lecture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication // SpringApplication을 사용하면 붙여주어야 함.
public class LectureApplication {
	final static Logger log =
			LoggerFactory.getLogger(LectureApplication.class);
	// SpringApplication.run 하면
	// 웹 서버가 구동된다 - 서비스 번호: 8080
	public static void main(String[] args) {
//		HelloSpring hs = new HelloSpring();
//		log.info(hs.print());
//
		SpringApplication.run(LectureApplication.class, args);
	}
}
