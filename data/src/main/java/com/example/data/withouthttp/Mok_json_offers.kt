package com.example.data.withouthttp

import com.example.data.Offers

val listOfOffers:List<Offers> = arrayListOf(
    Offers(
        "near_vacancies",
        "Вакансии рядом с вами",
        link = "https://hh.ru/"
    ),
    Offers(
        "level_up_resume",
        "Поднять резюме в поиске",
        "Поднять",
        "https://hh.ru/mentors?from\u003dfooter_new\u0026hhtmFromLabel\u003dfooter_new\u0026" +
                "hhtmFrom\u003dmain\u0026purposeId\u003d1"
    ),
    Offers(
        "temporary_job",
        "  Временная работа или подработка",
        link = "https://hh.ru/"
    ),
    Offers(
        title = "Полезные статьи и советы",
        link = "https://hh.ru/articles?hhtmFrom\u003dmain"
    )
)