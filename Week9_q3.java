public class EmployeeModel {

    private String username = "admin";
    private String password = "admin123";

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public boolean changePassword(String oldPass, String newPass,
                                  String confirmPass) {

        if (!password.equals(oldPass))
            return false;

        if (!newPass.equals(confirmPass))
            return false;

        password = newPass;
        return true;
    }
}
import javax.swing.*;

public class EmployeeView extends JFrame {

    JTextField username;
    JPasswordField password;
    JButton loginButton;

    EmployeeView() {
        setTitle("Employee Login");
        setSize(350, 250);
        setLayout(null);

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(30, 40, 100, 30);
        add(l1);

        username = new JTextField();
        username.setBounds(130, 40, 150, 30);
        add(username);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(30, 90, 100, 30);
        add(l2);

        password = new JPasswordField();
        password.setBounds(130, 90, 150, 30);
        add(password);

        loginButton = new JButton("Login");
        loginButton.setBounds(110, 140, 100, 35);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
import javax.swing.*;

public class MainView extends JFrame {

    JMenuItem addEmployee;
    JMenuItem viewEmployee;
    JMenuItem changePassword;
    JMenuItem logout;
    JMenuItem exitApplication;

    MainView() {

        setTitle("Employee Management Portal");
        setSize(500, 400);

        JMenuBar bar = new JMenuBar();

        JMenu employee = new JMenu("Employee");
        addEmployee = new JMenuItem("Add Employee");
        viewEmployee = new JMenuItem("View Employee");

        employee.add(addEmployee);
        employee.add(viewEmployee);

        JMenu tools = new JMenu("Tools");
        changePassword = new JMenuItem("Change Password");
        tools.add(changePassword);

        JMenu exit = new JMenu("Exit");
        logout = new JMenuItem("Logout");
        exitApplication = new JMenuItem("Exit Application");

        exit.add(logout);
        exit.add(exitApplication);

        bar.add(employee);
        bar.add(tools);
        bar.add(exit);

        setJMenuBar(bar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
import javax.swing.*;

public class EmployeeController {

    EmployeeModel model;
    EmployeeView loginView;
    MainView mainView;

    EmployeeController(EmployeeModel model, EmployeeView view) {

        this.model = model;
        this.loginView = view;

        loginView.loginButton.addActionListener(e -> login());
    }

    void login() {

        String user = loginView.username.getText();
        String pass = new String(loginView.password.getPassword());

        if (model.login(user, pass)) {

            JOptionPane.showMessageDialog(loginView,
                    "Login Successful");

            loginView.dispose();

            mainView = new MainView();

            mainView.addEmployee.addActionListener(e -> addEmployee());

            mainView.changePassword.addActionListener(
                    e -> changePassword());

            mainView.logout.addActionListener(e -> logout());

            mainView.exitApplication.addActionListener(
                    e -> System.exit(0));

        } else {
            JOptionPane.showMessageDialog(loginView,
                    "Invalid Username or Password");
        }
    }

    void addEmployee() {

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField dept = new JTextField();

        Object[] fields = {
            "Employee ID:", id,
            "Employee Name:", name,
            "Department:", dept
        };

        int option = JOptionPane.showConfirmDialog(
                mainView,
                fields,
                "Add Employee",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(mainView,
                    "Employee Added Successfully");
        }
    }

    void changePassword() {

        JPasswordField oldPass = new JPasswordField();
        JPasswordField newPass = new JPasswordField();
        JPasswordField confirmPass = new JPasswordField();

        Object[] fields = {
            "Old Password:", oldPass,
            "New Password:", newPass,
            "Confirm Password:", confirmPass
        };

        int option = JOptionPane.showConfirmDialog(
                mainView,
                fields,
                "Change Password",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {

            boolean result = model.changePassword(
                    new String(oldPass.getPassword()),
                    new String(newPass.getPassword()),
                    new String(confirmPass.getPassword())
            );

            if (result)
                JOptionPane.showMessageDialog(mainView,
                        "Password Changed Successfully");
            else
                JOptionPane.showMessageDialog(mainView,
                        "Invalid old password or passwords do not match");
        }
    }

    void logout() {
        mainView.dispose();

        loginView = new EmployeeView();

        new EmployeeController(model, loginView);
    }
}
public class EmployeeMain {

    public static void main(String[] args) {

        EmployeeModel model = new EmployeeModel();
        EmployeeView view = new EmployeeView();

        new EmployeeController(model, view);
    }
}