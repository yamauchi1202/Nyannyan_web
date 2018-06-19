package jp.co.nyannyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.nyannyan.service.IQuestionnaireService;

@Controller
public class QuestionnaireController {

	@Autowired
	IQuestionnaireService IQuestionnaireService;
}
