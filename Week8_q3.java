import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {

    JTextField nameField, regField;
    JRadioButton male, female, other;
    JComboBox<String> department;

    StudentRegistration() {

        setTitle("Student Registration");
        setSize(400, 350);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Student Name:");
        nameField = new JTextField(20);

        JLabel regLabel = new JLabel("Register Number:");
        regField = new JTextField(20);

        JLabel genderLabel = new JLabel("Gender:");

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel deptLabel = new JLabel("Department:");

        String departments[] = {
            "CSE", "ECE", "EEE", "Mechanical", "Civil"
        };

        department = new JComboBox<>(departments);

        JButton submit = new JButton("Submit");

        add(nameLabel);
        add(nameField);

        add(regLabel);
        add(regField);

        add(genderLabel);
        add(male);
        add(female);
        add(other);

        add(deptLabel);
        add(department);

        add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String gender = "";

                if (male.isSelected())
                    gender = "Male";
                else if (female.isSelected())
                    gender = "Female";
                else if (other.isSelected())
                    gender = "Other";

                JOptionPane.showMessageDialog(
                    StudentRegistration.this,
                    "Name: " + nameField.getText()
                    + "\nRegister Number: " + regField.getText()
                    + "\nGender: " + gender
                    + "\nDepartment: " + department.getSelectedItem()
                );
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}