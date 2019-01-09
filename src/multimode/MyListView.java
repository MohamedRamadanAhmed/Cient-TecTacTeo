package multimode;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class MyListView extends AnchorPane {

    public MyListView(Stage PrimaryStage) {
    
    ObservableList<String> names = FXCollections
        .observableArrayList();
    ObservableList<String> data = FXCollections.observableArrayList();
    ListView<String> listView = new ListView<String>(data);
    listView.setPrefSize(200, 250);
    listView.setEditable(true);
    names.addAll("A", "B", "C", "D", "E");
    data.add("Double Click to Select Value");
    listView.setItems(data);
    listView.setCellFactory(ComboBoxListCell.forListView(names));

    StackPane root = new StackPane();
    root.getChildren().add(listView);
    PrimaryStage.setScene(new Scene(root, 200, 250));
    PrimaryStage.show();
  }
}


