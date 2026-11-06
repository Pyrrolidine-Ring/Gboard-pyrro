package dev.pyrrolidine.gboardpatches.patches.gboard.features.longpressquickactions

import dev.pyrrolidine.gboardpatches.patches.gboard.shared.GboardGestureFamilyFeature
import dev.pyrrolidine.gboardpatches.patches.gboard.shared.gboardGestureFamilyFeaturePatch

internal val gboardLongPressQuickActionsGesturePatch = gboardGestureFamilyFeaturePatch(
    description = "Consume owned globe-drag editing gestures before other gesture policies.",
    feature = GboardGestureFamilyFeature.LONG_PRESS_QUICK_ACTIONS,
)
