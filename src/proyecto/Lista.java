/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author dark
 */
public class Lista {
    private  ArrayList<Estudiante> Alumnos = new ArrayList<Estudiante>(); // Atributo donde se almacena los alumnos
    
    public  ArrayList<Estudiante> ObtenerAlumnos(){
        // Se devulve la lista de estudiantes en un ArrayList
        return this.Alumnos;
    }
    
    public  void AgregarAlumno(Estudiante alumno){
        // Metodo para agregar alumnos al Atributo "Alumnos"
       this.Alumnos.add(alumno);
    }
    
    public void AgregarNota(int indice, float nota){
        // Metodo que permite agregar una nota al estudiante en la posicion "indice"
        this.Alumnos.get(indice).AgregarNota(nota);
    }
    
    public void CargarLista(){
        // Metodo para Cargar la lista de los estudiantes almacenados en el fichero "datos.txt"
        File archivo;
        FileReader fr = null;
        BufferedReader leector = null;
        
        try{
            archivo = new File("datos.txt");
            fr = new FileReader(archivo);
            leector = new BufferedReader(fr);
            String linea;
            String[] datos;
            while((linea = leector.readLine()) != null){
                datos  = linea.split(",");
                Estudiante e = new Estudiante(datos[0]);
                for (int i = 1; i <= datos.length - 1; i++){
                    // convierte el dato almacenado en la posicion i del arreglo datos en float y lo pasa como parametro
                    // al metodo AgregarNota.
                    e.AgregarNota(Float.parseFloat(datos[i]));
                }
               this.AgregarAlumno(e);
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
        finally{
            try{
                if (fr != null){
                    leector.close();
                    fr.close();
                }
            }
            catch(IOException e2){
                System.out.println("Error");
            }
        }
        
    }
    
    public void GuardarLista(){
        // Metodo que permite guarda la lista de estudiantes almacenada en el  ArrayList Alumnos en el fichero "datos.txt"
        FileWriter fw = null;
        PrintWriter pw;
        try{
            fw = new FileWriter("datos.txt");
            pw = new PrintWriter(fw);
            for(int i = 0; i<= this.Alumnos.size() -1; i++){
                pw.print(this.Alumnos.get(i).ObtenerNombre());
                for(int e = 0; e <= this.Alumnos.get(i).ObtenerNotas().length - 1; e++){
                    pw.print("," + this.Alumnos.get(i).ObtenerNotas()[e]);
                }
                pw.println();
            }
        }
        catch(IOException e){
            System.out.println("Error");
        }
        finally{
            try{
                if(fw != null){
                    fw.close();
                }
            }
            catch(IOException e2){
                System.out.println("Error");
            }
        }
    }
    
}