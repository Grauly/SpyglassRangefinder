package grauly.spyglassrangefinder;


import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.HitResult;

public class TeleportTrigger {
    private static int cooldown = 0;
    public static void tick(Minecraft minecraftClient) {
        cooldown -= 1;
        if (cooldown > 0) return;
        if (!SpyglassRangefinderClient.TP_KEY_BINDS.isDown()) return;
        if (!minecraftClient.player.isScoping()) return;
        var result = minecraftClient.player.pick(1024, minecraftClient.getDeltaTracker().getGameTimeDeltaPartialTick(false),false);
        if (result.getType() != HitResult.Type.BLOCK) return;
        minecraftClient.getConnection().sendCommand("tp " + result.getLocation().x + " " + result.getLocation().y + " " + result.getLocation().z);
        cooldown = 10;
    }
}
