package ru.zhmyd.yandex.application;

import java.util.List;

import ru.zhmyd.yandex.application.dao.ActorDao;
import ru.zhmyd.yandex.application.dao.impl.ActorDaoImpl;
import ru.zhmyd.yandex.application.entity.Actor;


public class App {

	public static void main(String[] args) {
		ActorDao dao = new ActorDaoImpl();

		Actor actor = dao.getActorById(1L);
		System.out.println(actor);
	}
}
