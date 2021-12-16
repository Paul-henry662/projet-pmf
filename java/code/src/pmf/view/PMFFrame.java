package pmf.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PMFFrame extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public PMFFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public JPanel getContentPane() {
		return this.contentPane;
	}

	/**
	 * 
	 * @param contentPane
	 */
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

}
