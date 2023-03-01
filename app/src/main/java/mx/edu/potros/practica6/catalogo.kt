package mx.edu.potros.practica6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class catalogo : AppCompatActivity() {

    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    var gridview: GridView = findViewById(R.id.gridview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        adapter = PeliculaAdapter(this,peliculas)
        gridview.adapter = adapter
    }

    fun cargarPeliculas() {
        peliculas.add(Pelicula("1971",R.drawable.war,R.drawable.warheader, "At the height of the First World War, two young British soldiers, Schofield and Blake, \n" +
                "are given a seemingly impossible mission. \n" +
                "In a race against time, they must cross enemy \n" +
                "territory and deliver a message that will stop a \n" +
                "deadly attack on hundreds of soldiers—Blake’s \n" +
                "own brother among them."))
        peliculas.add(Pelicula("Big Hero",R.drawable.bighero6,R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults\n" +
                " Hiro into the midst of danger, he turns to Baymax\n" +
                " and his close friends: adrenaline junkie Go Go Tomago\n" +
                ", neatnik Wasabi, chemistry whiz Honey Lemon, and fanboy Fred.\n" +
                " Determined to uncover the mystery, Hiro transforms his friends\n" +
                " into a band of high-tech heroes called “Big Hero 6.”"))
        peliculas.add(Pelicula("Inception",R.drawable.inception,R.drawable.inceptionheader,"A thief who steals corporate secrets through the use of dream-sharing \n" +
                "technology is given the inverse task of planting an \n" +
                "idea into the mind of a C.E.O., but his tragic past\n" +
                " may doom the project and his team to disaster."))
        peliculas.add(Pelicula("Leap Year",R.drawable.leapyear,R.drawable.leapyearheader,"Anna Brady plans to travel to Dublin, Ireland to propose to her boyfriend\n" +
                " Jeremy on February 29, leap day, because, according to\n" +
                " Irish tradition, a man who receives a marriage proposal\n" +
                " on a leap day must accept it."))
        peliculas.add(Pelicula("Men in Black",R.drawable.mib,R.drawable.mibheader,"A police officer joins a secret organization that polices and monitors extraterrestrial\n" +
                " interactions on Earth."))
        peliculas.add(Pelicula("Toy Story",R.drawable.toystory,R.drawable.toystoryheader,"A cowboy doll is profoundly threatened and jealous when a new spaceman action figure\n" +
                " supplants him as top toy in a boy's bedroom."))
        peliculas.add(Pelicula("Dr. House",R.drawable.drhouse,R.drawable.drwhoheader,"An antisocial maverick doctor who specializes in diagnostic medicine does whatever it takes to\n" +
                " solve puzzling cases that come his way using his crack\n" +
                " team of doctors and his wits."))
        peliculas.add(Pelicula("Dr. Who",R.drawable.drwho,R.drawable.drwhoheader,"The further adventures in time and space of the alien adventurer known as the Doctor and their companions\n" +
                " from planet Earth."))
        peliculas.add(Pelicula("Friends",R.drawable.friends,R.drawable.friendsheader,"Follows the personal and professional lives of six twenty to thirty year-old friends living in the Manhattan\n" +
                " borough of New York City."))
        peliculas.add(Pelicula("Smallville",R.drawable.smallville,R.drawable.smallvilleheader,"A young Clark Kent struggles to find his place in the world as he learns to harness\n" +
                " his alien powers for good and deals with the typical troubles of\n" +
                " teenage life in Smallville, Kansas."))
    }

    class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Pelicula>()
        var contexto: Context? = null

        constructor(context: Context, peliculas: ArrayList<Pelicula>):super() {
            this.contexto = context
            this.peliculas = peliculas
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any {
            return peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula = peliculas[p0]
            var inflador =  LayoutInflater.from(contexto)
            var vista =  inflador.inflate(R.layout.peliculas, null)

            var imagen = vista.findViewById(R.id.iv_pelicula) as ImageView
            var nombre = vista.findViewById(R.id.tv_titulo) as TextView

            imagen.setImageResource(pelicula.image)
            nombre.setText(pelicula.titulo)

            vista.setOnClickListener {
                var intent = Intent(contexto, detalle_pelicula::class.java)
                intent.putExtra("nombre", pelicula.titulo)
                intent.putExtra("image", pelicula.image)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                contexto!!.startActivity(intent)
            }
            return vista
        }
    }
}