module br.edu.fesa.vaievem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens br.edu.fesa.vaievem to javafx.fxml;
    exports br.edu.fesa.vaievem;
}
