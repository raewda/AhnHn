package com.example.ahnhn.dcl

import android.util.Log
import com.example.ahnhn.R
import kotlin.math.log
import kotlin.random.Random

open class coffeeMore(
    val id: Int,
    val name: Int,
    val ingredients: Int,
    val recipe: Int,
    val picture: Int
){
    companion object{
        val sc = coffeeMore (0, R.string.scname, R.string.scingredients , R.string.screcipe, R.drawable.scimage)
        val cclatte = coffeeMore (1, R.string.cclattename , R.string.cclatteingredients , R.string.cclatterecipe, R.drawable.cclatteimage)
        val pc = coffeeMore (2, R.string.pcname , R.string.pcingredients , R.string.pcrecipe, R.drawable.pcimage)
        val hamfw = coffeeMore (3, R.string.hamfwname , R.string.hamfwingredients , R.string.hamfwrecipe, R.drawable.hamfwimage)
        val ps = coffeeMore (4, R.string.psname , R.string.psingredients , R.string.psrecipe, R.drawable.psimage)
        val wc = coffeeMore (5, R.string.wcname , R.string.wcingredients , R.string.wcrecipe, R.drawable.wcimage)
        val cbwsasf = coffeeMore (6, R.string.cbwsasfname , R.string.cbwsasfingredients , R.string.cbwsasfrecipe, R.drawable.cbwsasfimage)
        val vc = coffeeMore (7, R.string.vcname , R.string.vcingredients , R.string.vcrecipe, R.drawable.vcimage)
        val sil = coffeeMore (8, R.string.silname , R.string.silingredients , R.string.silrecipe, R.drawable.silimage)
        val pbem = coffeeMore (9, R.string.pbemname , R.string.pbemingredients , R.string.pbemrecipe, R.drawable.pbemimage)
        val jccs = coffeeMore (10, R.string.jccsname , R.string.jccsingredients , R.string.jccsrecipe, R.drawable.jccsimage)
        val mimm = coffeeMore (11, R.string.mimmname , R.string.mimmingredients , R.string.mimmrecipe, R.drawable.mimmimage)
        val tfc = coffeeMore (12, R.string.tfcname , R.string.tfcingredients , R.string.tfcrecipe, R.drawable.tfcimage)
        val fic = coffeeMore (13, R.string.ficname , R.string.ficingredients , R.string.ficrecipe, R.drawable.ficimage)
        val mbd = coffeeMore (14, R.string.mbdname , R.string.mbdingredients , R.string.mbdrecipe, R.drawable.mbdimage)
        val acbs = coffeeMore (15, R.string.acbsname , R.string.acbsingredients , R.string.acbsrecipe, R.drawable.acbsimage)
        val af = coffeeMore (16, R.string.aname , R.string.aingredients , R.string.arecipe, R.drawable.aimage)
        val yppil = coffeeMore (17, R.string.yppilname , R.string.yppilingredients , R.string.yppilrecipe, R.drawable.yppilimage)
        val cghc = coffeeMore (18, R.string.cghcname , R.string.cghcingredients , R.string.cghcrecipe, R.drawable.cghcimage)
        val icm = coffeeMore (19, R.string.icmname , R.string.icmingradients , R.string.icmrecipe, R.drawable.icmimage)

        const val Count: Int = 20
        val all = listOf(
            sc, cclatte, pc, hamfw, ps, wc, cbwsasf, vc, sil, pbem, jccs, mimm, tfc, fic, mbd, acbs,
            af, yppil, cghc, icm
        )
        fun getById(id: Int): coffeeMore{
            return all.find {
                Log.d("af", "${it.id}")
                it.id == id
            }?: sc
        }

        fun randomCoffee(): coffeeMore {
            return coffeeMore.getById(Random.nextInt(0, coffeeMore.Count))
        }
    }
}
