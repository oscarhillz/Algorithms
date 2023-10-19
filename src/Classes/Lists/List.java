/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Lists;

/**
 *
 * @author user
 */
public interface List<E> {
    public void addFirst(E element);
    public void addLast(E element);
    /*public boolean removeFirst();/*devuelve si se elimino o no el elemneto */
    public void removeFirst();
    public void removeLast();
    public E removeFirstElement(); /*devuelve el elemneto eliminado*/
    public E removeLastElement();
    public void remove(int index);

    /*public  E removeLast(); devuelve el elemneto eliminado*/
    /*public  E remove(E element); devuelve el elemneto eliminado*/
    
    /*Sobrecarga*/
    /*dos metodos tienen el mismo nombre, pero deben recibir parametros diferentes*/
    
    /*public E remove(int index); devuelve el elemneto eliminado*/
    /*public E get(int index); devuelve el elemneto eliminado*/
    
    /*Lo que defina en una interfaz ya es public y abstract*/
    int size();
    
    boolean isEmpty();
    
    /*TAREA*/
    public E get(int index);
    public void add(int index,E element);

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public List<E> slicing (int start, int end);
    public int indexof(E element);
    public boolean contains(E element);
    public boolean iguales(Object o);
    public List<E> reverse();

   

    
}
