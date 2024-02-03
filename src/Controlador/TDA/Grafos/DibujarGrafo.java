
package Controlador.TDA.Grafos;

import Controlador.Persona.EscuelaDao;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.ListaDinamica;
import java.io.FileWriter;

/**
 *
 * @author Victor
 */
public class DibujarGrafo {
    EscuelaDao DaoEs = new EscuelaDao();
    
    String URL = "d3/grafo.js";

    public void updateFile(Grafo graph) throws Exception {
        ListaDinamica<Escuela> le = DaoEs.all();
        String nodes = "";
        String edges = "";
        String paint = "";
        
        nodes += "var nodes = new vis.DataSet([\n";
        for (int i = 1; i < le.getLongitud()+1; i++) {
            String c = DaoEs.getListaEscuelas().getInfo(i-1).getNombre();
            nodes += "{id: " + i + ", label: \" " + c + "\"},\n";
        }
        nodes += "]);\n\n";

        edges += "var edges = new vis.DataSet([\n";
        for (int i = 1; i <= graph.num_vertice(); i++) {
            ListaDinamica<Adyacencia> links = graph.adycentes(i);
            for (int j = 0; j < links.getLongitud(); j++) {
                Adyacencia ady = links.getInfo(j);
                edges += "{from: " + i + ", to: " + ady.getDestino() + ", label: \"" + ady.getPeso() + "\"},\n";
            }
        }
        edges += "]);\n\n";

        paint += nodes + edges
                +"var container = document.getElementById(\"mynetwork\");\n"
                + "      var data = {\n"
                + "        nodes: nodes,\n"
                + "        edges: edges,\n"
                + "      };\n"
                + "      var options = {};\n"
                + "      var network = new vis.Network(container, data, options);";

        FileWriter load = new FileWriter(URL);
        load.write(paint);
        load.close();
    }
    
        public void update(Grafo graph, GrafoDirigidoEtiquetado grp) throws Exception {
        String nodes = "";
        String edges = "";
        String paint = "";
        
        nodes += "var nodes = new vis.DataSet([\n";
        for (int i = 1; i <= graph.num_vertice(); i++) {
            nodes += "{id: " + i + ", label: \"" + grp.getEtiquetaE(i) + "\"},\n";
        }
        nodes += "]);\n\n";

        edges += "var edges = new vis.DataSet([\n";
        for (int i = 1; i <= graph.num_vertice(); i++) {
            ListaDinamica<Adyacencia> links = graph.adycentes(i);
            for (int j = 0; j < links.getLongitud(); j++) {
                Adyacencia ady = links.getInfo(j);
                edges += "{from: " + i + ", to: " + ady.getDestino() + ", label: \"" + ady.getPeso() + "\"},\n";
            }
        }
        edges += "]);\n\n";

        paint += nodes + edges
                +"var container = document.getElementById(\"mynetwork\");\n"
                + "      var data = {\n"
                + "        nodes: nodes,\n"
                + "        edges: edges,\n"
                + "      };\n"
                + "      var options = {};\n"
                + "      var network = new vis.Network(container, data, options);";

        FileWriter load = new FileWriter(URL);
        load.write(paint);
        load.close();
    }
}
