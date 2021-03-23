import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import commands.*;
import event.UserInfoCommand;
import event.greet;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;


import javax.security.auth.login.LoginException;


public class Bot {
    public static void main(String[] args)throws LoginException{
        JDA jda = JDABuilder.createDefault("").build(); //Paste your Discord Bot token here
        jda.getPresence().setActivity(Activity.playing("Life"));
        //build the hash map class
        Roulette mainRoulette = new Roulette();
        //Instantiate the mongoClient
        jda.addEventListener(new greet(mainRoulette));
        jda.addEventListener(new Finance(mainRoulette));
        jda.addEventListener(new Balance(mainRoulette));
        jda.addEventListener(new Register(mainRoulette));
        jda.addEventListener(new Donate(mainRoulette));
        jda.addEventListener(new UserInfoCommand());
        //Client builder
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setPrefix("!");
        builder.setHelpWord("help");
        builder.setOwnerId(""); //paste your owner ID here
        builder.addCommand(new ServerInfo());
        builder.addCommand(new UserInfo());
        builder.addCommand(new Ranking(mainRoulette));
        CommandClient client = builder.build();
        jda.addEventListener(client);
        //client builder above




    }

}
