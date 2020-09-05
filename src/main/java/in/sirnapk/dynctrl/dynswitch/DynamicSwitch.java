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

package in.sirnapk.dynctrl.dynswitch;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://coderwall.com/p/wgtifw/java-tip-3-how-to-implement-dynamic-switch
// Based off of CoderWall's Dynamic Switch class.

/**
 * An implementation of the switch statement that allows cases to be dynamically modified during runtime, designed to
 * work with any functional interface.
 *
 * @param <C> The type of the identifier for the cases
 * @param <F> The type of functional interface that will be run
 * @param <A> An optional argument to the functional interface
 * @param <R> An optional return from the functional interface
 */
public abstract class DynamicSwitch<C, F, A, R> {

	/** The HashMap that stores all of the cases. */
	final Map<C, F> cases = new HashMap<>();

	/** The code to be run like a <code>default:</code> case. */
	@Nullable
	F defaultCase = null;

	/**
	 * Adds a new dynamic case statement.
	 *
	 * @param caseId the object that is used to get the code to be ran, equivalent to <code>case caseId:</code>
	 * @param _case the functional interface to be run
	 */
	public void addCase(@NotNull C caseId, @NotNull F _case) {
		cases.put(caseId, _case);
	}

	/**
	 * Removes a dynamic case statement.
	 *
	 * @param caseId the object that is used to get the code to be removed
	 */
	public void removeCase(@NotNull C caseId) {
		cases.remove(caseId);
	}

	/**
	 * Gets an ArrayList of all caseIds.
	 *
	 * @return an ArrayList containing all caseIds.
	 */
	@NotNull
	public List<C> getCaseIds() {
		return new ArrayList<>(cases.keySet());
	}

	/** Clears all cases. */
	public void clearCases() {
		cases.clear();
	}

	/**
	 * Sets the default case.
	 *
	 * @param _case the functional interface, or null for none
	 */
	public void setDefaultCase(@Nullable F _case) {
		defaultCase = _case;
	}

	/**
	 * Executes the case with the given caseId.
	 *
	 * @param caseId the case that is to be executed
	 * @param args the args that will be passed to the case
	 * @return the return value of the functional interface, or <code>null</code> if the interface does not have a
	 * return value or no interface with that identifier exists+
	 */
	@Nullable
	protected R _execute(@NotNull C caseId, @Nullable A args) {
		if (cases.containsKey(caseId)) {
			return runCase(cases.get(caseId), args);
		} else if (defaultCase != null) {
			return runCase(defaultCase, args);
		} else return null;
	}

	@Nullable
	protected abstract R runCase(@NotNull F _case, @Nullable A args);
}
