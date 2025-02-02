package com.example.ahnhn.ince

interface ZodiacRepository {
    suspend fun getZodiac(zodiacName: String) : List <HoroscopeZodiac>
}

class NetworkZodiacRepository(
    private val inHor: InHor
) : ZodiacRepository {
    override suspend fun getZodiac(
        zodiacName: String
    ): List<HoroscopeZodiac> = inHor.zodiacFilter(zodiacName).items.map { items ->
        HoroscopeZodiac(
            personal_life = items.String?.personal_life,
            profession = items.String?.profession,
            health = items.String?.health,
            emotions = items.String?.emotions,
            travel = items.String?.travel,
            luck = items.String?.luck
        )
    }
}