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