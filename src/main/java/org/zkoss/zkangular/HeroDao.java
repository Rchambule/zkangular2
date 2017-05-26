package org.zkoss.zkangular;

import java.util.*;

/**
 * a class to simulate accessing a database
 * @author hawk
 *
 */
public class HeroDao {
	static Integer currentIndex = 10;
	static private ArrayList<Hero> heroes = new ArrayList<Hero>();

	{
		heroes.add(new Hero(nextId(), "Mr. Nice"));
		heroes.add(new Hero(nextId(), "Narco"));
		heroes.add(new Hero(nextId(), "Bombasto"));
		heroes.add(new Hero(nextId(), "Celeritas"));
		heroes.add(new Hero(nextId(), "Magneta"));
		heroes.add(new Hero(nextId(), "RubberMan"));
		heroes.add(new Hero(nextId(), "Dynama"));
		heroes.add(new Hero(nextId(), "Dr IQ"));
		heroes.add(new Hero(nextId(), "Magma"));
		heroes.add(new Hero(nextId(), "Tornado"));
	}

	public List<Hero> queryAll(){
		return new LinkedList<Hero>(heroes);
	}
	
	public Hero create(String name){
		Hero hero = new Hero(nextId(), name);
		heroes.add(hero);
		return hero;
	}
	
	public void update(Hero hero){
		for (int i = 0 ; i < heroes.size() ; i++){
			Hero h = heroes.get(i);
			if (h.getId().equals(hero.getId())){
				heroes.remove(i);
				heroes.add(i, hero);
			}
		}
	}
	
	public void remove(String id){
		for (Hero h: heroes){
			if (h.getId().toString().equals(id)){
				heroes.remove(h);
				break;
			}
		}
	}
	
	static Integer nextId(){
		return currentIndex++;
	}

}
