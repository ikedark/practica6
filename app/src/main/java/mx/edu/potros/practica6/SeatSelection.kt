package mx.edu.potros.practica6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie = -1

        val bundle = intent.extras
        if (bundle!=null){
            title.setText(bundle.getString("name"))
            posMovie=bundle.getInt("id")
        }

        val confirm: Button = findViewById(R.id.confirm)
        confirm.setOnClickListener {
            Toast.makeText(this, "Enjoy the movie! :D", Toast.LENGTH_LONG).show()
        }

        val row1: RadioGroup = findViewById(R.id.row1)
    }
}