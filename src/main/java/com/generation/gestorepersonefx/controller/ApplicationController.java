package com.generation.gestorepersonefx.controller;

import com.generation.gestorepersonefx.helpers.ControllerHelper;
import com.generation.gestorepersonefx.model.Person;
import com.generation.gestorepersonefx.model.PersonRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class ApplicationController
{
	private ControllerHelper helper = ControllerHelper.getInstance();


	@FXML
	private Text peopleList;

	@FXML
	private TextField casella;

	@FXML
	private TextField name,surname;

	@FXML
	private GridPane formPerson;

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

	public void leggiForm()
	{
		String nome = name.getText();
		String cognome = surname.getText();
		String contenuto = helper.inserisciPersonaEDaiParenti(nome,cognome);
		peopleList.setText(contenuto);

		name.clear();
		surname.clear();
		formPerson.setVisible(false);
	}

	public void toggleForm()
	{
		boolean isVisible = formPerson.isVisible();
//		if(isVisible)
//			formPerson.setVisible(false);
//		else
//			formPerson.setVisible(true);
		formPerson.setVisible(!isVisible);
	}

	//prende nome e cognome e cancella la persona con essi
	//se non esiste deve semplicemente mettere nella lista ("Persona non trovata")
	public void killer()
	{
		String nome = name.getText();
		String cognome = surname.getText();
		String contenuto = helper.faiFuori(nome,cognome);
		peopleList.setText(contenuto);
		name.clear();
		surname.clear();
		formPerson.setVisible(false);
	}
}
