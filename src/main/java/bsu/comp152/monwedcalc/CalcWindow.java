package bsu.comp152.monwedcalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalcWindow {
    private long firstNumber;
    private OperatorType operation;

    @FXML
    private TextField numberField;

    @FXML
    public void numberButtonPressed(ActionEvent event) {
        var pressedButton = (Button)event.getSource();
        var buttonText = pressedButton.getText();
        var currentNumberText = numberField.getText();
        numberField.setText(currentNumberText + buttonText);
    }

    @FXML
    public void clearButtonPressed() {
        numberField.clear();
    }

    @FXML
    public void addButtonPressed() {
        firstNumber = Long.parseLong(numberField.getText());
        numberField.setText(""); //Just a different way to clear text
        operation = OperatorType.ADD;
    }

    @FXML
    public void subtractButtonPressed() {
        firstNumber = Long.parseLong(numberField.getText());
        numberField.setText("");
        operation = OperatorType.SUBTRACT;
    }

    @FXML
    public void multiplyButtonPressed() {
        firstNumber = Long.parseLong(numberField.getText());
        numberField.setText("");
        operation = OperatorType.MULTIPLY;
    }

    @FXML
    public void divideButtonPressed() {
        firstNumber = Long.parseLong(numberField.getText());
        numberField.setText("");
        operation = OperatorType.DIVIDE;
    }

    @FXML
    public void equalsButtonPressed() {
        var secondNumber = Long.parseLong(numberField.getText());
        var result = 0.0;
        switch (operation) {
            case ADD -> result = (firstNumber + secondNumber);
            case SUBTRACT -> result = (firstNumber - secondNumber);
            case MULTIPLY -> result = (firstNumber * secondNumber);
            case DIVIDE -> result = ((double)firstNumber / secondNumber);
        }
        numberField.setText("" + result);
    }
}
