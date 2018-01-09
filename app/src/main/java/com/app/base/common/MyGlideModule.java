package com.app.base.common;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.integration.volley.VolleyGlideModule;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;

/**
 * 自定义Glide模块
 *
 * @author Haojie.Dai
 */
public class MyGlideModule extends VolleyGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context));
    }
}
