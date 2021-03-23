package event;
import commands.Roulette;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class greet extends ListenerAdapter {
    public Roulette temp;
    public greet(Roulette a){
        temp = a;
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.contains("!roulette")){
            String UserName = event.getAuthor().getName();
            String[] arrOfStr = messageSent.split(" ",4);
            double points =Double.parseDouble(arrOfStr[1]);
            double tempPoints;
            try {
                if (Roulette.userBank.containsKey(UserName)) {
                    tempPoints = Roulette.userBank.get(UserName);
                    if(Roulette.userBank.get(UserName)<points){throw new IllegalArgumentException();}
                    Roulette.randomSet(UserName, points);

                } else {
                    Roulette.userBank.put(UserName, (double) 1000);
                    event.getChannel().sendMessage("Successfully registered in the Roulette database with 1000 points. Welcome aboard, player.").queue();
                    tempPoints = Roulette.userBank.get(UserName);
                    if(Roulette.userBank.get(UserName)<points){throw new IllegalArgumentException();}
                    Roulette.randomSet(UserName, points);
                }
                if (tempPoints > Roulette.userBank.get(UserName)) {
                    event.getChannel().sendMessage("Sorry, you lost the roll. Your current balance is at " + Roulette.userBank.get(UserName) + " points.").queue();

                } else {
                    event.getChannel().sendMessage("You won the roll this time! Your current balance is at " + Roulette.userBank.get(UserName) + " points. Want to try again?").queue();
                }
            } catch (IllegalArgumentException e) {

                event.getChannel().sendMessage("Please enter a valid amount of points. Your current budget is " + Roulette.userBank.get(UserName) + " points.").queue();
            }
        }
        }
    }



