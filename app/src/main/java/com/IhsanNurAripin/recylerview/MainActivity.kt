package com.IhsanNurAripin.recylerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.IhsanNurAripin.recylerview.adapter.AdapterTeamBola
import com.IhsanNurAripin.recylerview.databinding.ActivityMainBinding
import com.IhsanNurAripin.recylerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Luis Mila",R.drawable.mila,"Head Coach","1.70m","Spain","12 Maret 1966"))
        listPemain.add(Pemain("Rachmat Irianto",R.drawable.irianto,"Defender","1.75m","Indonesia","3 September 1999"))
        listPemain.add(Pemain("Nick Kuipers",R.drawable.kuipers,"Defender","1.93m","Belanda","9 Oktober 1992"))
        listPemain.add(Pemain("Reky Rahayu",R.drawable.reky,"Goalkeeper","1.76m","Indonesia","8 Mei 1993"))
        listPemain.add(Pemain("Ciro Alves",R.drawable.ciro,"Forward","1.75m","Brazil","18 April 1989"))
        listPemain.add(Pemain("David da Silva",R.drawable.david,"Forward","1.85m","Brazil","12 November 1989"))

        binding.List.adapter = AdapterTeamBola(this,listPemain,object :AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)//
                    val tempatLahir = this.findViewById<TextView>(R.id.txtTempatLahir)//
                    val tanggalLahir = this.findViewById<TextView>(R.id.txtwTanggalLahir)//
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatLahir.text = "${item?.tempatlahir}"
                    tanggalLahir.text = "${item?.tgllahir}"
                    btn.setOnClickListener { this.dismiss() }

                }.show()
            }

        })
    }
}