package ejercicios;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Vars
        int opcion = 0;
        int id = 0;
        String titulo = "";
        String director = "";
        int year = 0;
        boolean alquilada;
        Scanner sc = new Scanner(System.in);
        Videoclub videoclub = new Videoclub();
        //Menú
        do {
            try{
                System.out.println("--- MENÚ DEL VIDEOCLUB ---");
                System.out.println("1. Agregar pelicula");
                System.out.println("2. Listar peliculas");
                System.out.println("3. Mostrar pelicula por titulo.");
                System.out.println("4. Alquilar pelicula.");
                System.out.println("5. Devolver pelicula.");
                System.out.println("6. Salir.");
                System.out.println("--------------------------");

                System.out.println("Elije la opción que quieres realizar.");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion){
                    //Agregar pelicula
                    case 1 ->{
                        boolean esValido = false;
                        try {
                            do{
                                System.out.println("Introduce el ID de la pelicula en formato decimal.");
                                id = sc.nextInt();
                                if (id < 0){
                                    System.out.println("El id no puede ser negativo.");
                                    esValido = false;
                                    continue;
                                }

                                esValido = true;
                                for (int i = 0; i < videoclub.peliculas.size(); i++) {
                                    if (videoclub.peliculas.get(i).getId() == id){
                                        System.out.println("El id introducido ya existe, porfavor introduce otro id");
                                        esValido = false;
                                        break;
                                    }
                                }
                            }while(!esValido);

                            sc.nextLine();
                        }catch (Exception e){
                            System.out.println("El id introducido no es válido.");
                            sc.nextLine();
                            break;
                        }

                        System.out.println("Introduce el titulo de la pelicula.");
                        titulo = sc.nextLine();

                        System.out.println("Introduce el nombre del director.");
                        director = sc.nextLine();

                        try {
                            System.out.println("Introduce el año de publicación");
                            year = sc.nextInt();
                        }catch (Exception e){
                            System.out.println("El año introducido no es válido.");
                            break;
                        }
                        Pelicula p = new Pelicula(id, titulo, director, year);
                        videoclub.agregarPelicula(p);

                    }
                    //Mostrar todas las peliculas
                    case 2 ->{
                        videoclub.listarPeliculas();
                    }

                    //Mostrar pelicula por titulo.
                    case 3 ->{
                        System.out.println("Introduce el titulo de la pelicula de la que quieres ver la información.");
                        titulo = sc.nextLine();

                        videoclub.peliculaPorTitulo(titulo);
                    }

                    //Alquilar pelicula
                    case 4 ->{
                            System.out.println("Selecciona el nombre de la peli");
                            titulo = sc.nextLine();

                            boolean peliculaExistente = false;

                        for (int i = 0; i < videoclub.peliculas.size(); i++) {
                            if (videoclub.peliculas.get(i).getTitulo().equalsIgnoreCase(titulo)){
                                peliculaExistente = true;
                                System.out.println("Pelicula encontrada!");
                                if (videoclub.peliculas.get(i).isAlquilada()){
                                    System.out.println("La pelicula ya esta alquilada, porfavor vuelve en otro momento.");
                                }else{
                                    videoclub.peliculas.get(i).setAlquilada(true);
                                    System.out.println("Gracias por alquilar con nostros!");
                            }
                                break;
                            } else peliculaExistente = false;
                        }
                        if (!peliculaExistente) {
                            System.out.println("La pelicula que buscas no esta en nuestros armarios, porfavor vuelve mas tarde.");
                        }
                    }
                    //Devolver pelicula
                    case 5 -> {
                        System.out.println("Selecciona el nombre de la peli");
                        titulo = sc.nextLine();

                        boolean peliculaExistente = false;

                        for (int i = 0; i < videoclub.peliculas.size(); i++) {
                            if (videoclub.peliculas.get(i).getTitulo().equalsIgnoreCase(titulo)){
                                peliculaExistente = true;
                                System.out.println("Pelicula encontrada!");
                                if (!videoclub.peliculas.get(i).isAlquilada()){
                                    System.out.println("La pelicula que quieres devolver no se encuentra alquilada.");
                                }else{
                                    videoclub.peliculas.get(i).setAlquilada(false);
                                    System.out.println("Gracias por devolver algo que pueden disfrutar los demas!");
                                }
                                break;
                            } else peliculaExistente = false;
                        }
                        if (!peliculaExistente) {
                            System.out.println("No hay constancia en nuestros armarios de la pelicula que quieres devolver.");
                        }
                    }
                    case 6 ->{
                        sc.close();
                        System.out.println("Hasta la proxima!");
                    }
                    default -> System.out.println("La opción introducida no es válida.");
                }
            }catch (InputMismatchException e){
                System.out.println("La opción introducida no es válida.");
                sc.nextLine();
            }
        } while(opcion != 6);
    }
}