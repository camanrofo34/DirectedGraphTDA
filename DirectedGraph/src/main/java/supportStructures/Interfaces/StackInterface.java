package supportStructures.Interfaces;

import java.util.function.Function;

public interface StackInterface<E> extends Collection<E>{

    E peek();

    E pop();

    boolean push(E element);
}
