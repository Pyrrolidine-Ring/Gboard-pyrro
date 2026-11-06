package dev.pyrro.gboardpatches.patches.gboard.features.toprowswipe

import dev.pyrro.gboardpatches.patches.gboard.shared.GboardGestureFamilyFeature
import dev.pyrro.gboardpatches.patches.gboard.shared.gboardGestureFamilyFeaturePatch

internal val gboardTopRowSwipeGesturePatch = gboardGestureFamilyFeaturePatch(
    description = "在 gesture dispatch 前 consume armed top-row swipe，並阻擋 stale custom metadata dispatch。",
    feature = GboardGestureFamilyFeature.TOP_ROW_SWIPE,
)
