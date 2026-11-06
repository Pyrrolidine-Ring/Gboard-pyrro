package dev.pyrrolidine.gboardpatches.patches.gboard.features.customtheme

import app.morphe.patcher.patch.ResourcePatchContext
import app.morphe.patcher.patch.resourcePatch
import dev.pyrrolidine.gboardpatches.patches.gboard.shared.ensureManifestUsesPermission
import dev.pyrrolidine.gboardpatches.patches.shared.Constants.COMPATIBILITY_GBOARD

internal val gboardCustomThemeManifestPatch = resourcePatch(
    description = "為 Custom Theme 按需下載加入網路權限。"
) {
    compatibleWith(COMPATIBILITY_GBOARD)
    finalize { ensureCustomThemeNetworkPermission() }
}

context(context: ResourcePatchContext)
private fun ensureCustomThemeNetworkPermission() = with(context) {
    document("AndroidManifest.xml").use { document ->
        ensureManifestUsesPermission(document, document.documentElement, "android.permission.INTERNET")
    }
}
