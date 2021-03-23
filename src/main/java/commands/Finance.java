package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Finance extends ListenerAdapter {

    public Roulette temp;
    public Finance(Roulette a){temp =a;}

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String message = event.getMessage().getContentRaw();
        if(message.contains("!finance")){
            String UserName = event.getAuthor().getName();
            if(Roulette.userBank.containsKey(UserName)){
                if( Roulette.userBank.get(UserName) <1000){
                    Roulette.userBank.put(UserName,(double)1000);
                    event.getChannel().sendMessage("Successfully transferred. Your current balance is now 1000 points. Happy gambling.").queue();

                }else{ event.getChannel().sendMessage("Your balance is " + Roulette.userBank.get(UserName)+" points. Why are you asking for a loan?").queue();}

            if(!Roulette.userBank.containsKey(UserName)){
                Roulette.userBank.put(UserName,(double)1000);
                event.getChannel().sendMessage("Successfully registered in the Roulette database with 1000 points. Welcome aboard, player.").queue();
            }
            }
        }
    }
}
