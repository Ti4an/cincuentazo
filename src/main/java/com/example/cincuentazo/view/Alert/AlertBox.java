package com.example.cincuentazo.view.Alert;

import javafx.scene.control.Alert;

/**
 * A class that displays alert boxes to provide information to the user.
 * Implements the AlertBoxInterface.
 */
public class AlertBox implements AlertBoxInterface {

    /**
     * Displays an information alert box with the given title, header, and message.
     *
     * @param title   The title of the alert box.
     * @param header  The header text of the alert box.
     * @param message The content message of the alert box.
     */
    @Override
    public void InformationAlert(String title, String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
