package franklin.reyes.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)


        val btnIngresar: Button = findViewById(R.id.btnIngresar)

        btnIngresar.setOnClickListener {

            val correo = txtCorreo.text.toString()
            val contrasena = txtContrasena.text.toString()

            if (correo.isEmpty() || contrasena.isEmpty()) {

                Toast.makeText(
                    this,
                    "Error, llena todas las casillas para proceder",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                Log.i("Test de credenciales", "Correo: $correo y Contraseña: $contrasena")
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}