package com.example.claudetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.claudetutorial.ui.theme.ClaudeTutorialTheme

/**
 * The main entry point of the application.
 *
 * Enables edge-to-edge rendering and sets the Compose UI root.
 */
class MainActivity : ComponentActivity() {

    /**
     * Initializes the activity, enables edge-to-edge display, and sets the Compose content root.
     *
     * @param savedInstanceState Previously saved instance state, or null if none exists.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClaudeTutorialTheme {
                ClaudeTutorialApp()
            }
        }
    }
}

/**
 * Root composable for the app.
 *
 * Manages the current navigation destination and renders a [NavigationSuiteScaffold] that
 * automatically adapts between a bottom bar (phones) and a side rail (tablets/foldables).
 */
@PreviewScreenSizes
@Composable
fun ClaudeTutorialApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

/**
 * Defines the top-level navigation destinations for the app.
 *
 * Each entry provides a display [label] and a drawable resource [icon] used by
 * [NavigationSuiteScaffold] to render navigation items.
 */
enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    HOME("Home", R.drawable.ic_home),
    FAVORITES("Favorites", R.drawable.ic_favorite),
    PROFILE("Profile", R.drawable.ic_account_box),
}

/**
 * Displays a greeting message for the given [name].
 *
 * @param name The name to include in the greeting text.
 * @param modifier Modifier applied to the [Text] composable.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/**
 * Preview composable for [Greeting], shown with a white background in Android Studio.
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClaudeTutorialTheme {
        Greeting("Android")
    }
}
