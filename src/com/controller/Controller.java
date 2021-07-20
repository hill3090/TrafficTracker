package com.controller;

import com.model.Model;
import org.json.JSONException;

import java.io.IOException;

public class Controller {

    private Model model;

    public void setModel(Model model)   {
        this.model = model;
    }

    public void updateModel() throws JSONException, IOException {
        model.updateTraffic();
    }
}