package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Subject;

public class SubjectController {

	SubjectView view;
	Subject subject;
	
	
	public SubjectController(SubjectView view, Subject model) {
		this.view = view;
		this.subject = model;
	}
	
	public void addComment(CreateCommentModel createCommentModel){
		if (subject.equals(createCommentModel.getSubject())){
			subject.getComments().add(createCommentModel.getNewComment());
			view.addComment(createCommentModel.getNewComment());
			//view.addComment(subject.getComments().get(subject.getComments().size()-1));
		}
	}
	

}
