package net.stoonegomes.bot.command.impl.other

import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.stoonegomes.bot.command.Command
import net.stoonegomes.bot.command.queueAndDelete
import org.bukkit.Bukkit

class WhitelistCommand : Command("whitelist") {

    override fun execute(event: GuildMessageReceivedEvent, channel: TextChannel, args: Array<String>) {
        Bukkit.setWhitelist(!Bukkit.hasWhitelist())
        channel.sendMessage("You ${if (Bukkit.hasWhitelist()) "disabled" else "enabled"} the server whitelist successfully.").queueAndDelete(3)
    }

}