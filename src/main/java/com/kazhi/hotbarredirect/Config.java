package com.kazhi.hotbarredirect;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = HotbarRedirect.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<String> LOCATION = BUILDER.comment("The location to which Hotbar.nbt will be redirected").define("location", "hotbar.nbt");
    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static String location;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        location = LOCATION.get();
    }
}
