package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Donate extends ListenerAdapter {
    public Roulette temp;
    public Donate(Roulette a){
        temp =a;
    }
    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if (messageSent.contains("!donate")) {
            String UserName = event.getAuthor().getName();
            String UserName2;
            double points;
            String[] arrOfStr = messageSent.split(" ");
            try {
                if (arrOfStr.length < 3) {throw new IllegalArgumentException("There was an error in your command. The correct syntax is !donate [User's Name] [points].");}
                    UserName2 = arrOfStr[1];
                    if(!isDouble(arrOfStr[2])){throw new IllegalArgumentException("The number of points you have entered is not valid. Please try again."); }else{points = Double.parseDouble(arrOfStr[2]);}
                    if(!Roulette.userBank.containsKey(UserName)){throw new IllegalArgumentException("You are currently not registered. Please type !register to do so.");}
                    if(UserName.equals(UserName2)){throw new IllegalArgumentException("You cannot donate to yourself!");}
                    if (!Roulette.userBank.containsKey(UserName2)) {throw new IllegalArgumentException("Either that person is not currently registered or you have entered their name wrong. Please try again."); }
                    if(Roulette.userBank.get(UserName)<points){throw new IllegalArgumentException("You currently only have "+ Roulette.userBank.get(UserName)+" points. Please enter a lower amount.");}
                    double newPoints = Roulette.userBank.get(UserName) - points;
                    Roulette.userBank.put(UserName,newPoints);
                    newPoints = Roulette.userBank.get(UserName2) + points;
                    Roulette.userBank.put(UserName2, newPoints);
                    event.getChannel().sendMessage("Successfully transferred points. Your remaining balance is " + Roulette.userBank.get(UserName)+ " points.").queue();


            }catch(IllegalArgumentException e){
                event.getChannel().sendMessage(e.getMessage()).queue();
            }
        }
    }

}
