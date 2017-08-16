package com.example.user.fantasyzoomanager;

import java.util.ArrayList;
import java.util.Collections;

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

//    Method to check visitor funds on leaving an enclosure, release them if they have enough money,
//    transfer them to the creature enclosure if not.

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


    //    Test method to loop through an arraylist, check for 'instances of' the Dragon class,
    //    cast the object as a Dragon and run a method available only to Dragons.

    public int comparePredatorAgilityToVisitors() {
        int predatorAgility = 0;
        for (Enclosable entity : creatureEnclosure) {
            if (entity instanceof Dragon) {
                Dragon originalDragon = (Dragon) entity;
                predatorAgility = originalDragon.getAgility();
            }
        }
        return predatorAgility;
    }


    // To remove Visitors based on comparison to Creature agility.

    // While loop. While there is 1 predator and more than one entity in the enclosure,
    // loop through and compare the visitor agility to the predator agility. Remove them from the
    // arraylist if they win, add them to the belly.


    public void resolveVisitorsInDragonEnclosure() {
        int currentOccupants = countCreatures();
        int predatorAgility = 0;
        Dragon originalDragon = null;
        Visitor originalVisitor = null;
        for (Enclosable beast : creatureEnclosure) {
            if (beast instanceof Dragon) {
                originalDragon = (Dragon) beast;
                predatorAgility = originalDragon.getAgility();
            }
        }
        while (currentOccupants > 1) {
            for (Enclosable person : creatureEnclosure) {
                if (person instanceof Visitor) {
                    originalVisitor = (Visitor) person;
                }
            }
            if (originalVisitor.visitorAgility() <= predatorAgility && originalVisitor != null) {
            removeFromCreatureEnclosure(originalVisitor);
            originalDragon.addToBelly(originalVisitor);
            currentOccupants = countCreatures();
            } else {
                creatureEnclosure.remove(originalVisitor);
            }
        }
    }

    //  Create a loop similar to the one above for the Unicorn enclosure. Unicorns are nice so
    //  they will assist visitors instead of eating them.

    //  Create a method to loop through arraylist and count visitors for use in unicorn enclosure
    //  method.

    public int countVisitorsInCreatureEnclosure() {
        int numVisitors = 0;
        for (Enclosable person : creatureEnclosure) {
            if (person instanceof Visitor) {
                numVisitors++;
            }
        }
        return numVisitors;
    }

    public int countUnicornsInCreatureEnclosure() {
        int numUnicorns = 0;
        for (Enclosable creature : creatureEnclosure) {
            if (creature instanceof Unicorn) {
                numUnicorns++;
            }
        }
        return numUnicorns;
    }

    public int countDragonsInCreatureEnclosure() {
        int numDragons = 0;
        for (Enclosable creature : creatureEnclosure) {
            if (creature instanceof Dragon) {
                numDragons++;
            }
        }
        return numDragons;
    }

    // Unicorns provide people with money and send them on their way if they get placed
    // in the creatureEnclosure arraylist.

    public void resolveVisitorsInUnicornEnclosure() {
        int currentNumVisitors = countVisitorsInCreatureEnclosure();
        int currentNumUnicorns = countUnicornsInCreatureEnclosure();
        Visitor originalVisitor = null;
        while (currentNumVisitors > 0 &&  currentNumUnicorns > 0) {
            for (Enclosable person : creatureEnclosure) {
                if (person instanceof Visitor) {
                    originalVisitor = (Visitor) person;
                }
            }
            originalVisitor.money = originalVisitor.money + 10;
            removeFromCreatureEnclosure(originalVisitor);
            currentNumVisitors = countVisitorsInCreatureEnclosure();
            currentNumUnicorns = countUnicornsInCreatureEnclosure();
        }
    }

    // Write a unifying method that takes in a dragon and a few unicorns, and compares agility
    // to see whether visitors are eaten or provided with money.

    public void resolveVisitorsInGenPop() {
        int currentNumVisitors = countVisitorsInCreatureEnclosure();
        int currentNumUnicorns = countUnicornsInCreatureEnclosure();
        int currentNumDragons = countDragonsInCreatureEnclosure();
        int dragonAgility = 0;
        ArrayList<Integer> unicornAgilityList = new ArrayList<>();
        int unicornAgility = 0;
        Dragon originalDragon = null;
        Visitor originalVisitor = null;
            for (Enclosable dragon : creatureEnclosure) {
                if (dragon instanceof Dragon) {
                    originalDragon = (Dragon) dragon;
                    dragonAgility = ((Dragon) dragon).getAgility();
                }
            }
            for (Enclosable unicorn : creatureEnclosure) {
                if(unicorn instanceof Unicorn) {
                    unicornAgilityList.add(((Unicorn) unicorn).getAgility());
                    unicornAgility = Collections.max(unicornAgilityList);

                }
            }
            if (dragonAgility > unicornAgility) {
                for (Enclosable beast : creatureEnclosure) {
                    if (beast instanceof Dragon) {
                        originalDragon = (Dragon) beast;
                    }
                }
                while (currentNumVisitors > 0) {
                    for (Enclosable person : creatureEnclosure) {
                        if (person instanceof Visitor) {
                            originalVisitor = (Visitor) person;
                        }
                    }
                    removeFromCreatureEnclosure(originalVisitor);
                    originalDragon.addToBelly(originalVisitor);
                    currentNumVisitors = countVisitorsInCreatureEnclosure();
                }
            }
            else if (unicornAgility > dragonAgility) {
                for (Enclosable person : creatureEnclosure) {
                    if (person instanceof Visitor) {
                        originalVisitor = (Visitor) person;
                    }
                }
                originalVisitor.money = originalVisitor.money + 10;
                removeFromCreatureEnclosure(originalVisitor);
                currentNumVisitors = countVisitorsInCreatureEnclosure();
            }
    }
//    this is the last line.


//    public void resolveVisitorsInUnicornEnclosure() {
//        int currentNumVisitors = countVisitorsInCreatureEnclosure();
//        int currentNumUnicorns = countUnicornsInCreatureEnclosure();
//        Visitor originalVisitor = null;
//        while (currentNumVisitors > 0 &&  currentNumUnicorns > 0) {
//            for (Enclosable person : creatureEnclosure) {
//                if (person instanceof Visitor) {
//                    originalVisitor = (Visitor) person;
//                }
//            }
//            originalVisitor.money = originalVisitor.money + 10;
//            removeFromCreatureEnclosure(originalVisitor);
//            currentNumVisitors = countVisitorsInCreatureEnclosure();
//            currentNumUnicorns = countUnicornsInCreatureEnclosure();
//        }
//    }


//    public void resolveVisitorsInDragonEnclosure() {
//        int currentOccupants = countCreatures();
//        int predatorAgility = 0;
//        Dragon originalDragon = null;
//        Visitor originalVisitor = null;
//        for (Enclosable beast : creatureEnclosure) {
//            if (beast instanceof Dragon) {
//                originalDragon = (Dragon) beast;
//                predatorAgility = originalDragon.getAgility();
//            }
//        }
//        while (currentOccupants > 1) {
//            for (Enclosable person : creatureEnclosure) {
//                if (person instanceof Visitor) {
//                    originalVisitor = (Visitor) person;
//                }
//            }
//            if (originalVisitor.visitorAgility() <= predatorAgility && originalVisitor != null) {
//                removeFromCreatureEnclosure(originalVisitor);
//                originalDragon.addToBelly(originalVisitor);
//                currentOccupants = countCreatures();
//            } else {
//                creatureEnclosure.remove(originalVisitor);
//            }
//        }
//    }


}




