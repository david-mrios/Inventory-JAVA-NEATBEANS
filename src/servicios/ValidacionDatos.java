/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author lnarvaezb
 */
public class ValidacionDatos {
    
    private ArrayList<Object> data;
    private Object tipo;
    private String valEsperado;
    private int minLength;
    private int maxLength;
    
    public ValidacionDatos ()
    {
        this.data = new ArrayList(); //Inicializar el ArrayList
    }
    //Constructor con parámetros
    public ValidacionDatos (ArrayList data) {
       this.data = data;
    }//Fin del constructor
    
    /**
     * Verifica que el contenido no este blanco ni contenga espacios,además 
     * cumpla con un longitud minima y maxima.
     * @param txt Objeto contenedor de texto a validar (TextField)
     * @param min Tamaño de longitud minima que debe tener la cadena ingresada
     * @param max Tamaño de longitud máxima que debe tener la cadena de texto
     * @return verdadero si se han cumplido los criterios
     */
    public static boolean isTextFieldValid (Object obj, String txt, int min, 
                                           int max)
    {
        boolean valido = true; //Se indica que serán validos los datos
        if (txt.isBlank() || txt.length() < min ||
            txt.length() > max){
            JTextField field = (JTextField) obj;
            field.setBackground(Color.red);
            valido = false; //El campo ya no es valido, mejor salir               
        }//Fin de condicional
        return valido; 
    }//Fin método
    
    public static boolean isNumValido (JTextField txt) {
        
        if (txt.getText().isBlank()){
            txt.setBackground(Color.red);
            return false; //Salir porque no se ha digitado un valor
        }
        else {
             try {
                 Integer.parseInt(txt.getText());
                 return true;
             }
             catch (NumberFormatException err){
                return false; //El valor en la caja no cumple con un val numero
             }//Fin de la instrucción catch                 
        }//Fin de la instrucción else 
    }//Fin método




}//Fin de la clase
