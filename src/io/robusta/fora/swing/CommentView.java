package io.robusta.fora.swing;


import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class CommentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @wbp.nonvisual location=130,379
	 */
	Comment model;
	CommentController controller;

	public CommentView() {
		this.model = ForaDataSource.getInstance().getComments().get(1);
		initView();
	}
	
	public CommentView(Comment comment) {
		this.model = comment;
		initView();
	}
	
	JTextPane commentPane;
	/**
	 * Create the panel.
	 */
	public void initView() {
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[]{218, 112, 73, 73, 73, 0};
				gridBagLayout.rowHeights = new int[]{78, 0};
				gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				setAlignmentX(Component.LEFT_ALIGNMENT);
				setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				setLayout(gridBagLayout);
				
				JButton buttonLike = new JButton("");
				buttonLike.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						controller.like();
						updateContentColor();
					}
				});
				
				commentPane = new JTextPane();
				commentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
				commentPane.setBackground(UIManager.getColor("Label.background"));
				commentPane.setEditable(false);
				commentPane.setText(model.getContent());
				GridBagConstraints gbc_commentPane = new GridBagConstraints();
				gbc_commentPane.insets = new Insets(0, 0, 0, 5);
				gbc_commentPane.gridx = 0;
				gbc_commentPane.gridy = 0;
				add(commentPane, gbc_commentPane);
				
						
						JLabel lblUser = new JLabel(String.valueOf(model.getUser()));
						lblUser.setVerticalAlignment(SwingConstants.TOP);
						lblUser.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/user.png")));
						GridBagConstraints gbc_lblUser = new GridBagConstraints();
						gbc_lblUser.anchor = GridBagConstraints.WEST;
						gbc_lblUser.insets = new Insets(0, 0, 0, 5);
						gbc_lblUser.gridx = 1;
						gbc_lblUser.gridy = 0;
						add(lblUser, gbc_lblUser);
				buttonLike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/like.png")));
				GridBagConstraints gbc_buttonLike = new GridBagConstraints();
				gbc_buttonLike.anchor = GridBagConstraints.WEST;
				gbc_buttonLike.insets = new Insets(0, 0, 0, 5);
				gbc_buttonLike.gridx = 2;
				gbc_buttonLike.gridy = 0;
				add(buttonLike, gbc_buttonLike);
				
				JButton buttonDislike = new JButton("");
				buttonDislike.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.dislike();
						updateContentColor();
					}
				});
				buttonDislike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/dislike.png")));
				GridBagConstraints gbc_buttonDislike = new GridBagConstraints();
				gbc_buttonDislike.anchor = GridBagConstraints.WEST;
				gbc_buttonDislike.insets = new Insets(0, 0, 0, 5);
				gbc_buttonDislike.gridx = 3;
				gbc_buttonDislike.gridy = 0;
				add(buttonDislike, gbc_buttonDislike);
				
				JButton buttonFlag = new JButton("");
				buttonFlag.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/flag.jpg")));
				GridBagConstraints gbc_buttonFlag = new GridBagConstraints();
				gbc_buttonFlag.anchor = GridBagConstraints.WEST;
				gbc_buttonFlag.gridx = 4;
				gbc_buttonFlag.gridy = 0;
				add(buttonFlag, gbc_buttonFlag);

	}

	public void setController(CommentController controller) {
		this.controller = controller;
	}
	
	private void updateContentColor(){
		if (this.model.getScore() >0){
			commentPane.setForeground(Color.GREEN);
		}else if (this.model.getScore()<0){
			commentPane.setForeground(Color.RED);
		}else{
			commentPane.setForeground(Color.BLACK);
		}
	}
}
