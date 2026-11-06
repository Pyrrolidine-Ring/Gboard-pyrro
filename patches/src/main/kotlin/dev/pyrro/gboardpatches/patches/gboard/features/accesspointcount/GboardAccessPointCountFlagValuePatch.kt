package dev.pyrro.gboardpatches.patches.gboard.features.accesspointcount

import dev.pyrro.gboardpatches.patches.gboard.shared.GboardFlagFamilyFeature
import dev.pyrro.gboardpatches.patches.gboard.shared.gboardFlagFamilyFeaturePatch

internal val gboardAccessPointCountFlagValuePatch = gboardFlagFamilyFeaturePatch(
    description = "在 toolbar access point count flags 的 stock result 後套用 feature 設定。",
    feature = GboardFlagFamilyFeature.ACCESS_POINT_COUNT,
)
