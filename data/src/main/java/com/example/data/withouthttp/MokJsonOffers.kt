package com.example.data.withouthttp

import com.example.data.MyOffers

val listOfOffers = listOf(
    MyOffers(
        "near_vacancies",
        "Вакансии рядом с вами",
        link = "https://hh.ru/"
    ),
    MyOffers(
        "level_up_resume",
        "Поднять резюме в поиске",
        "Поднять",
        "https://hh.ru/mentors?from\u003dfooter_new\u0026hhtmFromLabel\u003dfooter_new\u0026" +
                "hhtmFrom\u003dmain\u0026purposeId\u003d1"
    ),
    MyOffers(
        "temporary_job",
        "  Временная работа или подработка",
        link = "https://hh.ru/"
    ),
    MyOffers(
        title = "Полезные статьи и советы",
        link = "https://hh.ru/articles?hhtmFrom\u003dmain"
    )
)