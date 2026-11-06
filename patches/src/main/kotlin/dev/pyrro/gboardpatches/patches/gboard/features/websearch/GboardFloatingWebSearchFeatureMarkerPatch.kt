package dev.pyrrolidine.gboardpatches.patches.gboard.features.websearch

import app.morphe.patcher.patch.resourcePatch
import dev.pyrrolidine.gboardpatches.patches.gboard.features.featureflags.applyFeatureMarker
import dev.pyrrolidine.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardFloatingWebSearchFeatureMarkerPatch = resourcePatch(
    description = "標記 Floating Web Search feature 已被打入 target APK。",
) {
    compatibleWith(COMPATIBILITY_GBOARD)

    finalize {
        applyFeatureMarker(FLOATING_WEB_SEARCH_FEATURE_MARKER)
    }
}

internal const val FLOATING_WEB_SEARCH_FEATURE_MARKER =
    "dev.pyrrolidine.gboardpatches.feature.floating_web_search"
