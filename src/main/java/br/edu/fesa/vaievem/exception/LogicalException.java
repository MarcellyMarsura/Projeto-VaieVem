
package br.edu.fesa.vaievem.exception;

import java.io.PrintStream;
import java.io.PrintWriter;


public class LogicalException extends Exception {

    public LogicalException() {
    }

    public LogicalException(String message) {
        super(message);
    }
    
    public LogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicalException(Throwable cause) {
        super(cause);
    }

    public LogicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getMessage() {
        return super.getMessage(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}