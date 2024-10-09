import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.*;

import java.io.IOException;

public class Game {
    private int x = 10;
    private int y = 10;
    private Screen screen;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            this.screen = new TerminalScreen(terminal);
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//___________________________________________________________________________

    private void draw() {
        try {
            screen.clear(); // Limpa a tela
            screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]); // Desenha o caractere 'X' na posição (10, 10)
            screen.refresh(); // Atualiza a tela
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//___________________________________________________________________________

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }

//___________________________________________________________________________

    public void run() {
        while (true) {
            draw();
            try {
                KeyStroke key = screen.readInput(); // Lê a entrada do teclado
                if(key.getKeyType()==KeyType.EOF){
                    break;
                }
                processKey(key);
                draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//____________________________________________________________________________


}
