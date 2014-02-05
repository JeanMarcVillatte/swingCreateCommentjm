package io.robusta.fora.swing;

import io.robusta.fora.domain.Subject;

public class SubjectController {
	
	Subject model;
	SubjectView view;
	

	public SubjectController(Subject model, SubjectView view) {
		this.model = model;
		this.view = view;
	}
	
	public Subject getModel() {
		return model;
	}
	public void setModel(Subject model) {
		this.model = model;
	}
	public SubjectView getView() {
		return view;
	}
	public void setView(SubjectView view) {
		this.view = view;
	}



}
