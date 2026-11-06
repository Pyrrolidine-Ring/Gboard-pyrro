package dev.pyrrolidine.gboardpatches.patches.gboard.features.featureflags

import app.morphe.patcher.patch.resourcePatch
import dev.pyrrolidine.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardDeviceIntelligenceFeatureMarkerPatch = resourcePatch(
    description = "標記 device intelligence rollout flag patch 已打入 target APK"
) {
    compatibleWith(COMPATIBILITY_GBOARD)

    finalize {
        applyFeatureMarker(DEVICE_INTELLIGENCE_FEATURE_MARKER_NAME)
    }
}

private const val DEVICE_INTELLIGENCE_FEATURE_MARKER_NAME =
    "dev.pyrrolidine.gboardpatches.feature.device_intelligence"
