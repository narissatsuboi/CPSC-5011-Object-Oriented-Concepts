Answer to (f): 
The Liskov Substitution Principle (LSP) states: Given a type T with a subtype S defined via inheritance, any object of subtype S can serve in place of an object of type T

LSP is violated because:
- exceptions thrown in subclass(es)
- invariants are not preserved in subclass(es)
- subtype(s) cannot serve in place of parent object
