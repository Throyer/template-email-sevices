package com.github.throyer.sender.shared.exceptions;

public class UnretryableFailureException extends RuntimeException {
  public UnretryableFailureException(String message) {
    super(message);
  }

  public UnretryableFailureException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnretryableFailureException(Throwable cause) {
    super(cause);
  }

  public UnretryableFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

