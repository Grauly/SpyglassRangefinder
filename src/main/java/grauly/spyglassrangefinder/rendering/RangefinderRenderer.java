package grauly.spyglassrangefinder.rendering;


import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.phys.HitResult;

public class RangefinderRenderer {

    private static Minecraft mc = Minecraft.getInstance();
    public static void onRender(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        if(mc.player.isScoping()) {
            HitResult result = mc.player.pick(1024, deltaTracker.getGameTimeDeltaPartialTick(false),false);
            if(!result.getType().equals(HitResult.Type.MISS)) {
                var width = mc.getWindow().getGuiScaledWidth();
                var height = mc.getWindow().getGuiScaledHeight();
                var distance = result.distanceTo(mc.player);
                var showSting = String.format("%.2f",distance);
                guiGraphics.drawCenteredString(
                        mc.font,
                        showSting,
                        width / 2 + mc.font.width(showSting) / 2 + 10,
                        height / 2 - mc.font.lineHeight / 2 -1,
                        -1
                );
            }
        }
    }
}
