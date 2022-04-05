package com.qa.util

import com.typesafe.config.{Config, ConfigFactory}

trait ConfigUtil {

    val configFile: Config = ConfigFactory.load("performance.conf")

    val baseUrl = configFile.getString("configurations.baseUrl")
    val durationMeasurements = configFile.getString("configurations.durationMeasurements")
    val simulationDuration = configFile.getString("configurations.simulationDuration").toInt

    def fromConfigToInt(path: String) = {
        configFile.getInt(path)
    }
}
