package com.follygbossou.booksocial.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationNotPermittedException extends RuntimeException {

    public OperationNotPermittedException(String msg) {
        super(msg);
    }
}
