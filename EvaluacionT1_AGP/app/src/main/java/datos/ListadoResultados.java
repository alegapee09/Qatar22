package datos;

import java.util.ArrayList;

public class ListadoResultados {

    private ArrayList<Resultado> listaResultados = new ArrayList<Resultado>() {{
        add(new Resultado("Fase de Grupos", "2021-06-11", "España", 1, "Suiza", 1));
        add(new Resultado("Fase de Grupos", "2021-06-12", "Francia", 1, "Alemania", 0));
        add(new Resultado("Fase de Grupos", "2021-06-13", "Portugal", 3, "Hungría", 0));
        add(new Resultado("Fase de Grupos", "2021-06-14", "Polonia", 1, "Eslovaquia", 2));
        add(new Resultado("Fase de Grupos", "2021-06-15", "Inglaterra", 3, "Gales", 1));
        add(new Resultado("Fase de Grupos", "2021-06-16", "Dinamarca", 1, "Finlandia", 0));
        add(new Resultado("Fase de Grupos", "2021-06-17", "Holanda", 3, "Ucrania", 2));
        add(new Resultado("Fase de Grupos", "2021-06-18", "Inglaterra", 1, "Croacia", 0));
        add(new Resultado("Fase de Grupos", "2021-06-19", "Belgica", 4, "Dinamarca", 1));
        add(new Resultado("Fase de Grupos", "2021-06-20", "Francia", 0, "Portugal", 1));
        add(new Resultado("Fase de Grupos", "2021-06-21", "España", 0, "Polonia", 1));
        add(new Resultado("Fase de Grupos", "2021-06-22", "Suiza", 1, "Turquía", 3));
        add(new Resultado("Fase de Grupos", "2021-06-23", "Bélgica", 3, "Finlandia", 0));
        add(new Resultado("Fase de Grupos", "2021-06-24", "Italia", 1, "Suiza", 3));
    }};


    public void addResultado(Resultado result) {
        listaResultados.add(result);
    }


    public ArrayList<Resultado> getResultado(String pais) {
        ArrayList<Resultado> listResultPais = new ArrayList<>();
        for (Resultado result : listaResultados) {
            if (result.getPrimerequipo().equals(pais) || result.getSegundoequipo().equals(pais)) {
                listResultPais.add(result);
            }
        }
        return listResultPais;
    }

}