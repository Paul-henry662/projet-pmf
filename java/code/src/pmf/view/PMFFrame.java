package pmf.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.Toolkit;

public class PMFFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel labelMainTitle;
	private JPanel panelMain;
	private JPanel panelOrder;
	private JPanel panelHumidity;
	private JPanel panelExternalTemp;
	private JPanel panelInternalTemp;
	private JButton btnOrderTemp;
	private JTextField fieldOrderTemp;
	private JLabel labelOrderTemp;
	private JSlider sliderOrderTemp;
	private JLabel labelInternalTemp;
	private JLabel labelExternalTemp;
	private JLabel labelHumidity;
	private JLabel lblInternalTempValueCelsius;
	private JLabel labelInternalTempValueKelvin;
	private JLabel labelExternalTempValueCelsius;
	private JLabel labelExternalTempValueKelvin;
	private JLabel labelHumdityValue;

	public PMFFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PMFFrame.class.getResource("/pmf/main/media/fridge.png")));
		setTitle("Projet PMF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		labelMainTitle = new JLabel("Projet Pimp My Fridge");
		labelMainTitle.setIcon(new ImageIcon(PMFFrame.class.getResource("/pmf/main/media/fridge.png")));
		labelMainTitle.setFont(new Font("Century Gothic", Font.BOLD, 30));
		contentPane.add(labelMainTitle, BorderLayout.NORTH);
		
		panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow]"));
		
		panelInternalTemp = new JPanel();
		panelInternalTemp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panelInternalTemp, "cell 0 0,grow");
		panelInternalTemp.setLayout(new MigLayout("", "[176px]", "[50px][][][][]"));
		
		labelInternalTemp = new JLabel("Temp\u00E9rature interne");
		labelInternalTemp.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		labelInternalTemp.setIcon(new ImageIcon(PMFFrame.class.getResource("/pmf/main/media/fan.png")));
		panelInternalTemp.add(labelInternalTemp, "cell 0 0,growx,aligny top");
		
		lblInternalTempValueCelsius = new JLabel("0 \u00B0C");
		lblInternalTempValueCelsius.setFont(new Font("Century Schoolbook", Font.PLAIN, 25));
		panelInternalTemp.add(lblInternalTempValueCelsius, "cell 0 2");
		
		labelInternalTempValueKelvin = new JLabel("0 K");
		labelInternalTempValueKelvin.setFont(new Font("Century Schoolbook", Font.PLAIN, 25));
		panelInternalTemp.add(labelInternalTempValueKelvin, "cell 0 4");
		
		panelExternalTemp = new JPanel();
		panelExternalTemp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panelExternalTemp, "cell 1 0,grow");
		panelExternalTemp.setLayout(new MigLayout("", "[167px]", "[50px][][][][][]"));
		
		labelExternalTemp = new JLabel("Temp\u00E9rature externe");
		labelExternalTemp.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		labelExternalTemp.setIcon(new ImageIcon(PMFFrame.class.getResource("/pmf/main/media/sun.png")));
		panelExternalTemp.add(labelExternalTemp, "cell 0 0,growx,aligny top");
		
		labelExternalTempValueCelsius = new JLabel("0 \u00B0C");
		labelExternalTempValueCelsius.setFont(new Font("Century Schoolbook", Font.PLAIN, 25));
		panelExternalTemp.add(labelExternalTempValueCelsius, "cell 0 2");
		
		labelExternalTempValueKelvin = new JLabel("0 K");
		labelExternalTempValueKelvin.setFont(new Font("Century Schoolbook", Font.PLAIN, 25));
		panelExternalTemp.add(labelExternalTempValueKelvin, "cell 0 4");
		
		panelHumidity = new JPanel();
		panelHumidity.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMain.add(panelHumidity, "cell 2 0,grow");
		panelHumidity.setLayout(new MigLayout("", "[156px]", "[50px][][]"));
		
		labelHumidity = new JLabel("Humidit\u00E9 ambiante");
		labelHumidity.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		labelHumidity.setIcon(new ImageIcon(PMFFrame.class.getResource("/pmf/main/media/drop.png")));
		panelHumidity.add(labelHumidity, "cell 0 0,growx,aligny top");
		
		labelHumdityValue = new JLabel("0 %");
		labelHumdityValue.setFont(new Font("Century Schoolbook", Font.PLAIN, 25));
		panelHumidity.add(labelHumdityValue, "cell 0 2");
		
		panelOrder = new JPanel();
		contentPane.add(panelOrder, BorderLayout.SOUTH);
		
		labelOrderTemp = new JLabel("Consigne");
		panelOrder.add(labelOrderTemp);
		
		sliderOrderTemp = new JSlider();
		sliderOrderTemp.setMinimum(10);
		sliderOrderTemp.setPaintLabels(true);
		sliderOrderTemp.setMinorTickSpacing(5);
		sliderOrderTemp.setPaintTicks(true);
		sliderOrderTemp.setMajorTickSpacing(5);
		sliderOrderTemp.setMaximum(30);
		panelOrder.add(sliderOrderTemp);
		
		fieldOrderTemp = new JTextField();
		panelOrder.add(fieldOrderTemp);
		fieldOrderTemp.setColumns(10);
		
		btnOrderTemp = new JButton("Modifier");
		panelOrder.add(btnOrderTemp);

	}

	public JLabel getLabelMainTitle() {
		return labelMainTitle;
	}

	public void setLabelMainTitle(JLabel labelMainTitle) {
		this.labelMainTitle = labelMainTitle;
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

	public void setPanelMain(JPanel panelMain) {
		this.panelMain = panelMain;
	}

	public JPanel getPanelOrder() {
		return panelOrder;
	}

	public void setPanelOrder(JPanel panelOrder) {
		this.panelOrder = panelOrder;
	}

	public JPanel getPanelHumidity() {
		return panelHumidity;
	}

	public void setPanelHumidity(JPanel panelHumidity) {
		this.panelHumidity = panelHumidity;
	}

	public JPanel getPanelExternalTemp() {
		return panelExternalTemp;
	}

	public void setPanelExternalTemp(JPanel panelExternalTemp) {
		this.panelExternalTemp = panelExternalTemp;
	}

	public JPanel getPanelInternalTemp() {
		return panelInternalTemp;
	}

	public void setPanelInternalTemp(JPanel panelInternalTemp) {
		this.panelInternalTemp = panelInternalTemp;
	}

	public JButton getBtnOrderTemp() {
		return btnOrderTemp;
	}

	public void setBtnOrderTemp(JButton btnOrderTemp) {
		this.btnOrderTemp = btnOrderTemp;
	}

	public JTextField getFieldOrderTemp() {
		return fieldOrderTemp;
	}

	public void setFieldOrderTemp(JTextField fieldOrderTemp) {
		this.fieldOrderTemp = fieldOrderTemp;
	}

	public JLabel getLabelOrderTemp() {
		return labelOrderTemp;
	}

	public void setLabelOrderTemp(JLabel labelOrderTemp) {
		this.labelOrderTemp = labelOrderTemp;
	}

	public JSlider getSliderOrderTemp() {
		return sliderOrderTemp;
	}

	public void setSliderOrderTemp(JSlider sliderOrderTemp) {
		this.sliderOrderTemp = sliderOrderTemp;
	}

	public JLabel getLabelInternalTemp() {
		return labelInternalTemp;
	}

	public void setLabelInternalTemp(JLabel labelInternalTemp) {
		this.labelInternalTemp = labelInternalTemp;
	}

	public JLabel getLabelExternalTemp() {
		return labelExternalTemp;
	}

	public void setLabelExternalTemp(JLabel labelExternalTemp) {
		this.labelExternalTemp = labelExternalTemp;
	}

	public JLabel getLabelHumidity() {
		return labelHumidity;
	}

	public void setLabelHumidity(JLabel labelHumidity) {
		this.labelHumidity = labelHumidity;
	}

	public JLabel getLblInternalTempValueCelsius() {
		return lblInternalTempValueCelsius;
	}

	public void setLblInternalTempValueCelsius(JLabel lblInternalTempValueCelsius) {
		this.lblInternalTempValueCelsius = lblInternalTempValueCelsius;
	}

	public JLabel getLabelInternalTempValueKelvin() {
		return labelInternalTempValueKelvin;
	}

	public void setLabelInternalTempValueKelvin(JLabel labelInternalTempValueKelvin) {
		this.labelInternalTempValueKelvin = labelInternalTempValueKelvin;
	}

	public JLabel getLabelExternalTempValueCelsius() {
		return labelExternalTempValueCelsius;
	}

	public void setLabelExternalTempValueCelsius(JLabel labelExternalTempValueCelsius) {
		this.labelExternalTempValueCelsius = labelExternalTempValueCelsius;
	}

	public JLabel getLabelExternalTempValueKelvin() {
		return labelExternalTempValueKelvin;
	}

	public void setLabelExternalTempValueKelvin(JLabel labelExternalTempValueKelvin) {
		this.labelExternalTempValueKelvin = labelExternalTempValueKelvin;
	}

	public JLabel getLabelHumdityValue() {
		return labelHumdityValue;
	}

	public void setLabelHumdityValue(JLabel labelHumdityValue) {
		this.labelHumdityValue = labelHumdityValue;
	}
}