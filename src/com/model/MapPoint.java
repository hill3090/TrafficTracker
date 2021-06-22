package com.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapPoint {

    private List<String> latitude = new ArrayList<String>();
    private List<String> longitude = new ArrayList<String>();

    private String filePath;

    public MapPoint(String filePath) throws IOException {
        this.filePath = filePath;
        readData();
    }

    public void readData() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                latitude.add(values[0]);
                longitude.add(values[1]);
            }
        }
    }

    public List<String> getLatitude()   {
        return latitude;
    }
    public List<String> getLongitude()  {
        return longitude;
    }
}
