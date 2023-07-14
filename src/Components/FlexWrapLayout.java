/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;

/**
 *
 * @author David
 */
public class FlexWrapLayout extends FlowLayout {

    public FlexWrapLayout(int align, int hgap, int vgap) {
        super(align, hgap, vgap);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        synchronized (target.getTreeLock()) {
            int targetWidth = target.getSize().width;

            int hgap = getHgap();
            int vgap = getVgap();
            Insets insets = target.getInsets();
            int horizontalInsetsAndGap = insets.left + insets.right + (hgap * 2);
            int maxWidth = targetWidth - horizontalInsetsAndGap;

            int x = 0;
            int y = insets.top;
            int rowHeight = 0;
            int rowWidth = 0;
            int numComponents = target.getComponentCount();

            for (int i = 0; i < numComponents; i++) {
                Component component = target.getComponent(i);
                if (component.isVisible()) {
                    Dimension componentPreferredSize = component.getPreferredSize();
                    int componentWidth = componentPreferredSize.width;
                    int componentHeight = componentPreferredSize.height;

                    if (x == 0 || (x + componentWidth) <= maxWidth) {
                        if (x > 0) {
                            x += hgap;
                        }
                        x += componentWidth;
                        rowWidth = Math.max(rowWidth, x);
                        rowHeight = Math.max(rowHeight, componentHeight);
                    } else {
                        x = componentWidth;
                        y += vgap + rowHeight;
                        rowWidth = componentWidth;
                        rowHeight = componentHeight;
                    }
                }
            }

            y += rowHeight + insets.bottom;

            return new Dimension(targetWidth, y);
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        return preferredLayoutSize(target);
    }
}
