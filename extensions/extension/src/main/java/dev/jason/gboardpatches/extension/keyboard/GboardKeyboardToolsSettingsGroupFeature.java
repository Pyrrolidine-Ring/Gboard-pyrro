package dev.pyrrolidine.gboardpatches.extension.keyboard;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import dev.pyrrolidine.gboardpatches.extension.R;
import dev.pyrrolidine.gboardpatches.extension.editingaccesspoints.GboardEditingAccessPointsSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.calculator.GboardCalculatorSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.cursortrackpad.GboardCursorTrackpadSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.longpressquickactions.GboardLongPressQuickActionsSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.manualincognito.GboardManualIncognitoSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.ocr.GboardOcrSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.quickinsert.GboardQuickInsertSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.settings.GboardFeatureGroup;
import dev.pyrrolidine.gboardpatches.extension.settings.GboardPatchesSettingsContract;
import dev.pyrrolidine.gboardpatches.extension.settings.GboardSettingsText;
import dev.pyrrolidine.gboardpatches.extension.swipedismiss.GboardSwipeDismissSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.toprowswipe.GboardTopRowSwipeSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.websearch.GboardFloatingWebSearchSettingsFeature;

public final class GboardKeyboardToolsSettingsGroupFeature
        implements GboardPatchesSettingsContract.Feature {
    private final GboardFeatureGroup delegate;

    public GboardKeyboardToolsSettingsGroupFeature(Context context) {
        delegate = new GboardFeatureGroup(
                GboardSettingsText.get(context,
                        R.string.gboard_patches_group_keyboard_tools_title),
                GboardSettingsText.get(context,
                        R.string.gboard_patches_group_keyboard_tools_summary),
                GboardSettingsText.get(context, R.string.gboard_patches_header_badge),
                GboardSettingsText.get(context,
                        R.string.gboard_patches_group_keyboard_header_summary),
                GboardSettingsText.get(context,
                        R.string.gboard_patches_group_keyboard_empty_title),
                GboardSettingsText.get(context,
                        R.string.gboard_patches_group_keyboard_empty_summary),
                Arrays.asList(
                        new GboardTopRowSwipeSettingsFeature(context),
                        new GboardManualIncognitoSettingsFeature(context),
                        new GboardLongPressQuickActionsSettingsFeature(context),
                        new GboardEditingAccessPointsSettingsFeature(context),
                        new GboardCursorTrackpadSettingsFeature(context),
                        new GboardOcrSettingsFeature(context),
                        new GboardQuickInsertSettingsFeature(context),
                        new GboardFloatingWebSearchSettingsFeature(context),
                        new GboardCalculatorSettingsFeature(context),
                        new GboardSwipeDismissSettingsFeature(context)));
    }

    @Override
    public String getEntryTitle() {
        return delegate.getEntryTitle();
    }

    @Override
    public String getEntrySummary() {
        return delegate.getEntrySummary();
    }

    @Override
    public boolean isAvailable(Context context) {
        return delegate.isAvailable(context);
    }

    @Override
    public List<GboardPatchesSettingsContract.Feature> getNavigationChildren() {
        return delegate.getNavigationChildren();
    }

    @Override
    public GboardPatchesSettingsContract.Screen buildScreen(
            GboardPatchesSettingsContract.FeatureHost host) {
        return delegate.buildScreen(host);
    }
}
