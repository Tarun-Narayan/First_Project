package ui.tools;

import model.CalorieTracker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackCalories extends JFrame implements ActionListener {
    private CalorieTracker trackCaloriesConsumed;
    JFrame frame1;
    JLabel label1;
    JLabel label2;
    JPanel panel;
    JButton btn1;
    JButton btn2;
    JTextField txtQuestion1;
    JTextField txtQuestion2;


    public TrackCalories() {
        frame1 = new JFrame();
        panel = new JPanel();
        addLabels();
        addTextBox();
        addButtons();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calorie Tracker");
        pack();
        setVisible(true);
        panel.setLayout(null);
        add(panel);
        setSize(500, 500);
        trackCaloriesConsumed = new CalorieTracker();
    }

    public void addLabels() {
        label1 = new JLabel("Enter total calories consumed in this meal:");
        label1.setBounds(10, 20, 300, 25);
        panel.add(label1);

        label2 = new JLabel("Total Calories Consumed:");
        label2.setBounds(10, 50, 200, 25);
        panel.add(label2);

    }

    public void addTextBox() {
        txtQuestion1 = new JTextField(40);
        txtQuestion1.setBounds(250, 20, 200, 25);
        panel.add(txtQuestion1);
        txtQuestion2 = new JTextField(40);
        txtQuestion2.setBounds(250, 50, 200, 25);
        panel.add(txtQuestion2);

    }

    public void addButtons() {
        btn1 = new JButton("Track meal!");
        btn1.setBounds(50, 200, 150, 25);
        btn1.addActionListener(this);
        panel.add(btn1);
        btn2 = new JButton("Quit Tracking");
        btn2.setBounds(200, 200, 150, 25);
        btn2.addActionListener(this);
        panel.add(btn2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String s1 = txtQuestion1.getText();
            Double totalCal = Double.parseDouble(s1);
            trackCaloriesConsumed.addCalories(totalCal);
        } else if (e.getSource() == btn2) {
            this.dispose();
        }
        String result = String.valueOf(trackCaloriesConsumed.getTotalCaloriesConsumed());
        txtQuestion2.setText(result);

    }
}
