package me.bytebeats.plugin.weather.ui;

import me.bytebeats.plugin.weather.SimpleWeatherContinuation;
import me.bytebeats.plugin.weather.data.simple.SimpleCity;
import me.bytebeats.plugin.weather.notification.NotificationsKt;
import me.bytebeats.plugin.weather.resp.LocationResponse;
import me.bytebeats.plugin.weather.service.CityService;
import me.bytebeats.plugin.weather.util.DatasKt;
import me.bytebeats.plugin.weather.util.MappersKt;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class PrimaryLocationDialog extends JDialog {
    private JPanel contentPane;
    private JButton onOK;
    private JButton onCancel;
    private JTextField locationEditor;
    private JTable locationList;

    public PrimaryLocationDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(onOK);

        onOK.addActionListener(e -> onOK());
        onCancel.addActionListener(e -> onCancel());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
                super.windowClosing(e);
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        locationEditor.registerKeyboardAction(e -> onSearch(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onSearch() {
        String location = locationEditor.getText();
        CityService.Companion.getService().queryCities(location, new SimpleWeatherContinuation<LocationResponse>() {
            @Override
            public void resume(LocationResponse result) {
                updateList(result);
            }

            @Override
            public void resumeException(@NotNull Throwable t) {

            }
        });
    }

    private void updateList(LocationResponse response) {
        List<SimpleCity> simpleCities = MappersKt.simplifyCities(response);
        Object[][] data = new Object[simpleCities.size()][DatasKt.getCITY_BELONGING_TITLE().length];
        for (int i = 0; i < simpleCities.size(); i++) {
            SimpleCity city = simpleCities.get(i);
            data[i] = new Object[]{city.getName(), city.getAdm2(), city.getAdm1(), city.getCountry()};
        }
//        ApplicationManager.getApplication().invokeLater(() -> {
        SwingUtilities.invokeLater(() -> {
            DefaultTableModel model = new DefaultTableModel(data, DatasKt.getCITY_BELONGING_TITLE());
            locationList.setModel(model);
            ListSelectionModel selectionModel = locationList.getSelectionModel();
            selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            selectionModel.addListSelectionListener(e -> {
                int idx = locationList.getSelectedRow();
                SimpleCity city = simpleCities.get(idx);
                NotificationsKt.info(city.string());
            });
        });

    }

    private void onOK() {

    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        PrimaryLocationDialog dialog = new PrimaryLocationDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
