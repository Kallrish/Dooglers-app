/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.data.DataSource.dogs
import com.example.dogglers.databinding.GridListItemBinding
import com.example.dogglers.databinding.VerticalHorizontalListItemBinding
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    private val dogList: List<Dog> = dogs
    private lateinit var bindingVerHor: VerticalHorizontalListItemBinding
    private lateinit var bindingGrid: GridListItemBinding
    // TODO: Initialize the data using the List found in data/DataSource

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dogImage: ImageView? = view?.findViewById(R.id.iv_dog_image)
        val dogName: TextView? = view?.findViewById(R.id.tv_dog_name)
        val dogAge: TextView? = view?.findViewById(R.id.tv_dog_age)
        val dogHobbies: TextView? = view?.findViewById(R.id.tv_dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val adapterLayout: View? = when (layout) {
            GRID -> {
                LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            }

            else -> {
                LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            }
        }
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = dogList.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dog = dogList[position]
        holder.dogImage?.setImageResource(dog.imageResourceId)
        // TODO: Get the data at the current position
        // TODO: Set the image resource for the current dog
        // TODO: Set the text for the current dog's name
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
//        holder.dogName?.text = resources?.getString(dog.name)
        holder.dogAge?.text = resources?.getString(R.string.dog_age, dog.age)
        holder.dogHobbies?.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
