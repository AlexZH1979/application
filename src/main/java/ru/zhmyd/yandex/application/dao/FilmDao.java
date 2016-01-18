package ru.zhmyd.yandex.application.dao;

import java.util.List;

import ru.zhmyd.yandex.application.entity.Films;

public interface FilmDao {
	List<Films> getAllFilms();
	List<Films> getFilmById(long id);
}
