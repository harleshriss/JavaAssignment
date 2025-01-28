import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class StudyOrganizer {

    public static void main(String[] args) {


        JFrame frame = new JFrame("Study Organizer");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel timetablePanel = createTimetablePanel();

        JPanel reminderPanel = createReminderPanel();

        tabbedPane.addTab("Timetable", timetablePanel);

        tabbedPane.addTab("Reminders", reminderPanel);

        frame.add(tabbedPane);

        frame.setVisible(true);

    }

    private static JPanel createTimetablePanel() {

        JPanel timetablePanel = new JPanel(new BorderLayout());
        DefaultListModel<String> timetableModel = new DefaultListModel<>();

        JList<String> timetableList = new JList<>(timetableModel);

        JScrollPane scrollPane = new JScrollPane(timetableList);

        JPanel inputPanel = new JPanel(new FlowLayout());

        JTextField activityField = new JTextField(20);

        JTextField timeField = new JTextField(10);

        JButton addButton = new JButton("Add");
        inputPanel.add(new JLabel("Activity:"));

        inputPanel.add(activityField);

        inputPanel.add(new JLabel("Time:"));

        inputPanel.add(timeField);

        inputPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String activity = activityField.getText();

                String time = timeField.getText();

                if (!activity.isEmpty() && !time.isEmpty()) {

                    timetableModel.addElement(time + " - " + activity);

                    activityField.setText("");

                    timeField.setText("");

                } else {

                    JOptionPane.showMessageDialog(timetablePanel, "Please fill both fields!");

                }

            }

        });

        timetablePanel.add(scrollPane, BorderLayout.CENTER);

        timetablePanel.add(inputPanel, BorderLayout.SOUTH);



        return timetablePanel;

    }

    private static JPanel createReminderPanel() {

        JPanel reminderPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> reminderModel = new DefaultListModel<>();

        JList<String> reminderList = new JList<>(reminderModel);

        JScrollPane scrollPane = new JScrollPane(reminderList);

        JPanel inputPanel = new JPanel(new FlowLayout());

        JTextField reminderField = new JTextField(20);

        JButton addButton = new JButton("Add Reminder");
        inputPanel.add(new JLabel("Reminder:"));

        inputPanel.add(reminderField);

        inputPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                String reminder = reminderField.getText();

                if (!reminder.isEmpty()) {

                    reminderModel.addElement(reminder);

                    reminderField.setText("");

                } else {

                    JOptionPane.showMessageDialog(reminderPanel, "Please enter a reminder!");

                }

            }

        });

        reminderPanel.add(scrollPane, BorderLayout.CENTER);

        reminderPanel.add(inputPanel, BorderLayout.SOUTH);



        return reminderPanel;

    }

}