package jp.co.nyannyan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.nyannyan.service.IAdminService;

@Controller
public class AdminController {

	@Autowired
	IAdminService IAdminService;
}
