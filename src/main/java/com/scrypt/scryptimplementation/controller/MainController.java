package com.scrypt.scryptimplementation.controller;

import com.scrypt.scryptimplementation.utils.SCryptUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.scrypt.scryptimplementation.utils.Constants.*;

public class MainController implements Initializable {
    private double x, y;
    private String status;
    private String generatedSecuredPasswordHash = "";
    @FXML
    private ImageView scryptImage;

    @FXML
    private Label lab;

    @FXML
    private TextField hashGeneratedField, booleanResultField,
            plaintextField, plaintextCheckField, nField, rField, pField;

    @FXML
    private Button btnGenerate, btnCheck;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    private void btnGenerateClicked(ActionEvent event) {
        if (!(plaintextField.getText().length() > 6)) {
            lab.setText("Password Length should be bigger than 6 characters.");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else {
            try {
                // generate hash

                if(nField.getText().matches("[0-9#]+"))
                {
                    lab.setText("Ensure that the 'N' parameter only consists of numerical values.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }

                if(pField.getText().matches("[0-9#]+"))
                {
                    lab.setText("Ensure that the 'P' parameter only consists of numerical values.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }

                if(rField.getText().matches("[0-9#]+"))
                {
                    lab.setText("Ensure that the 'R' parameter only consists of numerical values.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }

                if(plaintextField.getText().isEmpty())
                {
                    lab.setText("Require non-empty plaintext for hash generation.");
                    lab.setStyle("-fx-text-fill: #FF073A;");
                }
                else {

                    // Generate a secure hash of the plaintext password using SCrypt algorithm
                    generatedSecuredPasswordHash = SCryptUtil.scrypt(

                            // Get the plaintext password from the text field
                            plaintextField.getText(),
                            Integer.parseInt(nField.getText()),
                            Integer.parseInt(rField.getText()),
                            Integer.parseInt(pField.getText())
                    );

                    // Display the generated hash password in hashGeneratedField
                    hashGeneratedField.setText(generatedSecuredPasswordHash);

                    // Enable editing of hashGeneratedField
                    hashGeneratedField.setEditable(true);

                    // Disable disablement of hashGeneratedField
                    hashGeneratedField.setDisable(false);

                    // Update a label to show success message for hash generation
                    lab.setText("Hash Password has generated successfully!");

                    // Change style of the label to green indicating success
                    lab.setStyle("-fx-text-fill: #00FF00;");

                }
            }catch (Exception e) {
                lab.setText(STATUS + ": "+e.getMessage());
            }
        }

    }


    @FXML
    private void btnCheckClicked(ActionEvent event) {

        String plaintextCheck = plaintextCheckField.getText();

        if (plaintextCheck.isEmpty()) {
            lab.setText("Plaintext for checking shouldn't be empty!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else if (!(plaintextCheck.length() > 6)) {
            lab.setText("Character size limit is bigger than six.!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else if (hashGeneratedField.getText().isEmpty()) {
            lab.setText("You should have the hash for checking.!");
            lab.setStyle("-fx-text-fill: #FF073A;");
        } else {
            try {
                // Check if the entered plaintext matches the generated hash

                boolean matched = SCryptUtil.check(

                        // Get the entered plaintext password
                        plaintextCheckField.getText(),

                        // Get the previously generated hash password
                        hashGeneratedField.getText()
                );

                // If the plaintext matches the hash
                if (matched) {

                    // Set the booleanResultField to TRUE
                    booleanResultField.setText(TRUE);

                    // Style the booleanResultField for a positive match
                    booleanResultField.setStyle("    -fx-border-color: #00FF00;\n" +
                            "    -fx-background-color: #00FF00;\n" +
                            "    -fx-border-radius: 0;\n" +
                            "    -fx-border-width: 2px;\n" +
                            "    -fx-text-fill: #000;\n" +
                            "    -fx-prompt-text-fill: #58656D;");

                    // Update the label with a status message for a successful match
                    lab.setText(STATUS_TRUE);

                    // Change the style of the label to indicate a successful match
                    lab.setStyle("-fx-text-fill: #19ea19;");

                } else {
                    // If the plaintext does not match the hash

                    // Set the booleanResultField to FALSE
                    booleanResultField.setText(FALSE);

                    // Style the booleanResultField for a failed match
                    booleanResultField.setStyle(" -fx-border-color: red;\n" +
                            "    -fx-background-color: red;\n" +
                            "    -fx-border-radius: 0;\n" +
                            "    -fx-border-width: 2px;\n" +
                            "    -fx-text-fill: #000;\n" +
                            "    -fx-prompt-text-fill: #000;");

                    // Update the label with a status message for a failed match
                    lab.setText(STATUS_FALSE);

                    // Change the style of the label to indicate a failed match
                    lab.setStyle("-fx-text-fill: #ec0b0b;");
                }

                // Make the booleanResultField uneditable
                booleanResultField.setEditable(false);

                // Disable the booleanResultField
                booleanResultField.setDisable(true);

                // Set the cursor of booleanResultField to Hand cursor
                booleanResultField.setCursor(Cursor.HAND);

            }catch (Exception e) {
                lab.setText(STATUS + ": "+e.getMessage());
            }
        }
    }

    @FXML
    private void plaintextCheckFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    private void plaintextFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    private void hashGeneratedFieldClicked(ActionEvent event) throws Exception {
    }

    @FXML
    private void booleanResultFieldClicked(ActionEvent event) throws Exception {

    }

    @FXML
    void dragged(MouseEvent event) {

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setX(event.getScreenX() - x);
        primaryStage.setY(event.getScreenY() - y);
    }

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void min(MouseEvent event) {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
