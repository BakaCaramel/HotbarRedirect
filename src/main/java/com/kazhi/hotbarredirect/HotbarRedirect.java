package com.kazhi.hotbarredirect;

import com.kazhi.hotbarredirect.mixin.MixinHotbarInvoker;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod("hotbarredirect")
public class HotbarRedirect {
    public static final String MODID = "hotbarredirect";

    public HotbarRedirect() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerCommand(RegisterClientCommandsEvent event){
        event.getDispatcher().register(Commands.literal("reloadhotbar").executes((context -> {
            ((MixinHotbarInvoker) Minecraft.getInstance().getHotbarManager()).invokeLoad();
            context.getSource().sendSystemMessage(Component.literal("ReloadComplete!"));
            return 1;
        })));
    }
}
