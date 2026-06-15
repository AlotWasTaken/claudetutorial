package com.example.claudetutorial

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class AppDestinationsTest {

    @Test
    fun appDestinationsHasThreeEntries() {
        assertEquals(3, AppDestinations.entries.size)
    }

    @Test
    fun appDestinationsContainsHomeEntry() {
        assertNotNull(AppDestinations.entries.find { it == AppDestinations.HOME })
    }

    @Test
    fun appDestinationsContainsFavoritesEntry() {
        assertNotNull(AppDestinations.entries.find { it == AppDestinations.FAVORITES })
    }

    @Test
    fun appDestinationsContainsProfileEntry() {
        assertNotNull(AppDestinations.entries.find { it == AppDestinations.PROFILE })
    }

    @Test
    fun homeDestinationHasCorrectLabel() {
        assertEquals("Home", AppDestinations.HOME.label)
    }

    @Test
    fun favoritesDestinationHasCorrectLabel() {
        assertEquals("Favorites", AppDestinations.FAVORITES.label)
    }

    @Test
    fun profileDestinationHasCorrectLabel() {
        assertEquals("Profile", AppDestinations.PROFILE.label)
    }

    @Test
    fun homeDestinationHasNonZeroIconResource() {
        assert(AppDestinations.HOME.icon != 0)
    }

    @Test
    fun favoritesDestinationHasNonZeroIconResource() {
        assert(AppDestinations.FAVORITES.icon != 0)
    }

    @Test
    fun profileDestinationHasNonZeroIconResource() {
        assert(AppDestinations.PROFILE.icon != 0)
    }

    @Test
    fun allDestinationsHaveUniqueIcons() {
        val icons = AppDestinations.entries.map { it.icon }
        assertEquals(icons.size, icons.toSet().size)
    }

    @Test
    fun allDestinationsHaveUniqueLabels() {
        val labels = AppDestinations.entries.map { it.label }
        assertEquals(labels.size, labels.toSet().size)
    }
}
