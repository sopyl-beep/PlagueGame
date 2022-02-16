package Giereczka;

import javax.swing.*;
import java.util.ArrayList;

public class World{
    //podstawowe staty
    public static int day = 1;
    public static String player;
    public static int victory_goal = 1000; //TO SIĘ ZMIENIA W ZALEŻNOSCI OD LVL TRUDNOSCI ALBO WYWALĘ I BĘDZIE TRYB PRZETRWANIA PEWNIE      //i wywaliłem
    public static int poparcie = 100;
    public static int hajs = 100000;
    public static long people_infected = 0;
    public static long people_dead = 0;
    public static long people_alive;
    public static long people_all;
    public static int difficulty = 2; // <- zmienia ilość popracia

    //tworzenie krajów

    public static State chiny = new State("China", 1, 2000000, 0.03);
    public static State s2 = new State("India", 3, 35000, 0.01);
    public static State s3 = new State("Iran", 4, 700000, 0.00);
    public static State s4 = new State("Arabic penisula", 2, 370000, 0.02);
    public static State s5 = new State("USA)", 3, 75000, 0.01);
    public static State s6 = new State("Russia", 3, 120000, 0.01);
    public static State s7 = new State("Korea & Japan", 1, 75000, 0.03);
    public static State s8 = new State("Grenlandia", 0, 30000, 0.04);
    public static State s9 = new State("Indonesia", 3, 14000, 0.01);
    public static State s10 = new State("Australia", 1, 140000 , 0.03);
    //public static State s11 = new State("Eastern europe", 2, 1400000, 0.02);
    //public static State s12 = new State("Scandinavia", 1, 1400000, 0.03);
    public static State s11 = new State("Europe", 1, 140000, 0.03);
    public static State s12 = new State("Mediterranean Africa", 3, 140000, 0.01);
    public static State s13 = new State("Ethiopia", 4, 14000, 0.00);
    public static State s14 = new State("Western Africa", 4, 14000, 0.00);
    public static State s15 = new State("Southern Africa", 4, 14000, 0.00);
    public static State s16 = new State("Argentina", 3, 70000, 0.01);
    public static State s17 = new State("Brasilia", 3, 14000, 0.01);
    public static State s18 = new State("Colombia", 4, 11000, 0.00);
    public static State s19 = new State("Mexico", 3, 45000, 0.01);
    public static State s20 = new State("Canada", 1, 30000,0.04);

    //przeliczniki
    public static double[] przelicznik = {0.1, 0.05, 0.03, 0.015, 0.01, 0.005 };
    public static int[] pasazerowie = {1, 20, 50, 50, 1000, 100};



    //TWORZYMY SWIAAAAT
    public static ArrayList<State> states = new ArrayList<>();

    public World(){

        ImageIcon flag = new ImageIcon(("images/china.png"));
        chiny.setFlag(flag);
        states.add(chiny);
        flag = new ImageIcon(("images/india.png"));
        s2.setFlag(flag);
        states.add(s2);
        flag = new ImageIcon(("images/iran.png"));
        s3.setFlag(flag);
        states.add(s3);
        flag = new ImageIcon(("images/arabic.png"));
        s4.setFlag(flag);
        states.add(s4);
        flag = new ImageIcon(("images/usa.png"));
        s5.setFlag(flag);
        states.add(s5);
        flag = new ImageIcon(("images/russia.png"));
        s6.setFlag(flag);
        states.add(s6);
        flag = new ImageIcon(("images/korea.png"));
        s7.setFlag(flag);
        states.add(s7);
        flag = new ImageIcon(("images/greenland.png"));
        s8.setFlag(flag);
        states.add(s8);
        flag = new ImageIcon(("images/indonesia.png"));
        s9.setFlag(flag);
        states.add(s9);
        flag = new ImageIcon(("images/australia.png"));
        s10.setFlag(flag);
        states.add(s10);
        flag = new ImageIcon(("images/europe.png"));
        s11.setFlag(flag);
        states.add(s11);
        flag = new ImageIcon(("images/mediterranean.png"));
        s12.setFlag(flag);
        states.add(s12);
        flag = new ImageIcon(("images/ethiopia.png"));
        s13.setFlag(flag);
        states.add(s13);
        flag = new ImageIcon(("images/niger.png"));
        s14.setFlag(flag);
        states.add(s14);
        flag = new ImageIcon(("images/rpa.png"));
        s15.setFlag(flag);
        states.add(s15);
        flag = new ImageIcon(("images/argentina.png"));
        s16.setFlag(flag);
        states.add(s16);
        flag = new ImageIcon(("images/brasil.png"));
        s17.setFlag(flag);
        states.add(s17);
        flag = new ImageIcon(("images/colombia.png"));
        s18.setFlag(flag);
        states.add(s18);
        flag = new ImageIcon(("images/mexico.png"));
        s19.setFlag(flag);
        states.add(s19);
        flag = new ImageIcon(("images/canada.png"));
        s20.setFlag(flag);
        states.add(s20);
        //states.add(s21);
        //states.add(s22);

        for(int i = 0; i < states.size(); i++){
            people_all+= states.get(i).population;
            people_alive = people_all;
        }

        for(int i = 0; i < states.size(); i ++){
            for(int j = 0; j < states.size(); j++){
                if(j != i){
                    State.Add_road(states.get(i), states.get(j));
                    State.Add_road(states.get(i), states.get(j));
                }
            }
        }

        //PACJENCI ZERO
        chiny.stan = State.Stan.INFECTED;
        chiny.infected += 100;
        people_infected = 100;




    }
}
