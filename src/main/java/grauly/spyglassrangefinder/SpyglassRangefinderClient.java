package grauly.spyglassrangefinder;

import grauly.spyglassrangefinder.rendering.RangefinderRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class SpyglassRangefinderClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(RangefinderRenderer::onRender);
    }
}
