package io.robusta.fora.swing;

import io.robusta.fora.domain.Comment;

public class CommentController {

	Comment model;
	CommentView view;
	

	public CommentController(Comment model, CommentView view) {
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


	


	public int like(){
		this.model.setScore(this.model.getScore() + 1);
		return this.model.getScore();
	}
	
	public int dislike(){
		this.model.setScore(this.model.getScore() - 1);
		return this.model.getScore();
	}
	
	public void flag(){
		
	}

	
	
	
}
