/**
*The card class represents a playing card
* @author Yuheng Cheng
* @version 1.0
*/
public class Card extends AbstractCard{
    /** Create a card with specified suit and rank
  *
  * @param rank is the rank of the card 
  * @param suit is the suit of the card 
  */
    public Card(RANK rank, SUIT suit){
        super(rank,suit);
    }
    /** Create a card with specified suit and rank
     *
    * @param card is the string representation of the cards rank and suit
    */
    public Card(String card){
        super(checkRank(card),strSuit(card));
       
    }
    /**
    *interperets the suit of the string representation 
    * @param card is the string representation of the cards rank and suit
    * @return the suit
     */
    private static SUIT strSuit(String card){
        card = card.toLowerCase();
        SUIT suit;
         if(card.length() == 2){
             switch(card.charAt(1)){
                case 's':
                suit = SUIT.SPADES;
                break;
                case 'd':
                suit = SUIT.DIAMONDS;
                break;
                case 'c':
                suit = SUIT.CLUBS;
                break;
                case 'h':
                suit = SUIT.HEARTS;
                break;
                default:
                suit = SUIT.NONE;
            }
            }else if(card.length() == 3){
                switch(card.charAt(1)){
                case 's':
                suit = SUIT.SPADES;
                break;
                case 'd':
                suit = SUIT.DIAMONDS;
                break;
                case 'c':
                suit = SUIT.CLUBS;
                break;
                case 'h':
                suit = SUIT.HEARTS;
                break;
                default:
                suit = SUIT.NONE;
            }
            }else{
                suit = SUIT.NONE;
            }

           
     return suit;
    }
    /**
    *interperets the rank of the string representation 
    * @param card is the string representation of the cards rank and suit
    * @return the rank
     */
    private static RANK strRank(String card){
        RANK rank;
        if(card.length() == 2){
            switch(card.charAt(0)){
                case '2':
                rank = RANK.TWO;
                break;

                case '3':
                rank = RANK.THREE;
                break;

                case '4':
                rank = RANK.FOUR;
                break;

                case '5':
                rank = RANK.FIVE;
                break;

                case '6':
                rank = RANK.SIX;
                break;

                case '7':
                rank = RANK.SEVEN;
                break;

                case '8':
                rank = RANK.EIGHT;
                break;

                case '9':
                rank = RANK.NINE;
                break;
                
                case 'j':
                rank = RANK.JACK;
                break;
                
                case 'q':
                rank = RANK.QUEEN;
                break;

                case 'k':
                rank = RANK.KING;
                break;

                case 'a':
                rank = RANK.ACE;
                break;

                default:
                rank = RANK.JOKER;

            }
        } else if(card.length() == 3){
            char letter1 = card.charAt(0);
            char letter2 = card.charAt(1);
            if(""+letter1+letter2== "10"){
                rank = RANK.TEN;
            }else{
                rank = RANK.JOKER;
            }
        }else{
                rank = RANK.JOKER;
                
        }
        return rank;
    }
    /**
    *checks if the card should be changed to a joker card
    *@param card is the string representation of the card's rank and suit
    *@return turetirns the card's rank 
     */
    private static RANK checkRank(String card){
        card = card.toLowerCase();
        if(strRank(card) == RANK.JOKER ||strSuit(card)== SUIT.NONE){
            return RANK.JOKER;
        }else{
            return strRank(card);
        }

    }
    /**
    *checks if the current card is greater or lesser or equal to the input
    *@param card is a different card object
    *@return -1 if less, 0 if the same, and 1 if greater than 
     */
    @Override
    public int compareTo(AbstractCard card){
        if (this.getRank()== RANK.JOKER && card.getRank() != RANK.JOKER){
            return 1;
        }else if(this.getRank()!= RANK.JOKER && card.getRank() == RANK.JOKER){
            return -1;
        }else if(this.getRank() == RANK.KING && card.getRank() == RANK.QUEEN){
            return -1;
            
        }else if(this.getRank() == RANK.QUEEN && card.getRank() == RANK.KING){
            return 1;
            
        }else if(this.getRank() != RANK.JOKER){
            return this.getRank().compareTo(card.getRank());
        }else{
            return 0;
        }
    }
    /**
    *returns the rank and suit in a readable format
    *@return a readable string of the rank and suit
     */
    @Override
    public String toString(){
        String returnString = "";
        if(this.getRank() == RANK.JOKER){
            return RANK.JOKER.toString();

        }else{
        switch(this.getRank()){
                case TWO:
                returnString += "2";
                break;

                case THREE:
                returnString += "3";
                break;

                case FOUR:
                returnString += "4";
                break;

                case FIVE:
                returnString += "5";
                break;

                case SIX:
                returnString += "6";
                break;

                case SEVEN:
                returnString += "7";
                break;

                case EIGHT:
                returnString += "8";
                break;

                case NINE:
                returnString += "9";
                break;

                case TEN:
                returnString += "10";
                break;
                
                case JACK:
                returnString += "J";
                break;
                
                case QUEEN:
                returnString += "Q";
                break;

                case KING:
                returnString += "K";
                break;

                case ACE:
                returnString += "A";
                break;

                
            }
            switch(this.getSuit()){
                case SPADES:
                returnString += "S";
                break;
                case DIAMONDS:
                returnString += "D";
                break;
                case CLUBS:
                 returnString += "C";
                break;
                case HEARTS:
                returnString += "H";
                break;
            }
            return returnString;
        }
    }
}