package grauly.spyglassrangefinder;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.HitResult;

public class TeleportTrigger {
    private static int cooldown = 0;
    public static void tick(MinecraftClient minecraftClient) {
        cooldown -= 1;
        if (cooldown > 0) return;
        if (!SpyglassRangefinderClient.TP_KEY_BINDS.wasPressed()) return;
        if (!minecraftClient.player.isUsingSpyglass()) return;
        var result = minecraftClient.player.raycast(1024, minecraftClient.getRenderTickCounter().getTickProgress(false),false);
        if (result.getType() != HitResult.Type.BLOCK) return;
        minecraftClient.getNetworkHandler().sendChatCommand("tp " + result.getPos().x + " " + result.getPos().y + " " + result.getPos().z);
        cooldown = 10;
    }
}
