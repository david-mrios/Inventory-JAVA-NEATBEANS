/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author carlosvargas
 */
public class ScrollBarMenu extends JScrollBar {

    public ScrollBarMenu() {
        setUI(new ModernScrollbarUI());
        setPreferredSize(new Dimension(5, 5));
        setForeground(new Color(255, 255, 255));
        setUnitIncrement(20);
        setOpaque(false);
    }
}
