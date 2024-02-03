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
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Victor
 */
public class EscuelaDao extends DaoImplement<Escuela>{
    
    private ListaDinamica<Escuela> ListaEscuelas = new ListaDinamica<>();
    private GrafoNoDirigidoEtiquetado<Escuela> grafoEscuela;
    private Escuela escuela;

    public EscuelaDao(Class<Escuela> clazz) {
        super(Escuela.class);
    }

    public EscuelaDao() {
        super(Escuela.class);
    }

    public GrafoNoDirigidoEtiquetado<Escuela> getGrafo () throws Exception {
        if (grafoEscuela == null) {
            ListaDinamica<Escuela> list = getListaEscuelas();
            System.out.println(list);
            if (!list.EstaVacio()) {
                grafoEscuela = new GrafoNoDirigidoEtiquetado<>(list.getLongitud(), Escuela.class);
                for (int i = 0; i < list.getLongitud(); i++) {
                    grafoEscuela.etiquetarVertice((i + 1), list.getInfo(i));
                }
            }
        }
        
        return grafoEscuela;
    }

    public ListaDinamica<Escuela> getListaEscuelas() {
        if (ListaEscuelas.EstaVacio()) {
            ListaEscuelas = all();
        }
        return ListaEscuelas;
    }

    public void setListaEscuelas(ListaDinamica<Escuela> ListaEscuelas) {
        this.ListaEscuelas = ListaEscuelas;
    }

    public GrafoNoDirigidoEtiquetado<Escuela> getGrafoEscuela() {
        return grafoEscuela;
    }

    public void setGrafoEscuela(GrafoNoDirigidoEtiquetado<Escuela> grafoEscuela) {
        this.grafoEscuela = grafoEscuela;
    }

    public Escuela getEscuela() {
        if (escuela == null) {
            escuela = new Escuela();
        }
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public Boolean persist() {
        escuela.setId(all().getLongitud()+ 1);
        return Persist(escuela);
    }
    
    public void guardarGrafo() throws Exception{
        getConection().toXML(grafoEscuela, new FileWriter("files/grafo.json"));
    }
    
    public void loadGrapg() throws Exception{
        
        grafoEscuela = (GrafoNoDirigidoEtiquetado<Escuela>)getConection().fromXML(new FileReader("files/grafo.json"));
        ListaEscuelas.Limpiar();
        for(int i = 1; i <= grafoEscuela.num_vertice(); i++){
            ListaEscuelas.Agregar(grafoEscuela.getEtiquetaE(i));
        }
    }

    @Override
    public String toString() {
        return escuela.getNombre();
    }
    
    
//    private ListaDinamica<Escuela> listaEscuela = new ListaDinamica<>();
//    private Escuela escuelas;
//     private GrafoNoDirigidoEtiquetado<Escuela> grafoEscuela;
//     
////     for( int i = 0; i <= grafoEscuela.get ;i++{
////    
////}
//    public EscuelaDao(Class<Escuela> clazz) {
//        super(Escuela.class);
//    }
//     
//    public EscuelaDao(){
//        super (Escuela.class);
//    }
//
//    public ListaDinamica<Escuela> getListaEscuela() {
//        if (listaEscuela.EstaVacio()) {
//            listaEscuela = all();
//        }
//        return listaEscuela;
//    }
//
//    public void setListaEscuela(ListaDinamica<Escuela> listaEscuela) {
//        this.listaEscuela = listaEscuela;
//    }
//
//    public Escuela getEscuelas() {
//        if(escuelas == null){
//            escuelas = new Escuela();
//        }
//        return escuelas;
//    }
//
//    public void setEscuelas(Escuela escuelas) {
//        this.escuelas = escuelas;
//    }
//    
//    public void guardarGrafo() throws Exception{
//        getConection().toXML(grafoEscuela, new FileWriter("files/grafo.json"));
//    }
//    
//    public void CargarGrafoDao() throws Exception{
//        
//        grafoEscuela = (GrafoNoDirigidoEtiquetado<Escuela>)getConection().fromXML(new FileReader("files/grafo.json"));
//        listaEscuela.Limpiar();
//        for(int i = 1; i <= grafoEscuela.num_vertice(); i++){
//            listaEscuela.Agregar(grafoEscuela.getEtiquetaE(i));
//        }
//    }
//    
//    public GrafoNoDirigidoEtiquetado<Escuela> getGrafoEscuelaDao() throws Exception {
//        if (grafoEscuela == null) {
//            ListaDinamica<Escuela> list = getListaEscuela();
//            if (!list.EstaVacio()) {
//                grafoEscuela = new GrafoNoDirigidoEtiquetado<>(list.getLongitud()+1, Escuela.class);
//                for (int i = 0; i < list.getLongitud(); i++) {
//                    grafoEscuela.etiquetarVertice((i + 1), list.getInfo(i));
//                }
//            }
//            System.out.println("Presenta grafo");
//        }
//        return grafoEscuela;
//    }
//
////    public GrafoNoDirigidoEtiquetado<Escuela> getGrafoEscuela() {
////        if(grafoEscuela == null){
////            ListaDinamica<Escuela> listE = getListaEscuela();
////            grafoEscuela = new GrafoNoDirigidoEtiquetado<>(listE.getLongitud(), );
////            for(int i = 0; i <= listE.getLongitud(); i++){
////                grafoEscuela.getEtiquetaE(i+1), getListaEscuela().getInfo(i);
////            }
////        }
////        return grafoEscuela;
////    }
//
//    public void setGrafoEscuela(GrafoNoDirigidoEtiquetado<Escuela> grafoEscuela) {
//        this.grafoEscuela = grafoEscuela;
//    }
//    
//    public Boolean Persist(){
//        escuelas.setId(all().getLongitud()+1);
//        return Persist(escuelas);
//    }
//    
}
