import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CourseManagement extends JFrame {

    JList<String> courseList;
    JTable table;
    DefaultTableModel model;

    CourseManagement() {

        setTitle("Student Course Management");
        setSize(600, 400);
        setLayout(new BorderLayout());

        String courses[] = {
            "Java",
            "Data Structures",
            "Operating Systems",
            "Computer Networks",
            "Database Management"
        };

        courseList = new JList<>(courses);

        JScrollPane listScroll = new JScrollPane(courseList);

        model = new DefaultTableModel();

        model.addColumn("Student Name");
        model.addColumn("Selected Course");
        model.addColumn("Enrollment Status");

        table = new JTable(model);

        JScrollPane tableScroll = new JScrollPane(table);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Available Courses"), BorderLayout.NORTH);
        leftPanel.add(listScroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Course");
        JButton removeButton = new JButton("Remove Course");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(leftPanel, BorderLayout.WEST);
        add(tableScroll, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String course = courseList.getSelectedValue();

                if (course != null) {

                    String name = JOptionPane.showInputDialog(
                        CourseManagement.this,
                        "Enter Student Name:"
                    );

                    if (name != null && !name.equals("")) {

                        model.addRow(
                            new Object[] {
                                name,
                                course,
                                "Enrolled"
                            }
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        CourseManagement.this,
                        "Please select a course"
                    );
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row != -1) {
                    model.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(
                        CourseManagement.this,
                        "Please select a registration to remove"
                    );
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CourseManagement();
    }
}