package experiments

import populationMethods.GeneticAlgorithmForGP
import problems.SymbolicRegression

class GPExperimentRunner {

    static runExperiment(searchers, problems, numRuns = 30) {
        for (p in problems) {
            for (s in searchers) {
                for (i in 0..<numRuns) {
                    p.evalCount = 0
                    def result = s.maximize(p)
                    println "${s.toString()}\t${p.toString()}\t${p.quality(result)}\t${result}"
                }
            }
        }
    }

    static main(args) {
        def searchers = [
            new GeneticAlgorithmForGP()
        ]
        def problems = [
            new SymbolicRegression()
        ]

        runExperiment(searchers, problems, 1000)
        println "-------------------------------------------------------------"
        runExperiment(searchers, problems, 10000)
    }

}
