package ejercicios;

public class Pelicula {

    //Vars
    private int id;
    private String titulo;
    private String director;
    private int year;
    private boolean alquilada;

    //Constructores
    public Pelicula(int id, String titulo, String director, int year){
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.year = year;
        this.alquilada = false;
    }

    //Metodos logicos
    public void mostrarInfoPelicula(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Director: " + this.director);
        System.out.println("Año: " + this.year);
        System.out.println("Estado: " + (this.alquilada ? "Alquilada" : "No alquilada"));
    }

    public void alquilar(){
        setAlquilada(true);
    }

    public void devolver(){
        setAlquilada(false);
    }

    //Getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAlquilada() {
        return alquilada;
    }
    public void setAlquilada(boolean alquilada) {
        this.alquilada = alquilada;
    }
}
