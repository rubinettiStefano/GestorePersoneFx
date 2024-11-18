package com.generation.gestorepersonefx.model;

import com.generation.gestorepersonefx.helpers.DbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//anche essa un Singleton
//si occuperà di fornire le funzioni di interazione con il db per le Person
public class PersonRepository
{
	private static PersonRepository instance;
	public static PersonRepository getInstance()
	{
		if (instance == null)
			instance = new PersonRepository();
		return instance;
	}

	private PersonRepository(){}

	private DbHelper dbh = DbHelper.getInstance();

	public List<Person> findAllPeople() throws SQLException
	{
		ResultSet rs = dbh.executeSelect("SELECT * FROM person");
		List<Person> people = new ArrayList<>();

		while(rs.next())
		{
			Person p = convertFromRowToObject(rs);
			people.add(p);
		}

		return people;
	}

	public List<Person> findPeopleBySurname(String surname) throws SQLException
	{
		ResultSet rs = dbh.executeSelect("SELECT * FROM person WHERE surname = '" + surname + "'");
		List<Person> people = new ArrayList<>();

		while(rs.next())
		{
			Person p = convertFromRowToObject(rs);
			people.add(p);
		}

		return people;
	}

	public Person findPerson(int id) throws SQLException
	{
		ResultSet rs = dbh.executeSelect("SELECT * FROM person WHERE id = " + id);

		if(rs.next())
			return convertFromRowToObject(rs);

		return null;
	}

	//restituisco la persona appena inserita
	public Person insertPerson(Person p) throws SQLException
	{
		String query = "INSERT INTO person (name,surname) VALUES ('";
		query += p.getName() + "','";
		query += p.getSurname() + "')";

		dbh.executeDML(query);

		ResultSet rs = dbh.executeSelect("SELECT MAX(id) as maxId FROM person");

		rs.next();
		int id = rs.getInt("maxId");

		return findPerson(id);
	}

	public void deletePersonById(int id)
	{
		String query = "DELETE FROM person WHERE id = " + id;
		dbh.executeDML(query);
	}



	private Person convertFromRowToObject(ResultSet rs) throws SQLException
	{
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setSurname(rs.getString("surname"));
		return p;
	}

}
