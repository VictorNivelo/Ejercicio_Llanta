
package Controlador.TDA.Grafos;

import Controlador.TDA.Lista.ListaDinamica;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class DibujarGrafo {

    String URL = "d3/grafo.js";

    public void updateFile(Grafo graph) throws Exception {
        
        String nodes = "var nodes = new vis.DataSet([\n";
        for (int i = 1; i <= graph.num_vertice(); i++) {
            nodes += "{ id: " + i + ", label: \"Node " + i + "\" },\n";
        }
        nodes += "]);\n\n";
        
        String edges = "var edges = new vis.DataSet([\n";
        for (int i = 1; i <= graph.num_vertice(); i++) {
            ListaDinamica<Adyacencia> adyacentes = graph.adycentes(i);
            for (int j = 0; j < adyacentes.getLongitud(); j++) {
                Adyacencia adyacencia = adyacentes.getInfo(j);
                edges += "{ from: " + i + ", to: " + adyacencia.getDestino() + " },\n";
            }
        }
        edges += "]);\n\n";
        
        String paint = nodes + edges +
                "var container = document.getElementById(\"mynetwork\");\n" +
                "var data = {\n" +
                "  nodes: nodes,\n" +
                "  edges: edges,\n" +
                "};\n" +
                "var options = {};\n" +
                "var network = new vis.Network(container, data, options);";
        
        FileWriter load = new FileWriter(URL);
        load.write(paint);
        load.close();
    }
    
    public void updateFile(GrafoDirigidoEtiquetado graph) throws IOException, Exception {
        
        String nodes = "var nodes = new vis.DataSet([\n";
        for (int i = 1; i <= graph.num_vertice(); i++) {
            nodes += "{ id: " + i + ", label: \" " + graph.getEtiquetaE(i) + "\" },\n";
        }
        nodes += "]);\n\n";
        
        String edges = "var edges = new vis.DataSet([\n";
        for (int i = 1; i <= graph.num_vertice(); i++) {
            ListaDinamica<Adyacencia> adyacentes = graph.adjacents(i);
            for (int j = 0; j < adyacentes.getLongitud(); j++) {
                Adyacencia adyacencia = adyacentes.getInfo(j);
                edges += "{ from: " + i + ", to: " + adyacencia.getDestino() + ", label: \"" + adyacencia.getPeso() +"\" },\n";
            }
        }
        edges += "]);\n\n";
        
        String paint = nodes + edges +
                "var container = document.getElementById(\"mynetwork\");\n" +
                "var data = {\n" +
                "  nodes: nodes,\n" +
                "  edges: edges,\n" +
                "};\n" +
                "var options = {};\n" +
                "var network = new vis.Network(container, data, options);";
        
        FileWriter load = new FileWriter(URL);
        load.write(paint);
        load.close();
    }
}
//        StringBuilder paint = new StringBuilder();
//
//        paint.append("var nodes = [");
//        
//        for (int i = 1; i <= graph.num_vertice(); i++) {
//            paint.append("{id: ").append(i).append(", label: 'V").append(i).append("'},");
//        }
//        
//        paint.append("];\n");
//
//        paint.append("var edges = [");
//        
//        for (int i = 1; i <= graph.num_vertice(); i++) {
//            try {
//                ListaDinamica<Adyacencia> list = graph.adycentes(i);
//                for (int j = 0; j < list.getLongitud(); j++) {
//                    Adyacencia a = list.getInfo(j);
//                    paint.append("{from: ").append(i).append(", to: ").append(a.getDestino());
//                    if (!Double.isNaN(a.getPeso())) {
//                        paint.append(", label: '").append(a.getPeso()).append("'");
//                    }
//                    paint.append("},");
//                }
//            } 
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        
//        paint.append("];\n");
//
//        paint.append("var container = document.getElementById(\"mynetwork\");\n");
//        paint.append("var data = {\n");
//        paint.append("  nodes: nodes,\n");
//        paint.append("  edges: edges,\n");
//        paint.append("};\n");
//        paint.append("var options = {};\n");
//        paint.append("var network = new vis.Network(container, data, options);");
//
//        FileWriter load = new FileWriter(URL);
//        load.write(paint.toString());
//        load.close();
//    }
//}
//        
//        StringBuilder paint = new StringBuilder();
//
//        paint.append("var container = document.getElementById(\"mynetwork\");\n");
//        paint.append("var data = {\n");
//        paint.append("  nodes: [");
//
//        // Agregar información de nodos
//
//        paint.append("],\n");
//        paint.append("  edges: [");
//
//        // Agregar información de aristas
//
//        paint.append("]\n");
//        paint.append("};\n");
//        paint.append("var options = {};\n");
//        paint.append("var network = new vis.Network(container, data, options);");
//
//        FileWriter load = new FileWriter(URL);
//        load.write(paint.toString());
//        load.close();

//        String paint = "";
//
//        paint += "var container = document.getElementById(\"mynetwork\");\n"
//                + "      var data = {\n"
//                + "        nodes: nodes,\n"
//                + "        edges: edges,\n"
//                + "      };\n"
//                + "      var options = {};\n"
//                + "      var network = new vis.Network(container, data, options);";
//
//        FileWriter load = new FileWriter(URL);
//        load.write(paint);
//        load.close();

//    }
//}
