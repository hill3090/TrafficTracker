package com.view;

import com.adapter.Adapter;
import com.controller.Controller;
import sun.security.pkcs11.wrapper.Constants;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View {

    private Controller controller;
    private JFrame gui;
    private JButton refresh;
    private JLabel status;
    private String[][] trafficData;
    private JTable trafficTable;
    private JScrollPane tableContainer;
    private JPanel panel;
    private Adapter adapter;

    public View()   {
        gui = new JFrame("Traffic Data");
        initialize();
    }

    public void initialize() {
        gui.setSize(800, 800);
        gui.setTitle("Traffic Data");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        trafficTable = new JTable();
        tableContainer = new JScrollPane(trafficTable);
        refresh = new JButton("Refresh");
        panel.add(tableContainer, BorderLayout.CENTER);
        panel.add(refresh, BorderLayout.SOUTH);
        gui.getContentPane().add(panel);

        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
    }

    public void updateView(DefaultTableModel model)    {
        trafficTable.setModel(model);
        trafficTable.repaint();
        gui.pack();
    }

    public JTable getTable()    {
        return trafficTable;
    }

    public void setActionListener(Controller c) {
        this.adapter = new Adapter(c, this);
        refresh.addActionListener(adapter);
    }
}
