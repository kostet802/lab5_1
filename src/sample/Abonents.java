package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class Abonents implements Serializable {
    ObservableList<Abonent> ab = FXCollections.observableArrayList();
}
