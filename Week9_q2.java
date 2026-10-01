public class VehicleModel {

    public int calculateCost(boolean general, boolean oil,
                             boolean brake, boolean battery) {

        int total = 0;

        if (general)
            total += 1000;

        if (oil)
            total += 800;

        if (brake)
            total += 1200;

        if (battery)
            total += 500;

        return total;
    }
}
import javax.swing.*;

public class VehicleView extends JFrame {

    JTextField regField;
    JRadioButton twoWheeler, car;
    JCheckBox general, oil, brake, battery;
    JButton calculate;
    JLabel result;

    VehicleView() {
        setTitle("Vehicle Service Cost");
        setSize(450, 450);
        setLayout(null);

        JLabel l1 = new JLabel("Registration No:");
        l1.setBounds(30, 30, 120, 30);
        add(l1);

        regField = new JTextField();
        regField.setBounds(160, 30, 200, 30);
        add(regField);

        JLabel l2 = new JLabel("Vehicle Type:");
        l2.setBounds(30, 80, 120, 30);
        add(l2);

        twoWheeler = new JRadioButton("Two Wheeler");
        twoWheeler.setBounds(150, 80, 110, 30);

        car = new JRadioButton("Car");
        car.setBounds(270, 80, 80, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(twoWheeler);
        group.add(car);

        add(twoWheeler);
        add(car);

        JLabel l3 = new JLabel("Services:");
        l3.setBounds(30, 130, 100, 30);
        add(l3);

        general = new JCheckBox("General Service ₹1000");
        general.setBounds(30, 160, 200, 30);
        add(general);

        oil = new JCheckBox("Oil Change ₹800");
        oil.setBounds(30, 200, 200, 30);
        add(oil);

        brake = new JCheckBox("Brake Service ₹1200");
        brake.setBounds(30, 240, 200, 30);
        add(brake);

        battery = new JCheckBox("Battery Check ₹500");
        battery.setBounds(30, 280, 200, 30);
        add(battery);

        calculate = new JButton("Calculate Cost");
        calculate.setBounds(130, 330, 160, 35);
        add(calculate);

        result = new JLabel();
        result.setBounds(100, 380, 250, 30);
        add(result);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
import javax.swing.*;

public class VehicleController {

    VehicleModel model;
    VehicleView view;

    VehicleController(VehicleModel model, VehicleView view) {
        this.model = model;
        this.view = view;

        view.calculate.addActionListener(e -> calculate());
    }

    void calculate() {

        if (!view.twoWheeler.isSelected() &&
            !view.car.isSelected()) {

            JOptionPane.showMessageDialog(view,
                    "Select vehicle type");
            return;
        }

        int cost = model.calculateCost(
                view.general.isSelected(),
                view.oil.isSelected(),
                view.brake.isSelected(),
                view.battery.isSelected()
        );

        view.result.setText("Total Service Cost: ₹" + cost);
    }
}
public class VehicleMain {
    public static void main(String[] args) {
        VehicleModel model = new VehicleModel();
        VehicleView view = new VehicleView();

        new VehicleController(model, view);
    }
}