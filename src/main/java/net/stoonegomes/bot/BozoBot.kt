package net.stoonegomes.bot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.stoonegomes.bot.command.impl.other.BroadcastCommand
import net.stoonegomes.bot.command.impl.other.WhitelistCommand
import net.stoonegomes.bot.command.impl.punishment.KickCommand
import net.stoonegomes.bot.listener.PlayerJoinListener
import org.bukkit.plugin.java.JavaPlugin

class BozoBot : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: BozoBot
        lateinit var BOT: JDA

        const val GUILD_ID = "743263358832083024"
    }

    override fun onEnable() {
        saveDefaultConfig()
        INSTANCE = this

        val token = config.getString("token") ?: return
        if (token.isNotEmpty()) {
            server.pluginManager.registerEvents(PlayerJoinListener(), this)

            BOT = JDABuilder.createDefault(config.getString("token"))
                    .addEventListeners(
                            BroadcastCommand(),
                            WhitelistCommand(),
                            KickCommand()
                    )
                    .build()
            BOT.awaitReady()
        } else {
            server.pluginManager.disablePlugin(this)
        }
    }

    override fun onDisable() {
        BOT.shutdown()
    }

}
