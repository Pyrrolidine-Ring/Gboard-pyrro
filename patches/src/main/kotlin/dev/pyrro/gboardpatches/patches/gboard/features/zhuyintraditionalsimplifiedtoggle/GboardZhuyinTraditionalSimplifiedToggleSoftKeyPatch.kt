package dev.pyrro.gboardpatches.patches.gboard.features.zhuyintraditionalsimplifiedtoggle

import dev.pyrro.gboardpatches.patches.gboard.shared.GboardSoftKeyFamilyFeature
import dev.pyrro.gboardpatches.patches.gboard.shared.afterDelegate
import dev.pyrro.gboardpatches.patches.gboard.shared.beforeDelegate
import dev.pyrro.gboardpatches.patches.gboard.shared.gboardSoftKeyFamilyFeaturePatch

internal val ZHUYIN_TOGGLE_PATCH_INCOMING_METADATA_DELEGATE by lazy {
    GboardSoftKeyFamilyFeature.ZHUYIN_TOGGLE.beforeDelegate()
}
internal val ZHUYIN_TOGGLE_AFTER_BIND_DELEGATE by lazy {
    GboardSoftKeyFamilyFeature.ZHUYIN_TOGGLE.afterDelegate()
}

internal val gboardZhuyinTraditionalSimplifiedToggleSoftKeyPatch =
    gboardSoftKeyFamilyFeaturePatch(
        description = "修正注音 ㄥ 上滑繁簡切換鍵的 SoftKeyView bind-time metadata。",
        feature = GboardSoftKeyFamilyFeature.ZHUYIN_TOGGLE,
    )
