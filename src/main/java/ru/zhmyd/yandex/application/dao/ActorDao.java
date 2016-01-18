package ru.zhmyd.yandex.application.dao;

import java.util.List;

import ru.zhmyd.yandex.application.entity.Actor;

public interface ActorDao {
	List<Actor> getAllActors();
	Actor getActorById(long id);
}
