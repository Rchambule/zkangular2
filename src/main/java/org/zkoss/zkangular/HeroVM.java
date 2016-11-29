package org.zkoss.zkangular;

import java.util.ArrayList;
import java.util.Iterator;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.NotifyCommand;
import org.zkoss.bind.annotation.ToClientCommand;
import org.zkoss.bind.annotation.ToServerCommand;
import org.zkoss.zk.ui.util.Clients;

@NotifyCommand(value="updateHero", onChange="_vm_.heroes")
@ToClientCommand({"updateHero"})
@ToServerCommand({"reload", "delete", "add"})
public class HeroVM {

	private ArrayList<Hero> heroes = new ArrayList<Hero>();
	
	private static Integer currentIndex = 20;

	@Init
	public void init() {
		heroes.add(new Hero(11, "Mr. Nice"));
		heroes.add(new Hero(12, "Narco"));
		heroes.add(new Hero(13, "Bombasto"));
		heroes.add(new Hero(14, "Celeritas"));
		heroes.add(new Hero(15, "Magneta"));
		heroes.add(new Hero(16, "RubberMan"));
		heroes.add(new Hero(17, "Dynama"));
		heroes.add(new Hero(18, "Dr IQ"));
		heroes.add(new Hero(19, "Magma"));
		heroes.add(new Hero(20, "Tornado"));
	}
	
	@Command @NotifyChange("heroes")
	public void reload(){
		
	}
	
	@Command @NotifyChange("heroes")
	public void delete(@BindingParam("id")String id){
		for (Hero h: heroes){
			if (h.getId().toString().equals(id)){
				heroes.remove(h);
				break;
			}
		}
	}
	
	@Command @NotifyChange("heroes")
	public void add(@BindingParam("name")String name){
		heroes.add(new Hero(nextId(), name));
	}
	
	@Command
	public void show(){
		StringBuilder heroesString = new StringBuilder();
		for (Hero h : heroes){
			heroesString.append(h.toString()+" ");
		}
		Clients.showNotification(heroesString.toString());
	}

	public ArrayList<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(ArrayList<Hero> heroes) {
		this.heroes = heroes;
	}
	
	public static Integer nextId(){
		return currentIndex++;
	}
	
}
