package dodiwijaya.app_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dodiwijaya.app_mobile.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama = intent.getStringExtra("nama")
        val mk = intent.getStringExtra("mk")
        val nilai = intent.getDoubleExtra("nilai", 0.0)
        val grade = intent.getStringExtra("grade")
        val status = intent.getStringExtra("status")

        binding.tvNama.text = "Nama: $nama"
        binding.tvMatkul.text = "Mata Kuliah: $mk"
        binding.tvNilai.text = "Nilai Akhir: %.2f".format(nilai)
        binding.tvGrade.text = "Grade: $grade"
        binding.tvStatus.text = status

        binding.btnKembali.setOnClickListener {
            finish()
        }
    }
}