package pl.memory;

import javax.swing.*;
import java.awt.*;

public class MemoryFrame extends JFrame {
    private AboutDialog aboutDialog;
    private JMenuBar menuBar;

    public MemoryFrame() {                      //tworzy główną ramkę
        menuBar = new JMenuBar();
        menuConfig(menuBar);

        int widthScreen = Toolkit.getDefaultToolkit().getScreenSize().width;        //pobiera szerokość i długość ekrranu
        int heightScreen = Toolkit.getDefaultToolkit().getScreenSize().height;

        add(new GamePanel(), BorderLayout.CENTER);          //dodaje głowny panel gry
        setJMenuBar(menuBar);                               //ustawia menu

        pack();
        setBounds((widthScreen - getWidth()) / 2, (heightScreen - getHeight()) / 2, getWidth(), getHeight());   //ustawia ramkę na środku ekranu
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void menuConfig(JMenuBar menuBar) {          //wygląd menu
        JMenu main = new JMenu("Plik");

        JMenuItem aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(e -> {
            if (aboutDialog == null) aboutDialog = new AboutDialog(this);
        });

        JMenuItem exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(e -> System.exit(0));

        main.add(aboutItem);
        main.addSeparator();
        main.add(exitItem);
        menuBar.add(main);
    }

    public static void main(String[] args) {
        new MemoryFrame();
    }       //test
}
