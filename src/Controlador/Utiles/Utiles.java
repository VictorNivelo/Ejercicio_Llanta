/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Utiles;

import java.lang.reflect.Field;

/**
 *
 * @author Victor
 */
public class Utiles {
    public static String capitalizar(String nombre){
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String (aux);
    }
    
    public static Field obtenerAtributo(Class clase, String nombre){ //Devuelve que tipo de dato es el atributo enviado
        Field atributo = null;
        for(Field aux : clase.getDeclaredFields()){
            if(nombre.equalsIgnoreCase(aux.getName())){
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
    
    public static Object transformarDato(Field atributo, String dato){
        Object transformar = null;
        if(atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")){
            if(atributo.getType().getSimpleName().equals("Integer")){
                transformar = Integer.parseInt(dato);
            }
        } else if(atributo.getType().isEnum()){
            Enum enumeracion = Enum.valueOf((Class)atributo.getType(), dato.toString());
            transformar = enumeracion;
        } else if(atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")){
            transformar =  Boolean.parseBoolean(dato);
        }
        else{
            transformar = dato;
        }
        return transformar;
    }
    
    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        cedula = (cedula.length()==13) ? cedula.substring(0,10) : cedula;

        try {

            if (cedula.length() == 10)
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {

                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }
    
}
