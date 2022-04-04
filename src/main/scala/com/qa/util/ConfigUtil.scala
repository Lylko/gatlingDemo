package com.qa.util

import com.typesafe.config.{Config, ConfigFactory}

trait ConfigUtil {

    val configFile: Config = ConfigFactory.load("performance.conf")

}
