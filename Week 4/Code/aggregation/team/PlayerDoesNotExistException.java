package aggregation.team;

@SuppressWarnings("serial")
public class PlayerDoesNotExistException extends Exception {
    
    public PlayerDoesNotExistException(String msg) {
        super(msg);
    }
    
    public PlayerDoesNotExistException() {
        this("Player does not exist; cannot be removed.");
    }
}
