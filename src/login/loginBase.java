package login;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class loginBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Button btnLogin;
    protected final Button btnSignup;
    protected final Label label;
    protected final TextField tfName;
    protected final PasswordField tfPassword;

    public loginBase() {

        anchorPane = new AnchorPane();
        btnLogin = new Button();
        btnSignup = new Button();
        label = new Label();
        tfName = new TextField();
        tfPassword = new PasswordField();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #010226;");

        AnchorPane.setBottomAnchor(anchorPane, 90.0);
        AnchorPane.setLeftAnchor(anchorPane, 90.0);
        AnchorPane.setRightAnchor(anchorPane, 90.0);
        AnchorPane.setTopAnchor(anchorPane, 90.0);
        anchorPane.setLayoutX(200.0);
        anchorPane.setLayoutY(100.0);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);
        anchorPane.setStyle("-fx-background-color: #a90226;");

        btnLogin.setLayoutX(71.0);
        btnLogin.setLayoutY(163.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setOnAction(this::loginAction);
        btnLogin.setPrefHeight(25.0);
        btnLogin.setPrefWidth(97.0);
        btnLogin.setStyle("-fx-background-color: #010226; -fx-background-radius: 20;");
        btnLogin.setText("LOGIN");
        btnLogin.setTextFill(javafx.scene.paint.Color.valueOf("#f8f6f6"));
        btnLogin.setFont(new Font(15.0));

        btnSignup.setLayoutX(226.0);
        btnSignup.setLayoutY(163.0);
        btnSignup.setMnemonicParsing(false);
        btnSignup.setOnAction(this::signupAction);
        btnSignup.setPrefHeight(25.0);
        btnSignup.setPrefWidth(97.0);
        btnSignup.setStyle("-fx-background-color: #010226; -fx-background-radius: 20;");
        btnSignup.setText("SIGN UP");
        btnSignup.setTextFill(javafx.scene.paint.Color.valueOf("#f5f4f4"));
        btnSignup.setFont(new Font(15.0));

        label.setLayoutX(157.0);
        label.setLayoutY(6.0);
        label.setText("LOGIN");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fcf9f9"));
        label.setFont(new Font(30.0));

        tfName.setLayoutX(62.0);
        tfName.setLayoutY(58.0);
        tfName.setPrefHeight(25.0);
        tfName.setPrefWidth(278.0);
        tfName.setPromptText("User Name");

        tfPassword.setLayoutX(62.0);
        tfPassword.setLayoutY(110.0);
        tfPassword.setPrefHeight(25.0);
        tfPassword.setPrefWidth(278.0);
        tfPassword.setPromptText("Password");

        anchorPane.getChildren().add(btnLogin);
        anchorPane.getChildren().add(btnSignup);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(tfName);
        anchorPane.getChildren().add(tfPassword);
        getChildren().add(anchorPane);

    }

    protected  void loginAction(javafx.event.ActionEvent actionEvent){
        
    }

    protected  void signupAction(javafx.event.ActionEvent actionEvent){
        
    }

}
