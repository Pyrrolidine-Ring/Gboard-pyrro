package dev.pyrro.gboardpatches.patches.gboard.features.quickinsert

import dev.pyrro.gboardpatches.patches.gboard.shared.GboardFlagFamilyFeature
import dev.pyrro.gboardpatches.patches.gboard.shared.gboardFlagFamilyFeaturePatch

internal val gboardQuickInsertFlagValuePatch = gboardFlagFamilyFeaturePatch(
    description = "在 Quick Insert flags 的 stock result 後套用 feature 設定。",
    feature = GboardFlagFamilyFeature.QUICK_INSERT,
)
