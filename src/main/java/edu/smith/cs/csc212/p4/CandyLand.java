package edu.smith.cs.csc212.p4;

import java.util.HashMap;
import java.util.Map;


public class CandyLand implements GameWorld {
	private Map<String, Place> places = new HashMap<>();
	
	
	public String getStart() {
		return "rainbowroad";
	}

	

	public CandyLand() {
		Place rainbowroad = insert(
				Place.create("rainbowroad", "You are on rainbowroad and there is a fork in the road.\n"
						+ "What path should you choose? How did you get here?"));
		rainbowroad.addExit(new Exit("gumdropPass", "Go right.There is a side path leading to a gumdrop forest."));
		rainbowroad.addExit(new Exit("road0", "Go forward  along the main road"));
		rainbowroad.addExit(new Exit("candycaneLane", "Make a left."));
				
		Place  gumdropPass= insert(
				Place.create("gumdropPass", "You have found the Gumdrop forest.\n" + 
		                           "It is dark but you smell the scent of freshly baked cookies .\n" +
						"You want to follow the amazing scent, but it is too dark to go any further."
						));
		gumdropPass.addExit(new Exit("rainbowroad", "Go back to the way you came!"));

		Place candycaneLane = insert(Place.create("candycaneLane",
				"You end up in a field of Candycanes and see a mountain ahead.\n" + "It's beautiful here."));
		candycaneLane.addExit(new Exit("rainbowroad", "Go back to the way you came!"));
		candycaneLane.addExit(new Exit("Mountain", "Keep walking towards the mountain."));
		candycaneLane.addExit(new Exit("treeHouse", "You see a candycane treehouse and a rope ladder leading up to it.\n"+ "Let's go inside."));
		int roadDepth = 5;
		int lastroadPart = roadDepth - 1;
		for (int i=0; i<roadDepth; i++) {
			Place roadPart = insert(Place.create("road"+i, "Let's keep walking on the main road"));
			if (i == 0) {
				roadPart.addExit(new Exit("rainbowroad", "Go back."));
			} else {
				roadPart.addExit(new Exit("road"+(i-1), "Go back."));
			}
			if (i != lastroadPart) {
				roadPart.addExit(new Exit("road"+(i+1), "Go forward."));
			} else {
				roadPart.addExit(new Exit("secretCave", "There is cave ahead."));
			}
		}
		Place secretCave = insert(Place.create("secretCave",
				"You end up in a dark chocolate cave.\n" + "It's dark but smells good."));
		secretCave.addExit(new Exit("tunnel", "you see a really deep hole and a licorice ladder leading downwards"));
		secretCave.addExit(new Exit("rainbowroad", "Go back to the start!"));
		Place tunnel = insert(Place.create("tunnel",
				"You jump down the licorice ladder and end up in a dark tunnel.\n"+ "You are definitely stepping on gummy worms! Ew!"));
		tunnel.addExit(new Exit("secretCave", "Go back up the ladder!"));
	}	
		
		
		
		
	private Place insert(Place p) {
		places.put(p.getId(), p);
		return p;
	}

	
	public Place getPlace(String id) {
		return this.places.get(id);		
	}
}