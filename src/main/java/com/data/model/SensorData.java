package com.data.model;

public class SensorData {

  private String data;

  public SensorData() {}

  public SensorData(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "SensorData [data=" + data + "]";
  }
}
