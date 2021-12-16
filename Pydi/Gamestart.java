class Gamestart {
    Snake snake=new Snake();
    public Queue<Integer>pdice=new LinkedList<>();
    public Queue<String> playername=new LinkedList<>();
    private String pp;
    private int pd;
    private int gameend=0;
    private int gamedice;
    Dice dice=new Dice();
    Board board=new Board();
    public void setplayerdiceadd(int dice){
        this.pdice.add(dice);
    }
   
    public void setplayername(String name){
        this.playername.add(name);
    }
    public void getstartgame()
    {
        while(true){
            this.gamedice=dice.rolldice();
            //System.out.println(this.gamedice);
            this.pp=playername.poll();
            this.pd=pdice.poll();
            if((this.gamedice+this.pd)<100){
                pdice.add(board.checkboard((this.pd+this.gamedice),this.pp));
                playername.add(this.pp);
            }
            else if((this.gamedice+this.pd)==100){
                System.out.println(this.pp+" is won the game");
                break;
            }
            else{
                pdice.add(this.pd);
                playername.add(this.pp);
                //continue;
            }
        }
        //System.out.println(ply.getplayersname());
    }
}