package pl.ownvision.dogsociety.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import de.psdev.licensesdialog.LicensesDialog
import kotlinx.android.synthetic.main.activity_main.*
import pl.ownvision.dogsociety.R

class MainActivity : AppCompatActivity() {

    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            if(drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            }else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }

        drawerToggle = ActionBarDrawerToggle(
                this,
                drawer_layout,
                R.string.drawer_open,
                R.string.drawer_close);

        drawer_layout.setDrawerListener(drawerToggle);
        drawerToggle.syncState()
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeButtonEnabled(true);

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            drawer_layout.closeDrawer(GravityCompat.START)
            when (menuItem.itemId) {
                R.id.navigation_libraries -> {
                    LicensesDialog.Builder(this).setNotices(R.raw.notices).setIncludeOwnLicense(true).build().show()
                    true
                }
                else -> true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item)
    }
}
