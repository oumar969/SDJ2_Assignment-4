package gem;

public class WoodenCoin implements Gem
{
  @Override public int getValue()
  {
    return 40;
  }

  @Override public String getGemType()
  {
    return "Wooden Coin";
  }

}
