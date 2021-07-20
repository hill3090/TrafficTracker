package com.model;

import com.view.View;
import org.json.JSONException;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Model {

    private ApiCall caller;
    private View view;
    private DefaultTableModel model;

    public Model() throws IOException, JSONException {
        caller = new ApiCall();
    }

    public void registerView(View v) throws JSONException, IOException {
        this.view = v;
        model = (DefaultTableModel) view.getTable().getModel();
        model.addColumn("Time");
        model.addColumn("Street Name");
        model.addColumn("Direction");
        model.addColumn("Speed");
        model.fireTableDataChanged();
        view.updateView(model);
        updateTraffic();
    }

    public void updateTraffic() throws JSONException, IOException {
        caller.getNewCall();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());
        model.insertRow(0, new Object[]{date, "I-76", "North", caller.getI76NAvg()});
        model.insertRow(1, new Object[]{date, "I-76", "South", caller.getI76SAvg()});
        model.insertRow(2, new Object[]{date, "I-476", "North", caller.getI476NAvg()});
        model.insertRow(3, new Object[]{date, "I-476", "South", caller.getI476SAvg()});
        model.fireTableDataChanged();
        caller.setI76NTotal(0);
        caller.setI76STotal(0);
        caller.setI476NTotal(0);
        caller.setI476STotal(0);
        view.updateView(model);
    }
}
    /*public void reset() {
        model.insertRow(0, new Object[]{"", "", "", ""});
        model.insertRow(1, new Object[]{"", "", "", ""});
        model.insertRow(2, new Object[]{"", "", "", ""});
        model.insertRow(3, new Object[]{"", "", "", ""});
        model.fireTableDataChanged();
        view.updateView(model);
    }*/



    /*public void updateTraffic() throws IOException, JSONException {
        //caller.getNewCall();
        //view.updateView(caller.getI76SAvg(), caller.getI76NAvg(), caller.getI476SAvg(), caller.getI476NAvg());


        // Test print statements
        /*System.out.println("I76 North Bound: " + caller.getI76NAvg());
        System.out.println("I76 South Bound: " + caller.getI76SAvg());
        System.out.println("I476 South Bound: " + caller.getI476SAvg());
        System.out.println("I476 South Bound: " + caller.getI476NAvg());
    }*/
