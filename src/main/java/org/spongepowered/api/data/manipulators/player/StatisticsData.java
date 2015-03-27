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

import com.google.common.base.Optional;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.StatisticGroup;

import java.util.Map;

public interface StatisticsData extends DataManipulator<StatisticsData> {

    /**
     * Gets the current value for the given {@link Statistic}. If the statistic
     * has not been set yet then {@link Optional#absent()} will be returned.
     *
     * @param statistic The statistic to return
     * @return The current value, or Optional.absent() if not set
     */
    Optional<Long> getStatistic(Statistic statistic);

    /**
     * Gets all {@link Statistic}s with their current values. Does not return
     * statistics which have not been set yet.
     *
     * @return An immutable map containing all statistics with their current
     *         values
     */
    Map<Statistic, Long> getStatistics();

    /**
     * Gets all {@link Statistic}s which belong to the given group, along with
     * their current values. Does not return statistics which have not been set
     * yet.
     *
     * @param group The group to retrieve
     * @return An immutable map containing all statistics within the group, and
     *         their values
     */
    Map<Statistic, Long> getStatisticsByGroup(StatisticGroup group);

    /**
     * Adds the specified amount to the given statistic.
     *
     * @param statistic The statistic to update
     * @param amount The amount to add to the statistic
     */
    void addToStatistic(Statistic statistic, long amount);

    /**
     * Sets the given statistic to the given value.
     *
     * @param statistic The statistic to update
     * @param newValue The new value for the statistic
     */
    void setStatistic(Statistic statistic, long newValue);

    /**
     * Resets the given statistic. This may result in the statistic being
     * removed from the statistics for this player until it is set to a value
     * again.
     *
     * @param statistic The statistic to reset
     */
    void resetStatistic(Statistic statistic);

    /**
     * Resets all statistics. This may result in some of the statistics being
     * removed from the statistics for this player until it is set to a value
     * again.
     */
    void resetStatistics();

}
