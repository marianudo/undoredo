package me.marianonavas.undoredo.memento;

public class GenericMemento<T> implements Memento<T> {
	private final T state;
	
	public GenericMemento(T state) {
		super();
		this.state = state;
	}
	
	@Override
	public T getState() {
		return state;
	}
}
