
package br.edu.fesa.vaievem.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.UnaryOperator;
import javafx.scene.control.TextFormatter;

public class FormatString {
    
    public static String formataDecimal(Float numero){
        Locale localizacao = new Locale("pt", "BR");

        DecimalFormat formato = (DecimalFormat) NumberFormat.getNumberInstance(localizacao);
        formato.applyPattern("0.00");
        return formato.format(numero);
    }
    
    public static String formataDecimal(Double numero){
        Locale localizacao = new Locale("pt", "BR");

        DecimalFormat formato = (DecimalFormat) NumberFormat.getNumberInstance(localizacao);
        formato.applyPattern("0.00");
        return formato.format(numero);
    }
    
    public static TextFormatter<Float> formataInputDouble(){
        return new TextFormatter<Float>(FormatString.getMonetarioFilter());
    }
    
    private static UnaryOperator<TextFormatter.Change> getMonetarioFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*\\.?\\d{0,2}")) { // Permite dígitos, ponto e até duas casas decimais
                return change;
            }
            return null; // Rejeita a mudança se a entrada não corresponder ao padrão
        };
    }
    
    public static TextFormatter<Integer> formataInputInteger(){
        return new TextFormatter<Integer>(FormatString.getIntegerFilter());
    }
    
    private static UnaryOperator<TextFormatter.Change> getIntegerFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) { // Permite dígitos, ponto e até duas casas decimais
                return change;
            }
            return null; // Rejeita a mudança se a entrada não corresponder ao padrão
        };
    }
    
    public static TextFormatter<Integer> formataInputDay(){
        return new TextFormatter<Integer>(FormatString.getDayFilter());
    }
    
    private static UnaryOperator<TextFormatter.Change> getDayFilter() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d{0,2}")) { // Permite dígitos, ponto e até duas casas decimais
                return change;
            }
            return null; // Rejeita a mudança se a entrada não corresponder ao padrão
        };
    }
    
}
