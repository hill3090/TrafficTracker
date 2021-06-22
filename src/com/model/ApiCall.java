package com.model;

import java.io.IOException;

public class ApiCall {

    private int[] speedsI76;
    private int[] speedsI476;
    private String ApiKey;
    private MapPoint I76S;
    private MapPoint I76N;
    private MapPoint I476S;
    private MapPoint I476N;

    public ApiCall() throws IOException {

        ApiKey = "HTGYp7HzAvMfLShlIE1msI53xZmARHgz";
        speedsI76 = new int[5];
        speedsI476 = new int[8];
        I76S = new MapPoint("D:\\Java\\TrafficTracker\\src\\data\\southbound76.csv");
        I76N = new MapPoint("D:\\Java\\TrafficTracker\\src\\data\\northbound76.csv");

    }

    public void getNewCall()    {
        System.out.println(I76S.getLatitude());
        System.out.println(I76S.getLongitude());
    }
}
