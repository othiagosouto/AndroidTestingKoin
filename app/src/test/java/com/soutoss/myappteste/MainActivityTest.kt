package com.soutoss.myappteste

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setup() {
        stopKoin()
        val myModule = module {
            single { RepoLocalFake() as RepoSource }
            single { MainViewModel(get()) }

        }
        startKoin {
            modules(myModule)
        }
    }

    @After
    fun teardDown() {
        stopKoin()
    }

    @Test
    fun test_nameChanged() {
        launch(MainActivity::class.java)
        onView(withId(R.id.tv_name)).check(matches(withText("Repo Local Fake")))
    }
}