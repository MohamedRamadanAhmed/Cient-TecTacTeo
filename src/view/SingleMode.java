package view;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.TicTacTocGame;

public class SingleMode extends BorderPane {

    public final GridPane gameGrid;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    public final Label lblCell1;
    public final Label lblCell2;
    public final Label lblCell3;
    public final Label lblCell4;
    public final Label lblCell5;
    public final Label lblCell6;
    public final Label lblCell7;
    public final Label lblCell8;
    public final Label lblCell9;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final Label num_matchlbl;
    protected final Label num_match_value;
    protected final Label label10;
    protected final Label label11;
    protected final Button onlineBtn;
    protected final Button button0;
    protected final Label usrNameLbl;
    public static String userName="";

    public SingleMode(Stage primarystage) {
        primarystage.getScene().setRoot(this);
        
        while (userName.equals("")){
        userName=JOptionPane.showInputDialog("please enter your name = ");
        }
        
        primarystage.setWidth(800);
        primarystage.setHeight(500);
        TicTacTocGame game = new TicTacTocGame(this, primarystage);
        gameGrid = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        lblCell1 = new Label();
        lblCell2 = new Label();
        lblCell3 = new Label();
        lblCell4 = new Label();
        lblCell5 = new Label();
        lblCell6 = new Label();
        lblCell7 = new Label();
        lblCell8 = new Label();
        lblCell9 = new Label();
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        num_matchlbl = new Label();
        num_match_value = new Label();
        label10 = new Label();
        label11 = new Label();
        onlineBtn = new Button();
        button0 = new Button();
        usrNameLbl = new Label();

        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        setPrefHeight(463.0);
        setPrefWidth(742.0);

        BorderPane.setAlignment(gameGrid, javafx.geometry.Pos.CENTER);
        gameGrid.setGridLinesVisible(true);
        gameGrid.setHgap(2.0);
        gameGrid.setMaxHeight(USE_PREF_SIZE);
        gameGrid.setMaxWidth(USE_PREF_SIZE);
        gameGrid.setPrefHeight(463.0);
        gameGrid.setPrefWidth(416.0);
        gameGrid.setVgap(2.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        lblCell1.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell1.setGraphicTextGap(8.0);
        lblCell1.setLayoutX(245.0);
        lblCell1.setLayoutY(10.0);
        lblCell1.setPrefHeight(146.0);
        lblCell1.setPrefWidth(247.0);
        lblCell1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell1.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell1.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell1.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell1, 0));

