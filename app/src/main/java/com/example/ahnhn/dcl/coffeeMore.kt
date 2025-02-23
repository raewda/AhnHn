package com.example.ahnhn.dcl

import com.example.ahnhn.R
import kotlin.random.Random

open class coffeeMore(
    val id: Int,
    val name: Int,
    val ingredients: Int,
    val recipe: Int,
    val picture: Int
){
    object sc : coffeeMore (0, R.string.scname, R.string.scingredients , R.string.screcipe, R.drawable.scimage)
    object cclatte : coffeeMore (1, R.string.cclattename , R.string.cclatteingredients , R.string.cclatterecipe, R.drawable.cclatteimage)
    object pc : coffeeMore (2, R.string.pcname , R.string.pcingredients , R.string.pcrecipe, R.drawable.pcimage)
    object hamfw : coffeeMore (3, R.string.hamfwname , R.string.hamfwingredients , R.string.hamfwrecipe, R.drawable.hamfwimage)
    object ps : coffeeMore (4, R.string.psname , R.string.psingredients , R.string.psrecipe, R.drawable.psimage)
    object wc : coffeeMore (5, R.string.wcname , R.string.wcingredients , R.string.wcrecipe, R.drawable.wcimage)
    object cbwsasf : coffeeMore (6, R.string.cbwsasfname , R.string.cbwsasfingredients , R.string.cbwsasfrecipe, R.drawable.cbwsasfimage)
    object vc : coffeeMore (7, R.string.vcname , R.string.vcingredients , R.string.vcrecipe, R.drawable.vcimage)
    object sil : coffeeMore (8, R.string.silname , R.string.silingredients , R.string.silrecipe, R.drawable.silimage)
    object pbem : coffeeMore (9, R.string.pbemname , R.string.pbemingredients , R.string.pbemrecipe, R.drawable.pbemimage)
    object jccs : coffeeMore (10, R.string.jccsname , R.string.jccsingredients , R.string.jccsrecipe, R.drawable.jccsimage)
    object mimm : coffeeMore (11, R.string.mimmname , R.string.mimmingredients , R.string.mimmrecipe, R.drawable.mimmimage)
    object tfc : coffeeMore (12, R.string.tfcname , R.string.tfcingredients , R.string.tfcrecipe, R.drawable.tfcimage)
    object fic : coffeeMore (13, R.string.ficname , R.string.ficingredients , R.string.ficrecipe, R.drawable.ficimage)
    object mbd : coffeeMore (14, R.string.mbdname , R.string.mbdingredients , R.string.mbdrecipe, R.drawable.mbdimage)
    object acbs : coffeeMore (15, R.string.acbsname , R.string.acbsingredients , R.string.acbsrecipe, R.drawable.acbsimage)
    object a : coffeeMore (16, R.string.aname , R.string.aingredients , R.string.arecipe, R.drawable.aimage)
    object yppil : coffeeMore (17, R.string.yppilname , R.string.yppilingredients , R.string.yppilrecipe, R.drawable.yppilimage)
    object cghc : coffeeMore (18, R.string.cghcname , R.string.cghcingredients , R.string.cghcrecipe, R.drawable.cghcimage)
    object icm : coffeeMore (19, R.string.icmname , R.string.icmingradients , R.string.icmrecipe, R.drawable.icmimage)


    companion object{
        const val Count: Int = 20
        private val all = listOf(
            sc, cclatte, pc, hamfw, ps, wc, cbwsasf, vc, sil, pbem, jccs, mimm, tfc, fic, mbd, acbs, a, yppil, cghc, icm
        )
        fun getById(id: Int): coffeeMore{
            all.forEach(){
                el -> if (el.id == id)
                    return el
            }
            return sc
        }

        fun randomCoffee(): coffeeMore {
            return coffeeMore.getById(Random.nextInt(0, coffeeMore.Count))
        }
    }

}
