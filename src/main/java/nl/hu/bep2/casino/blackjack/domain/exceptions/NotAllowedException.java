package nl.hu.bep2.casino.blackjack.domain.exceptions;

public class NotAllowedException extends RuntimeException{
    public NotAllowedException(String message) {  super(message);  }
}
