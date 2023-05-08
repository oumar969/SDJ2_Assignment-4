package kingdom;

public class Catalogue
{
  private static Catalogue instance;

  private Catalogue() {}

  public static Catalogue getInstance() {
    if (instance == null) {
      instance = new Catalogue();
    }
    return instance;
  }

  public void transferGemsToTreasureRoom(int gems) {
    System.out.println("Transfering " + gems + " gems to treasure room");
  }

  public void throwParty() {
    System.out.println("The king is throwing a party");
  }

  public void cancelParty() {
    System.out.println("The king is cancelling the party");
  }

  public void totalWealth(int gems) {
    System.out.println("The king's total wealth is " + gems + " gems");
  }

  public void waitingToEnterTreasureRoom(String name) {
    System.out.println("The " + name + " is waiting to enter the treasure room");
  }

  public void enteredTreasureRoom() {
    System.out.println("Someone has entered the treasure room");
  }

  public void leftTreasureRoom() {
    System.out.println("Someone has left the treasure room");
  }
}
