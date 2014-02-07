package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.User;

public class CreateCommentController {

	CreateCommentView view;
	CreateCommentModel createCommentModel;
	SubjectController subjectController;

	public CreateCommentController(CreateCommentView view,
			CreateCommentModel model, SubjectController subjectController) {
		this.view = view;
		this.createCommentModel = model;
		this.subjectController=subjectController;
	}

	public void cancelAction() {

	}

	public Comment createComment(String content, boolean isAnonymous) {

		if (content == null || content.isEmpty()) {
			view.showError.setText("Empty content");
			return null;
		}

		User user = ForaDataSource.getInstance().nicolas();

		Comment comment = new Comment();
		comment.setContent(content);
		if (isAnonymous) {
			comment.setAnonymous(true);
		} else {
			comment.setUser(user);
		}
		
		createCommentModel.setNewComment(comment);
		createCommentModel.setAnonymous(isAnonymous);
		
		subjectController.addComment(createCommentModel);
		
		return comment;

	}
}
