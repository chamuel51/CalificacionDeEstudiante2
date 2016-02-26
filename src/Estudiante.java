

import java.io.*;

/**
 * Created by miguel on 2/13/2016.
 */
public class Estudiante {

   public String Matricula;
    String nombre;
    String apellido;
    File archivo;
    FileWriter escribir;
    PrintWriter linea;



    public Estudiante(String matricula, String nombre, String apellido) {
        Matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Estudiante(){

    }



    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }




    public void Registrar(String matricula,String nombre, String apellido ) {

        File archivo;
        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("Estudiante.csv");

        if (!archivo.exists()) {

            try {
                archivo.createNewFile();//crear nuevo archivo
                escribir = new FileWriter(archivo,true );//escribir archivo
                linea = new PrintWriter(archivo);
                linea.println("matricula,apellido,nombre");
                linea.println(matricula + " ," + apellido + " ," + nombre);
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
                linea.println(matricula + " ," + apellido + " ," + nombre);

                linea.close();
                escribir.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }





    public void EliminarEstudiante(String matricula) {


        File archivo = new File("Estudiante.csv");

        if (!archivo.isFile()) {

            System.out.println("no hay registro en el  archivo");
            return;
        }

        File temporal = new File(archivo.getAbsoluteFile() + ".tmp");

        try {
            BufferedReader leer = new BufferedReader(new FileReader("Estudiante.csv"));

            PrintWriter imprimir = new PrintWriter(new FileWriter(temporal));

         String linea = null;

         while ((linea = leer.readLine()) != null){

             if(!linea.startsWith(matricula)){

                 imprimir.println(linea);
                 imprimir.flush();


             }

         }
            imprimir.close();
            leer.close();

            if (!archivo.delete()){

                System.out.println("No se pudo borrar el archivo");
                return;
            }

            if(!temporal.renameTo(archivo)){
                System.out.println("No se pudo renombrar el archivo");
            }


         }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }


}
