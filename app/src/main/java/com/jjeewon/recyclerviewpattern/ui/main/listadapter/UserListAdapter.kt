package com.jjeewon.recyclerviewpattern.ui.main.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewpattern.R
import com.example.recyclerviewpattern.databinding.LayoutUserItemBinding
import com.jjeewon.recyclerviewpattern.data.model.User

class UserListAdapter(private val onClick: (User) -> Unit) :
    ListAdapter<User, UserListAdapter.UserListViewHolder>(UserDiffCallback) {

    class UserListViewHolder(
        private val binding: LayoutUserItemBinding,
        val onClick: (User) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) = with(binding) {
            userName.text = user.name
            Glide.with(root.context)
                .load(user.avatar)
                .into(userImage)
            root.setOnClickListener { onClick(user) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view = LayoutUserItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserListViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)

    }
}

object UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
}