
import java.io.*;

/**
 * Created by migue on 2/13/2016.
 */
public class Calificacion {


    String Tarea;
    int nota;
    String estudiante;





    public Calificacion(String estudiante, String tarea) {
        Tarea = tarea;
        this.estudiante = estudiante;
    }

    public String getTarea() {
        return Tarea;
    }

    public void setTarea(String tarea) {
        Tarea = tarea;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }



    public boolean VerificacionArchivo(String matricula) throws IOException {   //verificar el archivo

        int registros = 1;
        File archivo;
        FileReader leer;
        BufferedReader almacenamiento;
        String cadena,nuMatricula;
        boolean resultado= false;
        boolean respuesta = false;
        archivo = new File("Estudiante.csv");

        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);
            cadena = "";
            while(cadena!=null){

                try {
                    cadena = almacenamiento.readLine();

                    nuMatricula = cadena;

                    resultado =  nuMatricula.startsWith(matricula);

                    if (resultado){
                        respuesta = true;


                    }

                }catch (NullPointerException e){}



            }
            almacenamiento.close();
            leer.close();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return (respuesta);

    }

    public void RegistroCalificacion(String matricula,String tarea, int nota){

        File archivo;
        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("Calificacion.csv");

        if (!archivo.exists()) {

            try {
                archivo.createNewFile();//crear nuevo archivo
                escribir = new FileWriter(archivo,true );//escribir archivo
                linea = new PrintWriter(archivo);
                linea.println(" matricula ,tarea ,nota");
                linea.println(matricula + " ," + tarea + " ," + nota);
                linea.flush();
                linea.close();
                escribir.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {

                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(matricula + " ," + tarea + " ," + nota);

                linea.close();
                escribir.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }







    }
}
