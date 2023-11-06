/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.utils;

import java.text.DecimalFormat;

/**
 *
 * @author m.molinari.marsura
 */
public class FormatString {
    
    public static String formataDecimal(Long numero){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(numero);
    }
    
}
