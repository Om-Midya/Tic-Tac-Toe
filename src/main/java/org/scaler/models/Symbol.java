package org.scaler.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {
    private char character;

    public Symbol(char character) {
        this.character = character;
    }
}
