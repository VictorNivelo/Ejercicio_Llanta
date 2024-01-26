
package Controlador.Dao.GrafosEjemplo;

import Controlador.Dao.DaoImplement;
import Controlador.TDA.Grafos.GrafoNoDirigidoEtiquetado;
import Controlador.TDA.Grafos.Modelo.Escuela;
import Controlador.TDA.Lista.ListaDinamica;

/**
 *
 * @author Victor
 */
public class escuelaDaoE {}
//        extends DaoImplement<Escuela>{
//    private ListaDinamica<Escuela> lista = new ListaDinamica<>();
//    private Escuela escuelaDao;
//    private GrafoNoDirigidoEtiquetado<Escuela> grafoEscuela;
//    
//    public EscuelaDao(){
//        super(Escuela.class);
//    }
//
//    public ListaDinamica<Escuela> getLista() {
//        if (lista.EstaVacio()) {
//            lista = all();
//        }
//        return lista;
//    }
//
//    public void setLista(ListaDinamica<Escuela> lista) {
//        this.lista = lista;
//    }
//
//    public Escuela getEscuelaDao() {
//        if(escuelaDao == null){
//            escuelaDao = new Escuela();
//        }
//        return escuelaDao;
//    }
//
//    public void setEscuelaDao(Escuela escuelaDao) {
//        this.escuelaDao = escuelaDao;
//    }
//    
//    public Boolean Persist(){
//        escuelaDao.setId(all().getLongitud()+1);
//        return Persist(escuelaDao);
//    }
//}
