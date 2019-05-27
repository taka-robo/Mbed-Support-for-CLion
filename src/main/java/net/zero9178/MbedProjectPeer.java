/*
 * Created by JFormDesigner on Mon May 27 15:18:55 CEST 2019
 */

package net.zero9178;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.platform.ProjectGeneratorPeer;
import com.intellij.ui.AnimatedIcon;
import com.intellij.ui.components.JBLabel;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.*;

import javax.swing.*;

/**
 * @author Schülerlizenz 2019/20
 */
public abstract class MbedProjectPeer implements ProjectGeneratorPeer<MbedProjectOptions> {
    public MbedProjectPeer() {
        initComponents();
    }

    protected void setLoading(boolean loading) {
        m_loading.setIcon(loading ? new AnimatedIcon.Default() : null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        m_panel = new JPanel();
        JBLabel m_pathLabel = new JBLabel();
        m_cliPath = new TextFieldWithBrowseButton();
        JBLabel m_versionLabel = new JBLabel();
        m_versionSelection = new ComboBox<>();
        m_loading = new JBLabel();
        CellConstraints cc = new CellConstraints();

        //======== m_panel ========
        {
            m_panel.setLayout(new FormLayout(
                    new ColumnSpec[]{
                            new ColumnSpec(Sizes.dluX(21)),
                            FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
                            new ColumnSpec(Sizes.dluX(44)),
                            FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
                            new ColumnSpec(Sizes.dluX(168)),
                            FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
                            new ColumnSpec(Sizes.dluX(13))
                    },
                    new RowSpec[]{
                            FormFactory.DEFAULT_ROWSPEC,
                            FormFactory.LINE_GAP_ROWSPEC,
                            FormFactory.DEFAULT_ROWSPEC
                    }));

            //---- m_pathLabel ----
            m_pathLabel.setText("mbed-cli path:");
            m_panel.add(m_pathLabel, cc.xywh(1, 1, 3, 1));
            m_panel.add(m_cliPath, cc.xywh(5, 1, 3, 1));

            //---- m_versionLabel ----
            m_versionLabel.setText("mbed-os version:");
            m_panel.add(m_versionLabel, cc.xywh(1, 3, 3, 1));
            m_panel.add(m_versionSelection, cc.xy(5, 3));

            //---- m_loading ----
            m_loading.setToolTipText("Querying versions...");
            m_panel.add(m_loading, cc.xywh(6, 3, 2, 1, CellConstraints.RIGHT, CellConstraints.DEFAULT));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public JPanel getPanel() {
        return m_panel;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel m_panel;
    protected TextFieldWithBrowseButton m_cliPath;
    protected ComboBox<String> m_versionSelection;
    private JBLabel m_loading;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
