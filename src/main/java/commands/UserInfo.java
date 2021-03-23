package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;


import java.awt.*;
import java.time.format.DateTimeFormatter;

public class UserInfo extends Command {

    public UserInfo(){
        super.name = "userinfo";
        super.help = "Lists information about a user.";
        super.category = new Category("Members");
        super.arguments = "[name]";
    }
    @Override
    protected void execute(CommandEvent event){
        if (event.getArgs().isEmpty()){
            event.reply("No name was provided. Use: !userinfo [name]");

        }else{
            Member name;
            DateTimeFormatter fmt =DateTimeFormatter.ofPattern("MM-dd-yyyy");
            try {
             name =event.getMessage().getMentionedMembers().get(0);
                EmbedBuilder eb = new EmbedBuilder()
                        .setColor(Color.black)
                        .setThumbnail("https://i.ytimg.com/vi/gt52SaUnmNo/maxresdefault.jpg")
                        .setAuthor("Information on " + name.getUser().getName(),"http://www.google.com",name.getUser().getAvatarUrl())
                        .setDescription(name.getUser().getName()+" joined on "+ name.getTimeJoined().format(fmt))
                        .addField("They created their account on ", String.format(String.valueOf(name.getTimeCreated()), fmt),true);


                event.reply(eb.build());
            }catch (IndexOutOfBoundsException ex){
                System.out.println("Exception occured");
                event.reply("You have to mention the user following the userinfo command!");
            }

        }
    }
}
