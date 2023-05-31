package command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Calendar;

/**
 * 1. @description:
 * 2. @author: Dawn
 * 3. @time: 2023/5/29
 */
public class monitoring extends ListenerAdapter {
    blockChain block = new blockChain();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()){
            return;
        }
        MessageChannel channel = event.getChannel();

        Calendar now = Calendar.getInstance();
        int date = now.get(Calendar.HOUR_OF_DAY);

        for (int i = 0; i < 100000; i++) {
            if (block.getBlocks() == true){
                switch(date){
                    case 0:
                        channel.sendMessage("Currently synchronized for 8 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 16:
                        channel.sendMessage("Currently synchronized for 0 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 17:
                        channel.sendMessage("Currently synchronized for 1 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 18:
                        channel.sendMessage("Currently synchronized for 2 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 19:
                        channel.sendMessage("Currently synchronized for 3 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 20:
                        channel.sendMessage("Currently synchronized for 4 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 21:
                        channel.sendMessage("Currently synchronized for 5 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 22:
                        channel.sendMessage("Currently synchronized for 6 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 23:
                        channel.sendMessage("Currently synchronized for 7 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 1:
                        channel.sendMessage("Currently synchronized for 9 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 2:
                        channel.sendMessage("Currently synchronized for 10 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 3:
                        channel.sendMessage("Currently synchronized for 11 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 4:
                        channel.sendMessage("Currently synchronized for 12 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 5:
                        channel.sendMessage("Currently synchronized for 13 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 6:
                        channel.sendMessage("Currently synchronized for 14 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 7:
                        channel.sendMessage("Currently synchronized for 15 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 8:
                        channel.sendMessage("Currently synchronized for 16 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 9:
                        channel.sendMessage("Currently synchronized for 17 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 10:
                        channel.sendMessage("Currently synchronized for 18 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 11:
                        channel.sendMessage("Currently synchronized for 19 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    case 12:
                        channel.sendMessage("Currently synchronized for 20 hours").queue();
                        channel.sendMessage("The current synchronized block height is 【" + block.getBlock() + "】").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                        System.out.println("The current synchronized block height is 【" + block.getBlock() + "】");
                        break;
                    default:
                        System.out.println("default");
                }
            }else {
                if (date >= 17 && date <= 23 && date >= 0 && date <=11) {
                    channel.sendMessage("Synchronization exception, please check the synchronization service").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
                } else {
                    channel.sendMessage("Current synchronization completed").queue();
                }
            }
            try {
                Thread.sleep(3600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
