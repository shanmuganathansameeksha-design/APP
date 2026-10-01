import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {

    JTextField username;
    JPasswordField password;
    JCheckBox remember, notifications;

    UserLogin() {

        setTitle("User Login");
        setSize(350, 300);
        setLayout(new FlowLayout());

        JLabel userLabel = new JLabel("Username:");
        username = new JTextField(20);

        JLabel passLabel = new JLabel("Password:");
        password = new JPasswordField(20);

        remember = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        JButton login = new JButton("Login");

        add(userLabel);
        add(username);

        add(passLabel);
        add(password);

        add(remember);
        add(notifications);

        add(login);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String user = username.getText();
                String pass = new String(password.getPassword());

                if (user.equals("admin") && pass.equals("1234")) {

                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        "Login Successful!"
                        + "\nRemember Me: " + remember.isSelected()
                        + "\nReceive Notifications: "
                        + notifications.isSelected()
                    );

                } else {

                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        "Invalid Username or Password"
                    );
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}