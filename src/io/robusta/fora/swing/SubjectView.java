package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Subject;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;

public class SubjectView extends JPanel {

	Subject model;
	SubjectController controller;

	public SubjectView() {
		this.model = ForaDataSource.getInstance().getSubjects().get(0);
		initView();
	}
	
	public SubjectView(Subject subject) {
		this.model = subject;
		initView();
	}
	
	public void initView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{688, 0};
		gridBagLayout.rowHeights = new int[]{77, 287, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		JLabel titreSujet = new JLabel(model.getTitle());
		titreSujet.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		titreSujet.setAlignmentY(Component.TOP_ALIGNMENT);
		GridBagConstraints gbc_titreSujet = new GridBagConstraints();
		gbc_titreSujet.fill = GridBagConstraints.BOTH;
		gbc_titreSujet.insets = new Insets(0, 0, 5, 0);
		gbc_titreSujet.gridx = 0;
		gbc_titreSujet.gridy = 0;
		add(titreSujet, gbc_titreSujet);
		
		JPanel panelComments = new JPanel();
		panelComments.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelComments.setPreferredSize(new Dimension(0, 0));
		panelComments.setMinimumSize(new Dimension(0, 0));
		panelComments.setMaximumSize(new Dimension(0, 0));
		GridBagConstraints gbc_panelComments = new GridBagConstraints();
		gbc_panelComments.fill = GridBagConstraints.BOTH;
		gbc_panelComments.gridx = 0;
		gbc_panelComments.gridy = 1;
		add(panelComments, gbc_panelComments);

		for (Comment c : model.getComments()) {
			CommentView cV=new CommentView(c);
			CommentController controller = new CommentController(c, cV);
			cV.setController(controller);
			panelComments.add(cV);
		}
	}
	
	public void setController(SubjectController controller) {
		this.controller = controller;
	}

}
