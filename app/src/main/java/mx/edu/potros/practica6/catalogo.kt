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
    var gridview:GridView = findViewById(R.id.gridview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)
        gridview.adapter = adapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("1971",R.drawable.war,R.drawable.warheader, "At the height of the First World War, two young British soldiers, Schofield and Blake, are given a seemingly impossible mission. In a race against time, they must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers—Blake’s own brother among them."))
        peliculas.add(Pelicula("Big Hero",R.drawable.bighero6,R.drawable.headerbighero6, "When a de"))
        peliculas.add(Pelicula("Inception",R.drawable.inception,R.drawable.inceptionheader,""))
        peliculas.add(Pelicula("LEap Year",R.drawable.leapyear,R.drawable.leapyearheader,""))
        peliculas.add(Pelicula("Men in Black",R.drawable.mib,R.drawable.mibheader,""))
        peliculas.add(Pelicula("Toy Story",R.drawable.toystory,R.drawable.toystoryheader,""))

        peliculas.add(Pelicula("Dr. House",R.drawable.drhouse,R.drawable.drwhoheader,""))
        peliculas.add(Pelicula("Dr. Who",R.drawable.drwho,R.drawable.drwhoheader,""))
        peliculas.add(Pelicula("Friends",R.drawable.friends,R.drawable.friendsheader,""))
        peliculas.add(Pelicula("Smallville",R.drawable.smallville,R.drawable.smallvilleheader,""))
    }

    class PeliculaAdapter: BaseAdapter{
        var peliculas = ArrayList<Pelicula>()
        var contexto: Context? = null

        constructor(peliculas: ArrayList<Pelicula>, context: Context){
            this.peliculas = peliculas
            this.contexto = context
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