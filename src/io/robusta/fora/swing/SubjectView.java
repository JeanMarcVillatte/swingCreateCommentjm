package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Subject;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SubjectView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Subject model;
	SubjectController controller;
	JPanel commentsPanel;
	
	public SubjectView(Subject model) {
		super();
		this.model = model;
		initView();
	}

	private void initView() {

		// Récupération du sujet pirelli

		setLayout(new BorderLayout(0, 0));

		// affichage du sujet
		this.add(new JLabel(model.getTitle()), BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		commentsPanel = new JPanel();
		scrollPane.setViewportView(commentsPanel);
		commentsPanel.setLayout(new BoxLayout(commentsPanel, BoxLayout.Y_AXIS));

		// affichage des commentaires
		List<Comment> comments = model.getComments();
		for (Comment comment : comments) {

			CommentView commentView = new CommentView(comment);
			CommentController controller = new CommentController(comment,
					commentView);
			commentView.setController(controller);

			commentsPanel.add(commentView);
		}

	}
	
	public void addComment(Comment comment){
		CommentView commentView = new CommentView(comment);
		CommentController controller = new CommentController(comment,
				commentView);
		commentView.setController(controller);
		commentsPanel.add(commentView);
		this.revalidate();
		this.repaint();
	}

	/**
	 * Create the panel.
	 */
	public SubjectView() {
		this.model = ForaDataSource.getInstance().getSubjects().get(0);
		initView();

	}

	public void setController(SubjectController controller) {
		this.controller = controller;
	}

}
