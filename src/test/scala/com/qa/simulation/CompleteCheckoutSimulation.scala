package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario.{CompleteCheckoutScenario, SuccessfulLoginScenario, UnsuccessfulLoginScenario, VisitScenario}

class CompleteCheckoutSimulation extends BaseSimulation {

  setUp(
    CompleteCheckoutScenario().populationBuilder
  )

}
