package com.idat.superherolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.idat.superherolist.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class HeroAdapter (val superhero:List<SuperHero>):RecyclerView.Adapter<HeroAdapter.HeroHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int =  superhero.size

    class HeroHolder(val view:View):RecyclerView.ViewHolder(view){
        val binding = ItemSuperheroBinding.bind(view)

        fun render(superhero: SuperHero){
           binding.tvRealName.text = superhero.realName
           binding.tvSuperHeroName.text = superhero.superHeroName
           binding.tvPublisher.text = superhero.publisher
           binding.itemSuperHero.setOnClickListener {
               Toast.makeText(binding.itemSuperHero.context,"Has seleccionado ${superhero.realName}",Toast.LENGTH_SHORT).show()
           }

//            Picasso.get().load(superhero.image).into(binding.ivHero)
            binding.ivHero.loadUrl(superhero.image)


        }
        fun ImageView.loadUrl(url: String){
            Picasso.get().load(url).into(this)
        }


    }
}