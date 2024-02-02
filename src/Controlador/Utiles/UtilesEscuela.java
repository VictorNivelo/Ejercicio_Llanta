/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Utiles;

import Controlador.Persona.EscuelaDao;
import Controlador.TDA.Grafos.GrafoDirigidoEtiquetado;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.ListaDinamica;
import java.io.FileWriter;
import javax.swing.JComboBox;

/**
 *
 * @author Victor
 */
public class UtilesEscuela {
    public static void crearMapaEscuela(GrafoDirigidoEtiquetado<Escuela> ge) throws Exception {
        String maps = "var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',\n"
                + "                    osmAttrib = '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors',\n"
                + "                    osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});\n"
                + "\n"
                + "            var map = L.map('map').setView([-4.036, -79.201], 15);\n"
                + "\n"
                + "            L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {\n"
                + "                attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n"
                + "            }).addTo(map); + \n";

        for (int i = 1; i <= ge.num_vertice(); i++) {
            Escuela ec = ge.getEtiquetaE(i);
            maps += "L.marker([" + ec.getCordenadaEscuela().getLongitud()+ ", " + ec.getCordenadaEscuela().getLatitud()+ "]).addTo(map)\n";
            maps += ".bindPopup('" + ec.toString() + "')\n";
            maps += ".openPopup();";
        }
        FileWriter file = new FileWriter("mapas/mapa.js");
        file.write(maps);
        file.close();

//        L.marker([-4.045, -79.2015]).addTo(map)
//                    .bindPopup('1.')
//                    .openPopup();
    }

    public static void cargarComboEscuela(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        ListaDinamica<Escuela> list = new EscuelaDao().getListaEscuela();
        for (int i = 0; i < list.getLongitud(); i++) {
            cbx.addItem(list.getInfo(i));
        }
    }

    public static Double calcularDistanciaEscuelas(Escuela o, Escuela d) {
        Double dist = Utiles.coordGpsToKm(o.getCordenadaEscuela().getLatitud(), o.getCordenadaEscuela().getLongitud(),
                                          d.getCordenadaEscuela().getLatitud(), d.getCordenadaEscuela().getLongitud());
        return redondear(dist);
    }
    
    public static Double redondear(Double x){
        Double d = Math.round(x *100.0)/100.0;
        return d;
    }
}
