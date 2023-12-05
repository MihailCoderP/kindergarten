package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChildCareSystemGUI {

    private final Daycare daycare;

    private final JFrame frame;
    private JTextField groupNameField;
    private JTextField groupNumberField;
    private JTextField childNameField;
    private JTextField childGenderField;
    private JTextField childAgeField;
    private JTextArea outputArea;

    private JButton addGroupButton;
    private JButton removeGroupButton;
    private JButton editGroupButton;
    private JButton addChildButton;
    private JButton removeChildButton;
    private JButton editChildButton;
    private JButton showInfoButton;

    private Group selectedGroup;
    private Child selectedChild;

    public ChildCareSystemGUI(Daycare daycare) {
        this.daycare = daycare;

        frame = new JFrame("Child Care System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        initializeComponents();
        createLayout();
        addActionListeners();

        frame.setVisible(true);
    }

    private void initializeComponents() {
        addGroupButton = new JButton("Добавить группу");
        removeGroupButton = new JButton("Удалить группу");
        editGroupButton = new JButton("Редактировать группу");
        addChildButton = new JButton("Добавить ребенка");
        removeChildButton = new JButton("Удалить ребенка");
        editChildButton = new JButton("Редактировать ребенка");
        showInfoButton = new JButton("Показать информацию");

        groupNameField = new JTextField(20);
        groupNumberField = new JTextField(5);
        childNameField = new JTextField(20);
        childGenderField = new JTextField(10);
        childAgeField = new JTextField(5);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
    }

    private void createLayout() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Название группы:"));
        panel.add(groupNameField);
        panel.add(new JLabel("Номер группы:"));
        panel.add(groupNumberField);
        panel.add(new JLabel("Имя ребенка:"));
        panel.add(childNameField);
        panel.add(new JLabel("Пол ребенка:"));
        panel.add(childGenderField);
        panel.add(new JLabel("Возраст ребенка:"));
        panel.add(childAgeField);

        panel.add(addGroupButton);
        panel.add(removeGroupButton);
        panel.add(editGroupButton);
        panel.add(addChildButton);
        panel.add(removeChildButton);
        panel.add(editChildButton);
        panel.add(showInfoButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void addActionListeners() {
        // ActionListener logic for buttons (similar to the previous example)
    }
}
