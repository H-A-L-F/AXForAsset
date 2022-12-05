
package com.example.axforasset.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.axforasset.R
import com.example.axforasset.databinding.ActivityItemBinding
import com.example.axforasset.models.Item
import com.example.axforasset.utils.ItemRvAdapter
import com.example.axforasset.utils.RecyclerViewInterface

class ItemActivity : AppCompatActivity(), RecyclerViewInterface {

    private lateinit var binding: ActivityItemBinding
    private lateinit var items: ArrayList<Item>
    private lateinit var itemRvAdapter: ItemRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.itemRv.layoutManager = LinearLayoutManager(this)
        binding.itemRv.setHasFixedSize(true)

        items = arrayListOf()

        itemRvAdapter = ItemRvAdapter(items, this)

        binding.itemRv.adapter = itemRvAdapter

        items.add(Item(R.drawable.cozyfarm, "Cozy Farm", "Planning to start a Project where you can take care of cute Animals, build a Cozy Town and harvest your own Produce? "))
        items.add(Item(R.drawable.cozyfishing, "Cozy Fishing", "This Asset Pack provides Beach Tiles, 100 aquatic creatures, Beach Buildings, Beach Decorations and marine themed Foraging Items."))
        items.add(Item(R.drawable.cozyinterior, "Cozy Interior", "Easily match wallpapers, flooring, furniture and decorations with this big selection in a muted color palette"))
        items.add(Item(R.drawable.cozypeople, "Cozy People", "Looking for animated, customizable player and NPCs sprites for your game?"))
        items.add(Item(R.drawable.cozytown, "Cozy Town", "Are your NPCs in need of a job and social life? Do you need activities for your player? Looking for a town that changes with seasons? This asset pack provides all that and more!"))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.profileMenu -> {
                intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
            R.id.homeMenu -> {
                intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.logoutMenu -> {
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(position: Int) {
        val curr = items[position]
        val image = curr.image
        val title = curr.title
        val desc = curr.desc

        val item: com.example.axforasset.parcel.Item = com.example.axforasset.parcel.Item(image, title, desc)

        intent = Intent(this, ItemDetailActivity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }
}