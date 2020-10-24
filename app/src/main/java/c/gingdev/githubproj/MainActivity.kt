package c.gingdev.githubproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import c.gingdev.githubproj.constracts.Constract
import c.gingdev.githubproj.presenters.MainPresenter

class MainActivity: AppCompatActivity(), Constract.view {

	private val presenter = MainPresenter(this)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

	}

	override fun responseUser() {

	}

	override fun responseUserRepo() {

	}
}