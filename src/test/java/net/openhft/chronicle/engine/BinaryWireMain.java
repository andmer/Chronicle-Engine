/*
 *     Copyright (C) 2015  higherfrequencytrading.com
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.openhft.chronicle.engine;

import net.openhft.chronicle.engine.server.ServerEndpoint;
import net.openhft.chronicle.engine.tree.VanillaAssetTree;
import net.openhft.chronicle.wire.WireType;
import net.openhft.chronicle.wire.YamlLogging;
import org.jetbrains.annotations.NotNull;

/**
 * Created by andre on 01/05/2015.
 */
public class BinaryWireMain {

    public static final net.openhft.chronicle.wire.WireType WIRE_TYPE = WireType.BINARY;

    public static void main(@NotNull String[] args) {
        int port = 8088;

        VanillaAssetTree assetTree = new VanillaAssetTree().forTesting(false, t -> t.printStackTrace());
        final ServerEndpoint serverEndpoint = new ServerEndpoint("*:" + port, assetTree);

        if (args.length == 1 && args[0].compareTo("-debug") == 0) {
            System.out.println("Enabling message logging");
            YamlLogging.showServerReads(true);
            YamlLogging.showServerWrites(true);
        }
        System.out.println("Server port seems to be " + port);
    }
}
