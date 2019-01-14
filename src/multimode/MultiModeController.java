package multimode;

import client.server.remote.interfaces.Step;
import client.server.remote.interfaces.UserAccountHandler;
import client.server.remote.interfaces.UserModel;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javax.swing.JOptionPane;
import model.ClintImp;
import model.TicTacTocGame;
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
    public GridPane myGridPane;
    @FXML
    private JFXListView<UserModel> listView;
    String s;

    boolean isMyTurnToplay = false;
    int[] game_arr = new int[9];
    private Image offline;
    Utils util = new Utils();
    public ObservableList<UserModel> mylistview;
    UserModel model;
    List<UserModel> onlineUsersList;
    MyControoler controoler;

    private Step step;
    private UserAccountHandler accountHandler;
    private String symbol = "x";
    private int position = 3;
    private SceneHandler handler;
    static MultiModeController m;

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

        new Thread(new Runnable() {
            @Override
            public void run() {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (Utils.isPlaying) {
                            myGridPane.setVisible(true);
                        } else {
                            System.out.println("NO ACTION ");
                        }
                    }
                });

            }
        }).start();

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
                            myGridPane.setVisible(true);
                        } else {
                            System.out.println("NO ACTION ");
                        }
                    }
                });

            }
        }).start();
    }

    class Cell extends ListCell<UserModel> {

        HBox hbox = new HBox();
        Button btn = new Button("Delete");
        Label label = new Label("");
        Pane pane = new Pane();

        public Cell() {
            hbox.getChildren().addAll(label, pane, btn);
            hbox.setHgrow(pane, Priority.ALWAYS);

            // clicking on list view to request another player to play 
            listView.setOnMouseClicked(event -> {

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
                                        System.out.println("NO ACTION ");
                                    }
                                }
                            });

                        }
                    }).start();
                    model = listView.getSelectionModel().getSelectedItem();
                    Utils.setPlayer(model);
                    Utils.setSymbol("x");
                    listView.setOnMouseClicked(null);

                    MyControoler.requestGame(Utils.getlayer());
                } catch (RemoteException ex) {
                    util.missingConnection();
                } catch (NotBoundException ex) {
                    util.missingConnection();
                } catch (NullPointerException ex) {
                    util.missingConnection();
                }

            }
            );
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (Utils.isPlaying) {
                                myGridPane.setVisible(true);
                            } else {
                                System.out.println("NO ACTION ");
                            }
                        }
                    });

                }
            }).start();

        }

        @Override
        protected void updateItem(UserModel item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);
            if (item != null && !empty) {
                label.setText(item.getUserName());
                setGraphic(hbox);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            onlineUsersList = accountHandler.getOnlinePlayer();
            mylistview = FXCollections.observableArrayList(onlineUsersList);

        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        listView.setItems(mylistview);
        GridPane pane = new GridPane();
        Label name = new Label("gg");
        Button btn = new Button("dd");
        pane.add(name, 0, 0);
        pane.add(btn, 0, 1);
        listView.setCellFactory(param -> new Cell());
        myGridPane.setVisible(false);
    }

    @FXML

    public void startGameAction(ActionEvent event) {
        startgame();
    }

    @FXML
    private void exitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void recordAction(ActionEvent event) {
    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        exit.getScene().getWindow().hide();
        handler.setScene("choosemode/SelectMode", "hg", 800, 800, true);
    }

    @FXML
    void logOutAction(ActionEvent event) throws RemoteException, IOException, NotBoundException {
        try {
            if (MyControoler.logOut()) {
                System.out.println(MyControoler.logOut() + "xxx");
                handler.setScene("/choosemode/SelectMode.fxml", "", 800, 800, true);
            } else {
                util.missingConnection();
            }
        } catch (RemoteException | NotBoundException ex) {
            util.missingConnection();

        }
    }

    void setTextOnlable(Label lable, int position, int i, String symbol) {
        if (game_arr[position] == 0 && i == 2) {
            game_arr[position] = i;
            lable.setText(symbol);
            if (!checkWining()) {
                Utils.isMyTurn = true;
            }

        } else if (i == 1) {
            if (game_arr[position] == 0 && Utils.isMyTurn == true) {
                game_arr[position] = i;
                lable.setText(symbol);
                Utils.isMyTurn = false;
                MyControoler.transmitMove(position, Utils.getSymbol(), Utils.getlayer());
                checkWining();
            }
        }

    }

    public void newGame(String msg) {

        int x = JOptionPane.showConfirmDialog(null, msg + "! play again ?");
        System.out.println(x + "");

        Parent root = null;
        if (x == 0) {
            try {
//                root = FXMLLoader.load(getClass().getResource("/singlemode/SingleMode.fxml"));
//                Utils.switchWindow(root);

                handler.setScene("/multimode/MultiMode.fxml", "hg", 800, 800, true);
            } catch (IOException ex) {
                Logger.getLogger(TicTacTocGame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        } else if (x == 1) {

            try {
                handler.setScene("/multimode/MultiMode.fxml", "hg", 800, 800, true);

//                root = FXMLLoader.load(getClass().getResource("/sinup/signup.fxml"));
//                Utils.switchWindow(root);
            } catch (IOException ex) {
            }
        }
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

    public boolean checkWining() throws RemoteException {
        if ((game_arr[0] == 1 && game_arr[1] == 1 && game_arr[2] == 1) || (game_arr[3] == 1 && game_arr[4] == 1 && game_arr[5] == 1)
                || (game_arr[6] == 1 && game_arr[7] == 1 && game_arr[8] == 1)
                || (game_arr[0] == 1 && game_arr[4] == 1 && game_arr[8] == 1)
                || (game_arr[2] == 1 && game_arr[4] == 1 && game_arr[6] == 1)
                || (game_arr[0] == 1 && game_arr[3] == 1 && game_arr[6] == 1)
                || (game_arr[1] == 1 && game_arr[4] == 1 && game_arr[7] == 1)
                || (game_arr[2] == 1 && game_arr[5] == 1 && game_arr[8] == 1)) {
            newGame("you win");
            accountHandler.increaseWinnerScore(Utils.getCurrentUser().getEmailAddress());

            return true;
        } else if ((game_arr[0] == 2 && game_arr[1] == 2 && game_arr[2] == 2)
                || (game_arr[3] == 2 && game_arr[4] == 2 && game_arr[5] == 2)
                || (game_arr[6] == 2 && game_arr[7] == 2 && game_arr[8] == 2)
                || (game_arr[0] == 2 && game_arr[4] == 2 && game_arr[8] == 2)
                || (game_arr[2] == 2 && game_arr[4] == 2 && game_arr[6] == 2)
                || (game_arr[0] == 2 && game_arr[3] == 2 && game_arr[6] == 2)
                || (game_arr[1] == 2 && game_arr[4] == 2 && game_arr[7] == 2)
                || (game_arr[2] == 2 && game_arr[5] == 2 && game_arr[8] == 2)) {
            accountHandler.increaseWinnerScore(Utils.getlayer().getEmailAddress());
            newGame("you lose");
            return true;
        }
        return false;
    }

    @FXML
    void btnRefreshAction(MouseEvent event) {
        System.out.println("btn refreshh was clicked");

        try {
            UserAccountHandler accountHandler1 = Utils.establishConnection();
            onlineUsersList = accountHandler1.getOnlinePlayer();

            mylistview = FXCollections.observableArrayList(onlineUsersList);

        } catch (RemoteException | NotBoundException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

//        myGridPane.setVisible(false);
        listView.setItems(mylistview);
        GridPane pane = new GridPane();
        Label name = new Label("gg");
        Button btn = new Button("dd");
        pane.add(name, 0, 0);
        pane.add(btn, 0, 1);
        listView.setCellFactory(param -> new Cell());

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
}
