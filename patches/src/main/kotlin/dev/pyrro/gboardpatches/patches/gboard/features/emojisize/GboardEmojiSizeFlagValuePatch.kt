package dev.pyrro.gboardpatches.patches.gboard.features.emojisize

import dev.pyrro.gboardpatches.patches.gboard.shared.GboardFlagFamilyFeature
import dev.pyrro.gboardpatches.patches.gboard.shared.gboardFlagFamilyFeaturePatch

internal val gboardEmojiSizeFlagValuePatch = gboardFlagFamilyFeaturePatch(
    description = "在 emoji_scale_supported 原始結果後套用使用者設定值",
    feature = GboardFlagFamilyFeature.CHANGE_EMOJI_SIZE,
)
