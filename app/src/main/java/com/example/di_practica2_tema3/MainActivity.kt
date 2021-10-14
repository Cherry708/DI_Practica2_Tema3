package com.example.di_practica2_tema3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewSwitcher
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.di_practica2_tema3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ViewSwitcher.ViewFactory {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageSwitcher = findViewById(R.id.isSwitcher) as ImageSwitcher
        imageSwitcher.setFactory(this)
        imageSwitcher.inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        imageSwitcher.outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)

        val listaItems = ArrayList<ItemImage>()
        listaItems.add(ItemImage(R.drawable.image1))
        listaItems.add(ItemImage(R.drawable.image2))
        listaItems.add(ItemImage(R.drawable.image3))
        listaItems.add(ItemImage(R.drawable.image4))
        listaItems.add(ItemImage(R.drawable.image5))
        listaItems.add(ItemImage(R.drawable.image6))
        listaItems.add(ItemImage(R.drawable.image7))
        listaItems.add(ItemImage(R.drawable.image8))
        listaItems.add(ItemImage(R.drawable.image9))
        listaItems.add(ItemImage(R.drawable.image10))


        binding.rvImages.setHasFixedSize(true)
        binding.rvImages.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))


        val adaptador = ItemImageAdapter(listaItems)
        binding.rvImages.adapter = adaptador
        binding.rvImages.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        adaptador.onClick = {
            imageSwitcher.setImageResource(listaItems[binding.rvImages.getChildAdapterPosition(it)].image)
        }
    }

    override fun makeView(): View {
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        return imageView
    }
}