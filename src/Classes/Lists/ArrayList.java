/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Lists;

import java.util.Iterator;

/**
 *
 * @author user
 * @param <E>
 */
public class ArrayList<E> implements List<E>, Iterable<E>{
        private E[] array;
        private int current;
        public ArrayList(){
            this.array = (E[]) new Object [10];
        }
        /*Iterator es una interfaz y no deberia  instanciar una interfaz*/



    @Override
    public void addFirst(E element) {
        if(this.isEmpty()){
            this.array[current]=element;
        }else if(this.current == this.array.length){
            this.addCapcity();
            for(int i= (this.current-1); i>=0; i--){
                this.array[i+1] = this.array[i];
            }
            this.array[0] = element;
            this.current++;
        }else{
            for(int i= (this.current-1); i>=0; i--){
                this.array[i+1] = this.array[i];
            }
            this.array[0] = element;
            this.current++;
            
        }
      
    }

    @Override
    public void addLast(E element) {
        /*if(this.isEmpty()){ cuando currente es cero, la lista esta vacia
            this.array[current]= element;
        }else if(this.current == this.array.length){
            this.addCapcity();
            this.array[current] = element;
        }else{
            this.array[current] = element;
         }*/
        if(this.current == this.array.length){
            this.addCapcity();
        }else{
            this.array[current] = element;
            this.current++;/*repasar a++, ++a*/
        }
    }

    @Override
    public void removeFirst() {
        if(this.current>0){
            for(int i= 0; i < this.current-1 ; i++ ){
                this.array[i] = this.array[i+1];
            }
            this.array[current-1]=null;
            this.current--;
        }
    }
    
        @Override
    public E removeFirstElement() {
        if(this.isEmpty()){
            return null;
        }
        E tmp = this.array[0];
        /*Vamos a relizar una operacion de compactacion*/
        for(int i= 0; i < this.current-1 ; i++ ){
            this.array[i] = this.array[i+1];
        }
        this.array[current-1]=null;
        this.current--;
        return tmp;
        
        
    }
    
    
    @Override
    public void removeLast() {
        if(this.current>0){
            this.array[current-1] = null;
            this.current--;
        }
    }
    

    @Override
    public int size() {
        return this.array.length;

    }
    
    
 

    /*Cuando una clase implementa una interfaz, esta obligado a darle cuerpo
    a todos los comportamientos definidos en la interfaz*/
    /*Si sale object, debemos poner el diamante*/

    @Override
    public boolean isEmpty() {    
        boolean decision;
        decision = this.current == 0;
        return decision;
    }   /*tiempo de ejecucion in isEmpty es constante*/
    
