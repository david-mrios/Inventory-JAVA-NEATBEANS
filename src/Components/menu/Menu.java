package Components.menu;

import Components.ScrollBarMenu;
import Components.event.EventMenu;
import Components.swing.ButtonMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    private EventMenu event;

    public Menu() {
        initComponents();
        setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarMenu());
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        scroll.setVerticalScrollBar(new ScrollBarMenu());
        panelMenu.setLayout(new MigLayout("wrap 2, fillx", "[center]0[center]", "[fill, 100]0[fill, 100]"));
    }

    public void initMenu(EventMenu event) {

        this.event = event;

        addMenu("hogar", "Inicio", 0);
        addMenu("agregar-archivo", "Equipos", 1);
        addMenu("inventario", "Inventario", 2);
        addMenu("agregar-usuario", "Personal", 3);
        addMenu("asignacion", "Movimientos", 4);
        addMenu("reporte", "Reportes", 5);
        addMenu("cheque", "Verificar equipos", 6);
        addMenu("computer-science", "Laboratorios", 7);

    }

    public void initMenuIns(EventMenu event) {

        this.event = event;

        addMenu("hogar", "Inicio", 0);
        addMenu("cheque", "Verificar equipos", 6);

    }

    private void addMenu(String icon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIconName(icon);
        menu.setText(text);
        menu.setForeground(Color.WHITE);
        if (index == 0) {
            menu.setSelected(true);
        }
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(index);
                setSelected(menu);

            }
        });
        panelMenu.add(menu, " w 95");
    }

    private void setSelected(ButtonMenu menu) {
        menu.setForeground(Color.WHITE);
        for (Component com : panelMenu.getComponents()) {

            if (com instanceof ButtonMenu) {
                ButtonMenu b = (ButtonMenu) com;
                b.setSelected(false);
                menu.setForeground(Color.WHITE);
            }
        }
        menu.setSelected(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setOpaque(false);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        scroll.setViewportView(panelMenu);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo-home.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
