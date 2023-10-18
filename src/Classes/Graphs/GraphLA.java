

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author eduardo
 */
public class GraphLA <E>{
    private LinkedList<Vertex<E>> vertexes;
    private boolean directed;
    
    public GraphLA(boolean directed){
        this.directed = directed;
        vertexes = new LinkedList<>();
    }
    
    public boolean addVertex(E data){
        Vertex<E> v = new Vertex<>(data);
        return (data == null || vertexes.contains(v))?false:vertexes.add(v);
    }
    
    public boolean removeVertex(E data){
        if(data == null || vertexes.isEmpty()) return false;
        ListIterator<Vertex<E>> iv = vertexes.listIterator();
        while(iv.hasNext()){
            Vertex<E> v = iv.next();
            ListIterator<Edge<E>> ie = v.getEdges().listIterator();
            while(ie.hasNext()){
                Edge<E> e = ie.next();
                if(e.getVDestino().getData().equals(data))
                    ie.remove();
            }
        }
        Vertex<E> vi = new Vertex<>(data);
        return vertexes.remove(vi);
    }
    
    public boolean addEdge(E src, E dst, int peso){
        if(src == null || dst == null) return false;
        Vertex<E> vs = searchVertex(src);
        Vertex<E> vd = searchVertex(dst);
        if(vs == null || vd == null) return false;
        Edge<E> e = new Edge<>(peso,vs,vd);
        if(!vs.getEdges().contains(e))
            vs.getEdges().add(e);
        if(!directed){
            Edge<E> ei = new Edge<>(peso,vd,vs);
            if(!vd.getEdges().contains(ei))
                vd.getEdges().add(ei);
        }
        return true;
    }
    
    public boolean removeEdge(E src, E dst){
        if(src == null || dst == null) return false;
        Vertex<E> vs = searchVertex(src);
        Vertex<E> vd = searchVertex(dst);
        if(vs == null || vd == null) return false;
        Edge<E> e = new Edge<>(0,vs,vd);
        vs.getEdges().remove(e);
        if(!directed){
            e = new Edge<>(0,vd,vs);
            vd.getEdges().remove(e);
        }
        return true;
    }
    
    private Vertex<E> searchVertex(E data){
        for(Vertex<E> v : vertexes)
        {
            if(v.getData().equals(data))
                return v;
        }
        return null;
    }
}
