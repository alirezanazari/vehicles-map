package ir.alirezanazari.vehicles.internal

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class ImageLoader {

    fun load(iv: ImageView, url: String) {
        Glide.with(iv.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(iv)

    }
}