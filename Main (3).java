import java.io.*;
import java.util.*;
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
class Snake{
    private int head;
    private int tail;
    public static List<Integer>snakes=new ArrayList<>();
    public List<Integer>snakehead=new ArrayList<>();
    public List<Integer> getsnake(){
        return this.snakes;
    }
}
class Picksnake extends Snake{
    private int sh;
    private int st;
    public void getsnakerandom(){
        do{
            this.sh=(int)(Math.random()*(100-10)+10);
            this.st=(int)(Math.random()*(this.sh-1)+1);
        }while(this.sh<this.st || (snakehead.contains(this.sh)));
        snakehead.add(this.sh);
        snakes.add(this.sh);
        snakes.add(this.st);
        System.out.println(snakes);
    }
    public int checksnake(int pd,String pn){
        int i=0;
        int find=0;
        for(Integer s:snakes){
            if(i%2==0){
                if(s==pd){
                    find=1;
                    i++;
                }
                else{
                    i++;
                }
            }
            else if(find==1){
                System.out.println(pn+"bite a snake"+pd+"to"+s);
                pd=s;
                break;
            }
            else{
                i++;
            }
        }
        return pd;
    }
}
/*class Ladder{
    private int lend;
    private int lstart;
    public List<Integer>ladder=new ArrayList<>();
    public List<Integer>lsp=new ArrayList<>();
    //public List<Integer> getladder()
     
}*/
class Pickladder {
    private int ladderend;
    private int ladderstart;
    public static List<Integer>ladder=new ArrayList<>();
    public List<Integer>lsp=new ArrayList<>();
    public void getladderrandom(){
        do{
            this.ladderstart=(int)(Math.random()*(100-10)+10);
            this.ladderend=(int)(Math.random()*(100-this.ladderstart)+this.ladderstart);
        }while(this.ladderstart>=this.ladderend || (this.lsp.contains(this.ladderstart)));
        this.lsp.add(this.ladderstart);
        this.ladder.add(this.ladderstart);
        this.ladder.add(this.ladderend);
        System.out.println(ladder);
    }
    public int checkladder(int pd,String pn){
        int i=0;
        int find=0;
        //System.out.println(ladder);
        for(Integer l:ladder){
            if(i%2==0){
                if(pd==l){
                    find=1;
                    i++;
                }
                else{
                    //System.out.println(l);
                    i++;
                }
            }
            else if(find==1){
                System.out.println(pn+"claim a ladder"+pd+"to"+l);
                pd=l;
                break;
            }
            else{
                i++;
            }
        }
        return pd;
    }
}
class Board{
    Pickladder pl=new Pickladder();
    Picksnake ps=new Picksnake();
    public int checkboard(int pd,String pn){
        int tempd=0;
        //System.out.println(pl.getl());
        tempd=pl.checkladder(pd,pn);
        //System.out.println(tempd+"   "+pd);
        tempd=ps.checksnake(tempd,pn);
        //System.out.println(tempd+"   "+pd);
        if(tempd==pd){
            System.out.println(pn+" move to"+pd);
            return pd;
        }
        else{
            return tempd;
        }
    }
}
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
public class Main {

    public static void main(String[] args) {
        String p;
        Gamestart gs=new Gamestart();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Players:");
        int nply=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<nply;i++){
            System.out.print("enter player name:"+(i+1)+"\n");
            p=(sc.nextLine());
            gs.setplayername(p);
            gs.setplayerdiceadd(0);
        }
        System.out.println("enter how many snakes you want:");
        int nsnk;
        do{
            nsnk=sc.nextInt();
            sc.nextLine();
            if(nsnk>40){
                System.out.println("you cross the limit of snakes so enter the 40 bellow snakes:");
            }
        }while(nsnk>39);
        Picksnake ps=new Picksnake();
        Pickladder pl=new Pickladder();
        for(int j=0;j<nsnk;j++){
            ps.getsnakerandom();
        }
        int nldr;
        System.out.println("Enter how many ladders you want:");
        do{
            nldr=sc.nextInt();
            sc.nextLine();
            if((49-nsnk)<(nldr)){
                System.out.println("you have cross the ladders limit so enter bellow "+(49-nsnk-nldr)+" ladders");
            }
        }while((49-nsnk<(nldr)));
        for(int j=0;j<nldr;j++){
            pl.getladderrandom();
        }
        gs.getstartgame();
    }
}
