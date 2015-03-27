/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.spongepowered.api.data.manipulators.player;

import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.achievement.Achievement;

import java.util.Collection;

public interface AchievementData extends DataManipulator<AchievementData> {

    /**
     * Checks whether this player has earned the given {@link Achievement}.
     *
     * @param achievement The achievement to check
     * @return True if the player has completely earned the achievement
     */
    boolean hasAchievement(Achievement achievement);

    /**
     * Gets a {@link Collection} containing all {@link Achievement}s this player
     * has earned already.
     *
     * @return An immutable collection containing all earned achievements
     */
    Collection<Achievement> getAchievements();

    /**
     * Grants the given {@link Achievement} to this player. An
     * {@link Achievement} can be granted multiple times.
     *
     * @param achievement The achievement to grant
     */
    void grantAchievement(Achievement achievement);

    /**
     * Revokes the given {@link Achievement} from this player. This may also
     * revoke dependent {@link Achievement}s or reset {@link Statistic}s that
     * are used to count for the {@link Achievement}.
     *
     * @param achievement The achievement to revoke
     */
    void revokeAchievement(Achievement achievement);

    /**
     * Revokes all {@link Achievement}s from this player. This may also resets
     * {@link Statistic} that are used to count for the {@link Achievement}s.
     */
    void revokeAchievements();

}
