package model.enumeration;

import model.interfaces.Player;
import model.interfaces.Slot;

/**
 * Provided enum type for Further Programming representing a type of Bet<br>
 * See inline comments for where you need to provide additional code
 * 
 * @author Caspar Ryan
 * 
 */
public enum BetType
{
   RED
   {
      @Override
      public String applyWinLoss(Player player, Slot winSlot)
      {
         int points = player.getPoints();
         if(winSlot.getColor() == Color.RED) {
        	 player.setPoints(points + player.getBet());
        	 return "Win";
         }else {
        	 player.setPoints(points - player.getBet());
        	 return "Lose";
         }
      }
      
      public String toString() {
          return "RED";
      }
   },
   
   BLACK
   {
      @Override
      public String applyWinLoss(Player player, Slot winSlot)
      {
    	  int points = player.getPoints();
          if(winSlot.getColor() == Color.BLACK) {
         	 player.setPoints(points + player.getBet());
        	 return "Win";
          }else {
         	 player.setPoints(points - player.getBet());
        	 return "Lose";
          }
      }
      
      public String toString() {
          return "BLACK";
      }
   },
   
   ZEROS
   {
      @Override
      public String applyWinLoss(Player player, Slot winSlot)
      {
    	  int points = player.getPoints();
          if(	(winSlot.getColor() == Color.GREEN0) ||
        		(winSlot.getColor() == Color.GREEN00) ) {
         	 player.setPoints(points + (player.getBet() *18));
        	 return "Win";
          }else {
         	 player.setPoints(points - player.getBet());
        	 return "Lose";
          }
      }
      
      public String toString() {
          return "ZEROS";
      }
   };
 
   /**
    * This method is to be overridden for each bet type<br>
    * see assignment specification for betting odds and how win/loss is applied
    * 
    * @param player - the player to apply the win/loss points balance adjustment
    * @param winSlot - the winning slot the ball landed on
    */
   public abstract String applyWinLoss(Player player, Slot winSlot);
}