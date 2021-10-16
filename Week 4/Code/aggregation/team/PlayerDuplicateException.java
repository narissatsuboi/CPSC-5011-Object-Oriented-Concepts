package aggregation.team;

@SuppressWarnings("serial")
public class PlayerDuplicateException extends Exception {
    
    public PlayerDuplicateException(String msg) {
        super(msg);
    }
    
    public PlayerDuplicateException() {
        this("Player has already been added.");
    }
    
}
