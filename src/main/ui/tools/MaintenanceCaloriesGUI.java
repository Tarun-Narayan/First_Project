package ui.tools;

import model.UserMaintenanceCalories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the graphical user interface for the calculate maintenance calories feature of the application
public class MaintenanceCaloriesGUI extends JFrame implements ActionListener {
    private UserMaintenanceCalories userMaintenance;
    JFrame frame1;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JPanel panel;
    JButton btn1;
    JButton btn2;
    JTextField txtQuestion1;
    JTextField txtQuestion2;
    JTextField txtQuestion3;
    JTextField txtQuestion4;
    JTextField txtQuestion5;

    //EFFECTS: Constructs the frame and adds the buttons, labels, text boxes, and a panel
    public MaintenanceCaloriesGUI() {
        frame1 = new JFrame();
        panel = new JPanel();
        addLabels();
        addTextBox();
        addButtons();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Maintenance Calories");
        pack();
        setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.RED);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Calculate Maintenance calories"));
        add(panel);
        setSize(500, 500);
    }

    //EFFECTS: Constructs the labels for the panel
    public void addLabels() {
        label1 = new JLabel("Enter gender (m/f):");
        label1.setBounds(10, 20, 200, 25);
        panel.add(label1);

        label2 = new JLabel("Enter Age:");
        label2.setBounds(10, 50, 200, 25);
        panel.add(label2);

        label3 = new JLabel("Enter Weight(Kg):");
        label3.setBounds(10, 80, 200, 25);
        panel.add(label3);

        label4 = new JLabel("Enter Height(cm):");
        label4.setBounds(10, 110, 200, 25);
        panel.add(label4);

        label5 = new JLabel("Maintenance Calories:");
        label5.setBounds(10, 140, 200, 25);
        panel.add(label5);

    }

    //EFFECTS: Constructs the text boxes for the panel
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

        txtQuestion5 = new JTextField(40);
        txtQuestion5.setBounds(250, 140, 200, 25);
        panel.add(txtQuestion5);

    }

    //EFFECTS: Constructs the buttons for the panel
    public void addButtons() {
        btn1 = new JButton("Calculate Maintenance");
        btn1.setBounds(50, 300, 200, 25);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("Quit Tracking");
        btn2.setBounds(250, 300, 150, 25);
        btn2.addActionListener(this);
        panel.add(btn2);
    }

    /*
     *EFFECTS: Performs the action associated with a particular button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            getMaintenance();
        } else if (e.getSource() == btn2) {
            this.dispose();
        }

    }

    /*
     *MODIFIES: userMaintenance
     *EFFECTS: calculates the user's maintenance calories (i.e, Basal Metabolic Rate)
     */
    public void getMaintenance() {
        String gender = txtQuestion1.getText();
        String s2 = txtQuestion2.getText();
        String s3 = txtQuestion3.getText();
        String s4 = txtQuestion4.getText();
        Double height = Double.parseDouble(s4);
        Double weight = Double.parseDouble(s3);
        int age = Integer.parseInt(s2);
        userMaintenance = new UserMaintenanceCalories(age, height, weight, gender);
        String result = String.valueOf(userMaintenance.calculateMaintenance());
        txtQuestion5.setText(result);
    }
}
