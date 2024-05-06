package com.follygbossou.booksocial.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum BusinessErrorCodes {

    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "NO CODE"),

    INCORRECT_CURRENT_PASSWORD(300, HttpStatus.BAD_REQUEST, "CURRENT PASSWORD IS INCORRECT"),

    NEW_PASSWORD_DOES_NOT_MATCH(301, HttpStatus.BAD_REQUEST, "THE NEW PASSWORD DOES NOT MATCH"),

    ACCOUNT_LOCKED(302, HttpStatus.FORBIDDEN, "USER ACCOUNT IS LOCKED"),

    ACCOUNT_DISABLED(303, HttpStatus.FORBIDDEN, "USER ACCOUNT IS DISABLED"),

    BAD_CREDENTIALS(304, HttpStatus.FORBIDDEN, "LOGIN AND / OR PASSWORD IS INCORRECT")
    ;

    @Getter
    private final int code;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String description;


    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
