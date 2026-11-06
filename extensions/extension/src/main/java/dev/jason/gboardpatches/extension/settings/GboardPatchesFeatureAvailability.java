package dev.pyrrolidine.gboardpatches.extension.settings;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public final class GboardPatchesFeatureAvailability {
    public static final String FEATURE_EDITING_ACCESS_POINTS =
            "dev.pyrrolidine.gboardpatches.feature.editing_access_points";
    public static final String FEATURE_CLIPBOARD_ENHANCEMENTS =
            "dev.pyrrolidine.gboardpatches.feature.clipboard_enhancements";
    public static final String FEATURE_CLIPBOARD_CONTENT_LIMIT =
            "dev.pyrrolidine.gboardpatches.feature.clipboard_content_limit";
    public static final String FEATURE_WEB_CLIPBOARD =
            "dev.pyrrolidine.gboardpatches.feature.web_clipboard";
    public static final String FEATURE_LAN_FTP =
            "dev.pyrrolidine.gboardpatches.feature.lan_ftp_server";
    public static final String FEATURE_DEVICE_INTELLIGENCE =
            "dev.pyrrolidine.gboardpatches.feature.device_intelligence";
    public static final String FEATURE_GRAMMAR_CHECKER =
            "dev.pyrrolidine.gboardpatches.feature.grammar_checker";
    public static final String FEATURE_INLINE_SUGGESTIONS =
            "dev.pyrrolidine.gboardpatches.feature.inline_suggestions";
    public static final String FEATURE_KEY_SHAPE_SELECTION =
            "dev.pyrrolidine.gboardpatches.feature.key_shape_selection";
    public static final String FEATURE_CUSTOM_SYMBOLS =
            "dev.pyrrolidine.gboardpatches.feature.custom_symbols";
    public static final String FEATURE_SETTINGS_HOMEPAGE =
            "dev.pyrrolidine.gboardpatches.feature.settings_homepage";
    public static final String FEATURE_SYMBOL_FOOTER_ORDER =
            "dev.pyrrolidine.gboardpatches.feature.symbol_footer_order";
    public static final String FEATURE_LATIN_GLOBE_KEY_IGNORE_INTERVAL =
            "dev.pyrrolidine.gboardpatches.feature.latin_globe_key_ignore_interval";
    public static final String FEATURE_ENGLISH_UPPERCASE_TOGGLE =
            "dev.pyrrolidine.gboardpatches.feature.english_uppercase_toggle";
    public static final String FEATURE_ZHUYIN_BOTTOM_ROW_WEIGHT =
            "dev.pyrrolidine.gboardpatches.feature.zhuyin_bottom_row_weight";
    public static final String FEATURE_AI_WRITING_TOOLS =
            "dev.pyrrolidine.gboardpatches.feature.ai_writing_tools";
    public static final String FEATURE_TOP_ROW_SWIPE =
            "dev.pyrrolidine.gboardpatches.feature.top_row_swipe";
    public static final String FEATURE_DEVELOPER_OPTIONS =
            "dev.pyrrolidine.gboardpatches.feature.developer_options";
    public static final String FEATURE_BACKUP_RESTORE =
            "dev.pyrrolidine.gboardpatches.feature.backup_restore";
    public static final String FEATURE_LONG_PRESS_QUICK_ACTIONS =
            "dev.pyrrolidine.gboardpatches.feature.long_press_quick_actions";
    public static final String FEATURE_ADVANCED_VOICE_TYPING =
            "dev.pyrrolidine.gboardpatches.feature.advanced_voice_typing";
    public static final String FEATURE_BLUETOOTH_MICROPHONE =
            "dev.pyrrolidine.gboardpatches.feature.bluetooth_microphone";
    public static final String FEATURE_OCR_SCAN_TEXT =
            "dev.pyrrolidine.gboardpatches.feature.ocr_scan_text";
    public static final String FEATURE_MANUAL_INCOGNITO =
            "dev.pyrrolidine.gboardpatches.feature.manual_incognito";
    public static final String FEATURE_EMOJI_SIZE =
            "dev.pyrrolidine.gboardpatches.feature.emoji_size";
    public static final String FEATURE_CURSOR_TRACKPAD =
            "dev.pyrrolidine.gboardpatches.feature.cursor_trackpad";
    public static final String FEATURE_ACCESS_POINTS_MENU_STYLE =
            "dev.pyrrolidine.gboardpatches.feature.access_points_menu_style";
    public static final String FEATURE_SPLIT_KEYBOARD =
            "dev.pyrrolidine.gboardpatches.feature.split_keyboard";
    public static final String FEATURE_ACCESSIBILITY_LAYOUT =
            "dev.pyrrolidine.gboardpatches.feature.accessibility_layout";
    public static final String FEATURE_ROUNDED_KEYBOARD_PANEL =
            "dev.pyrrolidine.gboardpatches.feature.rounded_keyboard_panel";
    public static final String FEATURE_SPACEBAR_LOGO =
            "dev.pyrrolidine.gboardpatches.feature.spacebar_logo";
    public static final String FEATURE_CLOSE_PROACTIVE_SUGGESTIONS =
            "dev.pyrrolidine.gboardpatches.feature.close_proactive_suggestions";
    public static final String FEATURE_FLOW_MODE_ANIMATION =
            "dev.pyrrolidine.gboardpatches.feature.flow_mode_animation";
    public static final String FEATURE_QUICK_INSERT =
            "dev.pyrrolidine.gboardpatches.feature.quick_insert";
    public static final String FEATURE_ACCESS_POINT_COUNT =
            "dev.pyrrolidine.gboardpatches.feature.access_point_count";
    public static final String FEATURE_FLOATING_WEB_SEARCH =
            "dev.pyrrolidine.gboardpatches.feature.floating_web_search";
    public static final String FEATURE_SIMPLE_CALCULATOR =
            "dev.pyrrolidine.gboardpatches.feature.simple_calculator";
    public static final String FEATURE_CUSTOM_THEME =
            "dev.pyrrolidine.gboardpatches.feature.custom_theme";
    public static final String FEATURE_FROSTED_GLASS =
            "dev.pyrrolidine.gboardpatches.feature.frosted_glass";
    public static final String FEATURE_SWIPE_DISMISS =
            "dev.pyrrolidine.gboardpatches.feature.swipe_dismiss";

    private static final String TAG = "GboardPatches";

    private GboardPatchesFeatureAvailability() {
    }

    public static boolean hasFeature(Context context, String featureKey) {
        if (context == null || featureKey == null || featureKey.isEmpty()) {
            return false;
        }
        return hasAnyFeature(context, featureKey);
    }

    public static boolean hasAnyFeature(Context context, String... featureKeys) {
        if (context == null || featureKeys == null || featureKeys.length == 0) {
            return false;
        }
        for (String featureKey : featureKeys) {
            if (featureKey == null || featureKey.isEmpty()) {
                return false;
            }
        }

        try {
            Context applicationContext = context.getApplicationContext();
            Context lookupContext = applicationContext != null ? applicationContext : context;
            PackageManager packageManager = lookupContext.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(
                    lookupContext.getPackageName(),
                    PackageManager.GET_META_DATA);
            Bundle metaData = applicationInfo.metaData;
            if (metaData == null) {
                return false;
            }
            for (String featureKey : featureKeys) {
                if (metaData.getBoolean(featureKey, false)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable throwable) {
            try {
                Log.w(TAG, "Failed to resolve feature marker: " + describeFeatures(featureKeys),
                        throwable);
            } catch (Throwable ignored) {
                // Feature detection still fails closed when logging is unavailable.
            }
            return false;
        }
    }

    private static String describeFeatures(String[] featureKeys) {
        if (featureKeys.length == 1) {
            return featureKeys[0];
        }

        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < featureKeys.length; index++) {
            if (index > 0) {
                builder.append(", ");
            }
            builder.append(featureKeys[index]);
        }
        return builder.toString();
    }
}
