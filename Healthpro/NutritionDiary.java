import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NutritionDiary extends JFrame {
    private JLabel mealLabel;
    private JLabel calorieLabel;
    private JLabel nutritionLabel;

    
    
    public NutritionDiary() {
        setTitle("Nutrition Diary");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 30, 40));
        JLabel mealNameLabel = new JLabel("Meal Name:");
        JTextField mealNameField = new JTextField();
        JLabel calorieCountLabel = new JLabel("Calorie Count:");
        JTextField calorieCountField = new JTextField();
        JLabel nutritionValueLabel = new JLabel("Nutritional Values:");
        JTextField nutritionValueField = new JTextField();

        inputPanel.add(mealNameLabel);
        inputPanel.add(mealNameField);
        inputPanel.add(calorieCountLabel);
        inputPanel.add(calorieCountField);
        inputPanel.add(nutritionValueLabel);
        inputPanel.add(nutritionValueField);

        JPanel buttonPanel = new JPanel();
        JButton logButton = new JButton("OK");
        JButton clearButton = new JButton("Clear");
        logButton.setBounds(70,400,60,60);
        clearButton.setBounds(80,400,60,60);
        buttonPanel.add(logButton);
        buttonPanel.add(clearButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mealLabel = new JLabel("Last Meal: ");
        calorieLabel = new JLabel("Calories: ");
        nutritionLabel = new JLabel("Nutrition: ");

        JPanel displayPanel = new JPanel(new GridLayout(3, 1));
        displayPanel.add(mealLabel);
        displayPanel.add(calorieLabel);
        displayPanel.add(nutritionLabel);

        mainPanel.add(displayPanel, BorderLayout.NORTH);

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mealName = mealNameField.getText();
                String calorieCount = calorieCountField.getText();
                String nutritionValue = nutritionValueField.getText();

                mealLabel.setText("Last Meal Name: " + mealName);
                calorieLabel.setText("Calories is: " + calorieCount);
                nutritionLabel.setText("Nutrition is: " + nutritionValue);
              mealLabel.setBounds(30,20,40,40);
              calorieLabel.setBounds(30,20,40,40);
              nutritionLabel.setBounds(30,20,40,40);
                // Clear input fields
                mealNameField.setText("");
                calorieCountField.setText("");
                nutritionValueField.setText("");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealLabel.setText("Last Meal: ");
                calorieLabel.setText("Calories: ");
                nutritionLabel.setText("Nutrition: ");

                // Clear input fields
                mealNameField.setText("");
                calorieCountField.setText("");
                nutritionValueField.setText("");
            }
        });

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NutritionDiary nutritionDiary = new NutritionDiary();
            nutritionDiary.setVisible(true);
        });
    }
    
}