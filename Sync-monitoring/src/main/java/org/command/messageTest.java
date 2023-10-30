package org.command;

import org.command.monitoring;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

/**
 1. @description:
 2. @author: Dawn
 3. @time: 2023/5/24
 */
public class messageTest {

    private static final String TOKEN = "";

        public static void main(String[] args) throws Exception {
            JDA jda = JDABuilder.createDefault(TOKEN).build();
            jda.addEventListener(new monitoring());
            jda.awaitReady();
        }

}

