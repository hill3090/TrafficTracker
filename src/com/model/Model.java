package com.model;

import org.json.JSONException;

import java.io.IOException;

public class Model {

    private ApiCall caller;

    public Model() throws IOException, JSONException {
        caller = new ApiCall();
        updateTraffic();
    }

    public void updateTraffic() throws IOException, JSONException {
        caller.getNewCall();
        System.out.println("I76 North Bound: " + caller.getI76NAvg());
        System.out.println("I76 South Bound: " + caller.getI76SAvg());
        System.out.println("I476 South Bound: " + caller.getI476SAvg());
        System.out.println("I476 South Bound: " + caller.getI476NAvg());
        // view.updateView(caller.getI76SAvg(), caller.getI76NAvg());
    }
}
