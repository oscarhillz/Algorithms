/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Lists;

/**
 *
 * @author Nicole
 * @param <E>
 */
public class SinglyLinkedList<E> implements List<E>{
    
    
    /*-------------------------TAREA--------------------*/

    /*E get(int index) //devuelve el dato que está en index Nota.- validar 
    que el índice esté en el rango de índices permitidos para realizar la 
    operación, caso contrario retornar null.*/
    @Override
    public E get(int index) {

        if (index > this.current || index <0){
            return null;
        }else{
            Node<E> tmp = first;
            int count = 0;
            while(tmp != null){
                if(count == index)
                    return tmp.data;
                count ++;
                tmp = tmp.next;
            }
        }
        return null;
            

    }


    @Override
    public int indexof(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*boolean contains(E element) // verifica si el dato está en la lista, 
    recordar que para comparar contenido de objetos se usa el equals.*/
    @Override
    public boolean contains(E element) {
        Node tmp = first;
        while(tmp != null){
            if(tmp.data.equals(element)){
                return true;
            }
            tmp = tmp.next;   
        }
        return false;
    }
    /*void add(int index, E element)// agrega el dato en el index y desplaza los
    elementos subsecuentes a la derecha. Nota.- validar que el índice esté en el 
    rango de índices permitidos para realizar la operación.*/
    @Override
    public void add(int index, E element) {
        if(index < this.current-1 && index >=0 ){
            Node <E> n = new Node<>(element);
            n.data= element;
            n.next = null;
            Node<E> p = first;
            for(int i = 0; i<index-1;i++){
                p = p.next;
            }
            n.next = p.next;
            p.next = n;
            this.current++;
            
        }
        
 
    }
    
    
    @Override
    public List<E> slicing(int start, int end) {
        List<E> result = new ArrayList<>();
        Node<E> p = first;
        int count = 0;

        if(start<0 || start>= current || end<0 || end > current || start >= end)
            return result;
       for(int i = 0; i < this.current; i++){
           if(count >= start  && count <end){
               result.addLast(p.data);
           }
           p = p.next;
           count++;
       }

       
        return result;

    }
    
    /*-------------------------FIN TAREA--------------------*/



    @Override
    public boolean iguales(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLastElement() {
        if(this.isEmpty())return null;
        if(this.first == this.last){
            E tmp = this.last.data;
            this.first = this.last = null;
            this.current--;
            return tmp;
        }
        
        E tmp = this.last.data;
        Node<E> p = getPrevious(this.last);
        this.last = p;
        this.last.next = null;
        this.current--;
        return tmp;
        
        //O(n)    
    }

    /*Ejercicio de leccion */
    @Override
    public List<E> reverse() {
        List<E> result = new ArrayList<>();
        Node<E> p = first;
        while(p.next != null){
            result.addLast(p.data);
            p = p.next; 
        }
        return result;
    }
    public Node<E> getPrevious(Node<E> n){
        Node<E> p = this.first;
        while(p.next != n){
            p = p.next;
        }
        return p;
    }
    
    /*----------------------------TALLER GRUPAL----------------------------------*/

    @Override
    public void remove(int index) {
        //E aux = null;
        try{
            if(index == 0){
                //aux = this.first.data;
                this.removeFirstElement();
            }
            else if(index == this.current - 1){
                //aux = this.last.data;
                this.removeLastElement();
            }
            else{
                Node<E> p = this.first;
                for(int i = 0; i < index; i++){
                    p = p.next;
                }
                //aux = p.data;
                getPrevious(p).next = p.next;
                p.next = null;
                this.current -= 1;
            }
        }
         catch(NullPointerException ex){
            System.out.println("Ingrese un índice válido");
            //aux = null;
        }
        //return aux;
        
        
        

    }
    /*------------------------FIN TALLER--------------------------------*/
    

    
    private class Node<E>{
        E data;
        Node <E> next;
        public Node (E element){
            this.data = element;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int current;
    
    public SinglyLinkedList(){

    }
    
    @Override
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> p = first;
        while(p != null){
            sb.append(p.data);
            sb.append(",");
            p = p.next;            
        }

        return sb.substring(0,sb.length() -1)+ "]";
    }

    @Override
    public void addFirst(E element) {
        Node <E> n = new Node<>(element);
        if(this.isEmpty()){
            this.first = this.last = n;
        }else{ 
            n.next = this.first;
            this.first = n;
        }
        this.current++;
        
    }
    
    @Override
    public void addLast(E element) {
        Node<E> n = new Node<>(element);
        if (this.isEmpty()){
            this.first = this.last = n;
        } else {
            this.last.next = n;
            this.last = n;
        }
        this.current++;
    }

    @Override
    public void removeFirst() {
        
    }

    @Override
    public void removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeFirstElement() {
        if(this.isEmpty())return null;
        if(this.first == this.last){
            E tmp = this.last.data;
            this.first = this.last = null;
            return tmp;
        }
        E tmp = this.first.data;
        Node<E> p = this.first.next;
        this.first.next = null;
        this.first = p;
        this.current--;
        return tmp;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        return this.first==null && this.last==null;
    }
    
    
}
