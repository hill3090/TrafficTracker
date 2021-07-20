package com.adapter;

import com.controller.Controller;
import com.view.View;
import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*
    Decouples the view from the controller. When action happens, it moves from view to adapter to controller to model.
    Model then updates view.
 */

public class Adapter implements ActionListener {

    private Controller c;
    private View v;
    private int x;
    private int y;

    public Adapter(Controller c, View v)    {
        this.c = c;
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            c.updateModel();
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
