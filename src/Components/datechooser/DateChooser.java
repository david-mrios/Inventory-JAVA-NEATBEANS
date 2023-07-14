package Components.datechooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public final class DateChooser extends javax.swing.JPanel {

    public JTextField getTextRefernce() {
        return textRefernce;
    }

    public void addEventDateChooser(EventDateChooser event) {
        events.add(event);
    }

    private JTextField textRefernce;
    private final String[] MONTH_SPANISH = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private String dateFormat = "dd-MM-yyyy";
    private int MONTH = 1;
    private int YEAR = 2021;
    private int DAY = 1;
    private int STATUS = 1; // 1 is day 2 is month 3 is year
    private int startYear;
    private SelectedDate selectedDate = new SelectedDate();
    private List<EventDateChooser> events;

    public DateChooser() {
        initComponents();
        execute();
    }

    private void execute() {
        setForeground(new Color(64,122,237));
        events = new ArrayList<>();
        popup.add(this);
        toDay(false);
    }

    public void setTextRefernce(JTextField txt) {
        this.textRefernce = txt;
        this.textRefernce.setEditable(false);
        this.textRefernce.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (textRefernce.isEnabled()) {
                    showPopup();
                }
            }
        });
        setText(false, 0);
    }

    private void setText(boolean runEvent, int act) {
        if (textRefernce != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date date = df.parse(DAY + "-" + MONTH + "-" + YEAR);
                textRefernce.setText(new SimpleDateFormat(dateFormat).format(date));
            } catch (ParseException e) {
                System.err.println(e);
            }
        }
        if (runEvent) {
            runEvent(act);
        }
    }

    private void runEvent(int act) {
        SelectedAction action = () -> act;
        for (EventDateChooser event : events) {
            event.dateSelected(action, selectedDate);
        }
    }

    private Event getEventDay(Dates dates) {
        return (MouseEvent evt, int num) -> {
            dates.clearSelected();
            dates.setSelected(num);
            DAY = num;
            selectedDate.setDay(DAY);
            selectedDate.setMonth(MONTH);
            selectedDate.setYear(YEAR);
            setText(true, 1);
            if (evt != null && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                popup.setVisible(false);
            }
        };
    }

    private Event getEventMonth() {
        return (MouseEvent evt, int num) -> {
            MONTH = num;
            selectedDate.setDay(DAY);
            selectedDate.setMonth(MONTH);
            selectedDate.setYear(YEAR);
            setText(true, 2);
            Dates d = new Dates();
            d.setForeground(getForeground());
            d.setEvent(getEventDay(d));
            d.showDate(MONTH, YEAR, selectedDate);
            if (slide.slideToDown(d)) {
                cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
                cmdYear.setText(YEAR + "");
                STATUS = 1;
            }
        };
    }

    private Event getEventYear() {
        return (MouseEvent evt, int num) -> {
            YEAR = num;
            selectedDate.setDay(DAY);
            selectedDate.setMonth(MONTH);
            selectedDate.setYear(YEAR);
            setText(true, 3);
            Months d = new Months();
            d.setEvent(getEventMonth());
            if (slide.slideToDown(d)) {
                cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
                cmdYear.setText(YEAR + "");
                STATUS = 2;
            }
        };
    }

    private void setDaysAgo(int daysAgo, boolean runEvent) {
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -daysAgo);
        Date daysAgoDate = calendar.getTime();
        String daysAgoString = df.format(daysAgoDate);
        DAY = Integer.parseInt(daysAgoString.split("-")[0]);
        MONTH = Integer.parseInt(daysAgoString.split("-")[1]);
        YEAR = Integer.parseInt(daysAgoString.split("-")[2]);
        selectedDate.setDay(DAY);
        selectedDate.setMonth(MONTH);
        selectedDate.setYear(YEAR);
        dates.showDate(MONTH, YEAR, selectedDate);
        slide.slideNon(dates);
        cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText(runEvent, 0);
    }

    private void toThirtyDaysAgo(boolean runEvent) {
        setDaysAgo(30, runEvent);
    }

    private void toSevenDaysAgo(boolean runEvent) {
        setDaysAgo(7, runEvent);
    }

    private void toFifteenDaysAgo(boolean runEvent) {
        setDaysAgo(15, runEvent);
    }

    private void toDay(boolean runEvent) {
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        DAY = Integer.parseInt(toDay.split("-")[0]);
        MONTH = Integer.parseInt(toDay.split("-")[1]);
        YEAR = Integer.parseInt(toDay.split("-")[2]);
        selectedDate.setDay(DAY);
        selectedDate.setMonth(MONTH);
        selectedDate.setYear(YEAR);
        dates.showDate(MONTH, YEAR, selectedDate);
        slide.slideNon(dates);
        cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText(runEvent, 0);
    }

    public void toDay() {
        toDay(true);
    }

    public void toFifteenDaysAgo() {
        toFifteenDaysAgo(true);
    }

    public void toSevenDaysAgo() {
        toSevenDaysAgo(true);
    }

    public void toThirtyDaysAgo() {
        toThirtyDaysAgo(true);
    }

    private void setDateNext() {
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.showDate(MONTH, YEAR, selectedDate);
        if (slide.slideToLeft(dates)) {
            cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
            cmdYear.setText(YEAR + "");
        }
    }

    private void setDateBack() {
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.showDate(MONTH, YEAR, selectedDate);
        if (slide.slideToRight(dates)) {
            cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
            cmdYear.setText(YEAR + "");
        }
    }

    private void setYearNext() {
        Years years = new Years();
        years.setEvent(getEventYear());
        startYear = years.next(startYear);
        slide.slideToLeft(years);
    }

    private void setYearBack() {
        if (startYear >= 1000) {
            Years years = new Years();
            years.setEvent(getEventYear());
            startYear = years.back(startYear);
            slide.slideToLeft(years);
        }
    }

    public void showPopup(Component com, int x, int y) {
        popup.show(com, x, y);
    }

    public void showPopup() {
        popup.show(textRefernce, 0, textRefernce.getHeight());
    }

    public void hidePopup() {
        popup.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu(){
            @Override
            protected void paintComponent(Graphics grphcs) {
                grphcs.setColor(new Color(114, 113, 113));
                grphcs.fillRect(0, 0, getWidth(), getHeight());
                grphcs.setColor(Color.WHITE);
                grphcs.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
            }
        };
        header = new javax.swing.JPanel();
        cmdForward = new Components.datechooser.Button();
        MY = new javax.swing.JLayeredPane();
        cmdMonth = new Components.datechooser.Button();
        lb = new javax.swing.JLabel();
        cmdYear = new Components.datechooser.Button();
        cmdPrevious = new Components.datechooser.Button();
        slide = new Components.datechooser.Slider();
        DateOptions = new javax.swing.JPanel();
        ThirtyDaysAgo = new javax.swing.JLabel();
        TodayDate = new javax.swing.JLabel();
        SevenDaysAgo = new javax.swing.JLabel();
        FifteenDaysAgo = new javax.swing.JLabel();

        popup.setForeground(java.awt.Color.white);
        popup.setBorder(null);
        popup.setBorderPainted(false);
        popup.setInheritsPopupMenu(true);
        popup.setLightWeightPopupEnabled(false);
        popup.setMaximumSize(new java.awt.Dimension(380, 220));
        popup.setPopupSize(new java.awt.Dimension(380, 220));

        setBackground(java.awt.Color.white);
        setForeground(java.awt.Color.white);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(64, 122, 237));
        header.setMaximumSize(new java.awt.Dimension(262, 40));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdForward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdForward.setFocusable(true);
        cmdForward.setPaintBackground(false);
        cmdForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdForwardActionPerformed(evt);
            }
        });
        header.add(cmdForward, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        MY.setLayout(new java.awt.FlowLayout());

        cmdMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdMonth.setBackground(new java.awt.Color(0, 0, 0));
        cmdMonth.setForeground(new java.awt.Color(255, 255, 255));
        cmdMonth.setText("Enero");
        cmdMonth.setFocusPainted(false);
        cmdMonth.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        cmdMonth.setPaintBackground(false);
        cmdMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMonthActionPerformed(evt);
            }
        });
        MY.add(cmdMonth);

        lb.setForeground(new java.awt.Color(255, 255, 255));
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("-");
        MY.add(lb);

        cmdYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdYear.setForeground(new java.awt.Color(255, 255, 255));
        cmdYear.setText("2018");
        cmdYear.setFocusPainted(false);
        cmdYear.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        cmdYear.setPaintBackground(false);
        cmdYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdYearActionPerformed(evt);
            }
        });
        MY.add(cmdYear);

        header.add(MY, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 6, 198, -1));

        cmdPrevious.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdPrevious.setFocusable(true);
        cmdPrevious.setPaintBackground(false);
        cmdPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPreviousActionPerformed(evt);
            }
        });
        cmdPrevious.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdPreviousKeyPressed(evt);
            }
        });
        header.add(cmdPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 40));

        slide.setLayout(new javax.swing.BoxLayout(slide, javax.swing.BoxLayout.LINE_AXIS));
        add(slide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 270, 180));

        DateOptions.setBackground(new java.awt.Color(64, 122, 237));
        DateOptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ThirtyDaysAgo.setForeground(java.awt.Color.white);
        ThirtyDaysAgo.setText("Hace 30 dias");
        ThirtyDaysAgo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThirtyDaysAgo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThirtyDaysAgoMouseClicked(evt);
            }
        });
        DateOptions.add(ThirtyDaysAgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        TodayDate.setForeground(java.awt.Color.white);
        TodayDate.setText("Hoy");
        TodayDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TodayDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TodayDateMouseClicked(evt);
            }
        });
        DateOptions.add(TodayDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 20));

        SevenDaysAgo.setForeground(java.awt.Color.white);
        SevenDaysAgo.setText("Hace 7 dias");
        SevenDaysAgo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SevenDaysAgo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SevenDaysAgoMouseClicked(evt);
            }
        });
        DateOptions.add(SevenDaysAgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        FifteenDaysAgo.setForeground(java.awt.Color.white);
        FifteenDaysAgo.setText("Hace 15 dias");
        FifteenDaysAgo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FifteenDaysAgo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FifteenDaysAgoMouseClicked(evt);
            }
        });
        DateOptions.add(FifteenDaysAgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        add(DateOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 110, 220));
    }// </editor-fold>//GEN-END:initComponents

    private void cmdPreviousActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdPreviousActionPerformed
        if (STATUS == 1) { // Date
            if (MONTH == 1) {
                MONTH = 12;
                YEAR--;
            } else {
                MONTH--;
            }
            setDateBack();
        } else if (STATUS == 3) { // Year
            setYearBack();
        } else {
            if (YEAR >= 1000) {
                YEAR--;
                Months months = new Months();
                months.setEvent(getEventMonth());
                slide.slideToLeft(months);
                cmdYear.setText(YEAR + "");
            }
        }
    }// GEN-LAST:event_cmdPreviousActionPerformed

    private void cmdForwardActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdForwardActionPerformed
        if (STATUS == 1) { // Date
            if (MONTH == 12) {
                MONTH = 1;
                YEAR++;
            } else {
                MONTH++;
            }
            setDateNext();
        } else if (STATUS == 3) { // Year
            setYearNext();
        } else {
            YEAR++;
            Months months = new Months();
            months.setEvent(getEventMonth());
            slide.slideToLeft(months);
            cmdYear.setText(YEAR + "");
        }
    }// GEN-LAST:event_cmdForwardActionPerformed

    private void cmdMonthActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdMonthActionPerformed
        if (STATUS != 2) {
            STATUS = 2;
            Months months = new Months();
            months.setEvent(getEventMonth());
            slide.slideToDown(months);
        } else {
            Dates dates = new Dates();
            dates.setForeground(getForeground());
            dates.setEvent(getEventDay(dates));
            dates.showDate(MONTH, YEAR, selectedDate);
            slide.slideToDown(dates);
            STATUS = 1;
        }
    }// GEN-LAST:event_cmdMonthActionPerformed

    private void cmdYearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmdYearActionPerformed
        if (STATUS != 3) {
            STATUS = 3;
            Years years = new Years();
            years.setEvent(getEventYear());
            startYear = years.showYear(YEAR);
            slide.slideToDown(years);
        } else {
            Dates dates = new Dates();
            dates.setForeground(getForeground());
            dates.setEvent(getEventDay(dates));
            dates.showDate(MONTH, YEAR, selectedDate);
            slide.slideToDown(dates);
            STATUS = 1;
        }
    }// GEN-LAST:event_cmdYearActionPerformed

    private void cmdPreviousKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_cmdPreviousKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            Component com = slide.getComponent(0);
            if (com instanceof Dates) {
                Dates d = (Dates) com;
                d.up();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            Component com = slide.getComponent(0);
            if (com instanceof Dates) {
                Dates d = (Dates) com;
                d.down();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            Component com = slide.getComponent(0);
            if (com instanceof Dates) {
                Dates d = (Dates) com;
                d.back();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Component com = slide.getComponent(0);
            if (com instanceof Dates) {
                Dates d = (Dates) com;
                d.next();
            }
        }
    }// GEN-LAST:event_cmdPreviousKeyPressed

    private void TodayDateMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TodayDateMouseClicked
        this.toDay();
    }// GEN-LAST:event_TodayDateMouseClicked

    private void FifteenDaysAgoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_FifteenDaysAgoMouseClicked
        this.toFifteenDaysAgo();
    }// GEN-LAST:event_FifteenDaysAgoMouseClicked

    private void SevenDaysAgoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_SevenDaysAgoMouseClicked
        this.toSevenDaysAgo();
    }// GEN-LAST:event_SevenDaysAgoMouseClicked

    private void ThirtyDaysAgoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_ThirtyDaysAgoMouseClicked
        this.toThirtyDaysAgo();
    }// GEN-LAST:event_ThirtyDaysAgoMouseClicked

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setSelectedDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String d = df.format(date);
        DAY = Integer.parseInt(d.split("-")[0]);
        MONTH = Integer.parseInt(d.split("-")[1]);
        YEAR = Integer.parseInt(d.split("-")[2]);
        selectedDate.setDay(DAY);
        selectedDate.setMonth(MONTH);
        selectedDate.setYear(YEAR);
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.setSelected(DAY);
        dates.showDate(MONTH, YEAR, selectedDate);
        slide.slideNon(dates);
        cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText(true, 0);
        STATUS = 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DateOptions;
    private javax.swing.JLabel FifteenDaysAgo;
    private javax.swing.JLayeredPane MY;
    private javax.swing.JLabel SevenDaysAgo;
    private javax.swing.JLabel ThirtyDaysAgo;
    private javax.swing.JLabel TodayDate;
    private Components.datechooser.Button cmdForward;
    private Components.datechooser.Button cmdMonth;
    private Components.datechooser.Button cmdPrevious;
    private Components.datechooser.Button cmdYear;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lb;
    private javax.swing.JPopupMenu popup;
    private Components.datechooser.Slider slide;
    // End of variables declaration//GEN-END:variables

    public SelectedDate getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(SelectedDate selectedDate) {
        this.selectedDate = selectedDate;
        DAY = selectedDate.getDay();
        MONTH = selectedDate.getMonth();
        YEAR = selectedDate.getYear();
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates));
        dates.setSelected(DAY);
        dates.showDate(MONTH, YEAR, selectedDate);
        slide.slideNon(dates);
        cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText(true, 0);
        STATUS = 1;
    }

    @Override
    public void setForeground(Color color) {
        super.setForeground(color);
        if (header != null) {
            header.setBackground(color);
            toDay(false);
        }
    }
}
