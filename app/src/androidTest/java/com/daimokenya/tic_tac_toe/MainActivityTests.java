package com.daimokenya.tic_tac_toe;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by hitch_sex on 3/30/18.
 * Make use of the Junit4 Rule
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {
    @Rule
    //The Activity under the @Rule is launched after each @Test
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    /**
     * This test will be able to test player x button calls the method setPlayerX onClick()
     */
    public void testClickXButtonAnd(){
        //perform a click on 'btn_player_x' button and Toast is shown
        onView(withId(R.id.btn_player_x)).perform(click());
        onView(withText(R.string.msg_set_player_x)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));

        //perform a click on 'btn_player_x' button and Toast does not show
        onView(withId(R.id.btn_player_x)).perform(click());
        onView(withText(R.string.msg_set_player_x)).inRoot(new ToastMatcher())
                .check(matches(not(isDisplayed())));
    }

    @Test
    /**
     * This test will be able to test player O button calls the method setPlayerX onClick()
     */
    public void testClickOButtonAnd(){
        //perform a click on 'btn_player_o' button and Toast is shown
        onView(withId(R.id.btn_player_o)).perform(click());
        onView(withText(R.string.msg_set_player_o)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));

        //perform a click on 'btn_player_o' button and Toast does not show
        onView(withId(R.id.btn_player_o)).perform(click());
        onView(withText(R.string.msg_set_player_o)).inRoot(new ToastMatcher())
                .check(matches(not(isDisplayed())));
    }
    @Test
    /**
     * This test will be able to test three box board button calls the method setThreeBoxes onClick()
     */
    public void testClickThreeBoxButtonAnd(){
        //perform a click on 'btn_three_box_board' button and Toast is shown
        onView(withId(R.id.btn_three_box_board)).perform(click());
        onView(withText(R.string.msg_set_three_box)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));

        //perform a click on 'btn_three_box_board' button and Toast does not show
        onView(withId(R.id.btn_three_box_board)).perform(click());
        onView(withText(R.string.msg_set_three_box)).inRoot(new ToastMatcher())
                .check(matches(not(isDisplayed())));
    }

    @Test
    /**
     * This test will be able to test Five Box Board button calls the method setFiveBoxes onClick()
     */
    public void testClickFiveBoxButtonAnd(){
        //perform a click on 'btn_five_box_board' button and Toast is shown
        onView(withId(R.id.btn_five_box_board)).perform(click());
        onView(withText(R.string.msg_set_five_box)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));

        //perform a click on 'btn_five_box_board' button and Toast does not show
        onView(withId(R.id.btn_five_box_board)).perform(click());
        onView(withText(R.string.msg_set_five_box)).inRoot(new ToastMatcher())
                .check(matches(not(isDisplayed())));
    }
}
