public class GemDeposit<Gem> implements BlockingQueueKingdom<Gem>
{
  private ListADT<Gem> gemList = new ArrayListKingdom<Gem>();
  private int capacity;

  public GemDeposit(int capacity)
  {
    this.capacity = capacity;
  }


  @Override public boolean isFull()
  {
    return capacity== gemList.size();
  }
}
