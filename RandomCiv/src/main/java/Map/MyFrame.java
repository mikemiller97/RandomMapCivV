/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    
    MyFrame() {
        this.button = new JButton();
        button.setBounds(80, 200, 250, 100);
        button.addActionListener(this);
        button.setText("Click here for a random map");
        button.setFocusable(false);
        
        this.label = new JLabel();
        label.setBounds(100, 75, 250, 150);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(400,400);
        this.setVisible(true);
        this.add(label);
        this.add(button);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            //Pulls a list of all the maps in the game to select
            MapList list = new MapList();
            //Making a list of maps from the csv file
            try (Scanner scanner = new Scanner(Paths.get("C:\\Users\\wowru\\Documents\\NetBeansProjects\\RandomCiv\\maps\\maplist.csv"))) {
                while (scanner.hasNextLine()) {
                    String[] entries = scanner.nextLine().split(",");
                    int number = Integer.valueOf(entries[2]);
                    Map addThis = new Map(entries[0], entries[1], number);
                    list.add(addThis);
                }
            }
            catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            label.setText(list.pick());
        }
    }
}
