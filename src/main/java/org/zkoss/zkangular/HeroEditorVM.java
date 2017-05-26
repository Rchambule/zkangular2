package org.zkoss.zkangular;

import java.util.ArrayList;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.util.Clients;

@NotifyCommands({
@NotifyCommand(value="updateHero", onChange="_vm_.heroes"),
@NotifyCommand(value="getHero", onChange="_vm_.selected")
})
@ToClientCommand({"updateHero", "getHero"})
@ToServerCommand({"reload", "delete", "add", "update", "get"})
public class HeroEditorVM {

	private ArrayList<Hero> heroes = new ArrayList<Hero>();
	private static Integer currentIndex = 10;
	private Hero selected;

	@Init
	public void init() {
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

	@Command @NotifyChange("heroes")
	public void update(@BindingParam("hero")Hero hero){
		for (int i = 0 ; i < heroes.size() ; i++){
			Hero h = heroes.get(i);
			if (h.getId().equals(hero.getId())){
				heroes.remove(i);
				heroes.add(i, hero);
			}
		}
	}
	
	@Command
	public void show(){
		StringBuilder heroesString = new StringBuilder();
		for (Hero h : heroes){
			heroesString.append(h.toString()+"<br>");
		}
		Clients.showNotification(heroesString.toString());
	}
	
	@Command 
	@NotifyChange("selected")
	public void get(@BindingParam("id")Integer id){
		for (Hero h: heroes){
			if (h.getId().equals(id)){
				selected = h;
				break;
			}
		}
	}

	public ArrayList<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(ArrayList<Hero> heroes) {
		this.heroes = heroes;
	}
	
	private static Integer nextId(){
		return currentIndex++;
	}

	public Hero getSelected() {
		return selected;
	}

	public void setSelected(Hero selected) {
		this.selected = selected;
	}
	
}
