/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Lists;

/**
 *
 * @author Nicole
 */
public class DoublyLinkedList<E> implements List<E> {

    /*------------------TALLER GRUPAL-----------------*/
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
                p.previous.next = p.next;
                p.next.previous = p.previous;
                p.previous = p.next = null;
                this.current -= 1;
            }
        }
         catch(NullPointerException ex){
            System.out.println("Ingrese un índice válido");
            //aux = null;
        }
        //return aux;
        
         

    }
    /*-------------------FIN TALLER-----------------------------*/

    @Override
    public List<E> reverse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     private class Node<E>{
        E data;
        Node<E> next;
        Node<E> previous;
        
        public Node(E element){
            this.data = element;
        }
    }
    
    private Node<E> first;
    private Node<E> last;
    private int current;
    
    public DoublyLinkedList(){
        //Constructor por default, ambos atributos valen null ahora.
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
        Node<E> n = new Node<>(element);
        if (this.isEmpty()){
            this.first = this.last = n;
            this.current += 1;
            return;
        }
        n.next = this.first;
        this.first.previous = n;
        this.first = n;
        this.current += 1;    
    }

    @Override
    public void addLast(E element) {
        Node <E> n  = new Node<>(element);
        if(this.isEmpty()){        
            this.first = this.last = n;
            this.current += 1;
        }
        else{
            this.last.next = n;
            n.previous = this.last;
            this.last = n;
            this.current += 1;
        }
    }

    @Override
    public void removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeLast() {
    }


    @Override
    public E removeFirstElement() {
        if(this.isEmpty())return null;
        E aux = this.first.data;
        if(this.first == this.last){
            this.first = this.last = null;
            return aux;
        }
        Node<E> p = this.first.next;
        this.first.next = null;
        this.first = p;
        this.first.previous = null;
        this.current -= 1;
        return aux;   
    }
    
    @Override
    public E removeLastElement() {
        if(this.isEmpty())return null;
        E temp = this.last.data;
        
        if(this.first == this.last){
            this.first = this.last = null;
            return null;
        }
        
        Node<E> p = this.last.previous;
        this.last.previous = null;
        this.last = p;
        this.last.next = null;
        this.current -= 1;
        return temp;
    }
    

    


    @Override
    public int size() {
        return this.current;
    }

    @Override
    public boolean isEmpty() {
        return this.first==null && this.last==null;

    }

    /*---------------------TAREA-----------------------*/
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
    public void add(int index, E element) {
        Node<E> n = new Node<>(element);
        if(index < this.current-1 && index >=0 ){
            Node<E> p = first;
            for(int i = 0; i<index-1;i++){
                p = p.next;
            }
            n.next = p.next;
            n.previous = p;
            p.next.previous = n;
            p.next = n;
            this.current++;
        }
   
    }

   @Override
    public List<E> slicing(int start, int end) {
        DoublyLinkedList<E> result = new DoublyLinkedList();
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

    @Override
    public int indexof(E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
     /*---------------------FIN TAREA -----------------------*/

    @Override
    public boolean iguales(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
    public void switchFirstLast(){
        if(current>=3){
            Node<E> sf = first.next;
            Node<E> pl = last.previous;
            pl.next = first;
            first.previous = pl;
            sf.previous = last;
            last.next = sf;
            Node<E> tmp = first;
            first = last;
            last = tmp;
            first.previous = null;
            last.next = null;
        }
    }
}
