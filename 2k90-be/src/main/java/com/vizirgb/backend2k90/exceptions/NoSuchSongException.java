package com.vizirgb.backend2k90.exceptions;

public class NoSuchSongException extends Exception {

    public NoSuchSongException(String title) {
        super("Song with title: %s doesn't exist".formatted(title));
    }

    public NoSuchSongException(long id) {
        super("Song with title: %d doesn't exist".formatted(id));
    }

}
