package dev.pyrro.gboardpatches.patches.gboard.features.splitkeyboard

import app.morphe.patcher.patch.resourcePatch
import dev.pyrro.gboardpatches.patches.gboard.features.featureflags.applyFeatureMarker
import dev.pyrro.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardSplitKeyboardFeatureMarkerPatch = resourcePatch(
    description = "標記 Split keyboard feature 已被打入 target APK",
) {
    compatibleWith(COMPATIBILITY_GBOARD)

    finalize {
        applyFeatureMarker(SPLIT_KEYBOARD_FEATURE_MARKER)
    }
}

internal const val SPLIT_KEYBOARD_FEATURE_MARKER =
    "dev.pyrro.gboardpatches.feature.split_keyboard"
