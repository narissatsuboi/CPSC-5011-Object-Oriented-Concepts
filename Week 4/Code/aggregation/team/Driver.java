package aggregation.team;

public class Driver {
    public static void main(String [] args) {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");
        Player p3 = new Player("p3");
        Player p4 = new Player("p4");
        Player p5 = new Player("p5");
        Player p6 = new Player("p6");
        Player p7 = new Player("p7");
        Player p8 = new Player("p8");
        Player p9 = new Player("p9");
        Player p10 = new Player("p10");
        Player p11 = new Player("p11");
        Player p12 = new Player("p12");
        
        Team t = new Team();
        Team t2 = new Team();
        
        System.out.println("original...");
        try {
            t.addPlayer(p1);
            t.addPlayer(p2);
            t.addPlayer(p3);
            t.addPlayer(p4);
            t2.addPlayer(p5);
            t2.addPlayer(p6);
            t2.addPlayer(p7);
            t2.addPlayer(p8);
        } catch (PlayerDuplicateException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(t.toString());
        System.out.println(t2.toString());
        
        System.out.println("\nadd players to team 1 and 2...");
        try {
            t.addPlayer(p9);
            t.addPlayer(p10);            
            t2.addPlayer(p11);
            t2.addPlayer(p12);
        } catch (PlayerDuplicateException e) {
            System.err.println(e.getMessage());
        }        
        System.out.println(t.toString());
        System.out.println(t2.toString());
        
        System.out.println("\nremove players from team 1 and 2...");
        try {
            t.removePlayer(p1);
            t.removePlayer(p2);
            t2.removePlayer(p7);
            t2.removePlayer(p8);
        } catch (PlayerDoesNotExistException e) {
            System.err.println(e.getMessage());
        }        
        System.out.println(t.toString());
        System.out.println(t2.toString());    
    }
    
}
