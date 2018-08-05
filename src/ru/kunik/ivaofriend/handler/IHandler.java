package ru.kunik.ivaofriend.handler;

public interface IHandler<T> {
	
	public void showGUI();
	
	public T getGUI();
	
	public void hideGUI();
}
