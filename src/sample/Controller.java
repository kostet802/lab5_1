package sample;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {
    @FXML
    private TextField fieldNumber;
    @FXML
    private TextField fieldFio;
    @FXML
    private TextField fieldAdress;
    @FXML
    private TextField fieldOperator;
    @FXML
    private Label lblAdvise;
    @FXML
    private Label lblAlert;
    @FXML
    private TextArea fieldResult;
    @FXML
    private ComboBox cbOperator = new ComboBox();
    @FXML
    private void initialize(){
        fileOper.deserialise(abonent);
        for (int i = 0; i < abonent.ab.size(); i++) {
            fieldResult.setText(abonent.ab.get(i).toString());
        }
        cbOperator.setItems(FXCollections.observableArrayList("Poisk nomer", "Poisk familia","Svobodnye nomera"));
        cbOperator.setOnAction(event -> {
            if(cbOperator.getSelectionModel().isSelected(0)) lblAdvise.setText("Enter nomer");
            if(cbOperator.getSelectionModel().isSelected(1)) lblAdvise.setText("Enter familia");
            if(cbOperator.getSelectionModel().isSelected(2)) lblAdvise.setText("Press select");
        });
    }
    public Controller() {
    }

    Abonents abonent = new Abonents();
    FileOper fileOper = new FileOper();


    public void onAdd() {
        try {
            if (!fieldNumber.getText().isEmpty() && !fieldFio.getText().isEmpty() && !fieldAdress.getText().isEmpty()) {
                if(Integer.parseInt(fieldNumber.getText()) <= 0) throw new IllegalArgumentException("Incorrect input");
                abonent.ab.add(new Abonent(fieldFio.getText(), Integer.parseInt(fieldNumber.getText()), fieldAdress.getText()));
            }
        }catch (NumberFormatException e){lblAlert.setText("Incorrect input");}
        catch (IllegalArgumentException e) {lblAlert.setText(e.getMessage());}
        fieldFio.setText("");
        fieldNumber.setText("");
        fieldAdress.setText("");
    }
    public void onSave(){
        if(abonent.ab.size() > 0){
            fileOper.serialise(abonent);
        }
    }
    public void onSelection(){
        if(cbOperator.getSelectionModel().isSelected(0)){
            fieldResult.clear();

            if (abonent.ab.size() > 0) {
                boolean k = false;
                for (int i = 0; i < abonent.ab.size(); i++) {
                    if (Integer.parseInt(fieldOperator.getText()) == abonent.ab.get(i).getNumber()) {
                        fieldResult.setText(abonent.ab.get(i).toString());
                        k = true;
                    }
                }
                for (int i = 0; i < abonent.ab.size(); i++) {
                    fieldResult.setText(abonent.ab.get(i).toString());
                }
                if (!k) System.out.println("No abonents in such number");
            } else System.out.println("No abonents in database");
            fieldOperator.clear();
        }
        if(cbOperator.getSelectionModel().isSelected(1)){
            fieldResult.clear();

            if (abonent.ab.size() > 0) {
                boolean k = false;
                for (int i = 0; i < abonent.ab.size(); i++) {
                    if (fieldOperator.getText() == abonent.ab.get(i).getFio()) {
                        fieldResult.setText(abonent.ab.get(i).toString());
                        k = true;
                    }
                }
                for (int i = 0; i < abonent.ab.size(); i++) {
                    fieldResult.setText(abonent.ab.get(i).toString());
                }
                if (!k) System.out.println("");
            } else fieldResult.setText("Void");
            fieldOperator.clear();
        }

        if(cbOperator.getSelectionModel().isSelected(2)){
            fieldResult.clear();
                int min = 100000;
                int max = 900000;
                int diff = max - min;
                Random random = new Random();
                int random1 = random.nextInt(diff + 1);
                random1 += min;
                fieldResult.setText(Integer.toString(random1));

            }
            fieldOperator.clear();
    }}




