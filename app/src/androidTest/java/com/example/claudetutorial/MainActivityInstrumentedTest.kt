package com.example.claudetutorial

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun homeNavItemIsDisplayed() {
        composeTestRule.onNodeWithText("Home").assertIsDisplayed()
    }

    @Test
    fun favoritesNavItemIsDisplayed() {
        composeTestRule.onNodeWithText("Favorites").assertIsDisplayed()
    }

    @Test
    fun profileNavItemIsDisplayed() {
        composeTestRule.onNodeWithText("Profile").assertIsDisplayed()
    }

    @Test
    fun homeIsSelectedByDefault() {
        composeTestRule.onNodeWithText("Home").assertIsSelected()
    }

    @Test
    fun favoritesIsNotSelectedByDefault() {
        composeTestRule.onNodeWithText("Favorites").assertIsNotSelected()
    }

    @Test
    fun clickingFavoritesSelectsFavorites() {
        composeTestRule.onNodeWithText("Favorites").performClick()
        composeTestRule.onNodeWithText("Favorites").assertIsSelected()
    }

    @Test
    fun clickingFavoritesDeselectsHome() {
        composeTestRule.onNodeWithText("Favorites").performClick()
        composeTestRule.onNodeWithText("Home").assertIsNotSelected()
    }

    @Test
    fun clickingProfileSelectsProfile() {
        composeTestRule.onNodeWithText("Profile").performClick()
        composeTestRule.onNodeWithText("Profile").assertIsSelected()
    }

    @Test
    fun clickingHomeAfterProfileSelectsHome() {
        composeTestRule.onNodeWithText("Profile").performClick()
        composeTestRule.onNodeWithText("Home").performClick()
        composeTestRule.onNodeWithText("Home").assertIsSelected()
    }

    @Test
    fun greetingTextIsDisplayed() {
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }
}
