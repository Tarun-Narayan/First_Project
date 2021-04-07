package ui.tools;


import model.TodaysMeals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the graphical user interface for the meal tracker feature of the application
public class MealTrackerGUI extends JFrame implements ActionListener {
    private TodaysMeals meals;
    JFrame frame1;
    JLabel label1;
    JLabel label2;
    JPanel panel;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JTextField txtQuestion1;
    JTextField txtQuestion2;
    JTextField txtQuestion3;
    JTextArea txtArea;

    //EFFECTS: Constructs the frame and adds the buttons, labels, text boxes, and a panel
    public MealTrackerGUI() {
        frame1 = new JFrame();
        panel = new JPanel();
        addLabels();
        addTextBox();
        addButtons1();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Measurement Analysis");
        pack();
        setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Measurement analysis"));
        add(panel);
        setSize(1000, 500);
        meals = new TodaysMeals();
    }

    //EFFECTS: Constructs the labels for the panel
    public void addLabels() {
        label1 = new JLabel("Enter Name of the meal:");
        label1.setBounds(10, 20, 200, 25);
        panel.add(label1);

        label2 = new JLabel("Enter preparation time for meal (minutes):");
        label2.setBounds(10, 50, 350, 25);
        panel.add(label2);

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
        txtQuestion3.setBounds(250, 140, 200, 25);
        panel.add(txtQuestion3);

        txtArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setBounds(250, 170, 500, 500);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);


    }

    //EFFECTS: Constructs the buttons for the panel
    public void addButtons1() {
        btn1 = new JButton("Add Meal");
        btn1.setBounds(50, 200, 150, 25);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("View Meals");
        btn2.setBounds(50, 225, 200, 25);
        btn2.addActionListener(this);
        panel.add(btn2);

        btn3 = new JButton("Quit Tracking");
        btn3.setBounds(50, 250, 200, 25);
        btn3.addActionListener(this);
        panel.add(btn3);

        btn4 = new JButton("Remove meal");
        btn4.setBounds(10, 140, 230, 25);
        btn4.addActionListener(this);
        panel.add(btn4);

        btn5 = new JButton("Get Preparation Time");
        btn5.setBounds(10, 115, 230, 25);
        btn5.addActionListener(this);
        panel.add(btn5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            addMeal();
        } else if (e.getSource() == btn2) {
            viewMeals();
        } else if (e.getSource() == btn3) {
            dispose();
        } else if (e.getSource() == btn4) {
            removeMeal();
        } else if (e.getSource() == btn5) {
            getPreparationTime();
        }

    }

    /*
     *MODIFIES: meals
     *EFFECTS: Adds a new meal to user's hashmap of meals
     */
    public void addMeal() {
        String s1 = txtQuestion1.getText();
        String s2 = txtQuestion2.getText();
        int prep = Integer.parseInt(s2);
        meals.addMeal(s1, prep);
        txtArea.setText(null);
        txtArea.setText("Meal successfully added! ");
    }

    /*
     *EFFECTS: Displays the names of all meals in the text area
     */
    public void viewMeals() {
        String result = meals.viewTodaysMeals() + "\n";
        txtArea.setText(null);
        txtArea.insert(result, 0);
    }

    /*
     *EFFECTS: Removes specified meal from today's meals
     */
    public void removeMeal() {
        String s1 = txtQuestion3.getText();
        String result = meals.removeMeal(s1);
        txtArea.setText(null);
        txtArea.insert(result, 0);
    }

    /*
     *EFFECTS: Gets preparation time for specified meal from today's meals
     */
    public void getPreparationTime() {
        String s1 = txtQuestion3.getText();
        String result = meals.getPrepTime(s1);
        txtArea.setText(null);
        txtArea.insert(result, 0);
    }
}
