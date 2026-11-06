package dev.pyrrolidine.gboardpatches.extension.settings;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.pyrrolidine.gboardpatches.extension.backuprestore.GboardBackupRestoreSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.clipboard.GboardClipboardSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.developeroptions.GboardDeveloperOptionsSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.keyboard.GboardAiVoiceSettingsGroupFeature;
import dev.pyrrolidine.gboardpatches.extension.keyboard.GboardKeyboardLayoutSettingsGroupFeature;
import dev.pyrrolidine.gboardpatches.extension.keyboard.GboardKeyboardToolsSettingsGroupFeature;
import dev.pyrrolidine.gboardpatches.extension.lanftp.settings.GboardLanFtpSettingsFeature;
import dev.pyrrolidine.gboardpatches.extension.settingshomepage.GboardSettingsHomepageSettingsFeature;

public final class GboardPatchesSettingsFeatureRegistry {
    private static final String TAG = "GboardPatches";

    private GboardPatchesSettingsFeatureRegistry() {
    }

    public static List<GboardPatchesSettingsContract.Feature> features(Context context) {
        List<GboardPatchesSettingsContract.Feature> features =
                new ArrayList<GboardPatchesSettingsContract.Feature>();
        addIfAvailable(context, features, new GboardAiVoiceSettingsGroupFeature(context));
        addIfAvailable(context, features, new GboardKeyboardToolsSettingsGroupFeature(context));
        addIfAvailable(context, features, new GboardKeyboardLayoutSettingsGroupFeature(context));
        addIfAvailable(context, features, new GboardClipboardSettingsFeature());
        addIfAvailable(context, features, new GboardLanFtpSettingsFeature(context));
        addIfAvailable(context, features, new GboardSettingsHomepageSettingsFeature());
        addIfAvailable(context, features, new GboardBackupRestoreSettingsFeature(context));
        addIfAvailable(context, features, new GboardDeveloperOptionsSettingsFeature(context));
        return Collections.unmodifiableList(features);
    }

    private static void addIfAvailable(Context context,
            List<GboardPatchesSettingsContract.Feature> features,
            GboardPatchesSettingsContract.Feature feature) {
        try {
            if (feature.isAvailable(context)) {
                features.add(feature);
            }
        } catch (Throwable throwable) {
            Log.w(TAG, "Failed to evaluate feature availability: " + feature.getClass().getName(),
                    throwable);
        }
    }
}
