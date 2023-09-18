module br.edu.fesa.vaievem {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.fesa.vaievem to javafx.fxml;
    exports br.edu.fesa.vaievem;
}
