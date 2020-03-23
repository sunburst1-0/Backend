package com.data.model;

public class DecodedSignal {

  private String signalValue;

  public DecodedSignal() {}

  public DecodedSignal(String signal) {
    this.signalValue = signal;
  }

  public String getSignalValue() {
    return signalValue;
  }

  public void setSignalValue(String signal) {
    this.signalValue = signal;
  }

  @Override
  public String toString() {
    return "Bar [signalValue=" + signalValue + "]";
  }
}
