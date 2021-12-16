
class Dice{
    private int dice;
    public void setdice(int dice){
        this.dice=dice;
    }
    public int setdice(){
        return this.dice;
    }
    public int rolldice(){
        int gamedice=(int)(Math.random()*6+1);
        if(gamedice==6){
            System.out.println("you got 6 so extra chance");
            gamedice=gamedice+rolldice();
            if(gamedice>=18){
                return 0;
            }
            else{
                return gamedice;
            }
        }
        else{
            return gamedice;
        }
    }
}