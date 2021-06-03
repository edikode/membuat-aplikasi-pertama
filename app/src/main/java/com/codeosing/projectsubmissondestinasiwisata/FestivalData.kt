package com.codeosing.projectsubmissondestinasiwisata

object FestivalData {
    private val festivalNames = arrayOf("Barong Ider Bumi",
        "Seblang Oleh Sari",
        "Festival Kebaya",
        "Jazz Gunung",
        "Gandrung Sewu",
        "BEC",
        "BMX",
        "Barong Ider Bumi",
        "Seblang Oleh Sari",
        "Festival Kebaya")

    private val festivalLocation = arrayOf("Desa Kemiren, Kecamatan Glagah, Banyuwangi",
        "Desa Olehsari, Kecamatan Glagah, Kabupaten Banyuwangi",
        "Kabupaten Banyuwangi",
        "Ampititer Taman Gandrung Terakota",
        "Pantai Marina Boom Banyuwangi",
        "Start Taman Blambangan Banyuwangi",
        "Desa Muncar, Kabupaten Banyuwangi",
        "Desa Kemiren, Kecamatan Glagah, Banyuwangi",
        "Desa Olehsari, Kecamatan Glagah, Kabupaten Banyuwangi",
        "Kabupaten Banyuwangi")

    private val festivalImages = intArrayOf(R.drawable.barong,
        R.drawable.seblang,
        R.drawable.kebaya,
        R.drawable.jazz,
        R.drawable.gandrung,
        R.drawable.bec,
        R.drawable.bmx,
        R.drawable.barong,
        R.drawable.seblang,
        R.drawable.kebaya)

    val listData: ArrayList<Festival>
        get() {
            val list = arrayListOf<Festival>()
            for (position in festivalNames.indices) {
                val fest = Festival()
                fest.name = festivalNames[position]
                fest.location = festivalLocation[position]
                fest.photo = festivalImages[position]
                list.add(fest)
            }
            return list
        }
}