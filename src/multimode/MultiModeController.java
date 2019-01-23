package multimode;

import client.server.remote.interfaces.Step;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import com.jfoenix.controls.JFXListView;
import demo.MoveContent;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
import main.XMLRecord;
import client.ClintImp;
import client.TicTacTocGame;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import utils.SceneHandler;
import utils.Utils;

public class MultiModeController implements Initializable {

    @FXML
    private Button btnRefresh;
    @FXML
    public Label lable1;
    @FXML
    public Label lable2;
    @FXML
    public Label lable3;
    @FXML
    public Label lable4;
    @FXML
    public Label lable5;
    @FXML
    public Label lable6;
    @FXML
    public Label lable7;
    @FXML
    public Label lable8;
    @FXML
    public Label lable9;
    @FXML
    public Label user1;
    @FXML
    public Label user2;
    @FXML
    public Button startgame;
    @FXML
    private Button exit;
    @FXML
    private Button btnLogout;
    @FXML
    private Button record;
    @FXML
    private Button back;
    @FXML
    public  GridPane myGridPane;
    @FXML
    public  JFXListView<UserModel> listView;
    @FXML
    private TextArea txtAreaChat;
    @FXML
    private TextField txtFieldChat;
    @FXML
    private Button btnSendMessage;
    @FXML
    private Label lableReciever;

    @FXML
    private ImageView imgViewrefresh;

    @FXML
    private Button btnEndGame;

    String s;
    XMLRecord recordObj = new XMLRecord();

    boolean isMyTurnToplay = false;
    int[] game_arr = new int[9];
    private Image offline;
    Utils util = new Utils();
    public ObservableList<UserModel> list;
    UserModel model;
   public List<UserModel> onlineUsersList;
    MyControoler controoler;

    public UserAccountHandler accountHandler;
    private SceneHandler handler;
    public static MultiModeController m;
    int counter = 0;

 
    public MultiModeController() {
        try {
            m = this;
            controoler = new MyControoler();
            accountHandler = Utils.establishConnection();
            handler = SceneHandler.getInstance();
        } catch (RemoteException | NotBoundException ex) {
            util.missingConnection();
        }
    }

