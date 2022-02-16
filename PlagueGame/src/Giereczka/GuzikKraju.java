package Giereczka;

import javax.swing.*;

public class GuzikKraju extends JButton {
    public GuzikKraju(int a){
        addActionListener(new GuzikKrajuListener(a));
    }
}
