package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario.{CompleteCheckoutScenario, SuccessfulLoginScenario, UnsuccessfulLoginScenario, VisitScenario}

class SuccessfulLoginSimulation extends BaseSimulation {

  setUp(
    SuccessfulLoginScenario().populationBuilder
  )

}
