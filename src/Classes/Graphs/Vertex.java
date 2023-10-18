/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author eduardo
 */
public class Vertex <E>{
    private E data;
    private LinkedList<Edge<E>> edges;

    public Vertex(E data) {
        this.data = data;
        edges = new LinkedList<>();
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public LinkedList<Edge<E>> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge<E>> edges) {
        this.edges = edges;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex<E> other = (Vertex<E>) obj;
        return Objects.equals(this.data, other.data);   
    }
    
    
}
