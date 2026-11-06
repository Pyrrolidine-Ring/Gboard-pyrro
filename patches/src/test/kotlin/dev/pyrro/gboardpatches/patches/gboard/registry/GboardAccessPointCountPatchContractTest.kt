package dev.pyrro.gboardpatches.patches.gboard.registry

import dev.pyrro.gboardpatches.patches.gboard.features.accesspointcount.ACCESS_POINT_COUNT_FEATURE_MARKER
import dev.pyrro.gboardpatches.patches.gboard.features.accesspointcount.gboardAccessPointCountFeatureMarkerPatch
import dev.pyrro.gboardpatches.patches.gboard.features.accesspointcount.gboardAccessPointCountFlagValuePatch
import dev.pyrro.gboardpatches.patches.gboard.shared.gboardPatchesSettingsPatch
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class GboardAccessPointCountPatchContractTest {
    @Test
    fun `public patch is independently published and enabled by default`() {
        val patch = GboardPublishedPatchCatalog.morpheRegistrations.single { candidate ->
            candidate.name == "Top Toolbar Item Count"
        }

        assertSame(gboardAccessPointCountPatch, patch)
        assertTrue(patch.default)
        assertEquals(
            "自訂 Gboard 頂端工具列項目數量\n" +
                "Customize the Gboard top toolbar item count.",
            patch.description,
        )
    }

    @Test
    fun `public patch owns its settings marker and flag contribution`() {
        assertTrue(gboardAccessPointCountPatch.dependencies.any { dependency ->
            dependency === gboardPatchesSettingsPatch
        })
        assertTrue(gboardAccessPointCountPatch.dependencies.any { dependency ->
            dependency === gboardAccessPointCountFeatureMarkerPatch
        })
        assertTrue(gboardAccessPointCountPatch.dependencies.any { dependency ->
            dependency === gboardAccessPointCountFlagValuePatch
        })
        assertEquals(
            "dev.pyrro.gboardpatches.feature.access_point_count",
            ACCESS_POINT_COUNT_FEATURE_MARKER,
        )
    }
}
