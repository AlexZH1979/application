package ru.zhmyd.yandex.application.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import ru.zhmyd.yandex.application.entity.Actor;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory FACTORY;

	static {
		FACTORY = new AnnotationConfiguration().addPackage("ru.zhmyd.yandex.application.entity")
				.addAnnotatedClass(Actor.class).configure().buildSessionFactory();
	}

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
	
	public static void closeSessionFactory(){
		FACTORY.close();
	}
}
