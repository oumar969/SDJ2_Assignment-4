package kingdom;

import gem.Gem;

import java.util.List;

public class TreasureRoomGuardsman implements TreasureRoomDoor
{
  // her blev brugt readers/writers pattern.

  private int waitingWriters =0 ;
  private boolean activeWriter = false;
  private int activeReaders = 0;

  private TreasureRoom treasureRoom;

  public TreasureRoomGuardsman(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public void acquireReadAccess(String actorName)
      throws InterruptedException
  {
    while (waitingWriters > 0 || activeWriter)
    {
      wait();
    }
    treasureRoom.acquireReadAccess(actorName);
    activeReaders++;
    notifyAll();
  }


  @Override public void acquireWriteAccess(String actorName)
      throws InterruptedException
  {
    waitingWriters++;
    while(activeWriter || activeReaders > 0)
    {
      wait();
    }
    treasureRoom.acquireWriteAccess(actorName);
    waitingWriters--;
    activeWriter = true;
    notifyAll();

  }

  @Override public void releaseReadAccess(String actorName)
  {
    activeReaders--;
    treasureRoom.releaseReadAccess(actorName);
    if (activeReaders == 0)
    {
      notifyAll();
    }
  }

  @Override public void releaseWriteAccess(String actorName)
  {
    activeWriter = false;
    treasureRoom.releaseWriteAccess(actorName);
    notifyAll();
  }

  @Override public Gem retrieveValuable()
  {
    return treasureRoom.retrieveValuable();
  }

  @Override public void addValuable(Gem v)
  {
    treasureRoom.addValuable(v);
  }

  @Override public List<Gem> lookAtAllGems()
  {
    return treasureRoom.lookAtAllGems();
  }
}
