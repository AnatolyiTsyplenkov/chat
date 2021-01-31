package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Controller {

    private final ObservableList<String> usersList = FXCollections.observableArrayList("Иванов Иван", "Сидоров Петр");
    @FXML
    Label label = new Label("Название чата");
    @FXML
    private TextField inputField;
    @FXML
    private ListView<String> usersListView;
    @FXML
    private TextArea chatHistory;

    @FXML
    void initialize() {
        usersListView.setItems(usersList);
    }

    @FXML
    void sendMessage() {
        String message = inputField.getText().trim();
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yy HH:mm");

        if (message.length() != 0) {
            chatHistory.appendText("Я: <" + formatForDateNow.format(dateNow) + ">    " + message);
            chatHistory.appendText(System.lineSeparator());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ОШИБКА");
            alert.setContentText("Нельзя отправлять пустое сообщение!");
            alert.show();
        }
        inputField.clear();

    }

    @FXML
    void clickOnUser() {

    }

    @FXML
    void showAbout() {
        System.out.println("about");
    }

    @FXML
    void exit() {
        System.exit(0);
    }
}
