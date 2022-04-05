package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario._

class TotalSimulation extends BaseSimulation {

  setUp(
    VisitScenario().populationBuilder,
    SuccessfulLoginScenario().populationBuilder,
    CompleteCheckoutScenario().populationBuilder,
    UnsuccessfulLoginScenario().populationBuilder
  )
}
