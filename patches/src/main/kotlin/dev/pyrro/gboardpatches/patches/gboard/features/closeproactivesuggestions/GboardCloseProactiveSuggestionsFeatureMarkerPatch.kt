package dev.pyrrolidine.gboardpatches.patches.gboard.features.closeproactivesuggestions

import app.morphe.patcher.patch.resourcePatch
import dev.pyrrolidine.gboardpatches.patches.gboard.features.featureflags.applyFeatureMarker
import dev.pyrrolidine.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardCloseProactiveSuggestionsFeatureMarkerPatch = resourcePatch(
    description = "標記 Close Proactive Suggestions feature 已被打入 target APK。",
) {
    compatibleWith(COMPATIBILITY_GBOARD)

    finalize {
        applyFeatureMarker(CLOSE_PROACTIVE_SUGGESTIONS_FEATURE_MARKER)
    }
}

internal const val CLOSE_PROACTIVE_SUGGESTIONS_FEATURE_MARKER =
    "dev.pyrrolidine.gboardpatches.feature.close_proactive_suggestions"
