package com.generation.gestorepersonefx.controller;

import com.generation.gestorepersonefx.helpers.ControllerHelper;
import com.generation.gestorepersonefx.model.Person;
import com.generation.gestorepersonefx.model.PersonRepository;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class ApplicationController
{
	private ControllerHelper helper = ControllerHelper.getInstance();


	@FXML
	private Text peopleList;

	public void riempiCasellaTesto()
	{
		String contenuto = helper.produciListaDaStampareASchermo();

		peopleList.setText(contenuto);
	}
}
