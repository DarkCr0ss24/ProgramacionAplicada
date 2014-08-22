/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author dark
 */
public class Menu {
    private Scanner input = null;
    private Lista lista = new Lista();
    
    Menu(){
        this.lista.CargarLista();
        this.MenuPrincipal();
    }
    
    public void MenuPrincipal(){
        input = new Scanner(System.in);
        String opcion;
        System.out.println("Que desea hacer?");
        System.out.println("1) Crear nuevo alumno");
        System.out.println("2) Seleccionar alumno");
        System.out.println("3) Salir");
        opcion = input.nextLine();
        switch(opcion){
            case "1":
                this.MenuCrearAlumno();
                break;
            case "2":
                this.MenuSeleccion();
                break;
            case "3":
                this.lista.GuardarLista();
                break;
            default:
                System.out.println("No eligio ninguna de la opciones disponibles...");
                this.MenuPrincipal();
                break;
        }
    }
    
    public void MenuCrearAlumno(){
        input = new Scanner(System.in);
        String nombre;
        System.out.println("Introduzca el nombre completo del estudiante:");
        nombre = input.nextLine();
        Estudiante estudiante = new Estudiante(nombre);
        while (true){
            Scanner escanerNota = new Scanner(System.in);
            Scanner escanerRespuesta = new Scanner(System.in);
            System.out.println("Introduzca una nota:");
            try{
                estudiante.AgregarNota(escanerNota.nextFloat());
                System.out.println("Desear seguir agregando notas?[s/n]");
                String Respuesta = escanerRespuesta.nextLine().toLowerCase();
                if ("n".equals(Respuesta) || "no".equals(Respuesta) ){
                    this.lista.AgregarAlumno(estudiante);
                    this.MenuPrincipal();
                    break;
                    }
                }
            catch(Exception e){
                System.out.println("por favor utilice numeros");
            }
        }
    }
    
    public void MenuSeleccion(){
        ArrayList<Estudiante> alumnos = this.lista.ObtenerAlumnos();
        System.out.println("Elija uno de los siguientes alumnos:");
        for(int i = 0; i <= alumnos.size() - 1; i++){
            System.out.println( (i+1) + ") " + alumnos.get(i).ObtenerNombre()) ;
        }
        try{
            input = new Scanner(System.in);
            System.out.println("Introduzca su seleccion:");
            int seleccion = input.nextInt();
            if(seleccion  > alumnos.size() || seleccion <= 0 ){
                System.out.println("No existe el alumno numero " + seleccion);
                this.MenuSeleccion();
            }
            else{
                this.SubMenuSeleccion(seleccion -1);
            }
        }
        catch(Exception e){
            System.out.println("Su eleccion no esta disponible");
            this.MenuSeleccion();
        }
    }
    
    public void SubMenuSeleccion(int indice){
        System.out.println("Que desea hacer?");
        System.out.println("1) Obtener promedio");
        System.out.println("2) Agregar notas");
        System.out.println("3) Ver notas");
        System.out.println("4) Seleccion otro alumno");
        System.out.println("5) Regresar al menu principal");
        
        input = new Scanner(System.in);
        String eleccion = input.nextLine();
        switch(eleccion){
            case "1":
                System.out.println("El promedio de " + this.lista.ObtenerAlumnos().get(indice).ObtenerNombre() + " es "+  this.lista.ObtenerAlumnos().get(indice).ObtenerPromedio() );
                this.SubMenuSeleccion(indice);
                break;
            case "2":
                input = new Scanner(System.in);
                while(true){
                    try{
                        System.out.println("Introduzca la nota");
                        lista.AgregarNota(indice, input.nextFloat());
                        break;
                    }
                    catch(Exception e){
                        System.out.println("Por favor introduzca la nota en numeros");
                    }
                }
                this.SubMenuSeleccion(indice);                
                break;
            case "3":
                ArrayList<Estudiante> estudiante = this.lista.ObtenerAlumnos();
                for (int i = 0; i <= estudiante.get(indice).ObtenerNotas().length -1; i++){
                    System.out.println(estudiante.get(indice).ObtenerNotas()[i]);
                }
                this.SubMenuSeleccion(indice);
               break;
            case "4":
                this.MenuSeleccion();
                break;
            case "5":
                this.MenuPrincipal();
                break;
            default:
                System.out.println("Su eleccion no esta disponible");
                this.SubMenuSeleccion(indice);
                break;
        }
        
    }
    
}