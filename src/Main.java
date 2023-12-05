package app;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Daycare enterprise = new Daycare();
            ChildCareSystemGUI enterpriseGUI = new ChildCareSystemGUI(enterprise);
        });
    }
}