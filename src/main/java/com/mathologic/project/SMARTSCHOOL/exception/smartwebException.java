package com.mathologic.project.SMARTSCHOOL.exception;

import java.io.Serializable;

public class smartwebException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public smartwebException(String s) {
        super(s);
    }

    public smartwebException(Exception e) {
        super(e);
    }
}