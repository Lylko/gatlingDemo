package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario.{CompleteCheckoutScenario, SuccessfulLoginScenario, UnsuccessfulLoginScenario, VisitScenario}

class TotalSimulation extends BaseSimulation {

  setUp(
    VisitScenario().populationBuilder
  )
}
