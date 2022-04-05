package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario._

class TotalSimulation extends BaseSimulation {

  setUp(
    SuccessfulLoginScenario().populationBuilder,
    VisitScenario().populationBuilder
  )
}
