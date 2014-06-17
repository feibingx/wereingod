package com.zhiweiwang.gow.exception;

public class GameStatusException extends Exception {

	String feedbackText = null;
	
	public GameStatusException(){}
	
	public GameStatusException(String s){this.feedbackText=s;}
	
	

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}






	private static final long serialVersionUID = 957050684404981248L;

	
}
