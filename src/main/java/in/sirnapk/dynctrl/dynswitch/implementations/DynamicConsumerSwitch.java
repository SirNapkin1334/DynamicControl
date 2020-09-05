/*
 * Copyright (C) 2020  SirNapkin1334
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library.  If not, see <https://www.gnu.org/licenses/>.
 *
 * The author can be contacted via:
 * 	Email: sirnapkin@protonmail.com
 * 	Twitter: @SirNapkin1334
 * 	Discord: @SirNapkin1334#7960
 * 	Reddit: u/SirNapkin1334
 * 	IRC: SirNapkin1334; Registered on Freenode, EFNet, possibly others
 *
 * If you wish to use this software in a way violating the terms, please
 * contact the author, as an exception can be made.
 */

package in.sirnapk.dynctrl.dynswitch.implementations;

import in.sirnapk.dynctrl.dynswitch.DynamicSwitch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * An implementation of the DynamicSwitch class that uses Consumers.
 *
 * @param <C> The type of the identifier for the cases
 * @param <A> The type of the argument to the Consumer
 */
public class DynamicConsumerSwitch<C, A> extends DynamicSwitch<C, Consumer<A>, A, Void> {

	public void execute(@NotNull C caseId, @Nullable A args) {
		_execute(caseId, args);
	}

	@Override
	protected Void runCase(@NotNull Consumer<A> _case, @Nullable A args) {
        _case.accept(args);
        return null;
    }
}
