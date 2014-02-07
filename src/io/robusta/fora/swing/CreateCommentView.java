package io.robusta.fora.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

public class CreateCommentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CreateCommentController controller;
	CreateCommentModel model;
	public JLabel showError;

	/**
	 * Create the panel.
	 */
	public CreateCommentView(CreateCommentModel model) {
		this.model = model;
		initView();
	}

	private void initView() {
		setLayout(new BorderLayout(0, 0));

		final JTextPane contentPane = new JTextPane();
		contentPane.setPreferredSize(new Dimension(20, 50));
		contentPane.setMinimumSize(new Dimension(6, 50));
		contentPane.setMaximumSize(new Dimension(0, 0));
		contentPane.setText("Enter your comment");
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(contentPane, BorderLayout.CENTER);

		final JCheckBox anonymousCheckbox = new JCheckBox("Anonymous");
		anonymousCheckbox.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(anonymousCheckbox, BorderLayout.EAST);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setText("");
			}
		});
		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showError.setText("");
				String content = contentPane.getText();
				boolean anonymous = anonymousCheckbox.isSelected();
				controller.createComment(content, anonymous);
			}
		});

		showError = new JLabel("");
		panel.add(showError);
		panel.add(reset);
		panel.add(ok);

	}

	public CreateCommentController getController() {
		return controller;
	}

	public void setController(CreateCommentController controller) {
		this.controller = controller;
	}

}
