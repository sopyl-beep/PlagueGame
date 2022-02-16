package Giereczka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuzikKrajuListener implements ActionListener {

    private int country;

    public GuzikKrajuListener(int country){
        this.country = country;
        System.out.println("GUZIK KRAJU LISTENER!");
    }
    public void actionPerformed(ActionEvent actionEvent) {
        World_s.chosen_country = country;
        Window.left_update();


        //poniższy kod wkleiłem jako metodę do Window i wywołuję ją po ludzku jako left_update(), bo nagle potrzebowałęm użyć tego w jeszcze jednym miejscu
        /*
        Window.left_name.setText(World.states.get(country).name);       //STATE ZOSTAWIłem
        Giereczka.Window.left_population.setText("" +World.states.get(country).starting_population);  //służbę zdrowia też zostawiam, nie chce mi się robić switcha dzisiaj
        Window.left_alive.setText("" + World.states.get(country).population);
        Window.left_infected.setText("" + World.states.get(country).infected);
        switch (World.states.get(country).stan){
            case INFECTED:
                Window.left_STATE.setText("Zainfekowano!");
                break;
            case DEAD:
                Window.left_STATE.setText("Kraj martwy!");
                break;
            case HEALTHY:
                Window.left_STATE.setText("Kraj niezarażony!");
                break;
        }
        switch ((int)(World.states.get(country).sluzba_zdrowia*100)){
            case 0:
                Window.left_healthcare.setText("CO zdrowia?");
                break;
            case 1:
                Window.left_healthcare.setText("Jak w lesie");
                break;
            case 2:
                Window.left_healthcare.setText("Znośna");
                break;
            case 3:
                Window.left_healthcare.setText("Dobra");
                break;
            case 4:
                Window.left_healthcare.setText("Bardzo dobra!");
                break;
            default:
                Window.left_healthcare.setText("Poza skalą. Domyśl się.");
        }
        //ZROBIC LICZBĘ DRÓÓÓÓÓÓÓÓÓG - ZAKODZIć ZLICZACZ W STATE'ACH
        Window.left_plane.setText("Połączenia lotnicze: " + World.states.get(country).sum_roads[5]);
        Window.left_rail.setText("Połączenia Lotnicze: " + World.states.get(country).sum_roads[4]);
        Window.left_boat.setText("Połączenia morskie: " + World.states.get(country).sum_roads[3]);
        Window.left_car.setText("Połączenia szynowe: " + World.states.get(country).sum_roads[2]);
        Window.left_cargo.setText("Połączenia cargo: " + World.states.get(country).sum_roads[1]);
        Window.left_feet.setText("Nielegalni imigranci:  " + World.states.get(country).sum_roads[0]);
        */
    }
}
