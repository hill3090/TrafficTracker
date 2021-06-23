package com.model;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiCall {

    private int I76STotal;
    private int I76NTotal;
    private int I76SAvg;
    private int I76NAvg;
    private int I476STotal;
    private int I476NTotal;
    private int I476SAvg;
    private int I476NAvg;
    private String ApiKey;
    private MapPoint I76S;
    private MapPoint I76N;
    private MapPoint I476S;
    private MapPoint I476N;

    public ApiCall() throws IOException {

        ApiKey = "HTGYp7HzAvMfLShlIE1msI53xZmARHgz";
        I76STotal = 0;
        I76NTotal = 0;
        I76S = new MapPoint("D:\\Java\\TrafficTracker\\src\\data\\southbound76.csv");
        I76N = new MapPoint("D:\\Java\\TrafficTracker\\src\\data\\northbound76.csv");
        I476N = new MapPoint("D:\\Java\\TrafficTracker\\src\\data\\I476N.csv");
        I476S = new MapPoint("D:\\Java\\TrafficTracker\\src\\data\\I476S.csv");

    }

    public void getNewCall() throws IOException, JSONException {
        int index = 0;
        URL baseUrl = new URL("https://api.tomtom.com/traffic/services/4/flowSegmentData/absolute/10/json?key=HTGYp7HzAvMfLShlIE1msI53xZmARHgz&point=");

        // Loop for I-76 South bound
        while (index < I76S.getLatitude().size()) {
            URL url = new URL(baseUrl + I76S.getLatitude().get(index) + "," + I76S.getLongitude().get(index) + "&unit=mph");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                String jsonString = inline; //assign your JSON String here
                JSONObject obj = new JSONObject(jsonString);
                int currentSpeed = obj.getJSONObject("flowSegmentData").getInt("currentSpeed");
                I76STotal += currentSpeed;

            }
            index++;
        }
        I76SAvg = I76STotal / I76S.getLatitude().size();
        // Loop for I-76 North bound
        index = 0;
        while (index < I76N.getLatitude().size()) {
            URL url = new URL(baseUrl + I76N.getLatitude().get(index) + "," + I76N.getLongitude().get(index) + "&unit=mph");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                String jsonString = inline; //assign your JSON String here
                JSONObject obj = new JSONObject(jsonString);
                int currentSpeed = obj.getJSONObject("flowSegmentData").getInt("currentSpeed");
                I76NTotal += currentSpeed;

            }
            index++;
        }
        I76NAvg = I76NTotal / I76N.getLatitude().size();

        // Loop for I-476 North bound
        index = 0;
        while (index < I476N.getLatitude().size()) {
            URL url = new URL(baseUrl + I476N.getLatitude().get(index) + "," + I476N.getLongitude().get(index) + "&unit=mph");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                String jsonString = inline; //assign your JSON String here
                JSONObject obj = new JSONObject(jsonString);
                int currentSpeed = obj.getJSONObject("flowSegmentData").getInt("currentSpeed");
                I476NTotal += currentSpeed;

            }
            index++;
        }
        I476NAvg = I476NTotal / I476N.getLatitude().size();

        // Loop for I-476 North bound
        index = 0;
        while (index < I476S.getLatitude().size()) {
            URL url = new URL(baseUrl + I476S.getLatitude().get(index) + "," + I476S.getLongitude().get(index) + "&unit=mph");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int responsecode = con.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                String jsonString = inline; //assign your JSON String here
                JSONObject obj = new JSONObject(jsonString);
                int currentSpeed = obj.getJSONObject("flowSegmentData").getInt("currentSpeed");
                I476STotal += currentSpeed;

            }
            index++;
        }
        I476SAvg = I476STotal / I476S.getLatitude().size();
    }

    public double getI76NAvg()  {
        return I76NAvg;
    }

    public double getI76SAvg()  {
        return I76SAvg;
    }

    public double getI476NAvg()  {
        return I76NAvg;
    }

    public double getI476SAvg()  {
        return I76SAvg;
    }

}

