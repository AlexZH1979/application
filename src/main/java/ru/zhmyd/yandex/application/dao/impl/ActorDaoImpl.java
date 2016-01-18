package ru.zhmyd.yandex.application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.zhmyd.yandex.application.dao.ActorDao;
import ru.zhmyd.yandex.application.db.CoonectionUtil;
import ru.zhmyd.yandex.application.db.HibernateUtil;
import ru.zhmyd.yandex.application.entity.Actor;

public class ActorDaoImpl implements ActorDao {

	private static final String SELECT_ACTORS_BY_FILM_ID = "SELECT a.id as id, a.name as name,"
			+ " a.birth_day as birth_day FROM actors a WHERE a.film_id=?;";
	private static final String SELECT_ACTORS = "SELECT a.id as id, a.name as name,"
			+ " a.birth_day as birth_day FROM actors a";

	@Override
	public List<Actor> getAllActors() {
		Connection connection = CoonectionUtil.getConnction();
		List<Actor> actors= null;
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_ACTORS);
			ResultSet set = statement.executeQuery();

			actors = getActors(set);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public Actor getActorById(long id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Actor actor = (Actor) session.get(Actor.class, id);
		return actor;
	}

	private List<Actor> getActors(ResultSet set) throws SQLException {
		List<Actor> actors = new ArrayList<>();

		while (set.next()) {
			Actor actor = new Actor();
			actor.setId(set.getLong("id"));
			actor.setName(set.getString("name"));
			actor.setBirthDay(set.getDate("birth_day"));
			
			actors.add(actor);
		}
		
		return actors;
	}

}
