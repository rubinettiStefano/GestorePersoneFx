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




}
