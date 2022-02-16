package Giereczka;
import javax.swing.*;
import java.util.ArrayList;


public class State {

    public enum Stan{
        HEALTHY, INFECTED, DEAD;
    }
    Stan stan;
    String name;
    long starting_population;
    int dev;
    long population;
    long infected;
    double sluzba_zdrowia;
    int[] sum_roads = new int[]{ 0, 0, 0, 0, 0, 0,};
    int quarantine;
    int health_buff;
    int hb2;
    boolean dead;
    ImageIcon flag;
    ArrayList<Transport_way> roads = new ArrayList<Transport_way>();



    public State(String name, int dev, long population, double sluzba_zdrowia){

        this.dead = false;
        this.sum_roads = new int[]{0, 0, 0, 0, 0, 0};
        this.sluzba_zdrowia = sluzba_zdrowia;
        this.starting_population = population;
        this.name = name;
        this.dev = dev;
        this.population = population;
        this.infected = 0;
        this.stan = Stan.HEALTHY;
        this.quarantine = 0;
        this.health_buff = 0;
        this.hb2 = 0;
        roads = new ArrayList<Transport_way>();
    }


    public static void Add_road(State s1, State s2){

        int type = (int)(Math.random()*5);
        type -= (int)((s1.dev + s2.dev)/6);
        Transport_way road = new Transport_way(type, s1, s2);
        s1.roads.add(road);
        s2.roads.add(road);
        if(type > 5 || type < 0) type = 0;
        s1.sum_roads[type]++;
        s2.sum_roads[type]++;

    }
    public void setFlag(ImageIcon flag){
        this.flag = flag;
    }




}
