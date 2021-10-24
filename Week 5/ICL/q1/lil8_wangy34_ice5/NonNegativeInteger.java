package probOne;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class NonNegativeInteger {
    private Deque<Integer> queue;
    public NonNegativeInteger() {
        this.queue = new ArrayDeque<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NonNegativeInteger)) return false;
        NonNegativeInteger that = (NonNegativeInteger) o;
        return Objects.equals(that.get(), ((NonNegativeInteger) o).get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(queue);
    }

    public void set(int v) throws IllegalArgumentException {
        if (v < 0) {
            throw new IllegalArgumentException();
        }
        queue.offerFirst(v);

    }

    public int get() {
        if (queue.size() == 0) {
            return 0;
        } else {
            return queue.peekLast();
        }
    }
}