    private void addCapcity(){
        E[] tmp = (E[]) new Object[(int)(this.array.length +this.array.length*0.3)];/*aqui aplicamos casting*/
        for(int i=0; i<this.current;i++){ /*deep cpy or hard copy*/
            tmp[i]=this.array[i];
        }
        this.array=tmp;/*shallow copy*/
        /*deseamos qe array apunte al de tmp, la asignacion es a la izquierda*/
    }
    
        
    /*string builder*/ 
        @Override/*Este es un key de ayuda para el Java Compilers*/
        /*Este es un metodo que heredamos de la clase Object*/
    /*Los strings en java son inmutables, no es buena practica usa demasiado la concatenacion*/
    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i< this.current;i++){
            sb.append(this.array[i]);
            sb.append(",");
        }
        
        return sb.substring(0,sb.length() -1)+("]");
    }
    
    /*---------------TAREA 1--------------------*/
    
    /*E get(int index) //devuelve el dato que está en index Nota.- validar que 
    el índice esté en el rango de índices permitidos para realizar la operación,
    caso contrario retornar null.*/
    @Override
    public E get(int index) {
        if (index > this.array.length-1 || index <0){
            return null;
        }else{
            return this.array[index];
        }
    }

    /*void add(int index, E element)// agrega el dato en el index y desplaza los
    elementos subsecuentes a la derecha. Nota.- validar que el índice esté en el
    rango de índices permitidos para realizar la operación.*/
    @Override
    public void add(int index, E element) {
        if(index < this.array.length-1 && index >=0 ){
            if(this.array.length == this.current){
            this.addCapcity();
            }
            for(int i = this.current-1; i>=index; i--){
                this.array[i+1] = this.array[i];
            }
            this.array[index] = element;
            this.current++;
        } 
    }
    
    
    /*List<E> slicing(int start, int end) // devuelve una nueva lista con los 
    elementos que están en el rango desde start hasta end, sin inlcuir end. 
    Nota.- validar que start sea menor que end y que estén en el rango de índices
    permitidos, caso contrario retornar una lista vacía.*/

    @Override
    public List<E> slicing(int start, int end) {
        List<E> result = new ArrayList<>();
        if(start<0 || start>= current || end<0 || end > current || start >= end)
            return result;
        for(int i= start; i <end; i++){
            result.addLast(this.array[i]);
        }
        return result;
    }
    
    
    /*+ // verifica si el dato está en la lista, 
    recordar que para comparar contenido de objetos se usa el equals.*/
      
        @Override
    public int indexof(E element){
        for(int i = 0; i < this.current; i++){
            if(this.array[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    
        @Override
    public boolean contains(E element){
        return this.indexof(element)!= -1;
    }
    
    /*  Ademas en la clase ArrayList deben sobreescribir el metodo equals de la clase Object para comparar
    si dos Arraylist son iguales si y solo si tienen los mismos elementos y en el mismo orden*/

    @Override
    public boolean iguales(Object o) {
        List<E> result = new ArrayList<>();
        result = (List)o;
       int lista_length = result.size();
       if(this.array.length != lista_length){
           return false;
       }
       if(this.array== o){
           return true;
       }
       for (int i = 0; i< this.current; i++){
           if(!this.array[i].equals(((ArrayList)result).array[i])){
           return false;
           }
       }
       
        return true;
        
    }

    @Override
    public E removeLastElement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*  Ejercicio de LECCION */
        @Override
    public List<E> reverse(){
        List<E> result = new ArrayList<>();
        for(int i = this.current-1 ; i >=0 ; i--){
            result.addLast(this.array[i]);
        }
        return result;
    }

    /*Iterator es una interfaz y no deberia  instanciar una interfaz*/
/*Anonimo significa que no se lo conoce y no se puede usar*/
    /*Una clase inner es una clase dentro de algo, como la clase node dentro de linkedlist*/
    @Override
    public Iterator<E> iterator() {
        /*La clase creada solo la conoce iterator*/
        /*Esta clase no la puedo llamar en otra funcion*/
        /*Las clases anonimas solo existen cuando instancio interfaz*/
        Iterator<E> it = new Iterator<E>(){
            /*variable de control iteradora*/
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i< current;
            }

            @Override
            public E next() {
                return array[i++];
            }
            
        };
        return it;
    }

    /*-----------------TALLER GRUPAL--------------*/
    @Override
    public void remove(int index) {
        /*if(index >=0){
            for(int i= index; i < this.current-1 ; i++ ){
                this.array[i] = this.array[i+1];
            }
            this.array[current-1]=null;
            this.current--;
        }*/
        //E aux = null;
        try{
            if(index == 0){
                //aux = this.first.data;
                this.removeFirst();
            }
            else if(index == this.current - 1){
                //aux = this.last.data;
                this.removeLast();
            }
            else{
                for(int j = index; j < this.array.length - 1; j++){
                this.array[j] = this.array[j + 1];
                }
                
                this.array[this.current - 1] = null;        
                this.current -= 1;
                //return (E) aux;
            }
        }
         catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Ingrese un índice válido");
            //aux = null;
        }
        //return aux;
        

    }
    
    /*--------------------FIN TALLER------------------------*/
    
    


    
    
    


    
}
