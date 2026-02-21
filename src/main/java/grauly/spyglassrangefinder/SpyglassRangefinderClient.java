package grauly.spyglassrangefinder;

import com.mojang.blaze3d.platform.InputConstants;
import grauly.spyglassrangefinder.rendering.RangefinderRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class SpyglassRangefinderClient implements ClientModInitializer {

    public static final Identifier RANGEFINDER_LAYER = Identifier.fromNamespaceAndPath(SpyglassRangefinder.MODID, "rangefinder");
    public static final KeyMapping.Category SPYGLASS_RANGEFINDER_CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath(SpyglassRangefinder.MODID, "main"));
    public static final KeyMapping TP_KEY_BINDS = KeyBindingHelper.registerKeyBinding(new KeyMapping(
            "key." + SpyglassRangefinder.MODID + ".teleport",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_GRAVE_ACCENT,
            SPYGLASS_RANGEFINDER_CATEGORY
    ));

    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementAfter(VanillaHudElements.MISC_OVERLAYS, RANGEFINDER_LAYER, RangefinderRenderer::onRender);
        ClientTickEvents.END_CLIENT_TICK.register(TeleportTrigger::tick);
    }
}
