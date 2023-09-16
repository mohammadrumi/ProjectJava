import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DailyActivityLog extends JFrame {
    private final JLabel activityLabel;
    private final JLabel durationLabel;
    private final JLabel distanceLabel;
    private final JLabel calorieLabel;

    private final JTextField activityField;
    private final JTextField durationField;
    private final JTextField distanceField;
    private final JLabel calorieValueLabel;

    public DailyActivityLog() {
        setTitle("Daily Activity Log");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 3, 20, 20));
        activityLabel = new JLabel("Activity Name:");
        activityField = new JTextField();
        durationLabel = new JLabel("Duration (minutes):");
        durationField = new JTextField();
        distanceLabel = new JLabel("Distance (km):");
        distanceField = new JTextField();
        activityLabel.setBounds(50,50,150,100);
activityField.setBounds(130,60,150,30);
durationLabel.setBounds(50,100,110,40);
        inputPanel.add(activityLabel);
        inputPanel.add(activityField);
        inputPanel.add(durationLabel);
        inputPanel.add(durationField);
        inputPanel.add(distanceLabel);
        inputPanel.add(distanceField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCalorieBurn();
            }
        });

        calorieLabel = new JLabel("Calorie Burn:");
        calorieValueLabel = new JLabel();

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(calorieLabel, BorderLayout.WEST);
        mainPanel.add(calorieValueLabel, BorderLayout.EAST);
        mainPanel.add(calculateButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void calculateCalorieBurn() {
        String durationText = durationField.getText();
        String distanceText = distanceField.getText();

        if (!durationText.isEmpty() && !distanceText.isEmpty()) {
            int duration = Integer.parseInt(durationText);
            double distance = Double.parseDouble(distanceText);

            double calorieBurn = calculateCalories(duration, distance);
            calorieValueLabel.setText(String.format("%.2f", calorieBurn));
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both duration and distance values.");
        }
    }

    private double calculateCalories(int duration, double distance) {
        // Perform calorie burn calculation based on activity data
        // You can use any formula or logic specific to your requirements
        // For example, you can multiply duration by a factor and add distance multiplier to get calorie burn
        return duration * 5 + distance * 2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DailyActivityLog();
            }
        });
    }
}