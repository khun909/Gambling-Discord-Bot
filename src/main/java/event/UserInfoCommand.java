package event;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class UserInfoCommand extends ListenerAdapter{
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
      //  EmbedBuilder eb = new EmbedBuilder();
      /*  eb.setTitle("Embed Title");
        eb.setColor(Color.BLACK);
        eb.addField("Name","Lean", true);
        eb.setImage("https://i.ytimg.com/vi/gt52SaUnmNo/maxresdefault.jpg");
        e.getChannel().sendMessage(eb.build()).queue(); */
        String[] message = e.getMessage().getContentRaw().split("");
        if(message.length == 1 && message[0].equalsIgnoreCase("$user")){
            e.getChannel().sendMessage("To display a user's info, type $user [name]").queue();

        }else if(message.length==2 && message[0].equalsIgnoreCase("$user")){
            String userName = message[1];
            User user = e.getGuild().getMembersByName(userName, true).get(0).getUser();
            EmbedBuilder avatarEmbed = new EmbedBuilder();

            avatarEmbed.setTitle(userName +"'s Info:" );
            avatarEmbed.setColor(Color.black);
            avatarEmbed.addField("Name", user.getName(), true);
            e.getChannel().sendMessage(avatarEmbed.build()).queue();

        }

    }

}
