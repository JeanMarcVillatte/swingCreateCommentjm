package io.robusta.fora.swing;

import io.robusta.fora.domain.Comment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class CommentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Comment model = new Comment();
	private CommentController controller;
	/**
	 * Create the panel.
	 */
	
	public CommentView(Comment model){
		super();
		this.model=model;
		initView();
		
	}
	public void setController(CommentController controller) {
		this.controller = controller;
	}
	public void initView() {
		
		JTextPane CommentPane = new JTextPane();
		CommentPane.setText(model.getContent());
		add(CommentPane);
		
		JLabel lblUser = new JLabel(String.valueOf(model.getUser()));
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/user.png")));
		add(lblUser);
		
		JButton buttonLike = new JButton("");
		buttonLike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/like.png")));
		add(buttonLike);
		
		JButton buttonDislike = new JButton("");
		buttonDislike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/dislike.png")));
		add(buttonDislike);
		
		JButton buttonFlag = new JButton("");
		buttonFlag.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/flag.jpg")));
		add(buttonFlag);

	}
	public static void setModel(Comment model) {
		CommentView.model = model;
	}
	public static Comment getModel() {
		return model;
	}

}
