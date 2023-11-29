package T3Voraces.exams;

import TheOtherClasses.Voraces.jul2022.Concursante;

import java.util.ArrayList;

public class jul2022 {

    /*
     gente
     */

    public void creaEquiposVoraz(ArrayList<Concursante> supervivientes, ArrayList<Concursante> equipo1, ArrayList<Concursante> equipo2){
        double eq1=0, eq2=0;
        Concursante conc;
        while(!supervivientes.isEmpty()){
            conc = seleccionarMejorCandidato(supervivientes);
            supervivientes.remove(conc);
            if(eq1<eq2){
                equipo1.add(conc);
                eq1 += conc.fuerzaConcursante();
            } else {
                equipo2.add(conc);
                eq2 += conc.fuerzaConcursante();
            }
        }
    }

    private Concursante seleccionarMejorCandidato(ArrayList<Concursante> candidatos){
        Concursante conc = null;
        double maxFuerza = 0;
        for(int i = 0 ; i < candidatos.size() ; i++){
            if(candidatos.get(i).fuerzaConcursante() > maxFuerza)
                conc = candidatos.get(i);
        }
        return conc;
    }
}
