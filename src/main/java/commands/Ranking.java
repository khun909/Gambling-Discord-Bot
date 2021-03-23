package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ranking extends Command {
    public Roulette temp;
    public Ranking(Roulette a){
    this.name ="ranking";
    temp = a;
    }
    @Override
    protected void execute(CommandEvent e){
        EmbedBuilder eb =new EmbedBuilder();
        eb.setColor(Color.black);
        Map<String, Double> topFive = Roulette.userBank.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        String key;

        Iterator it = topFive.entrySet().iterator();
        while(it.hasNext()) {

            Map.Entry me = (Map.Entry)it.next();
            eb.addField((String) me.getKey(), String.valueOf(Roulette.userBank.get(me.getKey())), false);


        }
        e.getChannel().sendMessage(eb.build()).queue();
    }
}
