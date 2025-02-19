package com.example.jobsearchapp

import com.example.data.withouthttp.listOfVacancies


val itemTest = listOfVacancies.find {
    it.id == "15f88865-ae74-4b7c-9d81-b78334bb97db"
}
val id = itemTest?.id ?: "undefind_id"