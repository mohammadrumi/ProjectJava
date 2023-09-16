import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalSettingApp extends JFrame {
    private final JLabel stepsGoalLabel;
    private final JTextField stepsGoalTextField;
    private final JButton setStepsGoalButton;
    private final JLabel stepsProgressLabel;
    private int stepsProgress;

    private final JLabel weightGoalLabel;
    private final JTextField weightGoalTextField;
    private final JButton setWeightGoalButton;
    private final JLabel weightProgressLabel;
    private double weightProgress;

    public GoalSettingApp() {
        setTitle("Goal Setting App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLayout(new FlowLayout());

        stepsGoalLabel = new JLabel("Set steps goal:");
        add(stepsGoalLabel);

        stepsGoalTextField = new JTextField(10);
        add(stepsGoalTextField);

        setStepsGoalButton = new JButton("Set Steps Goal");
        setStepsGoalButton.addActionListener(new SetStepsGoalButtonListener());
        add(setStepsGoalButton);

        stepsProgressLabel = new JLabel("");
        add(stepsProgressLabel);

        weightGoalLabel = new JLabel("Set weight goal (in kg):");
        add(weightGoalLabel);

        weightGoalTextField = new JTextField(10);
        add(weightGoalTextField);

        setWeightGoalButton = new JButton("Set Weight Goal");
        setWeightGoalButton.addActionListener(new SetWeightGoalButtonListener());
        add(setWeightGoalButton);

        weightProgressLabel = new JLabel("");
        add(weightProgressLabel);
    }

    private class SetStepsGoalButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int stepsGoal = Integer.parseInt(stepsGoalTextField.getText());
            stepsProgress = 0;
            updateStepsProgressLabel(stepsProgress, stepsGoal);
        }
    }

    private class SetWeightGoalButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double weightGoal = Double.parseDouble(weightGoalTextField.getText());
            weightProgress = 0;
            updateWeightProgressLabel(weightProgress, weightGoal);
        }
    }

    private void updateStepsProgressLabel(int progress, int goal) {
        stepsProgressLabel.setText("Steps Progress: " + progress + "/" + goal);
    }

    private void updateWeightProgressLabel(double progress, double goal) {
        weightProgressLabel.setText("Weight Progress: " + progress + "/" + goal + " kg");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GoalSettingApp app = new GoalSettingApp();
            app.setVisible(true);
        });
    }
}
Write to CSE110 Mini Project
