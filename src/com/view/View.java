package com.view;

import sun.security.pkcs11.wrapper.Constants;

import javax.swing.*;

public class View {

    // private Controller controller;
    private JFrame gui;
    private JButton begin;
    private JLabel status;
    private String[][] trafficData;
    private JTable trafficTable;
    // private Adapter adapter;

    public View()   {
        gui = new JFrame("Traffic Data");
        trafficTable = new JTable();
        initialize();
    }

    public void initialize() {
        gui.setSize(800, 800);
        gui.setTitle("Traffic Data");
        gui.setResizable(false);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        String[] columnNames = {"Road", "Direction", "Current Speed"};

    }

    public void updateView(double I76SAvg, double I76NAvg, double I476SAvg, double I476NAvg)    {

    }
}
