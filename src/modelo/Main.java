package modelo;
import com.sun.source.tree.IfTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Main {
    public static Partido cargarPartidos(Equipo equipo1, Equipo equipo2, String[] arrayResultado){//metodo cargar partidos
        Partido partido1 = new Partido();//creo el partido
        //seteamos el partido con datos  de la linea de archivo
        partido1.setEquipo1(equipo1);
        partido1.setEquipo2(equipo2);
        partido1.setGolesEquipo1(Integer.parseInt(arrayResultado[1]));//convertimos gol de string a int
        partido1.setGolesEquipo2(Integer.parseInt(arrayResultado[2]));
        return partido1;
    }
    public static String leerArchivos(String archivo){//metodo estatico leer archivos
        String arc = archivo;
        return arc;
    }
    public static int obtenerPuntos(Pronostico[] pronosticoRonda, int indicePronostico){//metodo estatico obtener puntos
        int totalPuntos=0;
        for(int i=0; i<indicePronostico;i++){//recorro los pronosticos
            totalPuntos+=pronosticoRonda[i].puntos();//llamamos al metodo de la clase pronostico que asigna los puntos
        }
        return totalPuntos;
    }
    public static Pronostico cargarPronosticos(int x,List<String>pronosticos,Partido [] partidosRonda,Pronostico[] pronosticosRonda){
        Pronostico pronostico = new Pronostico();
        ResultadoEnum resultadoPronostico;
        for (int i=0; i < pronosticos.size() ;i++){
            String participante = pronosticos.get(x).split(";")[5];
            if ( pronosticos.get(i).split(";")[1].isEmpty()) {//obtenemos la linea que estamos recorriendo separando por ;  y obteniendo la posicion 1,IsEmpty. Devuelve el valor 1 (true) si hay un campo vacío; de lo contrario, devuelve el valor 0 (false).Si el espacio 1 esta vacio puede que sea un empate o que perdio el equipo 1
                if (pronosticos.get(i).split(";")[3].isEmpty()) {
                    resultadoPronostico = ResultadoEnum.EMPATE;//empate si en la posicion 3 da 0
                } else {//pierde el equipo1
                    resultadoPronostico = ResultadoEnum.PERDEDOR;
                }
            } else {
                resultadoPronostico = ResultadoEnum.GANADOR;//Si el espacio 1 no esta vacio es porque el equipo 1 GAN (ahi esta la cruz)
            }
        //Asignamos los valores de las variables mediante los set al pronostico
        pronostico.setParticipante(participante);
        pronostico.setPartido(partidosRonda[i]);
        pronostico.setEquipo(partidosRonda[i].getEquipo1());//Asignamos al equipo y luego su resultado
        pronostico.setResultado(resultadoPronostico);//seteamos el resultado

    }
        return pronostico;
    }
    public static void main(String[] args) {
        String resultado = leerArchivos("C:\\Users\\mathy\\IdeaProjects\\pruebas\\src\\modelo\\resultados.csv");//archivo resultados
        String archivo2 = leerArchivos("C:\\Users\\mathy\\IdeaProjects\\pruebas\\src\\modelo\\pronostico.csv");//archivo pronosticos persona
        List<String> partidos = new ArrayList<>();
        List<String> pronosticos = new ArrayList<>();
        Partido partidosRonda[] = new  Partido[5];
        Pronostico pronosticosRonda[] = new  Pronostico[5];
        try {
            pronosticos = Files.readAllLines(Paths.get(archivo2));
            partidos = Files.readAllLines(Paths.get(resultado));
            partidos.remove(0);//removemos primera linea del archivo resultados
            pronosticos.remove(0);//removemos primera linea del archivo pronosticos
            int i =0;
            for ( String linea: partidos  ){ //recorro cada linea del archivo resultados
                String[] arrayResultado = linea.split(";");
                //creamos el partido con (equipo,goles)
                Equipo equipo1 =new Equipo();//creo el equipo1
                equipo1.setNombre(arrayResultado[0]);//seteo el nombre del equipo 1 en el array
                Equipo equipo2 = new Equipo();//creo el equipo 2
                equipo2.setNombre(arrayResultado[3]);//seteo el nombre de equipo 2 en el array
                Partido partido1 = cargarPartidos(equipo1,equipo2,arrayResultado);
                //agregamos el  partido seteado en el metodo estatico cargarPaartidos al array partidosRonda
                partidosRonda[i] = partido1;
                i++;
            }
            Persona personas[] = new Persona[7];
            String participanteAnterior = "";
            String participante="";
            int indice=0;
            for (int z=0 ;z< pronosticos.size();z++){//for de cantidad  personas
                participante = pronosticos.get(z).split(";")[5];
                if (!participante.equals(participanteAnterior)){
                    Persona persona1 = new Persona();
                    persona1.setNombre(participante);

                    personas[z]=persona1;
                    indice++;
                }
                participanteAnterior = participante;
            }
            for (int x =0; x < indice ; x++){
                Pronostico persona1 = cargarPronosticos(x,pronosticos, partidosRonda, pronosticosRonda);
                pronosticosRonda[x]=persona1;
            }
            System.out.println(pronosticosRonda);

            //invoco a metodo estatico obtener puntos
            int totalPuntos= obtenerPuntos(pronosticosRonda,pronosticos.size());
            System.out.println("El puntaje de acuerdo al pronostico que seteo es: "+ totalPuntos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
   // String participante = pronosticos.get(i).split(";")[5];