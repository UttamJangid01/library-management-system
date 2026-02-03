package com.dto;

public class BookReturn {
  private String message;
  private double fine;

  public BookReturn(String message, double fine) {
    this.message = message;
    this.fine = fine;
  }

  public String getMessage() {
    return message;
  }

  public double getFine() {
    return fine;
  }

  @Override
  public String toString() {
    return "BookReturn [message=" + message + ", fine=" + fine + "]";
  }
}
