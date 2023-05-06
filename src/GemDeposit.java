
/*
Vi  opretter en blokeringskø kaldet Gem Deposit ved hjælp af ArrayList, der er angivet i opgaven.
Vi vil bruge adaptermønsteret til at konvertere ArrayList til en blokerende kø.

 */
public class GemDeposit<Gem> implements BlockingQueueKingdom<Gem>
{
  private ListADT<Gem> gemList;
  private int capacity;

  public GemDeposit(int capacity)
  {
    this.capacity = capacity;
    gemList = new ArrayList<>();

  }

  /**
   * Tilføjer en gem til køen. Hvis køen allerede har maksimal kapacitet,
   * metoden blokerer indtil der er ledig plads i køen.
   * Når en gem er blevet tilføjet, får alle ventende tråde besked.
   *
   * @throws InterruptedException, hvis tråden afbrydes, mens den venter
   * for at der bliver ledig plads i køen
   */
  public synchronized void put(Gem gem) throws InterruptedException {
    while (gemList.size() >= capacity) {
      wait();
    }
    gemList.add(gem);
    notifyAll();
  }

  /**
   * Henter og fjerner den første gem  i køen. Hvis køen er tom,
   * metoden blokerer indtil en gem  er tilgængelig. Når en gem  er vellykket
   * hentet, alle ventende tråde får besked.
   *
   * @return den første gem  i køen
   * @throws InterruptedException, hvis tråden afbrydes, mens den venter
   * for at en gem  bliver tilgængelig i køen
   */
  public synchronized Gem take() throws InterruptedException {
    while (gemList.isEmpty()) {
      wait();
    }
    Gem gem = gemList.remove(0);
    notifyAll();
    return gem;
  }


  @Override public boolean isFull()
  {
    return capacity== gemList.size();
  }
}
