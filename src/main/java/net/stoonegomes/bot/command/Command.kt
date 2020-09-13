package net.stoonegomes.bot.command

import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.restaction.MessageAction
import java.util.concurrent.TimeUnit

abstract class Command(private val commandName: String) : ListenerAdapter() {

    abstract fun execute(event: GuildMessageReceivedEvent, channel: TextChannel, args: Array<String>)

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        val message = event.message.contentRaw;

        if (message.toLowerCase().startsWith("b!${commandName.toLowerCase()}")) {
            val args = message.split(" ")
            val newArgs = args.toTypedArray().copyOfRange(1, args.size)

            execute(event, event.channel, newArgs)
        }
    }

}

fun MessageAction.queueAndDelete(seconds: Long) {
    this.queue { it.delete().queueAfter(seconds, TimeUnit.SECONDS) }
}