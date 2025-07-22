package cn.nukkit.settings;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class ServerSettings extends OkaeriConfig {

    @Comment("General server settings")
    private GeneralSettings general = new GeneralSettings();

    @Comment("Server network settings")
    private NetworkSettings network = new NetworkSettings();

    @Comment("Server performance settings")
    private PerformanceSettings performance = new PerformanceSettings();

    @Comment("World-related settings")
    private WorldSettings world = new WorldSettings();

    @Comment("Player-related settings")
    private PlayerSettings player = new PlayerSettings();
}
