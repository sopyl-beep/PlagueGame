package Giereczka;

import java.sql.Time;
import java.util.ArrayList;
import javax.swing.*;



/*
Witam w moim małym bałaganie
Niestety znowu nie udało mi się osiągnąć wszystkiego, co chciałem.
W kodzie jest trochę syfu, ale najgorsze miejsca są mocno pokomentowane, a poszczególne sekcje starałem się porozdzielać również zgrabnymi komentarzami.
Jako, że komentarze służyły mi na bieżąco do opisu sytuacji oraz trochę wylewania frustracji, z góry przepraszam, jeśli nie usuąłem czegoś zahaczającego o wulgaryzmy.

Brakuje:
-głównego menu (tak wiem :c) - poziom trudności jako zmienna jest ustawiony, ale niestety nie pykło odpalanie okien jedno po drugim.
-zapisu wyniku do pliku - pobieram jednak na końcu od gracza w osobnym oknie jego imię, które mogę potem użyć do zapisu oraz mam dzień, będący wynikiem
-skrótu klawiszowego - trudno mi wrócić do menu, które jest nieistniejące :c
-Oznaczeń dróg - zrobienie drawLine pomiędzy wcześniej ustalonymi środkami poszczególnych państw nie jest problemem. Zrobienie DrawIcon na środku tej drogi też nie.
                 Poległem na czynieniu tego czytelnym i nie psującym jakiejkolwiek widoczności, więc dróg nie ma.
-4 guziki nie mają funkcji - mogłem dodać ograniczanie poruszania się kolejnymi 4 drogami (tak jak w przypadku umiejętności odpowiadającej za ograniczanie nielegalnego przemieszczania),
                             ale liczyłem do samego końca na inspirację na coś ciekawszego, niż przekopiowanie i wklejenie 4 następne razy zrobionego kilka linijek wyżej przycisku. No nie wyszło :c

Dodatkowe info:
-kraje na mapie są klikalne i po lewej wyświetla się na panelu informacja o obecnie wybranym kraju
-żeby potestować rzeczy zostawiłem god mode, z nieskończoną gotówką
-Po prawej można śledzić historię wydarzeń oraz własnych działań.
-Dokładne szanse na zainfekowanie innych krajów nie były przeze mnie testowane zbyt wiele razy, więc bez ingerencji gracza cały świat łapie wirusa w około 7-8 dni.
-Wszystko prawie (łącznie z drogami, szansami na infekcję) jest oparte o RNG.
-Ze względu na to, iż użycie niektórych umiejętności bezpośrednio na Chinach na początku gry niszczyłoby rozgrywkę, wprowadziłem na nie ograniczenia.
-Tryb jest w zamiarze nieskończony, wynikiem jest liczba przetrwanych dni. Widzę jednak opcje złamania gierki i wytrzymania w nieskończoność przy odpowiednim spamowaniu kwarantanną,
 ale jest to RACZEJ niemożliwe przy ograniczonej gotówce.
-Obecne liczby użyte w grze pozwalają na odpalenie rozgrywki, pokazanie funkcji (np mała populacja w Kolumbii, by pokazać komunikaty o śmierci kraju) i chwilę zabawy, nie były balansowane pod kątem ich sensowności
-Starałem się zrobić typowe flatten the curve, ale liczby były robione "na oko"


Pozdrawiam,
Jednak szczęśliwy, że finito - Paweł Sołtys, s20935


 */




public class Main {
    public static void main(String[] args) {

        World world = new World();

       /* SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                while(true)
                try {
                    new Menu();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });*/


       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                    new Window();


            }
            });

       // World swiat = new World();
      //  Time_thread gierka = new Time_thread();
       // gierka.run();

    }
}
