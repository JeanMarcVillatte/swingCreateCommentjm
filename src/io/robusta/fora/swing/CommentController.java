package io.robusta.fora.swing;

import io.robusta.fora.domain.Comment;

public class CommentController {

	Comment model;
	CommentView view;
	
	public CommentController(Comment model, CommentView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public Comment getModel() {
		return model;
	}
	public void setModel(Comment model) {
		this.model = model;
	}
	public CommentView getView() {
		return view;
	}
	public void setView(CommentView view) {
		this.view = view;
	}


	
	
	
}
