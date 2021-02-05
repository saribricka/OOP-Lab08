package it.unibo.oop.lab.advanced;

public class DrawNumberViewStdout implements DrawNumberView {

    @Override
    public void setObserver(DrawNumberViewObserver observer) {
    }

    @Override
    public void start() {
        System.out.println("The game has started!");
    }

    @Override
    public void numberIncorrect() {
        System.out.println("The number is incorrect");
    }

    @Override
    public void result(final DrawResult res) {
        System.out.println(res.getDescription());
    }

    @Override
    public void limitsReached() {
        System.out.println("The limit has been reached... You Lost!");
    }

    @Override
    public void displayError(final String message) {
        System.err.println(message);
    }

}
