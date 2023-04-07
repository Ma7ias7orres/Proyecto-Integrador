package modelo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static String leerArchivos(String archivo){//metodo estatico leer archivos
        String arc = archivo;
        return arc;
    }
    public static int obtenerPuntos(Pronostico[] pronosticoRonda, int indicePronostico){//metodo estatico obtener puntos
        int totalPuntos=0;
        for(int i=0; i<indicePronostico;i++){
            totalPuntos+=pronosticoRonda[i].puntos();
        }
        return totalPuntos;
    }
    public static void main(String[] args) {
        String resultado = leerArchivos("C:\\Users\\mathy\\IdeaProjects\\Proyecto-Integrador\\src\\modelo\\resultados.csv");//archivo resultados
        String archivo2 = leerArchivos("C:\\Users\\mathy\\IdeaProjects\\Proyecto-Integrador\\src\\modelo\\pronostico.csv");//archivo pronosticos persona
        List<String> partidos = new ArrayList<>();
        List<String> pronosticos = new ArrayList<>();
        Partido partidosRonda[] = new  Partido[3];
        Pronostico pronosticosRonda[] = new  Pronostico[3];
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
                Partido partido1 = new Partido();//creo el partido
                //seteamos el partido con datos  de la linea de archivo
                partido1.setEquipo1(equipo1);
                partido1.setEquipo2(equipo2);
                partido1.setGolesEquipo1(Integer.parseInt(arrayResultado[1]));//convertimos gol de string a int
                partido1.setGolesEquipo2(Integer.parseInt(arrayResultado[2]));
                //agregamos partido al array
                partidosRonda[i] = partido1;
                i++;
            }
            int x = 0;
            for (x =0; x < pronosticos.size() ; x++){//recorre partidos
                Pronostico pronostico = new Pronostico();
                ResultadoEnum resultadoPronostico;
                if ( pronosticos.get(x).split(";")[1].isEmpty()) {
                    if (pronosticos.get(x).split(";")[3].isEmpty()) {
                        resultadoPronostico = ResultadoEnum.EMPATE;
                    } else {
                        resultadoPronostico = ResultadoEnum.PERDEDOR;
                    }
                } else {
                    resultadoPronostico = ResultadoEnum.GANADOR;
                    }
                pronostico.setPartido(partidosRonda[x]);
                pronostico.setEquipo(partidosRonda[x].getEquipo1());
                pronostico.setResultado(resultadoPronostico);
                pronosticosRonda[x] = pronostico;
           }
            //invoco a metodo estatico obtener puntos
            int totalPuntos= obtenerPuntos(pronosticosRonda,pronosticos.size());
            System.out.println("El puntaje de acuerdo al pronostico que seteo es: "+ totalPuntos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}