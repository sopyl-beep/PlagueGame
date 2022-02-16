package Giereczka;

import javax.swing.*;

public class Time_thread extends Thread {
    static int attacked;
    static double mnoznik;
    static double buff;

    //Jeżeli dodam do run'a World world i będę się odwoływał do obiektu world, to będę w stanie zrobić replayability! w jednej instancji aplikacji!
    //Ale będę musiał zbyt wiele przerabiać na tym etapie, więc zostawmy graczowi niedogodność otwierania programu 2 raz. Da sobie radę, tylko bystrzaki będą w to gierczyć


    public void run(){

        for( ; !this.isInterrupted(); World.day++){             //ZYCIE ZYCIE JEST NOWELĄĄĄ

           for(int i = 0; i < World.states.size(); i++){                //ZACZYNAMY SPRAWDZANIE WSZYSTKICH PANSTW

               if(World.states.get(i).stan.equals(Giereczka.State.Stan.INFECTED))        //SPRAWDZAMY, CZY PANSTWO WYSYLAJACE JEST ZAINFEKOWANE
               {

                   double chance;
                   for(int j = 0; j < World.states.get(i).roads.size(); j++){       //SPRAWDZANIE WSZYSTKICH DRÓG
                       chance = Math.random();

                       if(chance <= World_s.ratios[World.states.get(i).roads.get(j).type]){                                         //TEST NA ZAINFEKOWANIE
                            if(World.states.get(i).roads.get(j).state[0].equals(World.states.get(i))) attacked = 1;                 //SPAGHETTI!!!! A FUCKING LOT OF SPAGHETTI !!!
                            else attacked = 0;

                            //SPRAWDZAMY, CZY ZAATAKOWANE PAŃSTWO NIE MA ZAMKNIĘTYCH GRANIC
                            if(World.states.get(i).roads.get(j).state[attacked].quarantine == 0) {

                                if(World.states.get(i).roads.get(j).state[attacked].infected == 0 && World.states.get(i).roads.get(j).state[attacked].population != 0){         //jednak tutak sprawdzamy, czy to 1 zakażenie
                                    World.states.get(i).roads.get(j).state[attacked].stan = Giereczka.State.Stan.INFECTED;
                                    Window.model.addElement("Day: " + World.day + " " + World.states.get(i).roads.get(j).state[attacked].name + "  Zostało zainfekowane!");
                                }
                                //DODAJEMY ZAKAŻONYCH PASAŻERÓW
                                if ((World.states.get(i).roads.get(j).state[attacked].infected + World_s.numbers[World.states.get(i).roads.get(j).type]) < World.states.get(i).roads.get(j).state[attacked].population) { //ŻEBY NIE PRZEKRACZA ILOSCI ZYWYCH
                                    World.states.get(i).roads.get(j).state[attacked].infected += World_s.numbers[World.states.get(i).roads.get(j).type];
                                    World.people_infected += World_s.numbers[World.states.get(i).roads.get(j).type];
                                }                                            //DODAJEMY DO ZLICZACZA GLOBALNYCH ZAINFEKOWNANYCH
                                //SPRAWDZAMY, CZY WLASNIE DOSZLO DO PIERWSZEGO ZAKAŻENIA I TRZEBA ZMIENIC STAN
                               // if (World.states.get(i).roads.get(j).state[attacked].stan != Giereczka.State.Stan.DEAD){
                               //     World.states.get(i).roads.get(j).state[attacked].stan = Giereczka.State.Stan.INFECTED;
                                //
                                //}

                            }//koniec ida z kwarantanną


                   } //kończymy akcje związane z dodawaniem, jeśli wylosujemy
               } //kończymy sprawdzanie dróg dla daleno państwa
           }} // TUTAJ KONCZYMY INFEKOWANI

           for(int i = 0; i < World.states.size(); i++){                //ROBIMY UMIERANKOOOOOOOOOOOOO I ROZPRZESTRZENIANIE WEWNĄTRZ KRAJÓW
               if(World.states.get(i).stan == Giereczka.State.Stan.INFECTED){               //AAAAALE TYLKO DLA ZAKAŻONYCH
                   buff = 0;
                   if(World.states.get(i).health_buff > 0) buff = 0.02;


                   mnoznik = 0.04 - buff;
                   if(World.states.get(i).population * 0.5 < World.states.get(i).infected){ mnoznik = 0.10 - buff;}            //DUŻO ZAKAŻONYCH TO DUŻO TRUPÓW, AWWW YEAH


                   World.states.get(i).population -= (int) ((mnoznik - World.states.get(i).sluzba_zdrowia) * World.states.get(i).infected);//zabicie procenta zakażonych
                   //if(World.states.get(i).equals(World.chiny))   System.out.println(" zabici zakażeni: " + (mnoznik - World.states.get(i).sluzba_zdrowia) * World.states.get(i).infected);

                   World.people_alive -= (int) ((mnoznik - World.states.get(i).sluzba_zdrowia) * World.states.get(i).infected);             //odjęcie martwych zakażonych od świata
                   World.people_infected -= (int) ((mnoznik - World.states.get(i).sluzba_zdrowia)  * World.states.get(i).infected);          //odjęcie martwych od zakażonych na świecie

                   World.states.get(i).infected -= (int)((mnoznik - World.states.get(i).sluzba_zdrowia) * World.states.get(i).infected);              //ZABIJAMY PROCENT ZAKAŻONYCH, TAK JAK MOJĄ MOTYWACJĘ DO ŻYCIA W TEJ CHWILI

                   if(World.states.get(i).population < 0.0005 * World.states.get(i).starting_population && !World.states.get(i).dead){  //wszystko co się dzieje jak cały kraj umiera :c na rzie przy randomowym % ludności, pomyślę nad tym jeszcze
                       World.states.get(i).stan = Giereczka.State.Stan.DEAD;
                       World.states.get(i).dead = true;
                       Window.model.addElement("Day: " +World.day + " " + World.states.get(i).name + ": KRAJ WYMARŁ CAŁKOWICIE");
                       World.people_alive -= World.states.get(i).population;
                       World.people_infected -= World.states.get(i).infected;
                       World.states.get(i).population = 0;
                       World.states.get(i).infected = 0;
                   }


                   mnoznik = 0.20 - buff;
                   if(World.states.get(i).population * 0.5 <  World.states.get(i).infected) mnoznik = 0.06 - buff;

                   //if(World.states.get(i).equals(World.chiny)) System.out.println("Dodani zakażeni " + (mnoznik - World.states.get(i).sluzba_zdrowia) * World.states.get(i).infected);

                     //dodanie zakażonych
                   World.people_infected += (int) ((mnoznik - World.states.get(i).sluzba_zdrowia) * World.states.get(i).infected);
                   World.states.get(i).infected += (int) ((mnoznik - World.states.get(i).sluzba_zdrowia) * World.states.get(i).infected);;      //chyba całe dodanie zakażonych




               }
           }






            //zerknijmy na statystyki:
            //NOTE TO MYSELF: NAUCZ SIE UZYWAC DEBUGGERA!!!!!!!
           /*if(World.day%50 == 0 ){
                System.out.println();
                System.out.println();
                System.out.println("Statystyki na dzień " + World.day);
                System.out.println("Zainfekowani w Chinach      " + World.states.get(0).infected);
                System.out.println("Żywi w chinach     " + World.states.get(0).population);
               System.out.println("Zainfekowani w Chinaaaaaach     " + World.states.get(1).infected);
               System.out.println("Żywi w chinach     " + World.states.get(1).population);
               System.out.println("Zainfekowani w Chiaaaaaanach   " + World.states.get(2).infected);
               System.out.println("Żywi w chinach      " + World.states.get(2).population);
               System.out.println("Zainfekowani w Chinaaaaaaaaach    " + World.states.get(3).infected);
               System.out.println("Żywi w chinach      " + World.states.get(3).population);
               System.out.println("Zainfekowani w Chinaaaaach    " + World.states.get(4).infected);
               System.out.println("Żywi w chinach     " + World.states.get(4).population);
               System.out.println("Zainfekowani w Chinacaaaaaaah   " + World.states.get(5).infected);
               System.out.println("Żywi w chinach     " + World.states.get(5).population);
               System.out.println("Zainfekowani w Chinaaaaaach    " + World.states.get(6).infected);
               System.out.println("Żywi w chinach     " + World.states.get(6).population);
               System.out.println("Zainfekowani w Chinaaaaaaach     " + World.states.get(7).infected);
               System.out.println("Żywi w chinach     " + World.states.get(7).population);
               System.out.println("Zainfekowani w Chiaaaaaaanach    " + World.states.get(8).infected);
               System.out.println("Żywi w chinach     " + World.states.get(8).population);
               System.out.println("Zainfekowani w Chinaaaaaaach     " + World.states.get(9).infected);
               System.out.println("Żywi w chinach      " + World.states.get(9).population);
               System.out.println("Zainfekowani w Chinaaaaaaach    " + World.states.get(10).infected);
               System.out.println("Żywi w chinach        " + World.states.get(10).population);
               System.out.println("Zainfekowani w 11     " + World.states.get(11).infected);
               System.out.println("Żywi w 11      " + World.states.get(11).population);
               System.out.println("Zainfekowani w 12     " + World.states.get(12).infected);
               System.out.println("Żywi w 12     " + World.states.get(12).population);
               System.out.println("Zainfekowani w 13    " + World.states.get(13).infected);
               System.out.println("Żywi w 13      " + World.states.get(13).population);
               } */

            //AKTUALIZOWANIE DANYCH W PANELACH
            Window.left_update();
            Window.up_update();



           //ODLICZAMY JEDEN DZIEN BONUSOW OD KRAJOW
            for(int i = 0 ; i < World.states.size(); i++){
                if(World.states.get(i).quarantine == 1) Window.model.addElement("Day " + World.day + " " + World.states.get(i).name + ": Koniec zamknięcia granic!");
                if(World.states.get(i).quarantine > 0) World.states.get(i).quarantine--;

                if(World.states.get(i).health_buff == 1) Window.model.addElement("Day " + World.day + "" + World.states.get(i).name + ": Koniec ulepszonej służby zdrowia!");
                if(World.states.get(i).health_buff > 0) World.states.get(i).health_buff--;




            }
            //dzienny przyrost poparcia
            World.poparcie += (1+World.difficulty);



            //ZRÓB SPRYTNIEJSZE ZAKOńCZENIE PROGRAMU   <- TODO!!!
           if(World.people_alive <= 0){
               //JOptionPane pytanie_o_imie;
               World.player = JOptionPane.showInputDialog("What is your name?", null);
               this.interrupt();
               //this.stop();
           }
           try {
               this.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }                //ODCZEKANIE SEKUND CO KAŻDY DZIEN
    }

    }


}
