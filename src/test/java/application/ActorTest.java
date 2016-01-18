package application;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.zhmyd.yandex.application.entity.Actor;

public class ActorTest {
	
	@Test
	public void toTest(){
		Actor actor = new Actor();
		actor.setId(23L);
		
		assertEquals(new Long(24), actor.getId());
	}
}
