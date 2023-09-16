import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Exercise {
    private String name;
    private int sets;
    private int repetitions;

    public Exercise(String name, int sets, int repetitions) {
        this.name = name;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getName() {
        return name;
    }

    public int getSets() {
        return sets;
    }

    public int getRepetitions() {
        return repetitions;
    }

    @Override
    public String toString() {
        return "Exercise: " + name + " | Sets: " + sets + " | Repetitions: " + repetitions;
    }
}

class Workout {
    private String date;
    private List<Exercise> exercises;

    public Workout(String date) {
        this.date = date;
        exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public String getDate() {
        return date;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        StringBuilder workoutSummary = new StringBuilder("Workout on " + date + ":\n");
        for (Exercise exercise : exercises) {
            workoutSummary.append(exercise).append("\n");
        }
        return workoutSummary.toString();
    }
}

class WorkoutTracker {
    private List<Workout> workouts;

    public WorkoutTracker() {
        workouts = new ArrayList<>();
    }

    public void logWorkout(Workout workout) {
        workouts.add(workout);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
}

public class WorkoutTrackerGUI {
    private JFrame frame;
    private WorkoutTracker tracker;

    private JTextArea summaryTextArea;

    public WorkoutTrackerGUI() {
        tracker = new WorkoutTracker();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Workout Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel logPanel = createLogPanel();
        JPanel summaryPanel = createSummaryPanel();

        tabbedPane.addTab("Log Workout", logPanel);
        tabbedPane.addTab("Generate Summaries", summaryPanel);

        frame.add(tabbedPane);
    }

    private JPanel createLogPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JTextField dateField = new JTextField();
        JTextField exerciseNameField = new JTextField();
        JTextField setsField = new JTextField();
        JTextField repetitionsField = new JTextField();

        JButton logButton = new JButton("Log Workout");

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = dateField.getText();
                String exerciseName = exerciseNameField.getText();
                int sets = Integer.parseInt(setsField.getText());
                int repetitions = Integer.parseInt(repetitionsField.getText());

                Exercise exercise = new Exercise(exerciseName, sets, repetitions);
                Workout workout = new Workout(date);
                workout.addExercise(exercise);

                tracker.logWorkout(workout);

                dateField.setText("");
                exerciseNameField.setText("");
                setsField.setText("");
                repetitionsField.setText("");

                JOptionPane.showMessageDialog(frame, "Workout logged successfully!");
            }
        });

        panel.add(new JLabel("Workout Date:"));
        panel.add(dateField);
        panel.add(new JLabel("Exercise Name:"));
        panel.add(exerciseNameField);
        panel.add(new JLabel("Sets:"));
        panel.add(setsField);
        panel.add(new JLabel("Repetitions:"));
        panel.add(repetitionsField);
        panel.add(new JLabel(""));
        panel.add(logButton);

        return panel;
    }

    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        summaryTextArea = new JTextArea();
        summaryTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(summaryTextArea);

        JButton generateButton = new JButton("Generate Summaries");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Workout> workouts = tracker.getWorkouts();
                if (workouts.isEmpty()) {
                    summaryTextArea.setText("No workouts logged yet.");
                } else {
                    StringBuilder summary = new StringBuilder();
                    for (Workout w : workouts) {
                        summary.append(w).append("\n\n");
                    }
                    summaryTextArea.setText(summary.toString());
                }
            }
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(generateButton, BorderLayout.SOUTH);

        return panel;
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WorkoutTrackerGUI gui = new WorkoutTrackerGUI();
                gui.display();
            }
        });
    }
}
