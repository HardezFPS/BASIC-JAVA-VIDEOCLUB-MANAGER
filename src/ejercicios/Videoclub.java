package ejercicios;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class Videoclub {

    //Vars
    ArrayList<Pelicula> peliculas = new ArrayList<>();

    public Videoclub(){
    }

    public void listarPeliculas(){
        if (peliculas.isEmpty()){
            System.out.println("No hay peliculas por el momento, vuelve mas tarde.");
        } else {
            for (Pelicula p : peliculas) {
                p.mostrarInfoPelicula();
                System.out.println("-----------------");
            }
        }

    }

    public void peliculaPorTitulo(String titulo){
        boolean encontrada = false;
        if (peliculas.isEmpty()){
            System.out.println("No hay peliculas por el momento, vuelve mas tarde.");
        } else {
            for (Pelicula p : peliculas) {
                if (p.getTitulo().equalsIgnoreCase(titulo)){
                    p.mostrarInfoPelicula();
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada){
                System.out.println("No existe ninguna pelicula con ese titulo.");
            }
        }
    }

    public void peliculaPorId(int id){
        boolean encontrada = false;
        if (peliculas.isEmpty()){
            System.out.println("No hay peliculas por el momento, vuelve mas tarde.");
        } else {
            for (Pelicula p : peliculas) {
                if (p.getId() == id){
                    p.mostrarInfoPelicula();
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada){
                System.out.println("No existe ninguna pelicula con ese id.");
            }
        }
    }

    public void agregarPelicula(Pelicula p){
        peliculas.add(p);
    }

    public void alquilarPelicula(int id){
        peliculas.get(id).setAlquilada(true);
    }

    public void devolverPelicula(int id){
        peliculas.get(id).setAlquilada(false);
    }
}