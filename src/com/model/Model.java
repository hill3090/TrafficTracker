package com.model;

import com.view.View;
import org.json.JSONException;

import java.io.IOException;

public class Model {

    private ApiCall caller;
    private View view;

    public Model() throws IOException, JSONException {
        caller = new ApiCall();
    }

    public void registerView(View v) {
        this.view = v;
    }


    public void updateTraffic() throws IOException, JSONException {
        caller.getNewCall();
        view.updateView(caller.getI76SAvg(), caller.getI76NAvg(), caller.getI476SAvg(), caller.getI476NAvg());


        // Test print statements
        /*System.out.println("I76 North Bound: " + caller.getI76NAvg());
        System.out.println("I76 South Bound: " + caller.getI76SAvg());
        System.out.println("I476 South Bound: " + caller.getI476SAvg());
        System.out.println("I476 South Bound: " + caller.getI476NAvg());*/
    }
}
