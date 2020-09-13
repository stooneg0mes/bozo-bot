package net.stoonegomes.bot.listener

import net.stoonegomes.bot.BozoBot
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {

    private val jda = BozoBot.BOT
    private val guildId = BozoBot.GUILD_ID

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player;
        val guild = jda.getGuildById(guildId) ?: return

        val textChannel = guild.getTextChannelById("743263358832083028") ?: return
        textChannel.sendMessage("The player **${player.name}** joined in the minecraft server.")
    }

}