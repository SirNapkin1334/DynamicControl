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

/**
 * <b>!! WARNING !! I don't know much of Threads! This may have errors!</b><br>
 * An implementation of the DynamicSwitch class that uses Predicates.
 *
 * @param <C> The type of the identifier for the cases
 */
public class DynamicRunnableSwitch<C> extends DynamicSwitch<C, Runnable, Void, Void> {

	public void execute(@NotNull C _case) {
		_execute(_case, null);
	}

	@Override
	protected @Nullable Void runCase(@NotNull Runnable _case, @Nullable Void args) {
		_case.run();
		return null;
	}
}
