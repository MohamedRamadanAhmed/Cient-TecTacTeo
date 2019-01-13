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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import main.XMLRecord;
import utils.Utils;

public class MultiModeController implements Initializable {

    UserAccountHandler accountHandler = null;
    boolean isMyTurnToplay = false;
    int[] game_arr = new int[9];

    @FXML
    public  Label lable1;
    
    @FXML
    private Button btnRefresh;

    @FXML
    public Label lable4;

    @FXML
    public Label lable7;

    @FXML
    public Label lable2;

    @FXML
    public Label lable5;

    @FXML
    public Label lable8;

    @FXML
    public Label lable3;

    @FXML
    public Label lable6;

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
    Utils util = new Utils();
    public ObservableList<UserModel> mylistview;
    UserAccountHandler accountHandler1;
    UserModel model;
    List<UserModel> list ;
   

    public MultiModeController() {
        try {
            accountHandler1 = Utils.establishConnection();

        } catch (RemoteException ex) {
            util.missingConnection();
        } catch (NotBoundException ex) {
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

    class Cell extends ListCell<UserModel> {

        HBox hbox = new HBox();
        Button btn = new Button("Delete");
        Label label = new Label("");
        Pane pane = new Pane();

        //  Image profile = new Image("images/tic-tac-toe.png");
        // ImageView img = new ImageView(profile);
        public Cell() {
            super();
            new MultiModeController();
            hbox.getChildren().addAll(label, pane, btn);
            hbox.setHgrow(pane, Priority.ALWAYS);
            listView.setOnMouseClicked(event -> {
                try {
                    model = listView.getSelectionModel().getSelectedItem();
                    Utils.setPlayer(model);

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
            UserAccountHandler accountHandler1 = Utils.establishConnection();
            list = accountHandler1.getOnlinePlayer();

            mylistview = FXCollections.observableArrayList(list);

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
        myGridPane.setVisible(false);

    }

    @FXML
    public void startGameAction(ActionEvent event) {
        //  myGridPane.setVisible(false);

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
        Utils.switchWindow(FXMLLoader.load(getClass().getResource("/choosemode/SelectMode.fxml")));

    }

    @FXML
    void logOutAction(ActionEvent event) throws RemoteException, IOException, NotBoundException {
        try {

            if (MyControoler.logOut()) {
                System.out.println(MyControoler.logOut()+"xxx");

                Utils.switchWindow(FXMLLoader.load(getClass().getResource("/choosemode/SelectMode.fxml")));

            } else {
                util.missingConnection();
            }
        } catch (RemoteException | NotBoundException ex) {
            util.missingConnection();

        }
    }

    @FXML
    void lable1Action(MouseEvent event) {
        lable1.setText("x");
        MyControoler.transmitMove(0, "x", Utils.getlayer());

    }

    @FXML
    void lable2Action(MouseEvent event) {
        lable2.setText("x");
        MyControoler.transmitMove(1, "x", Utils.getlayer());

    }

    @FXML
    void lable3Action(MouseEvent event) {
        lable3.setText("x");
        MyControoler.transmitMove(2, "x", Utils.getlayer());

    }

    @FXML
    void lable4Action(MouseEvent event) {
        lable4.setText("x");
        MyControoler.transmitMove(3, "x", Utils.getlayer());
    }

    @FXML
    void lable5Action(MouseEvent event) {
        lable5.setText("x");
        MyControoler.transmitMove(4, "x", Utils.getlayer());

    }

    @FXML
    void lable6Action(MouseEvent event) {
        lable6.setText("x");
        MyControoler.transmitMove(5, "x", Utils.getlayer());

    }

    @FXML
    void lable7Action(MouseEvent event) {
        lable7.setText("x");
        MyControoler.transmitMove(6, "x", Utils.getlayer());

    }

    @FXML
    void lable8Action(MouseEvent event) {
        lable8.setText("x");
        MyControoler.transmitMove(7, "x", Utils.getlayer());

    }

    @FXML
    void lable9Action(MouseEvent event) {
        lable9.setText("x");
        MyControoler.transmitMove(8, "x", Utils.getlayer());

    }

    public boolean checkWining() {
        if ((game_arr[0] == 1 && game_arr[1] == 1 && game_arr[2] == 1)|| (game_arr[3] == 1 && game_arr[4] == 1 && game_arr[5] == 1)
                || (game_arr[6] == 1 && game_arr[7] == 1 && game_arr[8] == 1)
                || (game_arr[0] == 1 && game_arr[4] == 1 && game_arr[8] == 1)
                || (game_arr[2] == 1 && game_arr[4] == 1 && game_arr[6] == 1)
                || (game_arr[0] == 1 && game_arr[3] == 1 && game_arr[6] == 1)
                || (game_arr[1] == 1 && game_arr[4] == 1 && game_arr[7] == 1)
                || (game_arr[2] == 1 && game_arr[5] == 1 && game_arr[8] == 1)) {
            System.out.println("X is Winning");

            return true;
        } else {
            if ((game_arr[0] == 2 && game_arr[1] == 2 && game_arr[2] == 2)
                    || (game_arr[3] == 2 && game_arr[4] == 2 && game_arr[5] == 2)
                    || (game_arr[6] == 2 && game_arr[7] == 2 && game_arr[8] == 2)
                    || (game_arr[0] == 2 && game_arr[4] == 2 && game_arr[8] == 2)
                    || (game_arr[2] == 2 && game_arr[4] == 2 && game_arr[6] == 2)
                    || (game_arr[0] == 2 && game_arr[3] == 2 && game_arr[6] == 2)
                    || (game_arr[1] == 2 && game_arr[4] == 2 && game_arr[7] == 2)
                    || (game_arr[2] == 2 && game_arr[5] == 2 && game_arr[8] == 2)) {
                System.out.println("O is Winning");
                return true;
            }
        }
        return false;
    }
    
    
    @FXML
    void btnRefreshAction(MouseEvent event) {
        System.out.println("btn refreshh was clicked");
        
//         try {
//            UserAccountHandler accountHandler1 = Utils.establishConnection();
//            list = accountHandler1.getOnlinePlayer();
//
//            mylistview = FXCollections.observableArrayList(list);
//
//        } catch (RemoteException | NotBoundException ex) {
//            System.err.println(ex.getMessage());
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//        }
//
////        myGridPane.setVisible(false);
//        listView.setItems(mylistview);
//        GridPane pane = new GridPane();
//        Label name = new Label("gg");
//        Button btn = new Button("dd");
//        pane.add(name, 0, 0);
//        pane.add(btn, 0, 1);
//        listView.setCellFactory(param -> new Cell());
//
    }
    
}
