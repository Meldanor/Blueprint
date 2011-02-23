/*
 *  Copyright (C) 2010 Kilian Gaertner
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package blueprintdesktop.gui;

import blueprintdesktop.gui.menu.MenuBar;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Melankor
 */
public class MainFrame extends JFrame{

    private JTextField localesQuestFileField;
    private JTextField luaFileField;

    private JProgressBar progressBar;

    private File localesQuestFile;
    private File luaFile;

    private int counter = 1;

    private boolean canceled = false;

    public MainFrame(){
        initComponents();
        
    }

    private void initComponents(){

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setJMenuBar(new MenuBar());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(0,50));

        JLabel label = new JLabel();
        label.setFont(new Font("Arial",0,18));
        label.setText("LUA Parser");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label,BorderLayout.CENTER);
        add(panel);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(0,20));
        add(panel);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel("original locales_quest.sql");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label,BorderLayout.CENTER);
        add(panel);
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        localesQuestFileField = new JTextField();
        localesQuestFileField.setPreferredSize(new Dimension(200,20));
        localesQuestFileField.setEditable(false);
        panel.add(localesQuestFileField);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel("LUA File");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label,BorderLayout.CENTER);
        add(panel);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        luaFileField = new JTextField();
        luaFileField.setPreferredSize(new Dimension(200,20));
        luaFileField.setEditable(false);
        panel.add(luaFileField);

        

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(0,20));
        add(panel);

        

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(0,20));
        add(panel);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(300,20));
        panel.add(progressBar);
        add(panel);

        pack();

        setLocationRelativeTo(null);
    }
 }