package com.github.cman85.Game.entities;

import java.util.HashSet;
import java.util.Set;

public class EntityManager {

	private Set<Entity> entities = new HashSet<Entity>();
	
	public EntityManager() {
	}

	public Set<Entity> getEntities() {
		return entities;
	}

	public void setEntities(Set<Entity> entities) {
		this.entities = entities;
	}

}