    public void startgame() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                // while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
//                        Utils.showAlert(Alert.AlertType.CONFIRMATION, myGridPane.getScene().getWindow(), " ", "player "
//                                + Utils.getlPayer().getUserName() + "accept playing ith you");
                        JOptionPane.showMessageDialog(null, "Game starts", "TicTacToe", JOptionPane.INFORMATION_MESSAGE);
                        myGridPane.setVisible(true);
                    }
                });

            }
        });
        thread.start();
        clearGrid();
        txtFieldChat.setText("");

    }

    public void receive(Step step) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                // while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (controoler != null) {
                            if (step != null) {
                                myGridPane.setVisible(true);
                                drawStep(step.getPosition(), step.getDraw());
                                s = step.getDraw();
                                ClintImp.isReceving = false;
                            } else {
                                System.out.println("step is null");
                            }
                        } else {
                            System.out.println("controller is null");
                        }
                    }
                });

            }
        });
        thread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (Utils.isPlaying) {
                        } else {
                        }
                    }
                });

            }
        }).start();
    }

    public void print(UserModel player1, String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        txtAreaChat.appendText(player1.getUserName() + " : " + message
                                + " " + Utils.getCurrentDate() + "\n");

                    }
                });

            }
        }).start();

    }

    void showrefusedMessahe() {
        JOptionPane.showMessageDialog(null, "sorry player" + Utils.getlPayer().getUserName()
                + "refused to play with you ", "TicTacToe", JOptionPane.INFORMATION_MESSAGE);

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        try {

                            Utils.isMyTurn = true;
                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (Utils.isPlaying) {
                                                myGridPane.setVisible(true);
                                            } else {
                                            }

                                        }
                                    });

                                }
                            }).start();
                            model = listView.getSelectionModel().getSelectedItem();
                            Utils.setPlayer(model);
                            Utils.setSymbol("x");
                            listView.setOnMouseClicked(null);
                            MyControoler.requestGame(Utils.getlPayer());
                        } catch (RemoteException | NotBoundException | NullPointerException ex) {
                            util.missingConnection();
                        }
                    }
                }
            }
        });

    }

    private void clearGrid() {
        lable1.setText("");
        lable2.setText("");
        lable3.setText("");
        lable4.setText("");
        lable5.setText("");
        lable6.setText("");
        lable7.setText("");
        lable8.setText("");
        lable9.setText("");
    }

    private class UserListAdapter extends ListCell<UserModel> {

        private Pane pane;
        private HBox hBox;
        private VBox vBox;
        private Label userNameLabel;
        private HBox hBox0;
        private Label userScoreLabel;
        private Label userScoreValueLabel;
        private VBox vBox0;
        private Button btnInvite;
        // private Image online = new Image("images/online.png", 16, 16, false, false);
        // private Image offline = new Image("images/offline.png", 16, 16, false, false);
        private ImageView imageView;

        public UserListAdapter() {
            pane = new Pane();
            pane.setPrefHeight(75.0);
            pane.setPrefWidth(300.0);
            pane.setStyle("-fx-background-color: #ffffff;");

            hBox = new HBox();
            hBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
            hBox.setPrefHeight(75.0);
            hBox.setPrefWidth(300.0);
            hBox.setPadding(new Insets(10.0));

            vBox = new VBox();
            vBox.setPrefHeight(55.0);
            vBox.setPrefWidth(200.0);

            userNameLabel = new Label();
            userNameLabel.setMaxWidth(200.0);
            userNameLabel.setText("Amer Shaker");
            userNameLabel.setPadding(new Insets(5.0));
            userNameLabel.setFont(new Font("System Bold", 12.0));

            hBox0 = new HBox();
            hBox0.setPrefHeight(100.0);
            hBox0.setPrefWidth(200.0);

            userScoreLabel = new Label();
            userScoreLabel.setMaxWidth(50.0);
            userScoreLabel.setMinWidth(50.0);
            userScoreLabel.setText("Score");
            userScoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#03a9f4"));
            userScoreLabel.setPadding(new Insets(5.0));
            userScoreLabel.setFont(new Font("System Bold", 12.0));

            userScoreValueLabel = new Label();
            userScoreValueLabel.setMaxWidth(140.0);
            userScoreValueLabel.setMinWidth(140.0);
            userScoreValueLabel.setText("20.0");
            userScoreValueLabel.setPadding(new Insets(5.0));

            btnInvite = new Button();

            HBox.setMargin(userScoreValueLabel, new Insets(0.0, 0.0, 0.0, 10.0));
            HBox.setMargin(vBox, new Insets(0.0));

            vBox0 = new VBox();
            vBox0.setAlignment(javafx.geometry.Pos.CENTER);
            vBox0.setPrefHeight(55.0);
            vBox0.setPrefWidth(70.0);

            imageView = new ImageView();
            imageView.setFitHeight(16.0);
            imageView.setFitWidth(16.0);
            imageView.setPickOnBounds(true);
            imageView.setPreserveRatio(true);

            HBox.setMargin(vBox0, new Insets(0.0, 0.0, 0.0, 10.0));

            vBox.getChildren().add(userNameLabel);
            hBox0.getChildren().add(userScoreLabel);
            hBox0.getChildren().add(userScoreValueLabel);
            vBox.getChildren().add(hBox0);
            hBox.getChildren().add(vBox);
            vBox0.getChildren().add(imageView);
            hBox.getChildren().add(vBox0);
            pane.getChildren().add(hBox);

            // clicking on list view to request another player to play 
            listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                        if (mouseEvent.getClickCount() == 2) {
                            try {

                                Utils.isMyTurn = true;
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        Platform.runLater(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (Utils.isPlaying) {
                                                    myGridPane.setVisible(true);
                                                } else {
                                                }

                                            }
                                        });

                                    }
                                }).start();
                                model = listView.getSelectionModel().getSelectedItem();
                                Utils.setPlayer(model);
                                Utils.setSymbol("x");
                                listView.setOnMouseClicked(null);
                                MyControoler.requestGame(Utils.getlPayer());
                            } catch (RemoteException | NotBoundException | NullPointerException ex) {
                                util.missingConnection();
                            }
                        }
                    }
                }
            });

            new Thread(new Runnable() {
                @Override
                public void run() {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (Utils.isPlaying) {
                                myGridPane.setVisible(true);
                            } else {
                            }
                        }
                    });

                }
            }).start();
        }

        @Override
        protected void updateItem(UserModel user, boolean empty) {
            super.updateItem(user, empty);
            if (user != null && !empty) {
                userNameLabel.setText(user.getUserName());
                userScoreValueLabel.setText(user.getScore() + "");

                setGraphic(pane);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TicTacTocGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (Utils.logout) {

                                System.out.println(".run()");
                                Utils.logout = false;
                                JOptionPane.showMessageDialog(null, "second player terminated the game ", "TicTacToe", JOptionPane.INFORMATION_MESSAGE);

                            }

                        }
                    });

                }
            }).start();

            record.setVisible(false);
            onlineUsersList = accountHandler.getOnlinePlayers();
            list = FXCollections.observableArrayList(onlineUsersList);
            txtAreaChat.setEditable(false);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmailAddress().equals(Utils.getCurrentUser().getEmailAddress())) {
                    System.out.println(list.get(i).getEmailAddress());

                    list.remove(i);
                }
            }

        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        listView.setItems(list);
        listView.getItems().remove(Utils.getCurrentUser());
        GridPane pane = new GridPane();
        Label name = new Label("gg");
        Button btn = new Button("dd");
        pane.add(name, 0, 0);
        pane.add(btn, 0, 1);
        listView.setCellFactory(param -> new UserListAdapter());
        myGridPane.setVisible(false);

        SceneHandler.getInstance().getStage().setOnCloseRequest((event) -> {
            controoler.logOut();
        });
        txtFieldChat.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    String message;

                    try {
                        accountHandler = Utils.establishConnection();
                        message = txtFieldChat.getText();
                        accountHandler.sendMessage(Utils.getCurrentUser(), Utils.getlPayer(), message);
                        txtFieldChat.setText("");
                    } catch (RemoteException ex) {
                        Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NotBoundException ex) {
                        Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    void btnRefreshAction(MouseEvent event) {

        try {
            onlineUsersList = accountHandler.getOnlinePlayers();
            list = FXCollections.observableArrayList(onlineUsersList);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmailAddress().equals(Utils.getCurrentUser().getEmailAddress())) {
                    System.out.println(list.get(i).getEmailAddress());

                    list.remove(i);
                }
                System.out.println("i = " + i);
            }

        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        listView.setItems(list);
       // listView.getItems().remove(Utils.getCurrentUser());
        GridPane pane = new GridPane();
        Label name = new Label("gg");
        Button btn = new Button("dd");
        pane.add(name, 0, 0);
        pane.add(btn, 0, 1);
        listView.setCellFactory(param -> new UserListAdapter());
        myGridPane.setVisible(false);

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        try {

                            Utils.isMyTurn = true;
                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (Utils.isPlaying) {
                                                myGridPane.setVisible(true);
                                            } else {
                                            }

                                        }
                                    });

                                }
                            }).start();
                            model = listView.getSelectionModel().getSelectedItem();
                            Utils.setPlayer(model);
                            Utils.setSymbol("x");
                            listView.setOnMouseClicked(null);
                            MyControoler.requestGame(Utils.getlPayer());
                        } catch (RemoteException | NotBoundException | NullPointerException ex) {
                            util.missingConnection();
                        }
                    }
                }
            }
        });

    }

    @FXML

    public void startGameAction(ActionEvent event) {
        startgame();
    }

    @FXML
    private void recordAction(ActionEvent event) {
        displayRecord();
        //        recordObj.unmarchal();
//        final ArrayList<MoveContent> playrecord = recordObj.playRecord();
//        clearGrid();
//
//        new AnimationTimer() {
//            int i = 0;
//            long lastUpdate = 0;
//
//            @Override
//            public void handle(long now) {
//                if (now - lastUpdate >= 700_000_000) {
//
//                    playRecord(recordObj.playRecord().get(i).getPosition(), playrecord.get(i).getDraw());
//                    i++;
//                    if (i >= playrecord.size()) {
//                        stop();
//                    }
//                    lastUpdate = now;
//                }
//            }
//        }.start();

    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        handler.setScene("choosemode/SelectMode", "SelectMode", 800, 800, true);
    }

    @FXML
    void logOutAction(ActionEvent event) throws RemoteException, IOException, NotBoundException {
        try {
            if (MyControoler.logOut()) {
                //  System.out.println(MyControoler.logOut() + "xxx");
                handler.setScene("/sinup/signup.fxml", " Sin up  ", 800, 800, true);

                //handler.setScene("/choosemode/SelectMode.fxml", "choose mode", 800, 800, true);
            } else {
                util.missingConnection();
            }
        } catch (RemoteException ex) {
            util.missingConnection();

        }
    }

    void setTextOnlable(Label lable, int position, int i, String symbol) {
        if (counter == 0) {
            recordObj.unmarchal();
        }
        if (game_arr[position] == 0 && i == 2) {
            System.out.println("server" + game_arr[position]);
            game_arr[position] = i;
            lable.setText(symbol);

            recordObj.addMove(position, symbol);
            if (!checkWinner()) {
                Utils.isMyTurn = true;
            }

            counter++;

        } else if (i == 1) {
            if (game_arr[position] == 0 && Utils.isMyTurn == true) {
                game_arr[position] = i;
                lable.setText(symbol);
                System.out.println("before" + Utils.isMyTurn);
                Utils.isMyTurn = false;
                System.out.println("after" + Utils.isMyTurn);
                MyControoler.transmitMove(position, Utils.getSymbol(), Utils.getlPayer());
                recordObj.addMove(position, symbol);
                checkWinner();

                counter++;
            }
        }

    }

    public void newGame(String msg) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TicTacTocGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        recordObj.marchal();
                        int recordResult = JOptionPane.showConfirmDialog(null, msg + " replay the last game ?", "TicTacToe", JOptionPane.INFORMATION_MESSAGE);
                        if (recordResult == 0) {

                            displayRecord();
                            record.setVisible(true);

                        } else {
                            record.setVisible(false);

                        }

                    }
                });

            }
        }).start();

    }

    @FXML
    void lable1Action(MouseEvent event) {
        setTextOnlable(lable1, 0, 1, Utils.getSymbol());
    }

    @FXML
    void lable2Action(MouseEvent event) {
        setTextOnlable(lable2, 1, 1, Utils.getSymbol());
    }

    @FXML
    void lable3Action(MouseEvent event) {

        setTextOnlable(lable3, 2, 1, Utils.getSymbol());
    }

    @FXML
    void lable4Action(MouseEvent event) {
        setTextOnlable(lable4, 3, 1, Utils.getSymbol());
    }

    @FXML
    void lable5Action(MouseEvent event) {
        setTextOnlable(lable5, 4, 1, Utils.getSymbol());
    }

    @FXML
    void lable6Action(MouseEvent event) {
        setTextOnlable(lable6, 5, 1, Utils.getSymbol());
    }

    @FXML
    void lable7Action(MouseEvent event) {
        setTextOnlable(lable7, 6, 1, Utils.getSymbol());
    }

    @FXML
    void lable8Action(MouseEvent event) {
        setTextOnlable(lable8, 7, 1, Utils.getSymbol());

    }

    @FXML
    void lable9Action(MouseEvent event) {
        setTextOnlable(lable9, 8, 1, Utils.getSymbol());

    }

    // check winner
    public boolean checkWinner() {
        if (counter >= 8) {
            recordObj.marchal();
            newGame("no one win!");

            return true;
        } else {
            if ((game_arr[0] == 1 && game_arr[1] == 1 && game_arr[2] == 1)
                    || (game_arr[3] == 1 && game_arr[4] == 1 && game_arr[5] == 1)
                    || (game_arr[6] == 1 && game_arr[7] == 1 && game_arr[8] == 1)
                    || (game_arr[0] == 1 && game_arr[4] == 1 && game_arr[8] == 1)
                    || (game_arr[2] == 1 && game_arr[4] == 1 && game_arr[6] == 1)
                    || (game_arr[0] == 1 && game_arr[3] == 1 && game_arr[6] == 1)
                    || (game_arr[1] == 1 && game_arr[4] == 1 && game_arr[7] == 1)
                    || (game_arr[2] == 1 && game_arr[5] == 1 && game_arr[8] == 1)) {
                recordObj.marchal();
                newGame("congratulation you win! ");
                try {
                    accountHandler.increaseWinnerScore(Utils.getCurrentUser().getEmailAddress());
                } catch (RemoteException ex) {
                    Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
                }

                return true;

            } else if ((game_arr[0] == 2 && game_arr[1] == 2 && game_arr[2] == 2)
                    || (game_arr[3] == 2 && game_arr[4] == 2 && game_arr[5] == 2)
                    || (game_arr[6] == 2 && game_arr[7] == 2 && game_arr[8] == 2)
                    || (game_arr[0] == 2 && game_arr[4] == 2 && game_arr[8] == 2)
                    || (game_arr[2] == 2 && game_arr[4] == 2 && game_arr[6] == 2)
                    || (game_arr[0] == 2 && game_arr[3] == 2 && game_arr[6] == 2)
                    || (game_arr[1] == 2 && game_arr[4] == 2 && game_arr[7] == 2)
                    || (game_arr[2] == 2 && game_arr[5] == 2 && game_arr[8] == 2)) {
                System.out.println("sorry you lose ");
                recordObj.marchal();
                newGame("you lose!");
                try {
                    accountHandler.increaseWinnerScore(Utils.getlPayer().getEmailAddress());
                } catch (RemoteException ex) {
                    Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }
        return false;
    }

    @FXML
    void imgViewAction(MouseEvent event) {

        try {
            UserAccountHandler accountHandler1 = Utils.establishConnection();
            onlineUsersList = accountHandler1.getOnlinePlayers();
            list = FXCollections.observableArrayList(onlineUsersList);

            //remove current user from list
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmailAddress().equals(Utils.getCurrentUser().getEmailAddress())) {

                    list.remove(i);
                }
            }
            listView.setItems(list);
            GridPane pane = new GridPane();
            Label name = new Label("gg");
            Button btn = new Button("dd");
            pane.add(name, 0, 0);
            pane.add(btn, 0, 1);
            listView.setCellFactory(param -> new UserListAdapter());
        } catch (RemoteException | NotBoundException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void drawStep(int position, String symbol) {
        switch (position) {
            case 0:
                setTextOnlable(lable1, position, 2, symbol);
                break;
            case 1:
                setTextOnlable(lable2, position, 2, symbol);

                break;
            case 2:
                setTextOnlable(lable3, position, 2, symbol);

                break;
            case 3:
                setTextOnlable(lable4, position, 2, symbol);

                break;
            case 4:
                setTextOnlable(lable5, position, 2, symbol);
                break;
            case 5:
                setTextOnlable(lable6, position, 2, symbol);
                break;
            case 6:
                setTextOnlable(lable7, position, 2, symbol);
                break;
            case 7:
                setTextOnlable(lable8, position, 2, symbol);
                break;
            case 8:
                setTextOnlable(lable9, position, 2, symbol);
                break;
        }
    }

    public static MultiModeController getInstance() {
        return m;
    }

    @FXML
    void btnSendMessageClicked(ActionEvent event) {
        String message;

        try {
            accountHandler = Utils.establishConnection();
            message = txtFieldChat.getText();
            accountHandler.sendMessage(Utils.getCurrentUser(), Utils.getlPayer(), message);
            txtFieldChat.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MultiModeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void playRecord(int x, String symbol) {

        System.out.println(x);

        switch (x) {
            case 0:
                lable1.setText(symbol);
                break;
            case 1:

                lable2.setText(symbol);
                break;
            case 2:

                lable3.setText(symbol);
                break;
            case 3:

                lable4.setText(symbol);
                break;
            case 4:

                lable5.setText(symbol);
                break;
            case 5:

                lable6.setText(symbol);
                break;
            case 6:

                lable7.setText(symbol);
                break;
            case 7:

                lable8.setText(symbol);
                break;
            case 8:

                lable9.setText(symbol);
                break;
        }

    }

    public void displayRecord() {
        recordObj.unmarchal();
        final ArrayList<MoveContent> playrecord = recordObj.playRecord();
        clearGrid();
        new AnimationTimer() {
            int i = 0;
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 700_000_000) {

                    playRecord(recordObj.playRecord().get(i).getPosition(), playrecord.get(i).getDraw());
                    i++;
                    if (i >= playrecord.size()) {
                        stop();
                    }
                    lastUpdate = now;
                }
            }
        }.start();

    }

    @FXML
    void btnEndGameAction(ActionEvent event) {
        try {
          //end game
          //update other player score (not done)
            accountHandler.closeGame(Utils.getCurrentUser(), Utils.getlPayer());
            accountHandler.increaseWinnerScore(Utils.getlPayer().getEmailAddress());
        } catch (Exception ex) {
         System.out.println("remote ex");
        }

    }
    
    public void refreshListt()
    {
       try {
            onlineUsersList = accountHandler.getOnlinePlayers();
            list = FXCollections.observableArrayList(onlineUsersList);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getEmailAddress().equals(Utils.getCurrentUser().getEmailAddress())) {
                    System.out.println(list.get(i).getEmailAddress());

                    list.remove(i);
                }
                System.out.println("i = " + i);
            }

        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        listView.setItems(list);
       // listView.getItems().remove(Utils.getCurrentUser());
        GridPane pane = new GridPane();
        Label name = new Label("gg");
        Button btn = new Button("dd");
        pane.add(name, 0, 0);
        pane.add(btn, 0, 1);
        listView.setCellFactory(param -> new UserListAdapter());
        myGridPane.setVisible(false);
    }
}