import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private int x = 10;
    private int y = 10;
    private Terminal terminal;
    private Screen screen;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
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
        draw();
        while (true) {
            try {
                KeyStroke key = screen.readInput(); // Lê a entrada do teclado
                System.out.println(key); // Imprime a tecla pressionada
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//____________________________________________________________________________


}
