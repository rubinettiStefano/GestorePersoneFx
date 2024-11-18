package com.generation.gestorepersonefx.controller;

import com.generation.gestorepersonefx.helpers.ControllerHelper;
import com.generation.gestorepersonefx.model.Person;
import com.generation.gestorepersonefx.model.PersonRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class ApplicationController
{
	private ControllerHelper helper = ControllerHelper.getInstance();


	@FXML
	private Text peopleList;

	@FXML
	private TextField casella;

	public void riempiCasellaTesto()
	{
		String contenuto = helper.produciListaDaStampareASchermo();

		peopleList.setText(contenuto);
	}

	public void stampaCasellaConsole()
	{
		String valoreCasella = casella.getText();
		System.out.println(valoreCasella);
	}
}
