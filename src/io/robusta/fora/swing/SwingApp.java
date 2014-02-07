package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Subject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class SwingApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApp window = new SwingApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame .
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		/*
		//Boilerplate for CommentView
		Comment model = ForaDataSource.getInstance().getComments().get(0);
		CommentView commentView = new CommentView(model);
		CommentController controller = new CommentController(model, commentView);
		commentView.setController(controller);		
		//frame.getContentPane().add(commentView, BorderLayout.CENTER);
		*/
		
		//Boilerplate for SubjectView
		/*Subject model = ForaDataSource.getInstance().getSubjects().get(0);		
		SubjectView view = new SubjectView(model);
		SubjectController controller = new SubjectController(view, model);
		view.setController(controller);
		frame.getContentPane().add(view, BorderLayout.CENTER);*/
		
		Subject subject = ForaDataSource.getInstance().getSubjects().get(0);
		//Boilerplate for SubjectView
		
		SubjectView subjectView = new SubjectView(subject);
		SubjectController subjectController = new SubjectController(subjectView, subject);
		subjectView.setController(subjectController);
		
		CreateCommentModel createCommentModel = new CreateCommentModel();
		createCommentModel.setSubject(subject);
		CreateCommentView createCommentView = new CreateCommentView(createCommentModel);
		
		CreateCommentController createCommentController = new CreateCommentController(createCommentView, createCommentModel,subjectController);
		createCommentView.setController(createCommentController );

		frame.getContentPane().add(subjectView, BorderLayout.CENTER);
		frame.getContentPane().add(createCommentView, BorderLayout.SOUTH);

	}

}
