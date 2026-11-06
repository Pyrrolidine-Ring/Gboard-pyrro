package dev.pyrrolidine.gboardpatches.patches.gboard.features.ocr

import dev.pyrrolidine.gboardpatches.patches.gboard.shared.GboardFlagFamilyFeature
import dev.pyrrolidine.gboardpatches.patches.gboard.shared.gboardFlagFamilyFeaturePatch
import dev.pyrrolidine.gboardpatches.patches.gboard.shared.runtimeabi.RuntimeAbiCatalog
import dev.pyrrolidine.gboardpatches.patches.gboard.shared.runtimeabi.RuntimeCallId

internal val gboardOcrFlagValuePatch = gboardFlagFamilyFeaturePatch(
    description = "強制啟用 stock OCR 入口與所有語言 gate。",
    feature = GboardFlagFamilyFeature.ENABLE_OCR_SCAN_TEXT,
)

internal val OCR_RUNTIME_CLASS =
    RuntimeAbiCatalog.abi(RuntimeCallId.OCR_RUNTIME_APPLY_FLAG_VALUE).owner
