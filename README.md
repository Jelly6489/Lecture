# Lecture
1. 개발환경 및 제작도구 
Linux - Ubuntu 18.04
Java - java 12
Mysql - Mysql 5.7.31
Vue-CLI - vue/cli 4.4.6
Spring Boot - 2.3.3.RELEASE
JPA - hibernate-core 5.4.17.Final, hibernate-validator 6.0.7.Final
Gradle - Spring Boot DevTools, Lombok, Spring Configuration Processor, Spring Web,
Thymeleaf, MySQL Driver

2. 상세 기능
Main Home, 회원가입, 로그인, 게시판, 페이지네이션, 뉴스 크롤링

3. DB 환경설정
config - DBConfig에서 본인 DB에 맞게 설정

4. Npm 구동
npm install
./frontend에서 npm run serve

# build.gradle 파일에 추가한 내용

# plugins {
#     id 'org.springframework.boot' version '2.2.1.RELEASE'
#     id 'io.spring.dependency-management' version '1.0.9.RELEASE'
#     id 'java'
# }

# configurations {
#     compileOnly {
#         extendsFrom annotationProcessor
#     }
# }

# dependencies {
#     implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
#     implementation 'org.springframework.boot:spring-boot-starter-web'
#     compileOnly 'org.projectlombok:lombok'
#     annotationProcessor 'org.projectlombok:lombok'
#     compile group: 'commons-io', name: 'commons-io', version: '2.6'
#     compile 'org.springframework:spring-orm'
#     compile 'org.apache.httpcomponents:httpclient:4.5.12'
#     testCompile group: 'junit', name: 'junit', version: '4.12'
# }
