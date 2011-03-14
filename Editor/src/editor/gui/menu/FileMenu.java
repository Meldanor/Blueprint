/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Meldanor
 */
public class FileMenu extends JMenu {

    public FileMenu() {
        super("Datei");
        initiate();
    }

    private void initiate() {
        JMenuItem newFileItem = new JMenuItem("Neuer Blueprint");
        newFileItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewFile();
            }
        });
        add(newFileItem);

        JMenuItem openFileItem = new JMenuItem("Öffne Blueprint");
        openFileItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                openBlueprintFile();
            }
        });
        add(openFileItem);

        JMenuItem saveFileItem = new JMenuItem("Speichere Blueprint");
        saveFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveBlueprintFile();
            }
        });
        add(saveFileItem);

        JMenuItem saveAsFileItem = new JMenuItem("Speichere Blueprint unter...");
        saveAsFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsBlueprintFile();
            }
        });
        add(saveAsFileItem);

        JMenuItem quitItem = new JMenuItem("Beenden");
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true)
                    System.exit(0);
            }
        });
        add(quitItem);
    }

    private void openBlueprintFile() {
        
    }

    private void createNewFile() {

    }
    
    private void saveBlueprintFile() {
        
    }

    private void saveAsBlueprintFile() {

    }


}
