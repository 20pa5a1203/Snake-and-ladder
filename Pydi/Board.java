class Board {
    Pickladder pl = new Pickladder();
    Picksnake ps = new Picksnake();

    public int checkboard(int pd, String pn) {
        int tempd = 0;
        // System.out.println(pl.getl());
        tempd = pl.checkladder(pd, pn);
        // System.out.println(tempd+" "+pd);
        tempd = ps.checksnake(tempd, pn);
        // System.out.println(tempd+" "+pd);
        if (tempd == pd) {
            System.out.println(pn + " move to" + pd);
            return pd;
        } else {
            return tempd;
        }
    }
}