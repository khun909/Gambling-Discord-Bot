package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Balance extends ListenerAdapter{
    public Roulette temp;
    public Balance(Roulette a){
        temp = a;
    }
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.contains("!balance")){
            String UserName = event.getAuthor().getName();
            if(!Roulette.userBank.containsKey(UserName)){
                event.getChannel().sendMessage("You are currently not registered in the Roulette database. Please register with !register").queue();
            }else{
                event.getChannel().sendMessage("Your current balance is "+ Roulette.userBank.get(UserName)+ " points.").queue();
            }
        }

    }

}
