package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario.{CompleteCheckoutScenario, SuccessfulLoginScenario, UnsuccessfulLoginScenario, VisitScenario}

class UnsuccessfulLoginSimulation extends BaseSimulation {

  setUp(
    UnsuccessfulLoginScenario().populationBuilder
  )

}
