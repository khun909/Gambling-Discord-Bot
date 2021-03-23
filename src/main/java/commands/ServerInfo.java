package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ServerInfo extends Command {

    public ServerInfo(){
        this.name = "serverinfo";
        this.aliases = new String[]{"server"};

    }
   @Override
    protected void execute(CommandEvent e){

       EmbedBuilder eb = new EmbedBuilder();
       eb.setColor(Color.BLACK);
       eb.setAuthor(e.getGuild().getName());
       eb.setThumbnail("https://i.ytimg.com/vi/gt52SaUnmNo/maxresdefault.jpg");
       eb.addField("Server Owner: ", e.getGuild().getOwner().getEffectiveName(), true);
       eb.addField("Server is being boosted by: ", String.valueOf(e.getGuild().getBoostCount()),true);
       eb.addField("Member Count: ", Integer.toString(e.getGuild().getMembers().size()),true);

       e.getChannel().sendMessage(eb.build()).queue();

    }

}
