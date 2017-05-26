package org.zkoss.zkangular;

import java.util.*;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.util.Clients;

@NotifyCommand(value="updateHero", onChange="_vm_.heroes")
@ToClientCommand({"updateHero"})
@ToServerCommand({"reload", "delete", "add", "update"})
public class HeroEditorVM {

	private List<Hero> heroes = new ArrayList<Hero>();
	private HeroDao dao = new HeroDao();

	@Command @NotifyChange("heroes")
	public void reload(@BindingParam("id")Integer id){
		if (id == null){
			heroes = dao.queryAll();
		}else{//query one
			Hero selected = null;
			for (Hero h: heroes){
				if (h.getId().equals(id)){
					selected = h;
					break;
				}
			}
			heroes.clear();
			heroes.add(selected);
		}
	}
	
	@Command @NotifyChange("heroes")
	public void delete(@BindingParam("id")String id){
		dao.remove(id);
		reload(null);
	}
	
	@Command @NotifyChange("heroes")
	public void add(@BindingParam("name")String name){
		heroes.add(dao.create(name));
	}

	@Command @NotifyChange("heroes")
	public void update(@BindingParam("hero")Hero hero){
		dao.update(hero);
	}
	
	@Command
	public void show(){
		StringBuilder heroesString = new StringBuilder();
		for (Hero h : heroes){
			heroesString.append(h.toString()+"<br>");
		}
		Clients.showNotification(heroesString.toString());
	}
	
	public List<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(ArrayList<Hero> heroes) {
		this.heroes = heroes;
	}
	
}
