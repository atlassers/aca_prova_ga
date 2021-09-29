package it.euris.teslabattery_ag.exception;

public class IdMustNotBeNullException extends RuntimeException {
  
  private static final long serialVersionUID = 11547588023389561L;

  public IdMustNotBeNullException() {
    super("Id must not be null. You sent a dto with no id");
  }
  public IdMustNotBeNullException(String message) {
    super(message);
  }
}
