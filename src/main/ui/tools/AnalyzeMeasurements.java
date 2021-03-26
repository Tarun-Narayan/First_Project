package ui.tools;

import model.ListOfMeasurements;
import model.TodaysMeasurements;
import persistence.Reader;
import persistence.Writer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnalyzeMeasurements extends JFrame implements ActionListener {
    private static final String JSON_STORE = "./data/ListOfMeasurements.json";
    private ListOfMeasurements listOfMeasurements;
    private Writer writer;
    private Reader reader;
    JFrame frame1;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JPanel panel;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JTextField txtQuestion1;
    JTextField txtQuestion2;
    JTextField txtQuestion3;
    JTextField txtQuestion4;
    JTextField txtQuestion5;

    public AnalyzeMeasurements() throws FileNotFoundException, IOException {
        frame1 = new JFrame();
        panel = new JPanel();
        writer = new Writer(JSON_STORE);
        reader = new Reader(JSON_STORE);
        addLabels();
        addTextBox();
        addButtons();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Measurement Analysis");
        pack();
        setVisible(true);
        panel.setLayout(null);
        add(panel);
        setSize(1000, 500);
        listOfMeasurements = new ListOfMeasurements();

    }

    public void addLabels() {
        label1 = new JLabel("Enter Today's Weight:");
        label1.setBounds(10, 20, 200, 25);
        panel.add(label1);

        label2 = new JLabel("Enter Today's Chest Measurement:");
        label2.setBounds(10, 50, 350, 25);
        panel.add(label2);

        label3 = new JLabel("Enter Today's Waist Measurement:");
        label3.setBounds(10, 80, 350, 25);
        panel.add(label3);

        label4 = new JLabel("Enter Today's Shoulder Measurement:");
        label4.setBounds(10, 110, 350, 25);
        panel.add(label4);

        label5 = new JLabel("List Of Measurements:");
        label5.setBounds(10, 140, 350, 25);
        panel.add(label5);

    }

    public void addTextBox() {
        txtQuestion1 = new JTextField(40);
        txtQuestion1.setBounds(250, 20, 200, 25);
        panel.add(txtQuestion1);

        txtQuestion2 = new JTextField(40);
        txtQuestion2.setBounds(250, 50, 200, 25);
        panel.add(txtQuestion2);

        txtQuestion3 = new JTextField(40);
        txtQuestion3.setBounds(250, 80, 200, 25);
        panel.add(txtQuestion3);

        txtQuestion4 = new JTextField(40);
        txtQuestion4.setBounds(250, 110, 200, 25);
        panel.add(txtQuestion4);

        txtQuestion5 = new JTextField(1);
        txtQuestion5.setBounds(250, 140, 1000, 25);
        panel.add(txtQuestion5);


    }

    public void addButtons() {
        btn1 = new JButton("Add Measurement");
        btn1.setBounds(50, 200, 150, 25);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("View list of Measurements");
        btn2.setBounds(50, 225, 200, 25);
        btn2.addActionListener(this);
        panel.add(btn2);

        btn3 = new JButton("Save list of Measurements");
        btn3.setBounds(50, 250, 200, 25);
        btn3.addActionListener(this);
        panel.add(btn3);

        btn4 = new JButton("Load list of Measurements");
        btn4.setBounds(50, 275, 200, 25);
        btn4.addActionListener(this);
        panel.add(btn4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String s1 = txtQuestion1.getText();
            Float weight = Float.parseFloat(s1);
            String s2 = txtQuestion2.getText();
            Float chest = Float.parseFloat(s2);
            String s3 = txtQuestion3.getText();
            Float waist = Float.parseFloat(s3);
            String s4 = txtQuestion4.getText();
            Float shoulder = Float.parseFloat(s4);
            TodaysMeasurements newMeasurements = new TodaysMeasurements(weight, waist, shoulder, chest);
            listOfMeasurements.addNewMeasurements(newMeasurements);

        } else if (e.getSource() == btn2) {
            String result = listOfMeasurements.viewListOfMeasurements() + "\n";
            txtQuestion5.setText(result);
        } else if (e.getSource() == btn3) {
            saveMeasurements();
        } else if (e.getSource() == btn4) {
            loadMeasurements();
        }

    }

    public void loadMeasurements() {
        try {
            listOfMeasurements = reader.read();
            System.out.println("Loaded your previously made List of Measurements from:" + JSON_STORE);
        } catch (IOException a) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }


    }

    public void saveMeasurements() {
        try {
            writer.open();
            writer.write(listOfMeasurements);
            writer.close();
        } catch (FileNotFoundException a) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}
