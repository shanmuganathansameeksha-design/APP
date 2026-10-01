public class StudentModel {
    private String name;
    private int mark1, mark2, mark3;
    private int total;
    private double average;
    private String grade;

    public void calculate(String name, int m1, int m2, int m3) {
        this.name = name;
        mark1 = m1;
        mark2 = m2;
        mark3 = m3;

        total = mark1 + mark2 + mark3;
        average = total / 3.0;

        if (average >= 90)
            grade = "A";
        else if (average >= 75)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    public String getGrade() {
        return grade;
    }
}
import javax.swing.*;

public class StudentView extends JFrame {
    JTextField nameField, mark1Field, mark2Field, mark3Field;
    JButton calculateButton;
    JLabel resultLabel;

    StudentView() {
        setTitle("Student Grade Calculator");
        setSize(400, 400);
        setLayout(null);

        JLabel l1 = new JLabel("Student Name:");
        l1.setBounds(30, 30, 120, 30);
        add(l1);

        nameField = new JTextField();
        nameField.setBounds(160, 30, 180, 30);
        add(nameField);

        JLabel l2 = new JLabel("Mark 1:");
        l2.setBounds(30, 80, 120, 30);
        add(l2);

        mark1Field = new JTextField();
        mark1Field.setBounds(160, 80, 180, 30);
        add(mark1Field);

        JLabel l3 = new JLabel("Mark 2:");
        l3.setBounds(30, 130, 120, 30);
        add(l3);

        mark2Field = new JTextField();
        mark2Field.setBounds(160, 130, 180, 30);
        add(mark2Field);

        JLabel l4 = new JLabel("Mark 3:");
        l4.setBounds(30, 180, 120, 30);
        add(l4);

        mark3Field = new JTextField();
        mark3Field.setBounds(160, 180, 180, 30);
        add(mark3Field);

        calculateButton = new JButton("Calculate Result");
        calculateButton.setBounds(100, 230, 180, 35);
        add(calculateButton);

        resultLabel = new JLabel();
        resultLabel.setBounds(50, 280, 300, 60);
        add(resultLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
import javax.swing.*;

public class StudentController {
    StudentModel model;
    StudentView view;

    StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;

        view.calculateButton.addActionListener(e -> calculateResult());
    }

    void calculateResult() {
        try {
            String name = view.nameField.getText();

            int m1 = Integer.parseInt(view.mark1Field.getText());
            int m2 = Integer.parseInt(view.mark2Field.getText());
            int m3 = Integer.parseInt(view.mark3Field.getText());

            model.calculate(name, m1, m2, m3);

            view.resultLabel.setText(
                "Total: " + model.getTotal() +
                "  Average: " + model.getAverage() +
                "  Grade: " + model.getGrade()
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Enter valid marks!");
        }
    }
}
public class StudentMain {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();

        new StudentController(model, view);
    }
}