/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Utiles;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Victor
 */
public class Utiles {
    
    private static Boolean stringLength(String string, int length) {
        if (string.length() == length)
            return true;
        return false;
    }

    private static byte sumDigits(byte[] digits) {
        byte verifier;
        byte sum = 0;
        for (byte i = 0; i < digits.length; i = (byte) (i + 2)) {
            verifier = (byte) (digits[i] * 2);
            if (verifier > 9)
                verifier = (byte) (verifier - 9);
            sum = (byte) (sum + verifier);
        }
        for (byte i = 1; i < digits.length; i = (byte) (i + 2)) {
            verifier = (byte) (digits[i] * 1);
            sum = (byte) (sum + verifier);
        }
        return (byte) ((sum - (sum % 10) + 10) - sum);
    }

    public static Boolean idCardEcuador(String idCard) {
        try {
            if (stringLength(idCard, 10)) {
                String[] data = idCard.split("");
                byte verifier = Byte.parseByte(data[0] + data[1]);
                byte[] digits = new byte[9];
                for (byte i = 0; i < 9; i++)
                    digits[i] = Byte.parseByte(data[i]);        
                if (verifier >= 1 && verifier <= 24) {
                    verifier = digits[2];
                    if (verifier <= 6) {
                        if (sumDigits(digits) == Byte.parseByte(data[9]))
                            return true;
                    }
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Field getField(Class clazz, String attribute) {
        Field field = null;
        for(Field f: clazz.getSuperclass().getDeclaredFields()) {
            System.out.println(f.getName()+" "+f.getType().getName());
            if(f.getName().equalsIgnoreCase(attribute)){
                field = f;
                break;
            }
        }
        for(Field f: clazz.getDeclaredFields()) {
            System.out.println(f.getName()+" "+f.getType().getName());
            if(f.getName().equalsIgnoreCase(attribute)){
                field = f;
                break;
            }
        }
        return field;
    }
    
    public static String getDirPoject() {
        return System.getProperty("user.dir");
    }
    
    public static String getOS() {
        return System.getProperty("os.name");
    }
    
    public static void abrirNavegadorPredeterminadorWindows(String url) throws Exception{
        
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", url);
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
    }
    
    public static void abrirNavegadorPredeterminadorLinux(String url) throws Exception{
        Runtime.getRuntime().exec("xdg-open " + url);
    }
    
    public static void abrirNavegadorPredeterminadorMacOsx(String url) throws Exception{
        Runtime.getRuntime().exec("open " + url);
    }
    
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
        } 
        else if(atributo.getType().isEnum()){
            Enum enumeracion = Enum.valueOf((Class)atributo.getType(), dato.toString());
            transformar = enumeracion;
        } 
        else if(atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")){
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
                    } 
                    else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } 
                    else {
                        cedulaCorrecta = false;
                    }
                } 
                else {
                    cedulaCorrecta = false;
                }
            } 
            else {
                cedulaCorrecta = false;
            }
        } 
        catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } 
        catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }
    
    public static double coordGpsToKm(double lat1, double lon1, double lat2, double lon2) {
        double lat1rad = Math.toRadians(lat1);
        double lon1rad = Math.toRadians(lon1);
        double lat2rad = Math.toRadians(lat2);
        double lon2rad = Math.toRadians(lon2);

        double difLatitud = lat1rad - lat2rad;
        double difLongitud = lon1rad - lon2rad;

        double a = Math.pow(Math.sin(difLatitud / 2), 2)
                + Math.cos(lat1rad)
                * Math.cos(lat2rad)
                * Math.pow(Math.sin(difLongitud / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double radioTierraKm = 6378.0;
        double distancia = radioTierraKm * c;

        return distancia;
    }
    
    
    public static void copiarArchivo(File origen, File destino) throws Exception {
        Files.copy(origen.toPath(),(destino).toPath(),StandardCopyOption.REPLACE_EXISTING);
    }
    
    public static String extension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
    

}
