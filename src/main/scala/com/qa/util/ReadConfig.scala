package com.qa.util

object ReadConfig extends ConfigUtil {

  val baseUrl = configFile.getString("configurations.baseUrl")
  val durationMeasurements = configFile.getString("configurations.durationMeasurements")
  val simulationDuration = configFile.getString("configurations.simulationDuration").toInt
  val loadUsers = configFile.getString("configurations.loadUsers").toInt
}
