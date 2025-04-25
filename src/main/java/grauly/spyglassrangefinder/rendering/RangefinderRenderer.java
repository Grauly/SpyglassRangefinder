package grauly.spyglassrangefinder.rendering;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.hit.HitResult;

public class RangefinderRenderer {

    private static MinecraftClient mc = MinecraftClient.getInstance();
    public static void onRender(DrawContext context, RenderTickCounter renderTickCounter) {
        if(mc.player.isUsingSpyglass()) {
            var result = mc.player.raycast(1024, renderTickCounter.getTickProgress(false),false);
            if(!result.getType().equals(HitResult.Type.MISS)) {
                var width = mc.getWindow().getScaledWidth();
                var height = mc.getWindow().getScaledHeight();
                var distance = Math.sqrt(result.squaredDistanceTo(mc.player));
                var showSting = String.format("%.2f",distance);
                context.drawCenteredTextWithShadow(mc.textRenderer,showSting,width/2 + mc.textRenderer.getWidth(showSting)/2 + 10,height/2 - mc.textRenderer.fontHeight/2,-1);
            }
        }
    }
}
