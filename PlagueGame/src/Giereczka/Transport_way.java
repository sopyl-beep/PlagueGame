package Giereczka;

public class Transport_way {

    double modifier;
    State[] state = new State[2];
    String name;
    int type;

    public Transport_way(int type, State st1, State st2){
        this.state[0] = st1;
        this.state[1] = st2;
        this.type = type;
        modifier = 0;

        switch(type){
            case 1:{
                name = "Cargo";
                break;
            }
            case 2:{
                name = "Car";
                break;
            }
            case 3:{
                name = "Boat";
                break;
            }
            case 4:{
                name = "Train";
                break;
            }
            default:{
                this.type = 0;
                name = "Nielegalni imigranci";
                break;
            }
        }
    }
}
