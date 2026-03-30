package dodiwijaya.app_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dodiwijaya.app_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, android.R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        binding.btnHitung.setOnClickListener {

            val nTugas = binding.tugas.text.toString().toDoubleOrNull()
            val nUTS = binding.uts.text.toString().toDoubleOrNull()
            val nUAS = binding.uas.text.toString().toDoubleOrNull()
            val nProject = binding.project.text.toString().toDoubleOrNull()
            val nKuis = binding.kuis.text.toString().toDoubleOrNull()

            if (nTugas == null || nUTS == null || nUAS == null || nProject == null || nKuis == null) {
                Toast.makeText(this, "Isi semua nilai!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nilaiAkhir = (nTugas * 0.2) +
                    (nUTS * 0.25) +
                    (nUAS * 0.25) +
                    (nProject * 0.2) +
                    (nKuis * 0.1)

            val grade = when {
                nilaiAkhir >= 85 -> "A"
                nilaiAkhir >= 80 -> "B+"
                nilaiAkhir >= 75 -> "B"
                nilaiAkhir >= 70 -> "C+"
                nilaiAkhir >= 65 -> "C"
                else -> "D"
            }

            val status = when (grade) {
                "A" -> "Sangat Baik Sekali"
                "B+", "B" -> "Baik"
                "C+", "C" -> "Cukup"
                else -> "Kurang, Anda harus mengulang tahun depan"
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nama", binding.nama.text.toString())
            intent.putExtra("mk", binding.mk.text.toString())
            intent.putExtra("nilai", nilaiAkhir)
            intent.putExtra("grade", grade)
            intent.putExtra("status", status)

            startActivity(intent)
        }
    }
    private fun clearForm() {
        binding.nama.text?.clear()
        binding.nim.text?.clear()
        binding.semester.text?.clear()
        binding.mk.text?.clear()

        binding.tugas.text?.clear()
        binding.uts.text?.clear()
        binding.uas.text?.clear()
        binding.project.text?.clear()
        binding.kuis.text?.clear()
    }
    override fun onResume() {
        super.onResume()
        clearForm()
    }
}