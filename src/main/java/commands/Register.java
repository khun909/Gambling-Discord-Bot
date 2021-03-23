package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Register extends ListenerAdapter {
    public Roulette temp;
    public Register(Roulette a){temp = a;}

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent =event.getMessage().getContentRaw();
        if(messageSent.contains("!register")){
            String UserName = event.getAuthor().getName();
            if(Roulette.userBank.containsKey(UserName)){
                event.getChannel().sendMessage("You are already registered!").queue();
            }else{Roulette.userBank.put(UserName,(double)1000);
            event.getChannel().sendMessage("Successfully registered with 1000 points! Welcome aboard, "+ UserName+ ".").queue();}
        }
    }


}
