package Giereczka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//MAM NADZIEJĘ, ŻE JAK W ROBOCIE ZOBACZĄ TEN SZAJS, TO NIGDY NIKT MI NIE KAŻE MI ROBIĆ USER INTERFACE'U



public class Window extends JFrame {





        JFrame f;
        public static JLayeredPane panel;
        Color light = new Color(229,242,255);
        Color navy = new Color(23,42,85);
        Color gold = new Color(254, 202, 1);
        public static JLabel left_name = new JLabel();
        public static JLabel left_stan = new JLabel("Stan kraju:");
        public static JLabel left_STATE = new JLabel();
        public static JLabel left_populacja = new JLabel("Początkowa populacja:");
        public static JLabel left_population = new JLabel();        //moje klawisze ctrl i V powoli zaczynają się psuć :C
        public static JLabel left_zakazeni = new JLabel("Zarażeni:");
        public static JLabel left_infected = new JLabel();
        public static JLabel left_zywi = new JLabel("Żywi:");
        public static JLabel left_alive = new JLabel();             //w upływie czasu było spaghetti. To jest absolutna lasagne
        public static JLabel left_sluzba = new JLabel("Stan służby zdrowia:");
        public static JLabel left_healthcare = new JLabel();
        public static JLabel left_roads = new JLabel("Ilość dróg:");
        public static JLabel left_plane = new JLabel();
        public static JLabel left_boat = new JLabel();
        public static JLabel left_rail = new JLabel();
        public static JLabel left_car = new JLabel();
        public static JLabel left_feet = new JLabel();
        public static JLabel left_cargo = new JLabel();


        public static JLabel up_day = new JLabel("TEST");
        public static JLabel up_poparcie = new JLabel("PUNKTY POPARCIA LUDU: 100");
        public static JLabel up_hajs = new JLabel("DOSTĘPNE FUNDUSZE: $400B");
        public static JLabel up_population = new JLabel("TEST");
        public static JLabel up_infected = new JLabel("TEST");
        //cebula ma warstwy, ogry mają warstwy! TE LABELE MAJA WARSTWY!!!!!

        public static DefaultListModel<String> model = new DefaultListModel<String>();
        public static JList<String> actions_taken = new JList<>();
        public static JLabel flag = new JLabel();


