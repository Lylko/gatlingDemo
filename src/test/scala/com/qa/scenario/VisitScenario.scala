package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.HomePage
import io.gatling.core.Predef._

case class VisitScenario() extends BaseSimulation {

  val scn =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage).exitHereIfFailed

  val populationBuilder = setInjectionProfile(scn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)

}
