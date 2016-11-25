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

@NotifyCommand(value="updateHero", onChange="_vm_.heroes")
@ToClientCommand({"updateHero"})
@ToServerCommand({"reload"})
public class HeroVM {

	private ArrayList<Hero> heroes = new ArrayList<Hero>();

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

	public ArrayList<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(ArrayList<Hero> heroes) {
		this.heroes = heroes;
	}
	
}