       public Window(){
           /*JFrame menu = new JFrame();
           boolean working = true;
           menu.setLocationRelativeTo(null);
           menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           menu.setLayout(null);
           menu.setVisible(true);
           menu.setSize(400, 600);
           menu.setTitle("Menu");
           while(working){
                                        //słabe próby zrobienia menu :c
           }*/



           //podstawowe info do JRamki!
           setLocationRelativeTo(null);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLayout(null);
           setVisible(true);
           setSize(1800, 1000);
           setTitle("Giereczka");

           //DODAJEMY MAPĘ!
           JLabel map = new JLabel();
           map.setBounds(250,100,1150,650);
           ImageIcon mapa = new ImageIcon("images/mapa3.jpg");
           map.setIcon(mapa);
           add(map);
           //DODAJEMY FLAGI!

           flag.setBounds(10,10,220,120);
           add(flag);

            //dodanie historii akcji wykonanych po prawej stronie!
           model.addElement("HISTORIA PODJĘTYCH AKCJI: ");

           JScrollPane lista = new JScrollPane(actions_taken);
           actions_taken.setBackground(navy);
           actions_taken.setForeground(light);
           lista.setBackground(navy);
           lista.setForeground(light);
           actions_taken.setModel(model);
           lista.setBorder(null);
           actions_taken.setBorder(null);
           lista.setBounds(1435,100,340,800);
           add(lista);
          // add(actions_taken);

            //CZY ŻAŁUJĘ, ŻE ZNOWU NIE DODAŁEM TEGO WSZYSTKIEGO DO JEDNEGO SENSOWNEGO ZBIORU ALBO NIE ZROBIŁEM JEDNEGO POLA TEKSTOWEGO, KTÓRE TO WYŚWIETLA? TAK. NAWET BARDZO.
           left_name.setForeground(light);
           left_stan.setForeground(light);
           left_STATE.setForeground(light);
           left_populacja.setForeground(light);
           left_population.setForeground(light);
           left_zakazeni.setForeground(light);
           left_infected.setForeground(light);
           left_zywi.setForeground(light);
           left_alive.setForeground(light);
           left_sluzba.setForeground(light);
           left_healthcare.setForeground(light);
           left_roads.setForeground(light);
           left_plane.setForeground(light);
           left_boat.setForeground(light);
           left_rail.setForeground(light);
           left_car.setForeground(light);
           left_cargo.setForeground(light);
           left_feet.setForeground(light);

           //analogiczne płakanie nad górnym panalem
            up_population.setBounds(270 , 5, 200, 40);
            up_population.setForeground(light);
            add(up_population);
            up_infected.setBounds(270, 45, 200,40);
            up_infected.setForeground(light);
            add(up_infected);
            up_poparcie.setBounds(1070, 5, 200,40);
            up_poparcie.setForeground(light);
            add(up_poparcie);
            up_hajs.setBounds(1070, 45, 200,40);
            up_hajs.setForeground(light);
            add(up_hajs);
            up_day.setBounds(750,5,200,40);
            up_day.setForeground(light);
            add(up_day);
            up_update();

            //W imieniu Polski podziemniej siedzącej w piwnicy i kodzącej - skazuję sam siebie na śmierć za zdradę ojczyzny i zrobienie tego wykomentowanego już syfu poniżej kilka dni temu

           //dodajemy cały panel informacji o kraju po lewej stronie ekranu, dzialąc go na kolejne linijki, które łatwo się update'uje. GDZIE JEST CSS
           // DO UKłADANIA STYLÓW JAK GO POTRZEBUJĘĘĘĘĘĘĘ
           /*JLabel left_name. = new JLabel("TEST");
           JLabel left_stan = new JLabel("Stan kraju:");
           JLabel left_STATE = new JLabel("TEST");
           JLabel left_populacja = new JLabel("Początkowa populacja");
           JLabel left_population = new JLabel("TEST");
           JLabel left_zakazeni = new JLabel("Zakażeni:") ;
           JLabel left_infected = new JLabel("TEST") ;
           JLabel left_zywi= new JLabel("Żywi:");
           JLabel left_alive= new JLabel("TEST");
           JLabel left_sluzba= new JLabel("Jakość służby zdrowia:");
           JLabel left_healthcare= new JLabel("TEST");
           JLabel left_roads= new JLabel("Ilość dróg:");
           JLabel left_plane= new JLabel("TEST");
           JLabel left_boat= new JLabel("TEST");
           JLabel left_rail= new JLabel("TEST");
           JLabel left_car= new JLabel("TEST");
           JLabel left_cargo = new JLabel("TEST");
           JLabel left_feet= new JLabel("TEST");*/  //^powyższa podwójna implementacja prawie zabiła moje zdrowie psychiczne, bo GuzikKrajuListener nie wiedział, do czego się odwołać i robił nic


           left_name.setBounds(50,140,200,64);
           add(left_name);
           left_stan.setBounds(50,204,200,64);
           add(left_stan);
           left_STATE.setBounds(50,234,200,64);
           add(left_STATE);
           left_populacja.setBounds(50,300,200,64);
           add(left_populacja);
           left_population.setBounds(50,332,200,64);
           add(left_population);
           left_zakazeni.setBounds(50,396,200,64);
           add(left_zakazeni);
           left_infected.setBounds(50,428,200,64);
           add(left_infected);
           left_zywi.setBounds(50,492,200,64);
           add(left_zywi);
           left_alive.setBounds(50,524,200,64);
           add(left_alive);
           left_sluzba.setBounds(50,588,200,64);
           add(left_sluzba);
           left_healthcare.setBounds(50,620,200,64);
           add(left_healthcare);
           left_roads.setBounds(50,684,200,64);
           add(left_roads);
         //  left_plane.setBounds(50,708,200,64);
           //add(left_plane);
           left_rail.setBounds(50,740,200,64);
           add(left_rail);
           left_boat.setBounds(50,772,200,64);
           add(left_boat);
           left_car.setBounds(50,804,200,64);
           add(left_car);
           left_feet.setBounds(50,868,200,64);
           add(left_feet);
           left_cargo.setBounds(50,836,200,64);
           add(left_cargo);


           left_update();
           //^ JEŻU, JAKIE DłUGIE       ^ZAMIENIŁEM MIEJSCAMI BO ZAPOMNIAŁEM O CARGO, NIECH PRZYSZŁY JA NIE SZUKA, DLACZEGO JEST NIEREGULARNIE PLIIIIS


           //tu jest lista buttonów dla krajów. łzy lecą nad klawiaturą jak na konstytucję

           //poniższe 134 linie są wyrazem mojej głębokiej cierpliwości i miłości, jakimi
           //darzę Pana przedmiot i te studia.

           //Tworzenie klasy GuzikKraju od razu pobierającej koordynaty nie miało sensu, bo i tak musiałbym je wklepywać ręcznie, a tak kopiuję i wklejam komendy
           //a potem ręcznie na szybkości zmieniam koordynaty. Tyle samo pracy, a mniej bałaganu z dodatkowymi klasami

           //koordynaty znajduję otwierając mapę w paintcie (swoją drogą została w nim wykonana), a następnie najeżdżając kursorem na lewe górne rogi stref. potem zaznaczam kraj
           //i na dole strony mam dane o rozmiarze zaznaczenia. PAINT FOR LIFE <3


           GuzikKraju b1 = new GuzikKraju(19);
           b1.setBounds(260,180,315,100);
           b1.addActionListener(new GuzikKrajuListener(19));
           b1.setOpaque(false);
           add(b1);

           GuzikKraju b2 = new GuzikKraju(7);
           b2.setBounds(325+250,150,150,90);
           b2.addActionListener(new GuzikKrajuListener(7));
           b2.setOpaque(false);
           add(b2);

           GuzikKraju b3 = new GuzikKraju(4);
           b3.setBounds(60+250,290,200,85);
           b3.addActionListener(new GuzikKrajuListener(4));
           b3.setOpaque(false);
           add(b3);

           GuzikKraju b4 = new GuzikKraju(18);
           b4.setBounds(87+250,285+100,160,55);
           b4.addActionListener(new GuzikKrajuListener(18));
           b4.setOpaque(false);
           add(b4);

           GuzikKraju b5 = new GuzikKraju(17);
           b5.setBounds(190+250,340+100,150,65);
           b5.addActionListener(new GuzikKrajuListener(17));
           b5.setOpaque(false);
           add(b5);

           GuzikKraju b6 = new GuzikKraju(16);
           b6.setBounds(185+250,405+100,185,75);
           b6.addActionListener(new GuzikKrajuListener(16));
           b6.setOpaque(false);
           add(b6);

           /*GuzikKraju b7 = new GuzikKraju(16);
           b7.setBounds(+250,340+100,150,65);
           b7.addActionListener(new GuzikKrajuListener(16));
          // b7.setOpaque(false);
           add(b7);*/

           GuzikKraju b8 = new GuzikKraju(15);
           b8.setBounds(235+250,490+100,100,145);
           b8.addActionListener(new GuzikKrajuListener(15));
           b8.setOpaque(false);
           add(b8);

           GuzikKraju b9 = new GuzikKraju(10);
           b9.setBounds(485+250,100+100,135,130);
           b9.addActionListener(new GuzikKrajuListener(10));
           b9.setOpaque(false);
           add(b9);

           GuzikKraju b10 = new GuzikKraju(11);
           b10.setBounds(455+250,240+100,165,40);
           b10.addActionListener(new GuzikKrajuListener(11));
           b10.setOpaque(false);
           add(b10);

           GuzikKraju b11 = new GuzikKraju(13);
           b11.setBounds(435+250,285+100,150,90);
           b11.addActionListener(new GuzikKrajuListener(13));
           b11.setOpaque(false);
           add(b11);

           GuzikKraju b12 = new GuzikKraju(12);
           b12.setBounds(590+250,290+100,60,90);
           b12.addActionListener(new GuzikKrajuListener(12));
           b12.setOpaque(false);
           add(b12);
           GuzikKraju b13 = new GuzikKraju(12);
           b13.setBounds(650+250,340+100,50,50);       // <- drugi guzik do etiopii!
           b13.addActionListener(new GuzikKrajuListener(12));
           b13.setOpaque(false);
           add(b13);

           GuzikKraju b14 = new GuzikKraju(14);
           b14.setBounds(535+250,395+100,160,150);
           b14.addActionListener(new GuzikKrajuListener(14));
           b14.setOpaque(false);
           add(b14);

           GuzikKraju b15 = new GuzikKraju(5);
           b15.setBounds(630+250,80+100,285,140);
           b15.addActionListener(new GuzikKrajuListener(5));
           b15.setOpaque(false);
           add(b15);
           GuzikKraju b16 = new GuzikKraju(5);
           b16.setBounds(925+250,88+100,120,110);   //<- i drugi dla Mateczki Rosji
           b16.addActionListener(new GuzikKrajuListener(5));
           b16.setOpaque(false);
           add(b16);

           GuzikKraju b17 = new GuzikKraju(6);
           b17.setBounds(935+250,200+100,90,50);
           b17.addActionListener(new GuzikKrajuListener(6));
           b17.setOpaque(false);
           add(b17);

           GuzikKraju b18 = new GuzikKraju(3);
           b18.setBounds(640+250,235+100,70,85);
           b18.addActionListener(new GuzikKrajuListener(3));
           b18.setOpaque(false);
           add(b18);

           GuzikKraju b19 = new GuzikKraju(2);
           b19.setBounds(710+250,235+100,60,70);
           b19.addActionListener(new GuzikKrajuListener(2));
           b19.setOpaque(false);
           add(b19);

           GuzikKraju b20 = new GuzikKraju(1);
           b20.setBounds(775+250,235+100,60,135);
           b20.addActionListener(new GuzikKrajuListener(1));
           b20.setOpaque(false);
           add(b20);

           GuzikKraju b21 = new GuzikKraju(0);
           b21.setBounds(840+250,240+100,100,110);
           b21.addActionListener(new GuzikKrajuListener(0));
           b21.setOpaque(false);
           add(b21);

           GuzikKraju b22 = new GuzikKraju(8);
           b22.setBounds(850+250,355+100,240,85);
           b22.addActionListener(new GuzikKrajuListener(8));
           b22.setOpaque(false);
           add(b22);

           GuzikKraju b23 = new GuzikKraju(9);
           b23.setBounds(910+250,450+100,180,160);
           b23.addActionListener(new GuzikKrajuListener(9));
           b23.setOpaque(false);
           add(b23);
           //KONIEC GUZIKÓW KRAJÓW!!!!

           //CZAS NA 10 GUZIKÓW OPCJIIIII!!!!!          :c JA CHCĘ WRÓCIĆ DO ROBIENIA WĄTKÓÓÓÓÓÓÓÓÓW I MECHANIKIII


           JButton o1 = new JButton("<html><center>Zamknięcie zewnętrznych granic kraju na miesiąc<br>Koszt: $10B</center></html>");
           o1.setBounds(275,780, 210, 75);
           o1.setBackground(light);
           o1.setForeground(navy);
           o1.setOpaque(true);
           o1.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   if (World_s.chosen_country != 0) {

                       if (World.hajs < 10) {
                           JOptionPane.showMessageDialog(f, "Nie ma pieniędzy!");
                       } else {
                           model.addElement("Day: " +World.day + " " + World.states.get(World_s.chosen_country).name + ":  Kwarantanna od " + World.day + " do " + (World.day+30));
                           World.hajs -= 10;
                           World.states.get(World_s.chosen_country).quarantine += 30;
                           up_update();
                       }
                   }
                   else{
                       JOptionPane.showMessageDialog(f,"<html><center>Nikt nie będzie ingerował w wewnętrzne sprawy <br> Wielkiej Chińskiej Republiki Ludowej!</center></html>");
                   }
               }
           });
           add(o1);


           JButton o2 = new JButton("<html><center>Dofinansuj służbę zdrowia w kraju na miesiąc! <br> Koszt: $30B");
           o2.setBounds(275,870, 210, 75);
           o2.setBackground(light);
           o2.setForeground(navy);
           o2.setOpaque(true);
           o2.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                 if(World_s.chosen_country!=0){

                   if(World.hajs < 30){
                       JOptionPane.showMessageDialog(f,"Nie ma pieniędzy!");
                   }
                   else{
                       World.hajs-=30;
                       World.states.get(World_s.chosen_country).health_buff += 30;
                       model.addElement("Day: " +World.day + " " + World.states.get(World_s.chosen_country).name + ": Dofinansowane szpitale od " + World.day + " do " + (World.day+30));
                       up_update();
                   }}
                 else{
                     JOptionPane.showMessageDialog(f,"<html><center>Nikt nie będzie ingerował w wewnętrzne sprawy <br> Wielkiej Chińskiej Republiki Ludowej!</center></html>");
                 }


               }
           });
           add(o2);


           JButton o3 = new JButton("<html><center>Finansuj światową propagandę! <br> Koszt: $15B</center></html>");
           o3.setBounds(495,780, 210, 75);
           o3.setBackground(light);
           o3.setForeground(navy);
           o3.setOpaque(true);
           o3.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   if(World.hajs < 15){
                       JOptionPane.showMessageDialog(f,"Nie ma pieniędzy!");
                   }
                   else{
                       World.hajs-=15;
                       World.poparcie += 20;
                       model.addElement("Day: " +World.day + " Pasek w TVP: Koronawirus = opozycja!");
                       up_update();
                   }
               }
           });
           add(o3);


           JButton o4 = new JButton("<html><center>Usuń 1000 zarażonych z kraju! <br> Koszt: 20 poparcia</center></html>");
           o4.setBounds(495,870, 210, 75);
           o4.setBackground(light);
           o4.setForeground(navy);
           o4.setOpaque(true);
           o4.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   if(World_s.chosen_country!=0) {
                       if (World.states.get(World_s.chosen_country).population < 1000) {
                           JOptionPane.showMessageDialog(f, "Nie ma do kogo strzelać :c");
                       }
                       else {
                           if (World.poparcie < 20) {
                               JOptionPane.showMessageDialog(f, "Ludzie się nie zgodzą!");
                           } else {
                               World.poparcie -= 20;
                               if (World.states.get(World_s.chosen_country).infected < 1000) {
                                   World.people_infected -= World.states.get(World_s.chosen_country).infected;
                                   World.states.get(World_s.chosen_country).infected = 0;
                               } else {
                                   World.states.get(World_s.chosen_country).infected -= 1000;
                                   World.people_infected -= 1000;
                               }
                               World.people_alive -= 1000;
                               World.states.get(World_s.chosen_country).population -= 1000;
                               model.addElement("Day: " + World.day + " " + World.states.get(World_s.chosen_country).name + ": Tajemnicze zniknięcie 1000 obywateli!");
                               left_update();
                               up_update();
                           }
                       }}
                   else{
                           JOptionPane.showMessageDialog(f, "<html><center>Nikt nie będzie mówił Chińskiej Republice Ludowej <br> kiedy i jak ma strzelać do swoich obywateli!</center></html>");
                       }


               }
           });
           add(o4);


           JButton o5 = new JButton("<html><center>Walcz z nielegalną migracją! <br>  Koszt: 5 poparcia, $10B");
           o5.setBounds(715,780, 210, 75);
           o5.setBackground(light);
           o5.setForeground(navy);
           o5.setOpaque(true);
           o5.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   if(World.poparcie < 15 || World.hajs < 10){
                       JOptionPane.showMessageDialog(f,"Nie ma pieniędzy lub poparcia!");
                   }
                   else{
                       System.out.println();
                       World.hajs-=10;
                       World.poparcie-=5;
                       World_s.numbers[0]-=5;
                       World_s.ratios[0]-=0.005;
                       model.addElement("<html>Day: " + World.day + " Wysłano więcej Sebkó...funkcjonariuszy <br>       do pilnowania granic!");
                       up_update();
                   }
               }
           });
           add(o5);

           JButton o6 = new JButton("<html><center>Zbiórka pieniędzy na walkę! <br>  Koszt: 30 poparcia");
           o6.setBounds(715,870, 210, 75);
           o6.setBackground(light);
           o6.setForeground(navy);
           o6.setOpaque(true);
           o6.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent actionEvent) {
                   if(World.poparcie < 30){
                       JOptionPane.showMessageDialog(f,"Nie ma zgody ludu na ten syf!");
                   }
                   else{
                       World.hajs+=20;
                       World.poparcie-=30;
                       model.addElement("Day: " + World.day + " " + World.states.get(World_s.chosen_country).name + ": Członkowie rządu robią Hot16Challenge!");
                       up_update();
                   }
               }
           });
           add(o6);

           JButton o7 = new JButton("OPCJA NUMER 1");
           o7.setBounds(935,780, 210, 75);
           o7.setBackground(light);
           o7.setForeground(navy);
           o7.setOpaque(true);
           add(o7);
           JButton o8 = new JButton("OPCJA NUMER 2");
           o8.setBounds(935,870, 210, 75);
           o8.setBackground(light);
           o8.setForeground(navy);
           o8.setOpaque(true);
           add(o8);

           JButton o9 = new JButton("OPCJA NUMER 1");
           o9.setBounds(1155,780, 210, 75);
           o9.setBackground(light);
           o9.setForeground(navy);
           o9.setOpaque(true);
           add(o9);
           JButton o10 = new JButton("OPCJA NUMER 2");
           o10.setBounds(1155,870, 210, 75);
           o10.setBackground(light);
           o10.setForeground(navy);
           o10.setOpaque(true);
           add(o10);





           //tła i ramki! barbarzyńsko, ale skutecznie i łatwo! Bardzo barbarzyńsko, ale bardzo skutecznie i bardzo łatwo

           JLabel back4 = new JLabel();         //górny label
           back4.setBackground(navy);
           back4.setBounds(240,10,1170,70);
           back4.setOpaque(true);
           add(back4);

           JLabel back5 = new JLabel();             //label dolny
           back5.setBackground(navy);
           back5.setBounds(240,770,1170,185);
           back5.setOpaque(true);
           add(back5);

           JLabel back3 = new JLabel();                     //ramka mapy
           back3.setBackground(gold);
           back3.setBounds(230,0,1190,1000);
           back3.setOpaque(true);
           add(back3);

           JLabel back1 = new JLabel();                        //tło główne
           back1.setBackground(navy);
           back1.setBounds(10,10,1765,945);
           back1.setOpaque(true);
           add(back1);

           JLabel back2 = new JLabel();                     //ramka całości
           back2.setBackground(gold);
           back2.setBounds(0,0,1800,1000);
           back2.setOpaque(true);
           add(back2);



            //do tego momentu jest frame, który działa i odpala się sam




           //TUTAJ ODPALAM WĄTEK Z CZASEM, BO MOGĘ
            Time_thread gierka = new Time_thread();

            gierka.start();




       }



       public static void left_update(){
           Window.left_name.setText(World.states.get(World_s.chosen_country).name);
           Giereczka.Window.left_population.setText("" +World.states.get(World_s.chosen_country).starting_population);
           Window.left_alive.setText("" + World.states.get(World_s.chosen_country).population);
           Window.left_infected.setText("" + World.states.get(World_s.chosen_country).infected);
           switch (World.states.get(World_s.chosen_country).stan){
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
           switch ((int)(World.states.get(World_s.chosen_country).sluzba_zdrowia*100)){
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
           Window.left_plane.setText("Połączenia lotnicze: " + World.states.get(World_s.chosen_country).sum_roads[5]);
           Window.left_rail.setText("Połączenia Lotnicze: " + World.states.get(World_s.chosen_country).sum_roads[4]);
           Window.left_boat.setText("Połączenia morskie: " + World.states.get(World_s.chosen_country).sum_roads[3]);
           Window.left_car.setText("Połączenia szynowe: " + World.states.get(World_s.chosen_country).sum_roads[2]);
           Window.left_cargo.setText("Połączenia cargo: " + World.states.get(World_s.chosen_country).sum_roads[1]);
           Window.left_feet.setText("Nielegalni imigranci:  " + World.states.get(World_s.chosen_country).sum_roads[0]);
           Window.flag.setIcon(World.states.get(World_s.chosen_country).flag);

       }

       public static void up_update(){
           up_day.setText("Day: " + World.day);
           up_hajs.setText("Dostępne fundusze:  $" + World.hajs +"B");
           up_poparcie.setText("Punkty poparcia ludu: " + World.poparcie);
           up_population.setText("Jeszcze żywi: " + World.people_alive);
           up_infected.setText("..ale już zainfekowani: " +World.people_infected);
       }
       }

