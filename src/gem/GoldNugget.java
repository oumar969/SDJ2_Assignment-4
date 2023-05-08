package gem;

public class GoldNugget implements Gem
{
  @Override public int getValue()
  {
    return 20;
  }

  @Override public String getGemType()
  {
    return "Gold Nugget";
  }
}
