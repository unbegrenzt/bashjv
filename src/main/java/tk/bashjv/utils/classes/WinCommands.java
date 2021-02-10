/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.utils.classes;

import tk.bashjv.utils.enums.BashCommand;
import tk.bashjv.utils.intefaces.ConsoleCommands;

/**
 * The type Win commands.
 * Returns the console commands string for execute on
 * Windows based systems
 */
public class WinCommands implements ConsoleCommands {
    @Override
    public String Command(BashCommand bashCommand) {
        return switch (bashCommand) {
            case VALID_PSCORE -> "pwsh -command \"$PSVersionTable.PSEdition\"";
            case HELM_NAMESPACES -> "pwsh -command \"helm get all namespaces\"";
            case HYPER_STATE -> "pwsh -command \"Get-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V\"";
            case WSL_STATE -> "pwsh -command \"Get-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux\"";
        };
    }
}
