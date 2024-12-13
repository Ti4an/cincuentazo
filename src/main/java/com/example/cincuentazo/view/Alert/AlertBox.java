package com.example.cincuentazo.view.Alert;

import javafx.scene.control.Alert;

public class AlertBox implements AlertBoxInterface{
    @Override
    public void InformationAlert(String title, String header, String message) {
        // Create an information alert of type INFORMATION
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title); // Set the title of the alert dialog
        alert.setHeaderText(header); // Set the header of the alert dialog
        alert.setContentText(message); // Set the content message of the alert dialog
        alert.showAndWait(); // Show the alert dialog and wait for the user to close it
    }

}
