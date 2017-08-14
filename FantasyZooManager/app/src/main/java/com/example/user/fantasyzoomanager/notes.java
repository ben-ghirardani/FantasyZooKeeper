package com.example.user.fantasyzoomanager;

/**
 * Created by user on 11/08/2017.
 */

// Create a Runner class to print stuff to the console for presentation purposes? Speak to Alex on
// Tuesday afternoon to check.

// Do I need to make getName etc part of my Enclosabe interface? Going to need to do checks on
// both Visitors and Creatures so makes sense to roll it up into the shared interface.

// Dry code. Need to go over Creature methods and add any repeated methods from the various
// creatures into the Creature class.

// could an enclosure be two arraylists? One of creatures, one of visitors. Each enclosure would
// have a price that gets removed from the total funds of the visitors and added to the total
// funds of the zoo. Could have a check against funds to see if a visitor can access the enclosure.
// If any visitors have 0 funds after entering an enclosure they are surplus to requirements and
// get added in as food and into the creature's belly. do a check to see if the creature is a
// predator or not. That would come under the creature class. Would loop through the ArrayList
// looking for matching conditions. Visitors and creatures would then have an agility rating. Once
// a visitor is in an enclosure they would have their agility compared to the creature and either
// go into a belly or back out. Would need an interface that allows creatures and visitors to
// inhabit the same arraylist. Can use an array with a set number by arbitrarily settign the
// capacity.


//    look for more ways to Zooify the manipulation of arrays. Moving between arrays. Looping
//    through arrays, sorting by type, removing specific types of things based on type (not
//    interface as this would be shared).

public class notes {
}
