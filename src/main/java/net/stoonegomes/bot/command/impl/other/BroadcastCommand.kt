package net.stoonegomes.bot.command.impl.other

import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.stoonegomes.bot.command.Command
import org.bukkit.Bukkit

class BroadcastCommand : Command("broadcast") {

    override fun execute(event: GuildMessageReceivedEvent, channel: TextChannel, args: Array<String>) {
        channel.sendMessage("Sended an test broadcast.")
        Bukkit.broadcastMessage("§dThis is an test broadcast by Discord.")
    }

}