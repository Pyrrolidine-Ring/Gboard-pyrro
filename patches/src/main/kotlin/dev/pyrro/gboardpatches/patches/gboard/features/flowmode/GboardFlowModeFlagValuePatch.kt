package dev.pyrro.gboardpatches.patches.gboard.features.flowmode

import dev.pyrro.gboardpatches.patches.gboard.shared.GboardFlagFamilyFeature
import dev.pyrro.gboardpatches.patches.gboard.shared.gboardFlagFamilyFeaturePatch

internal val gboardFlowModeFlagValuePatch = gboardFlagFamilyFeaturePatch(
    description = "在 Flow Mode flags 的 stock result 後套用 feature 設定。",
    feature = GboardFlagFamilyFeature.FLOW_MODE_ANIMATION,
)
