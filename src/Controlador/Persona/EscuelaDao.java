/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Persona;

import static Controlador.Dao.Bridge.getConection;
import Controlador.Dao.DaoImplement;
import Controlador.TDA.Grafos.GrafoNoDirigidoEtiquetado;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.ListaDinamica;
import java.io.FileWriter;

/**
 *
 * @author Victor
 */
public class EscuelaDao extends DaoImplement<Escuela>{
    private ListaDinamica<Escuela> listaEscuela = new ListaDinamica<>();
    private Escuela escuelas;
     private GrafoNoDirigidoEtiquetado<Escuela> grafoEscuela;
     
//     for( int i = 0; i <= grafoEscuela.get ;i++{
//    
//}
    
    public EscuelaDao(){
        super (Escuela.class);
    }

    public ListaDinamica<Escuela> getListaEscuela() {
        if (listaEscuela.EstaVacio()) {
            listaEscuela = all();
        }
        return listaEscuela;
    }

    public void setListaEscuela(ListaDinamica<Escuela> listaEscuela) {
        this.listaEscuela = listaEscuela;
    }

    public Escuela getEscuelas() {
        if(escuelas == null){
            escuelas = new Escuela();
        }
        return escuelas;
    }

    public void setEscuelas(Escuela escuelas) {
        this.escuelas = escuelas;
    }
    
    public void guardarGrafo() throws Exception{
        getConection().toXML(grafoEscuela, new FileWriter("files/grafo.json"));
    }
    
    public GrafoNoDirigidoEtiquetado<Escuela> getGrafoEscuelaDao() throws Exception {
        if (grafoEscuela == null) {
            ListaDinamica<Escuela> list = getListaEscuela();
            if (!list.EstaVacio()) {
                grafoEscuela = new GrafoNoDirigidoEtiquetado<>(list.getLongitud() + 1, Escuela.class);
                for (int i = 0; i < grafoEscuela.num_vertice(); i++) {
                    grafoEscuela.etiquetarVertice((i + 1), list.getInfo(i));
                }
            }
            System.out.println("Presenta grafo");
        }
        return grafoEscuela;
    }

//    public GrafoNoDirigidoEtiquetado<Escuela> getGrafoEscuela() {
//        if(grafoEscuela == null){
//            ListaDinamica<Escuela> listE = getListaEscuela();
//            grafoEscuela = new GrafoNoDirigidoEtiquetado<>(listE.getLongitud(), );
//            for(int i = 0; i <= listE.getLongitud(); i++){
//                grafoEscuela.getEtiquetaE(i+1), getListaEscuela().getInfo(i);
//            }
//        }
//        return grafoEscuela;
//    }

    public void setGrafoEscuela(GrafoNoDirigidoEtiquetado<Escuela> grafoEscuela) {
        this.grafoEscuela = grafoEscuela;
    }
    
    public Boolean Persist(){
        escuelas.setId(all().getLongitud()+1);
        return Persist(escuelas);
    }
    
}
