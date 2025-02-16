package com.follygbossou.booksocial.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BusinessErrorCodes {

    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "NO CODE"),

    INCORRECT_CURRENT_PASSWORD(300, HttpStatus.BAD_REQUEST, "CURRENT PASSWORD IS INCORRECT"),

    NEW_PASSWORD_DOES_NOT_MATCH(301, HttpStatus.BAD_REQUEST, "THE NEW PASSWORD DOES NOT MATCH"),

    ACCOUNT_LOCKED(302, HttpStatus.FORBIDDEN, "USER ACCOUNT IS LOCKED"),

    ACCOUNT_DISABLED(303, HttpStatus.FORBIDDEN, "User account is disabled"),

    BAD_CREDENTIALS(304, HttpStatus.FORBIDDEN, "Login and / or password is incorrect")
    ;

    private final int code;
    private final HttpStatus httpStatus;
    private final String description;


    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
