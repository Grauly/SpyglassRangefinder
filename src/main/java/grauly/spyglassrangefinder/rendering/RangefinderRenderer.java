package grauly.spyglassrangefinder.rendering;


import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.HitResult;

public class RangefinderRenderer {

    private static Minecraft mc = Minecraft.getInstance();
    public static void onRender(GuiGraphicsExtractor guiGraphics, DeltaTracker deltaTracker) {
        if(mc.player.isScoping()) {
            HitResult result = mc.player.pick(1024, deltaTracker.getGameTimeDeltaPartialTick(false),false);
            if(!result.getType().equals(HitResult.Type.MISS)) {
                var width = mc.getWindow().getGuiScaledWidth();
                var height = mc.getWindow().getGuiScaledHeight();
                var distance = Math.sqrt(result.distanceTo(mc.player));
                var showSting = String.format("%.2f",distance);
                guiGraphics.textWithBackdrop(
                        mc.font,
                        Component.literal(showSting),
                        width / 2 + mc.font.width(showSting) / 2 + 10,
                        height / 2 - mc.font.lineHeight / 2 - 1,
                        mc.font.width(showSting),
                        -1
                );
            }
        }
    }
}
