/*
 *  Copyright (C) 2011 Kilian Gaertner
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package blueprint;

import java.io.File;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

/**
 *
 * @author Kilian Gaertner
 */
public class CommandListener extends PlayerListener {

    @Override
    public void onPlayerCommandPreprocess (PlayerChatEvent event) {
        String[] split = event.getMessage().split(" ");
        Player player = event.getPlayer();
        if (split[0].startsWith("/blueprint") || split[0].startsWith("/bp")) {
            if (split[1].startsWith("load")) {
                File file = null;
                if (split[2].endsWith(".blueprint"))
                    file = new File ("plugins/Blueprint/".concat(split[2]));
                else
                    file = new File ("plugins/Blueprint/".concat(split[2]).concat(".blueprint"));
                if (file.exists()) {
                    new Blueprint(player,file);
                }
                else
                    player.sendMessage("The blueprint "+split[2]+" does not exist");
            }
            else if(split[1].startsWith("cancel")) {
                Blueprint.cancelBlueprint(player);
                player.sendMessage("The blueprint was sucessfully canceled!");
            }
            else if(split[1].startsWith("build")) {
                Blueprint.getBlueprint(player).buildBlueprint();
                player.sendMessage("The blueprint was sucessfully transformed into the building!");
            }
            else if(split[1].startsWith("help")) {
                player.sendMessage("Possible commands of the Blueprint Plugin");
                player.sendMessage("load FILENAME");
                player.sendMessage("cancel");
                player.sendMessage("build");
            }
        }
    }
}
