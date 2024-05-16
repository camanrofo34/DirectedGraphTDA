package supportStructures.Interfaces;

public interface QueueInterface<E> extends Collection<E> {

    E peek();

     E extract();

    boolean insert(E element);
}
