import net.ranktw.DiscordWebHooks.DiscordEmbed;
import net.ranktw.DiscordWebHooks.DiscordMessage;
import net.ranktw.DiscordWebHooks.DiscordWebhook;
import net.ranktw.DiscordWebHooks.embed.AuthorEmbed;
import net.ranktw.DiscordWebHooks.embed.FooterEmbed;
import net.ranktw.DiscordWebHooks.embed.ThumbnailEmbed;

import java.awt.*;
import java.util.Scanner;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class main {
    public static void main(String[] args) {
        // get webhook url
        Scanner get = new Scanner(System.in);
        System.out.println("Enter the webhook url");
        String webhook = get.nextLine();

        // Actually do what this was main to do
        System.out.println("Fetching HWID...");
        String hwid = HWID.getHWID();

        // Copy the HWID in case they don't do shit with the webhook
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(hwid);
        clipboard.setContents(strSel, null);

        //print out the hwid for said person to copy
        System.out.println("Your hwid is " + hwid);

        // Send the hwid in discord webhook
        String WEBHOOK = webhook;
        DiscordWebhook discord = new DiscordWebhook(webhook);

        DiscordEmbed embed = new DiscordEmbed.Builder()
                .withColor(Color.yellow)
                .withAuthor(new AuthorEmbed("Made by highkey smart#0001","https://github.com/Mister-Three/getHWID","https://media.discordapp.net/attachments/843661862599524362/855551655772684288/Group_124.png"))
                .withTitle("HWID is...")
                .withTitleUrl("https://github.com/Mister-Three/getHWID")
                .withDescription(hwid)
                .withThumbnail(new ThumbnailEmbed("https://media.discordapp.net/attachments/843661862599524362/855551655772684288/Group_124.png", 10, 100))
                .withFooter(new FooterEmbed("highkey smart#0001", "https://media.discordapp.net/attachments/843661862599524362/855551655772684288/Group_124.png"))
                .build();
        DiscordMessage dm = new DiscordMessage.Builder()
                .withUsername("CLOUD")
                .withContent("``Cool shit is happening right now``")
                .withAvatarURL("https://media.discordapp.net/attachments/843661862599524362/855551655772684288/Group_124.png")
                .withTTS(false)
                .build();

        //Add Embeds to the DiscordMessage
        dm.addEmbeds(embed);

        // Finally, send the fucking message.
        String s = dm.toJson(true);
        discord.sendMessage(dm);

    }

}
