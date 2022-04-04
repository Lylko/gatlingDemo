package com.qa.simulation

import com.qa.BaseSimulation
import com.qa.scenario.{CompleteCheckoutScenario, SuccessfulLoginScenario, UnsuccessfulLoginScenario, VisitScenario}

class TotalSimulation extends BaseSimulation {

  setUp(
    VisitScenario().populationBuilder
  )

<<<<<<< Updated upstream
  setUp(
    UnsuccessfulLoginScenario().populationBuilder
  )

  setUp(
    SuccessfulLoginScenario().populationBuilder
  )

  setUp(
    CompleteCheckoutScenario().populationBuilder
  )
=======
>>>>>>> Stashed changes
}
