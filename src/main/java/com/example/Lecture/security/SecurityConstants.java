package com.example.Lecture.security;

public class SecurityConstants {
    public static final String AUTH_LOGIN_URL = "/api/authenticate";
    // https://www.allkeysgenerator.com/
    public static final String JWT_SECRET =
            "@NcRfUjXnZr4u7x!A%D*G-KaPdSgVkYp3s5v8y/B?E(H+MbQeThWmZq4t7w9z$C&";
    // JWT 기본 토큰
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
}
