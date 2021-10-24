package pattern.composite;

public interface ExprBuilder {
    Expr toExpr();
    void add(Expr e);
}
