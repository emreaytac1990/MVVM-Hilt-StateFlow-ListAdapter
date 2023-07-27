package com.emreaytac.myapplication.data.api

import com.google.gson.annotations.SerializedName

data class PokemonResponse(

    @SerializedName("count"    ) val count    : Int?               = null,
    @SerializedName("next"     ) val next     : String?            = null,
    @SerializedName("previous" ) val previous : String?            = null,
    @SerializedName("results"  ) val results  : ArrayList<Results> = arrayListOf()

)

data class Results(

    @SerializedName("name" ) val name : String? = null,
    @SerializedName("url"  ) val url  : String? = null

)