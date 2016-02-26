



import java.io.IOException;
import java.util.Scanner;

/*
 * Created by migue on 2/13/2016.
 */
public class Main {

    public static void main(String args[]) throws IOException {

        Estudiante NuevoEstudiante = new Estudiante("Matricula" ,"Nombre" ,"Apellido");
        Estudiante EstudianteEliminar = new Estudiante();


        Calificacion NuevaCalificacion = new Calificacion("Matricula", "Tarea" );
        byte opcion;
        String matriculaCalificacion;

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("Que deseas hacer?");
            System.out.println();

            System.out.println("1. Registrar un nuevo estudiante");
            System.out.println("2. Borrar estudiante");
            System.out.println("3. Registrar calificacion para un  estudiante");
            System.out.println("4. Salir");
            opcion = entrada.nextByte();

            switch(opcion){


                case 1:
                    System.out.println("Introduce la matricula del estudiante: ");
                    String matriculaNuevoEstudiante = entrada.next();
                    NuevoEstudiante.setMatricula(matriculaNuevoEstudiante);


                    System.out.println("Intruduce el nombre del estudiante:");
                    String nombreEstudiante = entrada.next();
                    NuevoEstudiante.setNombre(nombreEstudiante);


                    System.out.println("Introduce el apellido del estudiante:");
                    String apellidoEstudiante = entrada.next();
                    NuevoEstudiante.setApellido(apellidoEstudiante);
                    NuevoEstudiante.Registrar(NuevoEstudiante.getMatricula(),NuevoEstudiante.getNombre(),NuevoEstudiante.getApellido());
                    System.out.println("El campo se ha registrado correctamente!!!!");
                    System.out.print("");

                    break;

                case 2:

                    System.out.println("Introduce la matricula del estudiante que desea elmiminar: ");
                    matriculaCalificacion = entrada.next();

                    if(NuevaCalificacion.VerificacionArchivo(matriculaCalificacion)){
                        EstudianteEliminar.setMatricula(matriculaCalificacion);
                        EstudianteEliminar.EliminarEstudiante(EstudianteEliminar.getMatricula());

                    }

                    else {
                        System.out.println("La matricula no esta registrada.!!");
                        System.out.println("");
                        System.out.println("");
                    }
                    break;

                case 3:

                    System.out.println("Introduce la matricula del estudiante: ");
                    matriculaCalificacion = entrada.next();
                    if(NuevaCalificacion.VerificacionArchivo(matriculaCalificacion)){

                        NuevaCalificacion.setEstudiante(matriculaCalificacion);
                        System.out.println("Introduce la Tarea: ");
                        String  Tarea = entrada.next();
                        NuevaCalificacion.setTarea(Tarea);

                        System.out.println("Intoduce la nota: ");
                        int nota = entrada.nextInt();
                        NuevaCalificacion.setNota(nota);
                        NuevaCalificacion.RegistroCalificacion(NuevaCalificacion.getEstudiante(),NuevaCalificacion.getTarea(),NuevaCalificacion.getNota());

                    }else{

                        System.out.println("El estudiante no esta Registrado. Debe de registrar antes de publicar");

                    }

                    break;

                default:

                    break;


            }

        }while(opcion!=4);
    }


}