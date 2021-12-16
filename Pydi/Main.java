public class Main {

    public static void main(String[] args) {
        String p;
        Gamestart gs = new Gamestart();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Players:");
        int nply = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nply; i++) {
            System.out.print("enter player name:" + (i + 1) + "\n");
            p = (sc.nextLine());
            gs.setplayername(p);
            gs.setplayerdiceadd(0);
        }
        System.out.println("enter how many snakes you want:");
        int nsnk;
        do {
            nsnk = sc.nextInt();
            sc.nextLine();
            if (nsnk > 40) {
                System.out.println("you cross the limit of snakes so enter the 40 bellow snakes:");
            }
        } while (nsnk > 39);
        Picksnake ps = new Picksnake();
        Pickladder pl = new Pickladder();
        for (int j = 0; j < nsnk; j++) {
            ps.getsnakerandom();
        }
        int nldr;
        System.out.println("Enter how many ladders you want:");
        do {
            nldr = sc.nextInt();
            sc.nextLine();
            if ((49 - nsnk) < (nldr)) {
                System.out
                        .println("you have cross the ladders limit so enter bellow " + (49 - nsnk - nldr) + " ladders");
            }
        } while ((49 - nsnk < (nldr)));
        for (int j = 0; j < nldr; j++) {
            pl.getladderrandom();
        }
        gs.getstartgame();
    }
}