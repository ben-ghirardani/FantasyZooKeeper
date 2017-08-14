package com.example.user.fantasyzoomanager;

import java.util.ArrayList;

/**
 * Created by user on 10/08/2017.
 */



public class Enclosure {

    private String name;
    private int price;
    private ArrayList<Enclosable> creatureEnclosure;
    private ArrayList<Visitor> visitorSeating;

    public Enclosure(String name, int price) {
        this.name = name;
        this.price = price;
        this.creatureEnclosure = new ArrayList<Enclosable>();
        this.visitorSeating = new ArrayList<Visitor>();
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int countCreatures() {
        int count = 0;
        for (Enclosable enclosable : creatureEnclosure) {
            if (enclosable != null) {
                count++;
            }
        }
        return count;
    }

    public int countVisitors() {
        int count = 0;
        for (Enclosable enclosable : visitorSeating) {
            if (enclosable != null) {
                count++;
            }
        }
        return count;
    }

//    Standard add and remove methods.

    public void addToCreatureEnclosure(Enclosable entity) {
        creatureEnclosure.add(entity);
    }

    public void removeFromCreatureEnclosure(Enclosable entity) {
        creatureEnclosure.remove(entity);
    }

    public void addToVisitorSeating(Visitor visitor) {
        visitorSeating.add(visitor);
    }

    public void removeVisitorFromSeating(Visitor visitor) {
        visitorSeating.remove(visitor);
    }

//    Method to add a Visitor and remove funds from them based on Enclosure price.

    public String addVisitorToSeatingAndPay(Visitor visitor) {
        if (visitor.visitorFunds() < this.price) {
            return visitor.getName() + " cannot afford to visit this enclosure.";
        } else {
            visitor.money = visitor.money - this.price;
            visitorSeating.add(visitor);
        }
        return visitor.getName() + " has paid and taken a seat.";
    }

//    Count Number of predators.

    public int countPredatorsInCreatureEnclosure() {
        int predatorCount = 0;
        for (Enclosable currentOccupant : creatureEnclosure) {
            if (currentOccupant.isPredator() == true)
                predatorCount++;
        }
        return predatorCount;
    }

//        Method to make sure only one predator can be added to an enclosure.


    public String addCreatureToEnclosureCheckPredator(Creature creature) {
        if (this.countPredatorsInCreatureEnclosure() > 0 && creature.predator == true) {
            return creature.getName() + " cannot be added to this enclosure as there is " +
                    "already one predator here. That would be dangerous.";
        } else {
            creatureEnclosure.add(creature);
            return creature.getName() + " has been added to " + "the " + this.getName();
        }
    }

//    Method to check visitor funds, release them if they have enough money, transfer them to the
//    creature enclosure if not.

    public String removeVisitorIfTheyHaveMoney(Visitor visitor) {
        if (visitor.visitorFunds() <= 0) {
            visitorSeating.remove(visitor);
            addToCreatureEnclosure(visitor);
            return "A visitor has entered the creature enclosure.";
        } else {
            visitorSeating.remove(visitor);
            return visitor.getName() + " has left the enclosure and still has money to spend.";
        }
    }

//    This is a test method to check the functionality of the 'instance of' operator.

    public int findDragonInArrayOfItems() {
        int numberOfDragons = 0;
        for (Enclosable entity : creatureEnclosure) {
            if (entity instanceof Dragon) {
                numberOfDragons++;
            }
        }
        return numberOfDragons;
    }


    //    Check for instances of a predator. Cast them into their original form and record their
    //    agility. Check for instances of Visitors. If their agility is less than the predator
    //    agility put them in it's belly ArrayList.


    //    Test method to loop through an arraylist, check for 'instances of' Dragon, cast the
    //    object as a Dragon and run a method available to Dragons.

    public int comparePredatorAgilityToVisitors() {
        int predatorAgility = 0;
        for (Enclosable entity : creatureEnclosure) {
            if (entity instanceof Dragon) {
                Dragon original = (Dragon) entity;
                predatorAgility = original.getAgility();
            }
        }
        return predatorAgility;
    }


}




