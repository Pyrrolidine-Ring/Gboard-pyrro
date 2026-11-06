package dev.pyrrolidine.gboardpatches.patches.gboard.features.longpressquickactions

import dev.pyrrolidine.gboardpatches.patches.gboard.shared.GboardSoftKeyFamilyFeature
import dev.pyrrolidine.gboardpatches.patches.gboard.shared.gboardSoftKeyFamilyFeaturePatch

internal val gboardLongPressQuickActionsSoftKeyPatch = gboardSoftKeyFamilyFeaturePatch(
    description = "在 18.0.3 SoftKeyView bind 前套用或回復 long-press shortcut metadata。",
    feature = GboardSoftKeyFamilyFeature.LONG_PRESS_QUICK_ACTIONS,
)
