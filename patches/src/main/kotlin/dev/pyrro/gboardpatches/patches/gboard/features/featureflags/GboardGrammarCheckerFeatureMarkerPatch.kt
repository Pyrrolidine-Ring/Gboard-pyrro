package dev.pyrro.gboardpatches.patches.gboard.features.featureflags

import app.morphe.patcher.patch.resourcePatch
import dev.pyrro.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardGrammarCheckerFeatureMarkerPatch = resourcePatch(
    description = "標記 grammar checker rollout flag patch 已打入 target APK"
) {
    compatibleWith(COMPATIBILITY_GBOARD)

    finalize {
        applyFeatureMarker(GRAMMAR_CHECKER_FEATURE_MARKER_NAME)
    }
}

private const val GRAMMAR_CHECKER_FEATURE_MARKER_NAME =
    "dev.pyrro.gboardpatches.feature.grammar_checker"
