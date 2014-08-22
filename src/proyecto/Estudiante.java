/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;
import java.util.ArrayList;
/**
 *
 * @author dark
 */
public class Estudiante {
   private  ArrayList<Float> Notas = new ArrayList<Float>(); // Se almacenan las notas del estudiante
   private  float Nota; // Atributo donde se almacena la suma de todas las notas
   private  String Nombre; // Atributo donde se guarda el nombre del estudiante
   
   Estudiante(String nombre){
       this.Nombre = nombre; // Se asigna el nombre del estudiante
   }
   
   public  void AgregarNota(float nota){
       // Metodo para agregar las notas del estudiante
       this.Notas.add(nota);
   }
   
   public  float ObtenerPromedio(){
       // Metodo que retorna el promedio del estudiante
       this.Nota = 0;
       for(int x = 0; x<= this.Notas.size() - 1; x++){
           this.Nota += this.Notas.get(x);
       }
       return this.Nota / this.Notas.size();
   }
   
   public float[] ObtenerNotas(){
       // Metodo que devuelve las notas del estudiante como un arreglo
       float[] notas = new float[this.Notas.size()];
       for (int i = 0; i <= this.Notas.size() - 1; i++)
           notas[i] = this.Notas.get(i);
       return notas;
   }
   
   public  String ObtenerNombre(){
       // Metodo para obtener el nombre del estudiante
       return this.Nombre;
   }
   
}