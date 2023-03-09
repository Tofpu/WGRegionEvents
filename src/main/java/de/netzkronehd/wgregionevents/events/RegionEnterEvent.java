package de.netzkronehd.wgregionevents.events;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import de.netzkronehd.wgregionevents.api.SilentlyCancellable;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

/**
 * Thrown when a {@link Player} is about to enter a {@link ProtectedRegion}
 */
public class RegionEnterEvent extends RegionEvent implements Cancellable, SilentlyCancellable {

    private boolean cancelled;
    private boolean silentlyCancelled = false;

    public RegionEnterEvent(ProtectedRegion region, Player player, MovementWay movement, PlayerEvent parent, Location from, Location to) {
        super(region, player, movement, parent, from, to);
    }


    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        if(getMovementWay().isCancellable()) {
            cancelled = b;
        } else throw new IllegalStateException("Movement '"+getMovementWay().getName()+"' is not cancelable.");
    }

    @Override
    public boolean isSilentlyCancelled() {
        return silentlyCancelled;
    }

    @Override
    public void setSilentlyCancelled(final boolean b) {
        this.silentlyCancelled = b;
    }
}
