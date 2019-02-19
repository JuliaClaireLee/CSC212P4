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
						+ "What path should you choose? Your goal is to get to King Kandy's castle"));
		rainbowroad.addExit(new Exit("gumdropPass", "Go right.There is a side path leading to a gumdrop forest."));
		rainbowroad.addExit(new Exit("road0", "Go forward along the main road"));
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
		candycaneLane.addExit(new Exit("mountain", "Keep walking towards the mountain."));
		candycaneLane.addExit(new Exit("treeHouse", "You see a candycane treehouse and a rope ladder leading up to it.\n"+ "Let's go inside."));
		Place mountain = insert(Place.create("mountain","You reach the top of the sugar mountain.\n" + "It is a beautiful view at the top.\n" + 
		"You see some winged horses nearby. "));
		mountain.addExit(new Exit("treeHouse", "you ask the winged horses to take you to the tree house"));
		mountain.addExit(new Exit("road3", "Walk down the other side of the mountain to reach the main road"));
		mountain.addExit(new Exit("gingerbreadHouse", "you see a gingerbread house 100 yards away. Let's go investigate"));
		Place gingerbreadHouse = insert(Place.create("gingerbreadHouse","You reach the house.\n" + "it is locked!"));
		gingerbreadHouse.addExit(new Exit("treeHouse", "you ask the winged horses to take you to the tree house"));
		gingerbreadHouse.addExit(new Exit("mountain", "Walk back where you came"));
				
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
		Place treeHouse = insert(Place.create("treeHouse",
				"You end up in a  Treehouse made of candycanes and it smells like hot cocoa."));
		treeHouse.addExit(new Exit("candycaneLane", "you see a rope ladder leading downwards"));
		treeHouse.addExit(new Exit("rainbowroad", "Drink some hot cocoa and go back to the start"));
		Place secretCave = insert(Place.create("secretCave",
				"You end up in a dark chocolate cave.\n" + "It's dark but smells good."));
		secretCave.addExit(new Exit("tunnel", "you see a really deep hole and a licorice ladder leading downwards"));
		secretCave.addExit(new Exit("rainbowroad", "Go back to the start!"));
		Place tunnel = insert(Place.create("tunnel",
				"You jump down the licorice ladder and end up in a dark fudge tunnel.\n"+ "You are definitely stepping on gummy worms! Ew! \n"
						+ "You turn around and the ladder is gone! you are trapped"));
		tunnel.addExit(new Exit("tunnel0", "we'll have to keep going"));
		int tunnelDepth = 7;
		int lasttunnelPart = 6;
		for (int i=0; i<tunnelDepth; i++) {
			Place tunnelPart = insert(Place.create("tunnel"+i, "Let's keep walking through this tunnel"));
			if (i == 0) {
				tunnelPart.addExit(new Exit("tunnel", "Go back."));
			} else {
				tunnelPart.addExit(new Exit("tunnel"+(i-1), "Go back."));
			}
			if (i != lasttunnelPart) {
				tunnelPart.addExit(new Exit("tunnel"+(i+1), "Go forward."));
			} else {
				tunnelPart.addExit(new Exit("kingKandy", "You finally find an exit."));
			}
		}
		Place kingKandy = insert(Place.terminal("kingKandy",
				"You step out from the darkness of the fudge tunnel and find yourself at King Kandy's castle.\n"
						+ "Just in time for the party! You win!"));
		
	}	
	
	public Place insert(Place p) {
		places.put(p.getId(), p);
		return p;
	}

	
	public Place getPlace(String id) {
		return this.places.get(id);		
	}
}

 
 


	
	


	