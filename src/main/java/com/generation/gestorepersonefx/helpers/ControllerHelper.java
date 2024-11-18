package com.generation.gestorepersonefx.helpers;

import com.generation.gestorepersonefx.model.Person;
import com.generation.gestorepersonefx.model.PersonRepository;

import java.sql.SQLException;
import java.util.List;

public class ControllerHelper
{
	private static ControllerHelper instance;
	public static ControllerHelper getInstance()
	{
		if(instance == null)
			instance = new ControllerHelper();

		return instance;
	}
	private ControllerHelper(){}

	private PersonRepository repo = PersonRepository.getInstance();

	public String produciListaDaStampareASchermo()
	{
		try
		{
			List<Person> all = repo.findAllPeople();
			StringBuilder res = new StringBuilder();

			for(Person p : all)
			{
				//                     condizione     V.V    V.F
				res.append(p.getId());
				res.append(	p.getId()<10 	? 	"     " 	:
							p.getId()<100   ?   "   "		:
							" ");
				res.append(p.getName()+" ");
				res.append(p.getSurname()+"\n");
			}

			return res.toString();
		}catch (SQLException e)
		{
			return "Problema con il db";
		}
	}

	public String produciListaPerCognome(String surname)
	{
		try
		{
			List<Person> all = repo.findPeopleBySurname(surname);
			StringBuilder res = new StringBuilder();

			for(Person p : all)
			{
				//                     condizione     V.V    V.F
				res.append(p.getId());
				res.append(	p.getId()<10 	? 	"     " 	:
							   p.getId()<100   ?   "   "		:
							   " ");
				res.append(p.getName()+" ");
				res.append(p.getSurname()+"\n");
			}

			return res.toString();
		}catch (SQLException e)
		{
			return "Problema con il db";
		}
	}


	public String inserisciPersonaEDaiParenti(String name,String surname)
	{
		Person p = new Person(name,surname);
		try
		{
			repo.insertPerson(p);
			return produciListaPerCognome(surname);
		} catch (SQLException e)
		{
			return "Problema con il db, inserimento fallito";
		}
	}


	public String faiFuori(String nome, String cognome)
	{
		//TODO
		return "TODO";
	}
}
