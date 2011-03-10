/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package editor;

import editor.gui.MainFrame;
import javax.swing.UIManager;

/**
 *
 * @author Meldanor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
            catch (Exception e) {
        }
        Block.loadBlocks();
        new MainFrame().setVisible(true);
    }

}
