package dev.pyrro.gboardpatches.patches.gboard.features.accesspointsmenu

import app.morphe.patcher.patch.resourcePatch
import dev.pyrro.gboardpatches.patches.gboard.features.featureflags.applyFeatureMarker
import dev.pyrro.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardAccessPointsMenuFeatureMarkerPatch = resourcePatch(
    description = "標記 Access Points menu style feature 已被打入 target APK",
) {
    compatibleWith(COMPATIBILITY_GBOARD)

    finalize {
        applyFeatureMarker(ACCESS_POINTS_MENU_FEATURE_MARKER)
    }
}

internal const val ACCESS_POINTS_MENU_FEATURE_MARKER =
    "dev.pyrro.gboardpatches.feature.access_points_menu_style"
