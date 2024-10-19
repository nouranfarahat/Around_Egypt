package com.example.a34ml.utilities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.a34ml.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

//This function is used to convert the duration from the format of "PT30M" into "30 min" and it is used in the recipe_card.xml
@BindingAdapter("myViews")
fun appendViews(view:TextView,viewsNo:Int)
{
    view.setText(viewsNo.toString()+" views")
}

@BindingAdapter("myImageUrl")
fun loadImage(view:ImageView,url: String)
{
    Picasso.get().load(url).error(R.drawable.ic_launcher_foreground).into(view)
}
@BindingAdapter("myCountry")
fun appendViews(view:TextView,city:String)
{
    view.setText(city+", Egypt.")
}