        GridPane.setColumnIndex(lblCell2, 1);
        lblCell2.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell2.setGraphicTextGap(8.0);
        lblCell2.setLayoutX(10.0);
        lblCell2.setLayoutY(10.0);
        lblCell2.setPrefHeight(146.0);
        lblCell2.setPrefWidth(247.0);
        lblCell2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell2.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell2.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell2.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell2, 1));
        GridPane.setColumnIndex(lblCell3, 2);
        lblCell3.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell3.setGraphicTextGap(8.0);
        lblCell3.setLayoutX(480.0);
        lblCell3.setLayoutY(154.0);
        lblCell3.setPrefHeight(146.0);
        lblCell3.setPrefWidth(247.0);
        lblCell3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell3.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell3.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell3.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell3, 2));
        GridPane.setRowIndex(lblCell4, 1);
        lblCell4.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell4.setGraphicTextGap(8.0);
        lblCell4.setLayoutX(10.0);
        lblCell4.setLayoutY(10.0);
        lblCell4.setPrefHeight(146.0);
        lblCell4.setPrefWidth(247.0);
        lblCell4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell4.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell4.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell4.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell4, 3));
        GridPane.setColumnIndex(lblCell5, 1);
        GridPane.setRowIndex(lblCell5, 1);
        lblCell5.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell5.setGraphicTextGap(8.0);
        lblCell5.setLayoutX(10.0);
        lblCell5.setLayoutY(10.0);
        lblCell5.setPrefHeight(146.0);
        lblCell5.setPrefWidth(247.0);
        lblCell5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell5.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell5.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell5.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell5, 4));
        GridPane.setColumnIndex(lblCell6, 2);
        GridPane.setRowIndex(lblCell6, 1);
        lblCell6.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell6.setGraphicTextGap(8.0);
        lblCell6.setLayoutX(480.0);
        lblCell6.setLayoutY(154.0);
        lblCell6.setPrefHeight(146.0);
        lblCell6.setPrefWidth(247.0);
        lblCell6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell6.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell6.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell6.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell6, 5));
        GridPane.setRowIndex(lblCell7, 2);
        lblCell7.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell7.setGraphicTextGap(8.0);
        lblCell7.setPrefHeight(146.0);
        lblCell7.setPrefWidth(247.0);
        lblCell7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell7.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell7.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell7.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell7, 6));
        GridPane.setColumnIndex(lblCell8, 1);
        GridPane.setRowIndex(lblCell8, 2);
        lblCell8.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell8.setGraphicTextGap(8.0);
        lblCell8.setLayoutX(245.0);
        lblCell8.setLayoutY(154.0);
        lblCell8.setPrefHeight(146.0);
        lblCell8.setPrefWidth(247.0);
        lblCell8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell8.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell8.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell8.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell8, 7));
        GridPane.setColumnIndex(lblCell9, 2);
        GridPane.setRowIndex(lblCell9, 2);
        lblCell9.setAlignment(javafx.geometry.Pos.CENTER);
        lblCell9.setGraphicTextGap(8.0);
        lblCell9.setLayoutX(245.0);
        lblCell9.setLayoutY(298.0);
        lblCell9.setPrefHeight(146.0);
        lblCell9.setPrefWidth(247.0);
        lblCell9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblCell9.setTextFill(javafx.scene.paint.Color.valueOf("#3f5290"));
        lblCell9.setFont(new Font("Viner Hand ITC", 69.0));
        lblCell9.setOnMouseClicked((event) -> game.gameStartSingleMode(lblCell9, 8));
        setLeft(gameGrid);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(459.0);
        anchorPane.setPrefWidth(336.0);
        anchorPane.setStyle("-fx-background-color: #010226;");

        anchorPane0.setLayoutX(3.0);
        anchorPane0.setLayoutY(151.0);
        anchorPane0.setPrefHeight(310.0);
        anchorPane0.setPrefWidth(323.0);

        num_matchlbl.setLayoutX(31.0);
        num_matchlbl.setLayoutY(23.0);
        num_matchlbl.setPrefHeight(29.0);
        num_matchlbl.setPrefWidth(151.0);
        num_matchlbl.setText("Number Of Matches ");
        num_matchlbl.setTextFill(javafx.scene.paint.Color.valueOf("#fffdfd"));
        num_matchlbl.setFont(new Font(15.0));

        num_match_value.setAlignment(javafx.geometry.Pos.CENTER);
        num_match_value.setLayoutX(208.0);
        num_match_value.setLayoutY(24.0);
        num_match_value.setPrefHeight(23.0);
        num_match_value.setPrefWidth(55.0);
        num_match_value.setText(game.getGameNum() + "");
        num_match_value.setTextFill(javafx.scene.paint.Color.valueOf("#fcfcfc"));
        num_match_value.setFont(new Font(18.0));

        label10.setLayoutX(31.0);
        label10.setLayoutY(74.0);
        label10.setPrefHeight(17.0);
        label10.setPrefWidth(127.0);
        label10.setText("Score");
        label10.setTextFill(javafx.scene.paint.Color.valueOf("#f8f6f6"));
        label10.setFont(new Font(18.0));

        label11.setAlignment(javafx.geometry.Pos.CENTER);
        label11.setLayoutX(202.0);
        label11.setLayoutY(74.0);
        label11.setPrefHeight(26.0);
        label11.setPrefWidth(68.0);
        label11.setText(game.getScore()+"");
        label11.setTextFill(javafx.scene.paint.Color.valueOf("#fcfafa"));
        label11.setFont(new Font(18.0));

        onlineBtn.setLayoutX(31.0);
        onlineBtn.setLayoutY(226.0);
        onlineBtn.setMnemonicParsing(false);
        onlineBtn.setPrefHeight(25.0);
        onlineBtn.setPrefWidth(95.0);
        onlineBtn.setText("Go Online");
        onlineBtn.setOnAction((event)->new Login(primarystage));

        button0.setLayoutX(173.0);
        button0.setLayoutY(226.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(25.0);
        button0.setPrefWidth(96.0);
        button0.setText("Record");

        usrNameLbl.setAlignment(javafx.geometry.Pos.CENTER);
        usrNameLbl.setLayoutX(49.0);
        usrNameLbl.setLayoutY(62.0);
        usrNameLbl.setPrefHeight(44.0);
        usrNameLbl.setPrefWidth(217.0);
        usrNameLbl.setText(userName);
        usrNameLbl.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        usrNameLbl.setFont(new Font(29.0));
        setRight(anchorPane);

        gameGrid.getColumnConstraints().add(columnConstraints);
        gameGrid.getColumnConstraints().add(columnConstraints0);
        gameGrid.getColumnConstraints().add(columnConstraints1);
        gameGrid.getRowConstraints().add(rowConstraints);
        gameGrid.getRowConstraints().add(rowConstraints0);
        gameGrid.getRowConstraints().add(rowConstraints1);
        gameGrid.getChildren().add(lblCell1);
        gameGrid.getChildren().add(lblCell2);
        gameGrid.getChildren().add(lblCell3);
        gameGrid.getChildren().add(lblCell4);
        gameGrid.getChildren().add(lblCell5);
        gameGrid.getChildren().add(lblCell6);
        gameGrid.getChildren().add(lblCell7);
        gameGrid.getChildren().add(lblCell8);
        gameGrid.getChildren().add(lblCell9);
        anchorPane0.getChildren().add(num_matchlbl);
        anchorPane0.getChildren().add(num_match_value);
        anchorPane0.getChildren().add(label10);
        anchorPane0.getChildren().add(label11);
        anchorPane0.getChildren().add(onlineBtn);
        anchorPane0.getChildren().add(button0);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(usrNameLbl);

    }
}
