/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.utilidades;

import Controlador.Persona.EscuelaDao;
import Controlador.TDA.Grafos.Excepcion.VerticeException;
import Controlador.TDA.Grafos.GrafoDirigidoEtiquetado;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.Exepcion.ListaVacia;
import Controlador.TDA.Lista.ListaDinamica;
import java.io.FileWriter;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilesVista {
    
    public static void crearMapaEscuela(GrafoDirigidoEtiquetado<Escuela> ge) throws VerticeException, Exception {
        String maps = "var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',\n"
                + "                    osmAttrib = '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors',\n"
                + "                    osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});\n"
                + "\n"
                + "            var map = L.map('map').setView([-4.036, -79.201], 15);\n"
                + "\n"
                + "            L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {\n"
                + "                attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n"
                + "            }).addTo(map);" + "\n";
        for (int i = 1; i <= ge.num_vertice(); i++) {
            Escuela ec = ge.getEtiquetaE(i);
            maps += "L.marker([" + ec.getCordenadaEscuela().getLatitud() + ", " + ec.getCordenadaEscuela().getLongitud() + "]).addTo(map)";
            maps += ".bindPopup(\"" + ec.toString() + "\")" + "\n";
            maps += ".openPopup();" + "\n";
        }
        FileWriter file = new FileWriter("mapas/mapa.js");
        file.write(maps);
        file.close();
    }
    
    public static void CargarComboEscuela(JComboBox cbx) throws ListaVacia{
        cbx.removeAllItems();
        ListaDinamica<Escuela> listE = new EscuelaDao().getListaEscuelas();
        for(int i = 0 ; i< listE.getLongitud(); i++){
            cbx.addItem(listE.getInfo(i));
        }
    }
    
    public static double coordGpsToKm(double lat1, double lon1, double lat2, double lon2) {
        double lat1rad = Math.toRadians(lat1);
        double lon1rad = Math.toRadians(lon1);
        double lat2rad = Math.toRadians(lat2);
        double lon2rad = Math.toRadians(lon2);

        double difLatitud = lat1rad - lat2rad;
        double difLongitud = lon1rad - lon2rad;

        double a = Math.pow(Math.sin(difLatitud / 2), 2)  + Math.cos(lat1rad)
                * Math.cos(lat2rad)* Math.pow(Math.sin(difLongitud / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double radioTierraKm = 6378.0;
        double distancia = radioTierraKm * c;

        return distancia;
    }
    
    public static Double redondear(Double x){
        Double d = Math.round(x *100.0)/100.0;
        return d;
    }
    
    public static Double CalcularDistanciaE(Escuela Origen, Escuela Destino){
        Double dist = UtilesVista.coordGpsToKm(Origen.getCordenadaEscuela().getLatitud(), Origen.getCordenadaEscuela().getLongitud(),
                Destino.getCordenadaEscuela().getLatitud(), Destino.getCordenadaEscuela().getLongitud());
        return dist;
    }
    
}
