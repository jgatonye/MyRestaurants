package com.maina.myrestaurants;

/**
 * Created by jgatonye on 3/14/17.
 */
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.maina.myrestaurants.ui.RestaurantListActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNot.not;

public class RestaurantsActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<RestaurantListActivity> activityActivityTestRule =
            new ActivityTestRule<RestaurantListActivity>(RestaurantListActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant(){
        View activityDecorView = activityActivityTestRule.getActivity().getWindow().getDecorView();
        String restaurantName = "Artcaffe Karen";
        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restaurantName)));
    }
}
