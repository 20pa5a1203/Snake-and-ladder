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