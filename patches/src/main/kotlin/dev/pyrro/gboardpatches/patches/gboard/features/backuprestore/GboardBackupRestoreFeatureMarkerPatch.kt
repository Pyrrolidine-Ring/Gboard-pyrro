package dev.pyrrolidine.gboardpatches.patches.gboard.features.backuprestore

import app.morphe.patcher.patch.resourcePatch
import dev.pyrrolidine.gboardpatches.patches.gboard.features.featureflags.applyFeatureMarker
import dev.pyrrolidine.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardBackupRestoreFeatureMarkerPatch = resourcePatch(
    description = "標記 Backup & Restore feature 已被打入 target APK。",
) {
    compatibleWith(COMPATIBILITY_GBOARD)

    finalize {
        applyFeatureMarker(BACKUP_RESTORE_FEATURE_MARKER)
    }
}

internal const val BACKUP_RESTORE_FEATURE_MARKER =
    "dev.pyrrolidine.gboardpatches.feature.backup_restore"
