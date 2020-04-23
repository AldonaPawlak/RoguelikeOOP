
public class Mentor extends Character{

    public Mentor(String name, String symbol, int x, int y) {
        super(name, symbol, x, y);
    }

    public void tellKnowledgeAmount(String playerName, int knowledgeAmount){
        System.out.println("Hi " + playerName + " you should have at least " 
                        + knowledgeAmount + " knowledge.");
    }

    public void makeConsultation(Statistics playerStatistics, Statistics mentorStatistics){
        System.out.println("Ok, so you feel frightened... I know... Programming is not easy.\n"
                        + "I'll give you part of my happiness because I can't look at you when you're sad!");
        int differ = mentorStatistics.getHappiness() - playerStatistics.getHappiness();
        mentorStatistics.setHappiness(mentorStatistics.getHappiness() - differ);
        playerStatistics.setHappiness(100);
    }

    public boolean qualityGateCheck(int playerknowledge, int neededKnowledge){
        System.out.println("Ok! Please show me your knowledge...");
        if (playerknowledge > neededKnowledge){
            System.out.println("Excelent! You are really good!");
            return true;
        }
        else if (playerknowledge == neededKnowledge){
            System.out.println("It's high enough but try harder next time!");
            return true;
        }
        else{
            System.out.println("You did not study well... I told you that you must try harder but you didn't listen!");
            return false;
        }
    }
}