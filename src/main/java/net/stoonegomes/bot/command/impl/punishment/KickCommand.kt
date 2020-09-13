package net.stoonegomes.bot.command.impl.punishment

import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.stoonegomes.bot.command.Command
import net.stoonegomes.bot.command.queueAndDelete
import org.bukkit.Bukkit

class KickCommand : Command("kick") {

    override fun execute(event: GuildMessageReceivedEvent, channel: TextChannel, args: Array<String>) {
        val author = event.author.name

        if (args.isEmpty()) {
            channel.sendMessage("Do you need to specify a player.").queueAndDelete(3)
            return
        }

        val target = Bukkit.getPlayer(args[0])
        if (target == null) {
            channel.sendMessage("The specified player is not online at the server.").queueAndDelete(3)
            return
        }

        target.kickPlayer("§cKicked by §f$author§c from discord.")
    }

}